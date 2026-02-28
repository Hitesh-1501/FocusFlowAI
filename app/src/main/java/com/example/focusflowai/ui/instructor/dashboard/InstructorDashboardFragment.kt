package com.example.focusflowai.ui.instructor.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.focusflowai.R
import com.example.focusflowai.databinding.FragmentInstructorDashboardBinding


class InstructorDashboardFragment : Fragment(R.layout.fragment_instructor_dashboard) {
    private var _binding: FragmentInstructorDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInstructorDashboardBinding.inflate(inflater, container, false)
        return binding.root

    }
}