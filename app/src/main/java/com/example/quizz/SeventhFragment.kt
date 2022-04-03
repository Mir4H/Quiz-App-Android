package com.example.quizz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.example.quizz.databinding.FragmentSeventhBinding

private const val ARG_PARAM1 = "answers"
class SeventhFragment : Fragment() {

    private var answers: String? = null
    private var _binding: FragmentSeventhBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        arguments?.let {
            answers = it.getString(ARG_PARAM1)
        }
        _binding = FragmentSeventhBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (checkResults(answers!!)) {
            -1 -> {
                binding.resultText.text = getString(R.string.minus)
                binding.kuva.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.angry, null))
            }
            0 -> {
                binding.resultText.text = getString(R.string.zero)
                binding.kuva.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.zero, null))
            }
            1 -> {
                binding.resultText.text = getString(R.string.one)
                binding.kuva.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.one, null))
            }
            2 -> {
                binding.resultText.text = getString(R.string.two)
                binding.kuva.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.two, null))
            }
            3 -> {
                binding.resultText.text = getString(R.string.three)
                binding.kuva.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.smile, null))
            }
            4 -> {
                binding.resultText.text = getString(R.string.four)
                binding.kuva.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.good, null))
            }
            5 -> {
                binding.resultText.text = getString(R.string.five)
                binding.kuva.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.perfect, null))
            }
        }


        binding.buttonBackHome.setOnClickListener {
            findNavController().navigate(SeventhFragmentDirections.actionSeventhFragmentToFirstFragment())
        }
    }

    private fun checkResults(answer: String): Int {
        var check = 0
        val correct = "cbbca"
        if (answer.length != correct.length) return -1
        for (i in answer.indices)
        {
            if(answer[i] == correct[i]) check++
        }
        return check
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

