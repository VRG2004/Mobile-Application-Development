package com.example.Program6;

import android.app.Activity;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Handler;

import android.widget.Button;

import android.widget.TextView;

public class MainActivity extends Activity {

Handler hand=new Handler();

TextView timer;

@Override

protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);

setContentView(R.layout.activity_main);

timer=(TextView)findViewById(R.id.timer);

String zero="10";

timer.setText(zero);

hand.postDelayed(run,1000);

}

Runnable run=new Runnable() {

@Override

public void run() {

updateTime();

}

};

private void updateTime() {

timer.setText(String.valueOf(Integer.parseInt(timer.getText().toString())-1));

if ((Integer.parseInt(timer.getText().toString())==0))

{

Intent a=new Intent(getApplicationContext(),newact1.class);

startActivity(a);

}

else

{

hand.postDelayed(run,1000);
}
}
}
