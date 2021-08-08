package com.example.Program8;

import android.annotation.TargetApi;

import android.os.Build;

import android.os.Environment;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

import android.widget.Toast;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileOutputStream;

import java.io.FileReader;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

File f;

EditText txt;

@Override

protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);

setContentView(R.layout.activity_main);

try

{

txt=(EditText) findViewById(R.id.multi);

File sdCard = Environment.getExternalStorageDirectory();

File dir = new File (sdCard.getAbsolutePath() + "/AndroidLab/");

if(!dir.exists())

dir.mkdirs();

f= new File(dir, "text.txt");
  
  if(!f.exists())

f.createNewFile();

}

catch (Exception e){

Toast.makeText(MainActivity.this, e.getMessage()+"Line : "+e.getStackTrace()[0].getLineNumber(),

Toast.LENGTH_SHORT).show();

}

}

@TargetApi(Build.VERSION_CODES.KITKAT)

public void read(View view) throws IOException {

try {

StringBuilder text = new StringBuilder();

BufferedReader br = new BufferedReader(new FileReader(f));

String line;

while ((line = br.readLine()) != null) {

text.append(line);

text.append('\n');

}

br.close();

txt.setText(text.toString());

}

catch (Exception e) {

Toast.makeText(MainActivity.this, e.getMessage() + "Line : " + e.getStackTrace()[0].getLineNumber(),

Toast.LENGTH_SHORT).show();

}

}

public void save(View view) throws IOException {

FileOutputStream os =new FileOutputStream(f);

String data=txt.getText().toString();

os.write(data.getBytes());

os.close();

Toast.makeText(MainActivity.this, "File Saved Sucessfully", Toast.LENGTH_SHORT).show();

}

public void clear(View view) {

txt.setText("");

}}
