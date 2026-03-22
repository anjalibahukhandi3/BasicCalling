package com.intern.callingapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.intern.callingapp.databinding.FragmentOutgoingCallBinding

class OutgoingCallFragment : Fragment() {

    private var _binding: FragmentOutgoingCallBinding? = null
    private val binding get() = _binding!!
    
    private val args: OutgoingCallFragmentArgs by navArgs()
    private val handler = Handler(Looper.getMainLooper())
    private val connectRunnable = Runnable {
        // Automatically connect the call after 3 seconds
        findNavController().navigate(R.id.action_outgoingCallFragment_to_activeCallFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOutgoingCallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.tvDialedNumber.text = args.number
        
        binding.btnEndCall.setOnClickListener {
            handler.removeCallbacks(connectRunnable)
            findNavController().navigate(R.id.action_outgoingCallFragment_to_dialPadFragment)
        }
        
        // Simulate picking up
        handler.postDelayed(connectRunnable, 3000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(connectRunnable)
        _binding = null
    }
}
