package com.example.loginfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginfinal.DB.DbHelper;

public class LoginActivity extends AppCompatActivity {

        private Button login, register;
        private EditText username, etPass;
        private DbHelper db;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            db = new DbHelper(this);
            login = (Button) findViewById(R.id.bt_login);
            register = (Button) findViewById(R.id.bt_resigter);
            username = (EditText) findViewById(R.id.et_user);
            etPass = (EditText) findViewById(R.id.et_pass);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    login();
                }
            });
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
            });
        }

    private void login() {
        String username1 = username.getText().toString();
        String pass = etPass.getText().toString();

        if (db.getUser(username1, pass)) {
            Intent intent=new Intent(LoginActivity.this, MainActivity.class);
            String name=db.getname(username1);
            intent.putExtra("name",name);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "infalid email or password", Toast.LENGTH_SHORT).show();
        }
    }

}
