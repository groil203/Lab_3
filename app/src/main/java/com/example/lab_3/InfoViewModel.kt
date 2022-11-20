package com.example.lab_3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_3.model.Exercise
import com.example.lab_3.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class InfoViewModel: ViewModel() {
    var repo = Repository()
    val myInfoExercisesList : MutableLiveData<Response<Exercise>> = MutableLiveData()

    fun getListExercises(){
        viewModelScope.launch {
            myInfoExercisesList.value = repo.getInfoExercises()
        }
    }
}