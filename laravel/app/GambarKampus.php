<?php

namespace App;

use Laravel\Passport\HasApiTokens;
use Illuminate\Database\Eloquent\Model;

class GambarKampus extends Model
{
    use HasApiTokens;
    protected $table = "tb_gambarkampus";
    protected $fillable = ['url','id_univ'];
    public $timestamp = false;
}
