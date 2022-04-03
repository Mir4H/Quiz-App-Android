package com.example.quizz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quizz.databinding.FragmentThirdBinding


private const val ARG_PARAM1 = "answers"
class ThirdFragment : Fragment() {

    private var answers: String? = null
    private var _binding: FragmentThirdBinding? = null

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

            _binding = FragmentThirdBinding.inflate(inflater, container, false)
            return binding.root

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val green = ContextCompat.getColor(requireContext(), R.color.lightGreen)
        val white = ContextCompat.getColor(requireContext(), R.color.white)

        val first = binding.meksiko
        val second = binding.kiina
        val third = binding.englanti

        first.setOnClickListener {
            first.setBackgroundColor(white)
            first.setTextColor(green)
            second.setBackgroundColor(green)
            second.setTextColor(white)
            third.setBackgroundColor(green)
            third.setTextColor(white)
            answers += "a"
        }
        second.setOnClickListener {
            second.setBackgroundColor(white)
            second.setTextColor(green)
            third.setBackgroundColor(green)
            third.setTextColor(white)
            first.setBackgroundColor(green)
            first.setTextColor(white)
            answers += "b"
        }
        third.setOnClickListener {
            third.setBackgroundColor(white)
            third.setTextColor(green)
            second.setBackgroundColor(green)
            second.setTextColor(white)
            first.setBackgroundColor(green)
            first.setTextColor(white)
            answers += "c"
        }

        binding.buttonThirdNext.setOnClickListener {
            if (answers?.length == 1) {
                Toast.makeText(context, getString(R.string.answer), Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(ThirdFragmentDirections.actionThirdFragmentToFourthFragment(answers!!))
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}