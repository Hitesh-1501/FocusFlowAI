package com.example.focusflow.ui.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.focusflowai.R
import com.example.focusflowai.databinding.BottomSheetStudentLoginBinding
import com.example.focusflowai.ui.auth.login.AuthViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class StudentBottomSheetLogin: BottomSheetDialogFragment(){
    private var _binding: BottomSheetStudentLoginBinding ? = null
    private val binding get() = _binding!!

    private val viewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomSheetStudentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvDontHaveAcc.setOnClickListener {
            dismiss()
            val signupSheet = StudentSignUpSheet()
            signupSheet.show(parentFragmentManager,"signup_sheet")
        }
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                binding.etEmail.error = "Required"
                return@setOnClickListener
            }
            loginStudent(email, password)
        }
    }

    private fun loginStudent(email: String,password: String){
        val success = viewModel.login(email,password)
        if(success){
            dismiss()
            requireActivity()
                .findNavController(R.id.nav_host_fragment)
                .navigate(R.id.action_loginFragment_to_studentDashBoardFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}