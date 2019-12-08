<?php

namespace App\Http\Controllers\API;

use App\Kampus;
use App\Prodi;
use App\Fakultas;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

class KampusController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $kampus = Kampus::get();
        return array("result"=>$kampus) ;

    }

    public function search($nama_univ)
    {
      $kampus = Kampus::where('nama_univ', 'like', "%{$nama_univ}%")->get();
      return response()->json([
        'result' => $kampus
      ]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $kampus = new Kampus;
        $kampus-> nama_univ = $request->nama_univ;
        $kampus-> tentang = $request->tentang;
        $kampus-> lokasi = $request->lokasi;
        $kampus-> save();

        return "Data Berhasil Masuk";
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Kampus  $kampus
     * @return \Illuminate\Http\Response
     */
    public function show($kampus)
    {
        $detail = Prodi::select('tb_kampus.nama_univ','tb_kampus.id as id_univ','tb_kampus.tentang as tentang_kampus',
                                'tb_kampus.lokasi','id_fakultas','nama_fakultas','nama_prodi',
                                'tb_prodi.tentang as tentang_prodi','tb_prodi.biaya','tb_prodi.id as id_prodi')
                ->join('tb_kampus','tb_prodi.id_univ','=','tb_kampus.id')
                ->join('tb_fakultas','tb_prodi.id_fakultas','=','tb_fakultas.id')
                ->where('tb_prodi.id_univ',$kampus)
                ->get();

        return response()->json([
            'result' => $detail
            ]);   
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Kampus  $kampus
     * @return \Illuminate\Http\Response
     */
    public function edit(Kampus $kampus,$id)
    {
        
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Kampus  $kampus
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $kampus)
    {
        $nama_univ = $request->nama_univ;
        $tentang = $request->tentang;
        $lokasi = $request->lokasi;

        $test = Kampus::find($kampus);
        $test->nama_univ = $nama_univ;
        $test->tentang = $tentang;
        $test->lokasi = $lokasi;
        $test->save();

        return $test;
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Kampus  $kampus
     * @return \Illuminate\Http\Response
     */
    public function destroy($kampus)
    {
        $kampus = Kampus::find($kampus);
        $kampus ->delete();

        return "Data Berhasil di Hapus";
    }
}
