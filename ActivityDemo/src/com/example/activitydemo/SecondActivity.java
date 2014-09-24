package com.example.activitydemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        String text = "";
        Intent i = getIntent();
        MyUser user;
        ArrayList<MyUser> userList;;

        // ����ͤ�ԡ���� Send Data to Second Activity
        if (i.getStringExtra("user1") != null) {
            text = "Name: " + i.getStringExtra("user1");
            text += ", Age: " + i.getIntExtra("age1", 0) + "\n";
            text += "Name: " + i.getStringExtra("user2");
            text += ", Age: " + i.getIntExtra("age2", 0) + "\n";
            
            Bundle bundle = i.getExtras();
            text += "Name: " + bundle.getString("user3");
            text += ", Age: " + bundle.getInt("age3") + "\n";
            text += "Name: " + bundle.getString("user4");
            text += ", Age: " + bundle.getInt("age4");
        }
        // ����ͤ�ԡ���� Send Object to Second Activity
        else if ((user = (MyUser) i.getSerializableExtra("someuser")) != null) {
            text = "Name: " + user.getName();
            text += ", Age: " + user.getAge();
        }
        // ����ͤ�ԡ���� Send Multiple Objects (Using ArrayList)
        else if ((userList = (ArrayList<MyUser>) i.getSerializableExtra("allusers")) != null) {
            for (MyUser u : userList) {
                text += "Name: " + u.getName();
                text += ", Age: " + String.valueOf(u.getAge()) + "\n";
            }
        }
        
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

}
