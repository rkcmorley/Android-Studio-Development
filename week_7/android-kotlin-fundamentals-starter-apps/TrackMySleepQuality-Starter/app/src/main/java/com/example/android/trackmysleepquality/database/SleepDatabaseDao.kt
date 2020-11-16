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
 */

package com.example.android.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SleepDatabaseDao{
    // Note: You can call the function anything you want.
    @Insert
    fun insert(night: SleepNight)

    @Update
    fun update(night: SleepNight)

    // Add a @Query annotation with a get() function that takes a Long key argument and returns
    // a nullable SleepNight. You'll see an error for a missing parameter.

    //  The query is supplied as a string parameter to the annotation. Add a parameter to @Query.
    //  Make it a String that is a SQLite query.

    // Select all columns from the daily_sleep_quality_table
    // WHERE the nightId matches the :key argument.

    // Notice the :key. You use the colon notation in the query to reference arguments in the function.

    @Query("SELECT * from daily_sleep_quality_table WHERE nightId = :key")
    fun get(key: Long): SleepNight?


    // The @Delete annotation is great for deleting specific entries, but not efficient for clearing
    // all entries from a table.
    @Query("DELETE FROM daily_sleep_quality_table")
    fun clear()

    // To get "tonight" from the database, write a SQLite query that returns the first element of a list of
    // results ordered by nightId in descending order. Use LIMIT 1 to return only one element.
    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC LIMIT 1")
    fun getTonight(): SleepNight?


    // Have getAllNights() return a list of SleepNight entities as LiveData. Room keeps this LiveData
    // updated for you, which means you only need to explicitly get the data once.
    // You may need to import LiveData from androidx.lifecycle.LiveData.
    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC")
    fun getAllNights(): LiveData<List<SleepNight>>
}

