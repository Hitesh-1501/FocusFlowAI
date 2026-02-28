package com.example.focusflowai.ui.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.focusflow.ui.auth.login.InstructorBottomSheetLogin
import com.example.focusflow.ui.auth.login.StudentBottomSheetLogin
import com.example.focusflowai.R
import com.example.focusflowai.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.studentCard.setOnClickListener {
            studentBottomSheetBar()
        }
        binding.instructorCard.setOnClickListener {
            InstructorBottomSheetBar()
        }

    }
    fun studentBottomSheetBar(){
        val loginBottomSheet = StudentBottomSheetLogin()
        loginBottomSheet.show(parentFragmentManager, "student_bottom_sheet")
    }
    fun InstructorBottomSheetBar(){
        val loginBottomSheet = InstructorBottomSheetLogin()
        loginBottomSheet.show(parentFragmentManager, "instructor_bottom_sheet")
    }
}