package kg.example.lovecalculator.board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kg.example.lovecalculator.R
import kg.example.lovecalculator.databinding.FragmentBoardBinding
import kg.example.lovecalculator.prefs.Prefs
import javax.inject.Inject

@AndroidEntryPoint
class BoardFragment : Fragment() {

    private lateinit var binding: FragmentBoardBinding

    @Inject
    lateinit var prefs: Prefs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BoardAdapter {
            findNavController().navigate(R.id.testFragment)
            prefs.saveState()
        }
        binding.view.adapter = adapter
        binding.dotsIndicator.attachTo(binding.view)
    }

}