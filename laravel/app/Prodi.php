<?php

namespace App;

use Laravel\Passport\HasApiTokens;
use Illuminate\Database\Eloquent\Model;

class Prodi extends Model
{
    use HasApiTokens;
    protected $table = "tb_prodi";
    protected $fillable = ['nama_prodi','tentang','id_fakultas','id_univ'];
    public $timestamp = false;
}
