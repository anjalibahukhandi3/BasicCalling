package com.intern.callingapp

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class IncomingCallFragmentDirections private constructor() {
  public companion object {
    public fun actionIncomingCallFragmentToActiveCallFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_incomingCallFragment_to_activeCallFragment)

    public fun actionIncomingCallFragmentToDialPadFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_incomingCallFragment_to_dialPadFragment)
  }
}
