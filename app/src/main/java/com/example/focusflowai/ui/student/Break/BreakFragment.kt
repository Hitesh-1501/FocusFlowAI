package com.example.focusflowai.ui.student.Break

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.focusflowai.R
import com.example.focusflowai.databinding.FragmentBreakBinding
import com.example.focusflowai.databinding.FragmentLoginBinding

class BreakFragment : Fragment(R.layout.fragment_break) {

    private var _binding: FragmentBreakBinding? = null
    private val binding get() = _binding!!
    private lateinit var timer: CountDownTimer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentBreakBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startBreakTimer()
    }

    private fun startBreakTimer() {

        val totalTime = 5 * 60 * 1000L // 5 minutes

            timer = object : CountDownTimer(totalTime, 1000) {

            @SuppressLint("DefaultLocale")
            override fun onTick(millisUntilFinished: Long) {

                val minutes = millisUntilFinished / 1000 / 60
                val seconds = (millisUntilFinished / 1000) % 60

                binding.tvTimer.text =
                    String.format("%02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                findNavController().navigate(
                    R.id.action_breakFragment_to_studentHistoryFragment
                )
            }

        }.start()
    }
}