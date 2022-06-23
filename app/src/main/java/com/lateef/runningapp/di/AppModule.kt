package com.lateef.runningapp.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.lateef.runningapp.data.db.RunningDatabase
import com.lateef.runningapp.other.Constants
import com.lateef.runningapp.other.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunningDatabase(@ApplicationContext app: Context)
            = Room.databaseBuilder(app, RunningDatabase::class.java, RUNNING_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideRunDao(db: RunningDatabase) = db.getRunDao()

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext app: Context) =
            app.getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)


    @Singleton
    @Provides
    fun providesName(sharedPref: SharedPreferences) = sharedPref.getString(Constants.KEY_NAME, "")?: ""

    @Singleton
    @Provides
    fun providesWeight(sharedPref: SharedPreferences) = sharedPref.getFloat(Constants.KEY_WEIGHT, 80f)

    @Singleton
    @Provides
    fun providesFistTimeToggle(sharedPref: SharedPreferences) = sharedPref.getBoolean(
            Constants.KEY_FIRST_TIME_TOGGLE, true)
}