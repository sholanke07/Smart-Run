package com.lateef.runningapp.di

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.lateef.runningapp.R
import com.lateef.runningapp.other.Constants
import com.lateef.runningapp.ui.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped

@Module
@InstallIn(ServiceComponent::class)
object ServiceModule {

    @ServiceScoped  //for the life time of our service, they will be only one instance
    @Provides
    fun provideFusedLocationProviderClient(@ApplicationContext app: Context) =
        FusedLocationProviderClient(app)

    @ServiceScoped
    @Provides
    fun provideMainActivityPendingIntent(@ApplicationContext app: Context) =
        PendingIntent.getActivity(app, 0, Intent(app, MainActivity::class.java).also {
        it.action = Constants.ACTION_SHOW_TRACKING_FRAGMENT
    },
    PendingIntent.FLAG_UPDATE_CURRENT
    )

    @ServiceScoped
    @Provides
    fun provideBaseNotificationBuilder(@ApplicationContext app: Context, pendingIntent: PendingIntent) =
        NotificationCompat.Builder(app, Constants.NOTIFICATION_CHANEL_ID)
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_directions_run_black_24dp)
            .setContentTitle("Smart")
            .setContentText("00:00:00")
            .setContentIntent(pendingIntent)


}