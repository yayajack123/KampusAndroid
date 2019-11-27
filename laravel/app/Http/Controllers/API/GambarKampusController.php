<?php

namespace App\Http\Controllers\API;

use App\GambarKampus;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;

class GambarKampusController extends Controller
{
    public function kampusList($filename){
        $path = public_path().'/image/'.$filename;
        return response()->download($path);
    }   

    public function kampusSave(Request $request){
        $path = $request->file('photo');
        $name=$path->getClientOriginalName();
        $path->move(public_path().'/image/', $name); 
        $photoURL = url('/image',$name);
        $form= new GambarKampus();   
        $form->id_univ = $request->id_univ;
        $form->url=$name;  
        $form->save(); 
        return response()->json(['url'=> $photoURL],200);
    }

    public function kampusid($id){
        $filename=GambarKampus::select('url')
                ->where('id_univ',$id)
                ->get();
        return response()->json(['image_name'=> $filename],200);
    }
}
