/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

/*
The MarsApiService class holds the network layer for the app; that is, this is the API that your ViewModel
will use to communicate with the web service. This is the class where you will implement the Retrofit service
API.
*/

package com.example.android.marsrealestate.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
        "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

/*
Right now the goal is to get the JSON response string from the web service, and you
only need one method to do that: getProperties(). To tell Retrofit what this method
should do, use a @GET annotation and specify the path, or endpoint, for that web service
method. In this case the endpoint is called realestate. When the getProperties() method
is invoked, Retrofit appends the endpoint realestate to the base URL (which you defined
in the Retrofit builder), and creates a Call object. That Call object is used to start
the request.
*/
interface MarsApiService {
    @GET("realestate")
    fun getProperties():
            Call<String>
}

object MarsApi {
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}