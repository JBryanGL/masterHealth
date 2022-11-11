package com.codingstuff.loginandsignup
import com.google.gson.annotations.SerializedName
class response (
    @SerializedName("status") var status: String,
    @SerializedName("message")var images:List<String>)