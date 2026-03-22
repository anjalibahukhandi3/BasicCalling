package com.intern.callingapp

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class OutgoingCallFragmentDirections private constructor() {
  public companion object {
    public fun actionOutgoingCallFragmentToActiveCallFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_outgoingCallFragment_to_activeCallFragment)

    public fun actionOutgoingCallFragmentToDialPadFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_outgoingCallFragment_to_dialPadFragment)
  }
}
