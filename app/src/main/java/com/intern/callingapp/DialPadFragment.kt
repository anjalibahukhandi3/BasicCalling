package com.intern.callingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.intern.callingapp.databinding.FragmentDialPadBinding

class DialPadFragment : Fragment() {

    private var _binding: FragmentDialPadBinding? = null
    private val binding get() = _binding!!
    
    private lateinit var viewModel: DialPadViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialPadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DialPadViewModel::class.java]

        setupObservers()
        setupClickListeners()
    }

    private fun setupObservers() {
        viewModel.inputNumber.observe(viewLifecycleOwner) { number ->
            binding.tvInput.text = number
        }
    }

    private fun setupClickListeners() {
        val numberButtons = listOf(
            binding.btn0 to "0", binding.btn1 to "1", binding.btn2 to "2",
            binding.btn3 to "3", binding.btn4 to "4", binding.btn5 to "5",
            binding.btn6 to "6", binding.btn7 to "7", binding.btn8 to "8",
            binding.btn9 to "9", binding.btnStar to "*", binding.btnHash to "#"
        )

        numberButtons.forEach { (btn, digit) ->
            btn.setOnClickListener { viewModel.appendDigit(digit) }
        }

        binding.btnBackspace.setOnClickListener {
            viewModel.backspace()
        }
        
        binding.btnBackspace.setOnLongClickListener {
            viewModel.clear()
            true
        }

        binding.btnCall.setOnClickListener {
            val number = viewModel.inputNumber.value ?: ""
            if (number.isNotEmpty()) {
                val action = DialPadFragmentDirections.actionDialPadFragmentToOutgoingCallFragment(number)
                findNavController().navigate(action)
            }
        }

        binding.btnSimulateIncoming.setOnClickListener {
            val action = DialPadFragmentDirections.actionDialPadFragmentToIncomingCallFragment("Unknown Caller")
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
