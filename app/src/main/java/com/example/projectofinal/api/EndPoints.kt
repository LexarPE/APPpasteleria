package com.example.projectofinal.api

object EndPoints {
    //ipv4 de la pc -> en cmd ipconfig
    private const val URL_ROOT = "http://192.168.1.102:3000/v1/"

    object Usuario {
        const val GET = "${URL_ROOT}usuario/get"
        const val ADD = "${URL_ROOT}usuario/add"
    }

    object Pastel {

    }
}