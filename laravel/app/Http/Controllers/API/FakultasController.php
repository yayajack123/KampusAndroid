<?php

namespace App\Http\Controllers\API;

use App\Fakultas;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\Http\Controllers\Controller;

class FakultasController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $fak = Fakultas::all();
        return array("result"=>$fak) ;
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Fakultas  $fakultas
     * @return \Illuminate\Http\Response
     */
    public function show($fakultas)
    {
        $detail = Fakultas::select('tb_fakultas.id','nama_fakultas','nama_prodi','tb_prodi.tentang')
                ->join('tb_prodi','tb_prodi.id_fakultas','=','tb_fakultas.id')
                ->where('tb_prodi.id_fakultas',$fakultas)
                ->get();

        return response()->json([
            'result' => $detail
            ]);   
        
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Fakultas  $fakultas
     * @return \Illuminate\Http\Response
     */
    public function edit(Fakultas $fakultas)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Fakultas  $fakultas
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Fakultas $fakultas)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Fakultas  $fakultas
     * @return \Illuminate\Http\Response
     */
    public function destroy(Fakultas $fakultas)
    {
        //
    }
}
