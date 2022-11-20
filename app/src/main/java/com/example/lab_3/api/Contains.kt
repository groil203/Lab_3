package com.example.lab_3.api

object Contains {
    private var par: String = "cardio"

    fun setPar(par: String){
        this.par=par
    }

    fun getPar(): String {
        return par
    }
}