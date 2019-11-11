<?php

namespace App;

use Laravel\Passport\HasApiTokens;
use Illuminate\Database\Eloquent\Model;

class Fakultas extends Model
{
    use HasApiTokens;
    protected $table = "tb_fakultas";
    protected $fillable = ['nama_fakultas','id_univ'];
    public $timestamp = false;
}
