<?php

namespace App\Http\Controllers\API;

use App\Kampus;
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
     * @param  \App\Kampus  $kampus
     * @return \Illuminate\Http\Response
     */
    public function show(Kampus $kampus)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Kampus  $kampus
     * @return \Illuminate\Http\Response
     */
    public function edit(Kampus $kampus)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Kampus  $kampus
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Kampus $kampus)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Kampus  $kampus
     * @return \Illuminate\Http\Response
     */
    public function destroy(Kampus $kampus)
    {
        //
    }
}
