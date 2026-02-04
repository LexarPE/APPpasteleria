package com.example.projectofinal

import android.app.Application
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley


class VolleySingleton  :  Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    //Si la cola no existe, créala; si ya existe, dame la que ya tenemos
    val requestQueue: RequestQueue? = null
        get() {
            if (field == null) {
                return Volley.newRequestQueue(applicationContext)
            }
            return field
        }

    fun <T> addToRequestQueue(request: Request<T>) {
        //Etique a cada peticion
        request.tag = TAG
        requestQueue?.add(request)
    }

    companion object {
        private val TAG = com.example.projectofinal.VolleySingleton::class.java.simpleName
        @get:Synchronized var instance: com.example.projectofinal.VolleySingleton? = null
            private set
    }

}