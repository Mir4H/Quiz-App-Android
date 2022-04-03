package com.example.quizz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quizz.databinding.FragmentFourthBinding

private const val ARG_PARAM1 = "answers"
class FourthFragment : Fragment() {

    private var answers: String? = null
    private var _binding: FragmentFourthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        arguments?.let {
            answers = it.getString(ARG_PARAM1)
        }
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val green = ContextCompat.getColor(requireContext(), R.color.lightGreen)
        val gray = ContextCompat.getColor(requireContext(), R.color.grayGreen)

        val first = binding.flatbread
        val second = binding.khachapuri
        val third = binding.pizza
        val fourth = binding.pie

        first.setOnClickListener {
            first.setBackgroundColor(green)
            second.setBackgroundColor(gray)
            third.setBackgroundColor(gray)
            fourth.setBackgroundColor(gray)
            answers += "a"
        }
        second.setOnClickListener {
            second.setBackgroundColor(green)
            first.setBackgroundColor(gray)
            third.setBackgroundColor(gray)
            fourth.setBackgroundColor(gray)
            answers += "b"
        }
        third.setOnClickListener {
            third.setBackgroundColor(green)
            first.setBackgroundColor(gray)
            second.setBackgroundColor(gray)
            fourth.setBackgroundColor(gray)
            answers += "c"
        }
        fourth.setOnClickListener {
            fourth.setBackgroundColor(green)
            first.setBackgroundColor(gray)
            second.setBackgroundColor(gray)
            third.setBackgroundColor(gray)
            answers += "d"
        }

        binding.buttonFourthNext.setOnClickListener {
            if (answers?.length == 2) {
                Toast.makeText(context, getString(R.string.answer), Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(FourthFragmentDirections.actionFourthFragmentToFifthFragment(answers!!))
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

