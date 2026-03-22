package com.intern.callingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.intern.callingapp.databinding.FragmentActiveCallBinding

class ActiveCallFragment : Fragment() {

    private var _binding: FragmentActiveCallBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ActiveCallViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActiveCallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ActiveCallViewModel::class.java]

        setupObservers()
        setupClickListeners()
    }

    private fun setupObservers() {
        viewModel.callDuration.observe(viewLifecycleOwner) { duration ->
            binding.tvTimer.text = duration
        }

        viewModel.isMuted.observe(viewLifecycleOwner) { isMuted ->
            binding.btnMute.alpha = if (isMuted) 1.0f else 0.5f
        }

        viewModel.isSpeakerOn.observe(viewLifecycleOwner) { isSpeakerOn ->
            binding.btnSpeaker.alpha = if (isSpeakerOn) 1.0f else 0.5f
        }
    }

    private fun setupClickListeners() {
        binding.btnMute.setOnClickListener {
            viewModel.toggleMute()
        }

        binding.btnSpeaker.setOnClickListener {
            viewModel.toggleSpeaker()
        }

        binding.btnEndCall.setOnClickListener {
            findNavController().navigate(R.id.action_activeCallFragment_to_dialPadFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
