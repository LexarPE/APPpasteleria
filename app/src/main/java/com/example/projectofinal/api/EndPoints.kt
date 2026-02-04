package com.example.projectofinal.api

object EndPoints {
    //ipv4 de la pc -> en cmd ipconfig
    private val URL_ROOT = "http://192.168.1.102:3000/v1/"

    val URL_GET_USER = URL_ROOT + "usuario/get"
    val URL_ADD_USER = URL_ROOT + "usuario/add"
}