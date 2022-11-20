package com.example.lab_3.repository

import com.example.lab_3.api.Contains
import com.example.lab_3.api.RetrofitInstance
import com.example.lab_3.model.Exercise

import retrofit2.Response

class Repository {

    suspend fun getInfoExercises(): Response<Exercise>{
        return RetrofitInstance.api.getExercises(Contains.getPar())
    }

}