package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;

import android.app.NotificationManager;

import android.app.PendingIntent;

import android.content.Context;

import android.content.Intent;

import android.os.Build;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import java.text.SimpleDateFormat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

@Override

protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);

setContentView(R.layout.activity_main);

Button notify = findViewById(R.id.b1);

notify.setOnClickListener(new View.OnClickListener() {

@Override

public void onClick(View v) {

addnotification();

}

});

}

private void addnotification() {

NotificationCompat.Builder builder = new NotificationCompat.Builder(this,

"abc").setContentTitle("SJCE").setContentText("Have a nice day").setSmallIcon(R.mipmap.ic_launcher);

Intent notificationIntent = new Intent(this, MainActivity.class);

PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,

PendingIntent.FLAG_UPDATE_CURRENT);

builder.setContentIntent(contentIntent);

NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

manager.notify(0, builder.build());

}
