package com.example.focusflowai.ui.student.learning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.focusflowai.R
import com.example.focusflowai.databinding.FragmentLearningFramentBinding
import com.example.focusflowai.databinding.FragmentStudentDashBoardBinding

class LearningFrament : Fragment(R.layout.fragment_learning_frament) {
    private var _binding: FragmentLearningFramentBinding? = null
    private val binding get() = _binding!!
    private var lesson =  1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLearningFramentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            lesson ++
            if(lesson <=  3){
                binding.tvLesson.text = "Lesson $lesson of 3"
                binding.progressCount.text = "$lesson/3"
                binding.tvLessonTitle.text = "Lesson $lesson : Array DSA Problem Find Largest Element in Array"
            }else{
                findNavController().navigate(R.id.action_learningFrament_to_quizFragment)
            }
        }

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}