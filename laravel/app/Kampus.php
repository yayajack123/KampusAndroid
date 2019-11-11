<?php

namespace App;

use Laravel\Passport\HasApiTokens;
use Illuminate\Database\Eloquent\Model;

class Kampus extends Model
{
    use HasApiTokens;
    protected $table = "tb_kampus";
    protected $fillable = ['nama_univ','tentang','lokasi'];
    public $timestamp = false;
}
