package com.intern.callingapp

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class ActiveCallFragmentDirections private constructor() {
  public companion object {
    public fun actionActiveCallFragmentToDialPadFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_activeCallFragment_to_dialPadFragment)
  }
}
