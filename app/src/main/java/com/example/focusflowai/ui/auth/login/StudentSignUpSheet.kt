package com.example.focusflow.ui.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.focusflowai.databinding.BottomSheetStudentSignupBinding
import com.example.focusflowai.ui.auth.login.AuthViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class StudentSignUpSheet: BottomSheetDialogFragment(){

    private var _binding: BottomSheetStudentSignupBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomSheetStudentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvlogin.setOnClickListener {
            dismiss()
            val loginSheet = StudentBottomSheetLogin()
            loginSheet.show(parentFragmentManager, "login_sheet")
        }
        binding.btnRegister.setOnClickListener {

            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val pass = binding.etPassword.text.toString()

            if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                return@setOnClickListener
            }

            registerStudent(name, email, pass)
        }
    }
    private fun registerStudent(name:String,email:String,password:String){4
        val success = viewModel.signup(name,email,password)
        if(success){
            dismiss()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}