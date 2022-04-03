package com.example.quizz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.quizz.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private var answers: String? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        answers = null
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val green = ContextCompat.getColor(requireContext(), R.color.lightGreen)
        val gray = ContextCompat.getColor(requireContext(), R.color.grayGreen)

        val first = binding.gingerbread
        val second = binding.macroons
        val third = binding.panettone
        val fourth = binding.mincepie

        first.setOnClickListener {
            first.setBackgroundColor(green)
            second.setBackgroundColor(gray)
            third.setBackgroundColor(gray)
            fourth.setBackgroundColor(gray)
            answers = "a"
        }
        second.setOnClickListener {
            second.setBackgroundColor(green)
            first.setBackgroundColor(gray)
            third.setBackgroundColor(gray)
            fourth.setBackgroundColor(gray)
            answers = "b"
        }
        third.setOnClickListener {
            third.setBackgroundColor(green)
            first.setBackgroundColor(gray)
            second.setBackgroundColor(gray)
            fourth.setBackgroundColor(gray)
            answers = "c"
        }
        fourth.setOnClickListener {
            fourth.setBackgroundColor(green)
            first.setBackgroundColor(gray)
            second.setBackgroundColor(gray)
            third.setBackgroundColor(gray)
            answers = "d"
        }

        binding.buttonSecondNext.setOnClickListener {
            if (answers.isNullOrEmpty()) {
                Toast.makeText(context, getString(R.string.answer), Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToThirdFragment(answers!!))
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}