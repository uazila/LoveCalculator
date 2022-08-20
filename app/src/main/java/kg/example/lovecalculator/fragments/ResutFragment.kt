package kg.example.lovecalculator.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import kg.example.lovecalculator.databinding.FragmentTest2Binding
import kg.example.lovecalculator.fragments.TestFragment.Companion.KEY_RESPONSE
import kg.example.lovecalculator.model.LoveModel
@AndroidEntryPoint
class ResutFragment : Fragment() {

    private lateinit var binding: FragmentTest2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTest2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initGetData()
    }

    private fun initGetData() {

        val getData = requireArguments().getSerializable(KEY_RESPONSE) as LoveModel?
        if (getData != null) {
            binding.tvName2.text = getData.firstName
            binding.tvName1.text = getData.secondName
            binding.tvPercent.text = getData.percentage + " процентов совместимости"
            binding.tvLike.text = getData.result
        }
    }
}