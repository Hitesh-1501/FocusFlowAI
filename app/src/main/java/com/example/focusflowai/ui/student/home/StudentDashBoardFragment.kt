package com.example.focusflowai.ui.student.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.focusflowai.R
import com.example.focusflowai.databinding.FragmentSplashBinding
import com.example.focusflowai.databinding.FragmentStudentDashBoardBinding


class StudentDashBoardFragment : Fragment(R.layout.fragment_student_dash_board) {
    private var _binding: FragmentStudentDashBoardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentDashBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStartLearning.setOnClickListener {
            findNavController().navigate(R.id.action_studentDashBoardFragment_to_learningFrament)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}