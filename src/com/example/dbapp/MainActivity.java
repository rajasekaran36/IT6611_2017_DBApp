package com.example.dbapp;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	private SQLiteDatabase sb;
	EditText input;
	Button add;
	SQLiteOpenHelper open_helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.username);
        add = (Button) findViewById(R.id.add_button);
        
        open_helper.getWritableDatabase();
        
        
        
        sb = openOrCreateDatabase("names", Context.MODE_PRIVATE, null);
        sb.execSQL("CREATE TABLE IF NOT EXISTS persons(name VARCHAR);");
        add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				sb.execSQL("INSERT INTO persons (name) VALUES ('"+input.getText().toString()+"')");
				Toast.makeText(getApplicationContext(), "Data Saved ...", Toast.LENGTH_LONG).show();
				
			}
		});
    }

  
}
