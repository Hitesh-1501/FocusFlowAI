package com.example.focusflow.ui.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.focusflowai.databinding.BottomSheetInstructorSignupBinding
import com.example.focusflowai.databinding.BottomSheetStudentSignupBinding
import com.example.focusflowai.ui.auth.login.AuthViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class InstructorSignUpSheet: BottomSheetDialogFragment(){

    private var _binding: BottomSheetInstructorSignupBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomSheetInstructorSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvAlreadyHaveAcc.setOnClickListener {
            dismiss()
            val loginSheet = InstructorBottomSheetLogin()
            loginSheet.show(parentFragmentManager, "login_instructor_sheet")
        }
        binding.btnSignup.setOnClickListener {

            val email = binding.etSignupEmail.text.toString()
            val pass = binding.etSignupPassword.text.toString()

            if (email.isEmpty() || pass.isEmpty()) {
                return@setOnClickListener
            }

            registerInstructor(email, pass)
        }
    }
    private fun registerInstructor(email:String,password:String){
        val success = viewModel.signupInstructor(email,password)
        if(success){
            dismiss()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}