package com.example.focusflowai.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.focusflowai.R
import com.example.focusflowai.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startIntroAnimation()
    }

    private fun startIntroAnimation() {
        binding.logoImage.animate()
            .alpha(1f)
            .setDuration(1200)
            .withEndAction {
                binding.logoImage.postDelayed({

                    binding.logoImage.animate()
                        .alpha(0f)
                        .setDuration(800)
                        .withEndAction {
                            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)

                        }.start()

                }, 800)
            }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}