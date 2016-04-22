package com.httpman_bok.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            SQLiteDatabase eventsDB = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);
            eventsDB.execSQL("CREATE TABLE IF NOT EXISTS events (event VARCHAR, year INT(4))");

            eventsDB.execSQL("INSERT INTO events (event, year) VALUES ('End of WW2', 1945)");
            eventsDB.execSQL("INSERT INTO events (event, year) VALUES ('Wham split up', 1986)");

            Cursor c = eventsDB.rawQuery("SELECT * FROM events", null);

            int eventIndex = c.getColumnIndex("event");
            int yearIndex = c.getColumnIndex("year");

            c.moveToFirst();

            while (c != null) {
                Log.i("Results - event", c.getString(eventIndex));
                Log.i("Results - year", Integer.toString(c.getInt(yearIndex)));

                c.moveToNext();
            }





        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }
}
/* Example Code
        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");

            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Rob', 34)");
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Gershom', 31)");
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Jill', 32)");

            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();
            while (c != null) {
                Log.i("name",c.getString(nameIndex));
                Log.i("age",Integer.toString(c.getInt(ageIndex)));

                c.moveToNext();

            }



        }
        catch (Exception e) {
            e.printStackTrace();
        }}*/



