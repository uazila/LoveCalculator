package kg.example.lovecalculator.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kg.example.lovecalculator.App
import kg.example.lovecalculator.LoveModel
import kg.example.lovecalculator.R
import kg.example.lovecalculator.databinding.FragmentTestBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TestFragment : Fragment() {
    private lateinit var binding: FragmentTestBinding
    var data: LoveModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            okBtn.setOnClickListener {
                val firstName = binding.firstName.text.toString()
                val secondName = binding.secondName.text.toString()
                doRequest(firstName, secondName)
            }
        }
    }

    private fun doRequest(firstName: String, secondName: String) : LoveModel?{
        App.api.calculate(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                Log.e("ololo", "onResponce: ${response.body()}")
                val bundle = Bundle()
                data = response.body()
                bundle.putSerializable(KEY_RESPONSE, data)
                findNavController().navigate(R.id.testFragment2, bundle)
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}")
            }
        })
        return data
    }

    companion object {
        const val KEY_RESPONSE = "key love"
    }
}