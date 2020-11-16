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

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// In the file, create an abstract class called SleepDatabase that extends RoomDatabase.
// Supply the SleepNight as the only item with the list of entities.
// Set the version as 1. Whenever you change the schema, you'll have to increase the version number.
// Set exportSchema to false, so as not to keep schema version history backups.

@Database(entities = [SleepNight::class], version = 1, exportSchema = false)
abstract class SleepDatabase : RoomDatabase() {

    // The database needs to know about the DAO. Inside the body of the class, declare an abstract
    // value that returns the SleepDatabaseDao. You can have multiple DAOs.
    abstract val sleepDatabaseDao: SleepDatabaseDao

    // Below that, define a companion object. The companion object allows clients to access the methods
    // for creating or getting the database without instantiating the class. Since the only purpose of
    // this class is to provide a database, there is no reason to ever instantiate it
    companion object {

        // Below that, define a companion object. The companion object allows clients to access the methods
        // for creating or getting the database without instantiating the class. Since the only purpose of
        // this class is to provide a database, there is no reason to ever instantiate it.

        // Annotate INSTANCE with @Volatile. The value of a volatile variable will never be cached, and all
        // writes and reads will be done to and from the main memory.
        @Volatile
        private var INSTANCE: SleepDatabase? = null

        // Below INSTANCE, still inside the companion object, define a getInstance()method with a Context
        // parameter that the database builder will need. Return a type SleepDatabase
        fun getInstance(context: Context): SleepDatabase {
            // Pass in this so that you can access the context.

            // Wrapping the code to get the database into synchronized means that only one thread of
            // execution at a time can enter this block of code, which makes sure the database only gets
            // initialized once.
            synchronized(this) {
                //  copy the current value of INSTANCE to a local variable instance. This is to take
                //  advantage of smart cast, which is only available to local variables.
                var instance = INSTANCE

                // add an if statement to check whether instance is null, that is, there is no database yet
                if (instance == null) {
                    // If instance is null, use the database builder to get a database. In the body of
                    // the if statement, invoke Room.databaseBuilder and supply the context that you
                    // passed in, the database class, and a name for the database, sleep_history_database
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            SleepDatabase::class.java,
                            "sleep_history_database"
                    )
                            // Add the required migration strategy to the builder.
                            //Normally, you would have to provide a migration object with a migration
                            // strategy for when the schema changes. A migration object is an object that
                            // defines how you take all rows with the old schema and convert them to rows
                            // in the new schema, so that no data is lost
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }

                // Inside the synchronized block, return instance at the end of the synchronized block.
                // Ignore the return type mismatch error; you won't ever return null once you are done.
                return instance
            }
        }
    }
}
