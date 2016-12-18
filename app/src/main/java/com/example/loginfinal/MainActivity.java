package com.example.loginfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView showname=(TextView)findViewById(R.id.tv_showname);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        showname.setText(name);
    }
}
