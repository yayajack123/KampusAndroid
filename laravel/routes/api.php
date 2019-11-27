<?php

use Illuminate\Http\Request;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::post('login', 'API\UserController@login');
Route::get('logout', 'API\UserController@logout');
Route::post('register', 'API\UserController@register');
Route::resource('kampus', 'API\KampusController');
Route::resource('fakultas','API\FakultasController');
Route::get('gambar/{filename}','API\GambarKampusController@kampusList');
Route::get('gambar/{id}','API\GambarKampusController@kampusid');
Route::post('gambar','API\GambarKampusController@kampusSave');
Route::get('getuser/{id}','API\UserController@getuser');

Route::group(['middleware' => 'auth:api'], function(){
    Route::post('details', 'API\UserController@details');
});
