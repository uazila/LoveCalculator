package kg.example.lovecalculator.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.example.lovecalculator.model.LoveModel
import kg.example.lovecalculator.repository.Repository
import javax.inject.Inject
@HiltViewModel
class TestViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    fun getLoveModel(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.doRequest(firstName, secondName)
    }
}