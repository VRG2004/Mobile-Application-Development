package com.example.Program9;

import android.app.PendingIntent;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.telephony.SmsManager;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

Button b1;

EditText e1;

EditText e2;

@Override

protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);

setContentView(R.layout.activity_main);

b1 = (Button) findViewById(R.id.b1);

e1= (EditText) findViewById(R.id.e1);

e2= (EditText) findViewById(R.id.e2);

b1.setOnClickListener(new View.OnClickListener() {

public void onClick(View v) {

String phoneNo = e1.getText().toString();

String message = e2.getText().toString();

if (phoneNo.length() > 0 && message.length() > 0)

sendSMS(phoneNo, message);

else

Toast.makeText(getBaseContext(),

"Please enter both phone number and message.",

Toast.LENGTH_SHORT).show();

}

});

}

private void sendSMS(String phoneNumber, String message)

{

PendingIntent pi = PendingIntent.getActivity(this, 0,

new Intent(this, MainActivity.class), 0);

SmsManager sms = SmsManager.getDefault();

sms.sendTextMessage(phoneNumber, null, message, pi, null);

Toast.makeText(MainActivity.this, "SMS sent", Toast.LENGTH_SHORT).show();

}
}
