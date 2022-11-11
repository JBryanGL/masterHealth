package com.codingstuff.loginandsignup

import com.google.android.gms.common.api.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface apiService {
    @GET
    suspend fun getInformation(@Url url:String):retrofit2.Response<response>
}