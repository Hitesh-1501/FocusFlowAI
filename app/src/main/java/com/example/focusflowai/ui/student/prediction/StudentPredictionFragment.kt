package com.example.focusflowai.ui.student.prediction

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.focusflowai.R
import com.example.focusflowai.databinding.BottomSheetInstructorLoginBinding
import com.example.focusflowai.databinding.FragmentStudentPredictionBinding
import com.example.focusflowai.databinding.LayoutFatiguePopupBinding

class StudentPredictionFragment : Fragment(R.layout.fragment_student_prediction) {
    private var _binding: FragmentStudentPredictionBinding ? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentPredictionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnContinue.setOnClickListener {
            showFatiguePopup()
        }
    }
    private fun showFatiguePopup() {
        val popupBinding = LayoutFatiguePopupBinding.inflate(layoutInflater)

        val dialog = Dialog(requireContext())
        dialog.setContentView(popupBinding.root)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        popupBinding.btnContinueLearning.setOnClickListener {
            dialog.dismiss()
            findNavController().navigate(R.id.action_studentPredictionFragment_to_studentHistoryFragment)
        }
        popupBinding.btnTakeBreak.setOnClickListener {
            dialog.dismiss()
            findNavController().navigate(R.id.action_studentPredictionFragment_to_breakFragment)

        }

        dialog.show()
    }
}