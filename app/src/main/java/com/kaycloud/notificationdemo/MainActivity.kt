package com.kaycloud.notificationdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID = "11111111"
    private val CHANNEL_ID_2 = "2222222"
    private val CHANNEL_ID_3 = "22222"
    private val CHANNEL_ID_4 = "2222342322"


    private val title1 = "title1"
    private val message1 = "message1"
    private val title2 = "title2"
    private val message2 = "message2"

    private var notifyId = 1

    val GROUP_KEY_WORK_EMAIL = "com.android.example.WORK_EMAIL"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
        val remoteViews = RemoteViews(packageName, R.layout.item_layout)
        var notification1 = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setAutoCancel(true)
            .setShowWhen(true)
            .setCategory(NotificationCompat.CATEGORY_SOCIAL)
//            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomContentView(remoteViews)
//            .setContentTitle(title1)
//            .setContentText(message1)
            .setGroup(GROUP_KEY_WORK_EMAIL)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .build()


        var notification2 = NotificationCompat.Builder(this, CHANNEL_ID_2)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomContentView(remoteViews)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setAutoCancel(true)
            .setShowWhen(true)
            .setCategory(NotificationCompat.CATEGORY_SOCIAL)
//            .setContentTitle(title2)
//            .setContentText(message2)
            .setGroup(GROUP_KEY_WORK_EMAIL)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .build()

        var notification3 = NotificationCompat.Builder(this, CHANNEL_ID_3)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomContentView(remoteViews)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setAutoCancel(true)
            .setShowWhen(true)
            .setCategory(NotificationCompat.CATEGORY_SOCIAL)
//            .setContentTitle(title2)
//            .setContentText(message2)
            .setGroup(GROUP_KEY_WORK_EMAIL)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .build()

        var notification4 = NotificationCompat.Builder(this, CHANNEL_ID_4)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomContentView(remoteViews)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setAutoCancel(true)
            .setShowWhen(true)
            .setCategory(NotificationCompat.CATEGORY_SOCIAL)
//            .setContentTitle(title2)
//            .setContentText(message2)
            .setGroup(GROUP_KEY_WORK_EMAIL)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .build()

        var notificationSummary = NotificationCompat.Builder(this, CHANNEL_ID_4)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title2)
            .setContentText(message2)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setShowWhen(true)
            .setGroup(GROUP_KEY_WORK_EMAIL)
//            .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_CHILDREN)
            .setGroupSummary(true)
            .build()

//        for (id in 1..5) {
        with(NotificationManagerCompat.from(this)) {
            notify(notifyId++, notification1)
            notify(notifyId++, notification2)
            notify(notifyId++, notification3)
            notify(notifyId++, notification4)
            notify(notifyId++, notificationSummary)
        }
//        }

    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val channel2 = NotificationChannel(CHANNEL_ID_2, name, importance).apply {
                description = descriptionText
            }
            val channel3 = NotificationChannel(CHANNEL_ID_3, name, importance).apply {
                description = descriptionText
            }
            val channel4 = NotificationChannel(CHANNEL_ID_4, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(channel2)
            notificationManager.createNotificationChannel(channel3)
            notificationManager.createNotificationChannel(channel4)
        }
    }

}
