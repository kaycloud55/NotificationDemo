package com.kaycloud.notificationdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID = "11111111"
    private val CHANNEL_ID_2 = "2222222"


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
        var notification1 = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title1)
            .setContentText(message1)
            .setGroup(GROUP_KEY_WORK_EMAIL)
            .setStyle(NotificationCompat.InboxStyle())
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()


        var notification2 = NotificationCompat.Builder(this, CHANNEL_ID_2)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title2)
            .setContentText(message2)
            .setStyle(NotificationCompat.InboxStyle())
            .setGroup(GROUP_KEY_WORK_EMAIL)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()

        var notificationSummary = NotificationCompat.Builder(this, CHANNEL_ID_2)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title2)
            .setContentText(message2)
//            .setStyle(
//                NotificationCompat.InboxStyle()
//                    .addLine("$title2 $message2")
//                    .addLine("$title1 $message1")
//                    .addLine("$title1 $message1")
//                    .addLine("$title1 $message1")
//                    .addLine("$title1 $message1")
//                    .addLine("$title1 $message1")
//                    .addLine("$title1 $message1")
//                    .addLine("$title1 $message1")
//                    .addLine("$title1 $message1")
//                    .setBigContentTitle("2 new messages")
//                    .setSummaryText("user@example")
//            )
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setGroup(GROUP_KEY_WORK_EMAIL)
            .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_CHILDREN)
            .setGroupSummary(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT).build()

//        for (id in 1..5) {
        with(NotificationManagerCompat.from(this)) {
            notify(notifyId++, notification1)
            notify(notifyId++, notification2)
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
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(channel2)
        }
    }

}
