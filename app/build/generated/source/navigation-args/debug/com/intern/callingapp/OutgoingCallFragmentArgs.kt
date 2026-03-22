package com.intern.callingapp

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class OutgoingCallFragmentArgs(
  public val number: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("number", this.number)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("number", this.number)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): OutgoingCallFragmentArgs {
      bundle.setClassLoader(OutgoingCallFragmentArgs::class.java.classLoader)
      val __number : String?
      if (bundle.containsKey("number")) {
        __number = bundle.getString("number")
        if (__number == null) {
          throw IllegalArgumentException("Argument \"number\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"number\" is missing and does not have an android:defaultValue")
      }
      return OutgoingCallFragmentArgs(__number)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): OutgoingCallFragmentArgs {
      val __number : String?
      if (savedStateHandle.contains("number")) {
        __number = savedStateHandle["number"]
        if (__number == null) {
          throw IllegalArgumentException("Argument \"number\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"number\" is missing and does not have an android:defaultValue")
      }
      return OutgoingCallFragmentArgs(__number)
    }
  }
}
