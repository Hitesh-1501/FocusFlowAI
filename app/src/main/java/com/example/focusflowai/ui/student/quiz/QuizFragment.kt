package com.example.focusflowai.ui.student.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.focusflowai.R
import com.example.focusflowai.databinding.FragmentQuizBinding

class QuizFragment : Fragment(R.layout.fragment_quiz) {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private var question = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            question++
            if(question <= 5){
                binding.tvCount.text = "Question $question of 5"
            }
            if(question == 5){
                binding.btnNext.text = "Submit"
            }
            if (question > 5){
                findNavController().navigate(R.id.action_quizFragment_to_studentPredictionFragment)
            }
        }
    }

}