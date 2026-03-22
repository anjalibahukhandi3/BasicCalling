package com.intern.callingapp

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class DialPadFragmentDirections private constructor() {
  private data class ActionDialPadFragmentToOutgoingCallFragment(
    public val number: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_dialPadFragment_to_outgoingCallFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("number", this.number)
        return result
      }
  }

  private data class ActionDialPadFragmentToIncomingCallFragment(
    public val callerName: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_dialPadFragment_to_incomingCallFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("callerName", this.callerName)
        return result
      }
  }

  public companion object {
    public fun actionDialPadFragmentToOutgoingCallFragment(number: String): NavDirections =
        ActionDialPadFragmentToOutgoingCallFragment(number)

    public fun actionDialPadFragmentToIncomingCallFragment(callerName: String): NavDirections =
        ActionDialPadFragmentToIncomingCallFragment(callerName)
  }
}
