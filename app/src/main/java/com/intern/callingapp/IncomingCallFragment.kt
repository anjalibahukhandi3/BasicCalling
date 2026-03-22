package com.intern.callingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.intern.callingapp.databinding.FragmentIncomingCallBinding

class IncomingCallFragment : Fragment() {

    private var _binding: FragmentIncomingCallBinding? = null
    private val binding get() = _binding!!

    private val args: IncomingCallFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIncomingCallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvCallerName.text = args.callerName

        binding.btnAccept.setOnClickListener {
            findNavController().navigate(R.id.action_incomingCallFragment_to_activeCallFragment)
        }

        binding.btnReject.setOnClickListener {
            findNavController().navigate(R.id.action_incomingCallFragment_to_dialPadFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
