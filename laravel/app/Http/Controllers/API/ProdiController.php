<?php

namespace App\Http\Controllers\API;

use App\Prodi;
use App\Kampus;
use App\Fakultas;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class ProdiController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
       
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
        $prodi = new Prodi;
        $prodi-> nama_prodi = $request->nama_prodi;
        $prodi-> tentang = $request->tentang;
        $prodi-> biaya = $request->biaya;
        $prodi-> id_fakultas = $request->id_fakultas;
        $prodi-> id_univ = $request->id_univ;
        $prodi-> save();

        return "Data Berhasil Masuk";
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Prodi  $prodi
     * @return \Illuminate\Http\Response
     */
    public function show(Prodi $prodi)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Prodi  $prodi
     * @return \Illuminate\Http\Response
     */
    public function edit(Prodi $prodi)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Prodi  $prodi
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $prodi)
    {
        $nama_prodi = $request->nama_prodi;
        $tentang = $request->tentang;
        $biaya = $request->biaya;
        $id_fakultas = $request->id_fakultas;
        $id_univ = $request->id_univ;

        $test = Prodi::find($prodi);
        $test->nama_prodi = $nama_prodi;
        $test->tentang = $tentang;
        $test->biaya = $biaya;
        $test->id_fakultas = $id_fakultas;
        $test->id_univ = $id_univ;
        $test->save();

        return $test;
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Prodi  $prodi
     * @return \Illuminate\Http\Response
     */
    public function destroy($prodi)
    {
        $kampus = Prodi::find($prodi);
        $kampus ->delete();

        return "Data Berhasil di Hapus";
    }
}
