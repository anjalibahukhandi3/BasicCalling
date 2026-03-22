package com.intern.callingapp

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class IncomingCallFragmentArgs(
  public val callerName: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("callerName", this.callerName)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("callerName", this.callerName)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): IncomingCallFragmentArgs {
      bundle.setClassLoader(IncomingCallFragmentArgs::class.java.classLoader)
      val __callerName : String?
      if (bundle.containsKey("callerName")) {
        __callerName = bundle.getString("callerName")
        if (__callerName == null) {
          throw IllegalArgumentException("Argument \"callerName\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"callerName\" is missing and does not have an android:defaultValue")
      }
      return IncomingCallFragmentArgs(__callerName)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): IncomingCallFragmentArgs {
      val __callerName : String?
      if (savedStateHandle.contains("callerName")) {
        __callerName = savedStateHandle["callerName"]
        if (__callerName == null) {
          throw IllegalArgumentException("Argument \"callerName\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"callerName\" is missing and does not have an android:defaultValue")
      }
      return IncomingCallFragmentArgs(__callerName)
    }
  }
}
