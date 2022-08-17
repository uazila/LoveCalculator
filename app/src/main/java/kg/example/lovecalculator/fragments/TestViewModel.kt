package kg.example.lovecalculator.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kg.example.lovecalculator.model.LoveModel
import kg.example.lovecalculator.repository.Repository

class TestViewModel : ViewModel() {

    private val repository = Repository()

    fun getLoveModel(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.doRequest(firstName, secondName)
    }
}