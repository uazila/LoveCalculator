package kg.example.lovecalculator.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kg.example.lovecalculator.R
import kg.example.lovecalculator.databinding.FragmentTestBinding
import kg.example.lovecalculator.model.LoveModel

@AndroidEntryPoint
class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding
    var data: LoveModel? = null

    private val viewModel: TestViewModel by viewModels()

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
                viewModel.getLoveModel(firstName, secondName).observe(viewLifecycleOwner) {
                    data = it
                    val bundle = Bundle()
                    bundle.putSerializable(KEY_RESPONSE, data)
                    Handler(Looper.myLooper()!!).postDelayed({
                        findNavController().navigate(R.id.testFragment2, bundle)
                    }, 2500)

                }
            }
        }
    }

    companion object {
        const val KEY_RESPONSE = "key love"
    }
}