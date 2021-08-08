package com.example.Program4;
import android.database.Cursor; 
import android.database.sqlite.SQLiteDatabase; 
import android.support.v7.app.AppCompatActivity; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.EditText;
import android.widget.Toast; 
public class MainActivity extends AppCompatActivity 
{
SQLiteDatabase myDb; 
EditText name1; 
EditText roll1; 
EditText dept1; 
@Override protected void onCreate(Bundle savedInstanceState)
{
super.onCreate(savedInstanceState); 
setContentView(R.layout.activity_main); 
name1= (EditText) findViewById(R.id.name);
roll1= (EditText) findViewById(R.id.roll);
dept1= (EditText) findViewById(R.id.dept); 
name1.setText(""); 
roll1.setText(""); 
dept1.setText("");
myDb=openOrCreateDatabase("classs", MODE_PRIVATE, null); //table creation myDb.execSQL("CREATE TABLE IF NOT EXISTS studentt(rollnumber VARCHAR,name VARCHAR,department VARCHAR);"); // myDb.close(); } public void ins(View v){ String name=name1.getText().toString(); String roll=roll1.getText().toString(); String dept=dept1.getText().toString(); //database creation //Toast.makeText(MainActivity.this, roll, Toast.LENGTH_SHORT).show(); myDb=openOrCreateDatabase("classs", MODE_PRIVATE, null); myDb.execSQL("INSERT INTO studentt VALUES('" + roll + "','" + name + "','" + dept + "');"); name1.setText(""); roll1.setText(""); dept1.setText("");

}
public void show(View v)
{

EditText roll2= (EditText) findViewById(R.id.roll);
myDb=openOrCreateDatabase("classs", MODE_PRIVATE, null);
Cursor c=myDb.rawQuery("SELECT * FROM studentt WHERE rollnumber='"+roll2.getText().toString()+"'", null); if(c!=null&&c.moveToFirst()) 
{

roll1.setText(c.getString(0));

name1.setText(c.getString(1));

dept1.setText(c.getString(2));

c.close();
}
else {

Toast.makeText(MainActivity.this, "No values", Toast.LENGTH_SHORT).show(); 
}

} 
public void delete(View v)
{
EditText roll2= (EditText) findViewById(R.id.roll);
try 
{
myDb=openOrCreateDatabase("classs", MODE_PRIVATE, null); 
myDb.delete("studentt","rollnumber=?",new String[]{roll2.getText().toString()});
Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show(); 
name1.setText(""); roll1.setText(""); dept1.setText("");
}
catch (Exception d)
{
Toast.makeText(MainActivity.this, " No values", Toast.LENGTH_SHORT).show();
}

}

}
