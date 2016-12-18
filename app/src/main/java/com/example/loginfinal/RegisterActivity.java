package com.example.loginfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginfinal.DB.DbHelper;

public class RegisterActivity extends AppCompatActivity{
    private Button bt_create;
    private TextView tvLogin;
    private EditText etname, etUsername,etPassword;
    private DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DbHelper(this);
        bt_create = (Button)findViewById(R.id.bt_create);
        tvLogin = (TextView)findViewById(R.id.tv_login);
        etname = (EditText)findViewById(R.id.et_nameR);
        etUsername = (EditText)findViewById(R.id.et_usernameR);
        etPassword = (EditText)findViewById(R.id.et_passR);
        bt_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }


    private void register(){
        String name = etname.getText().toString();
        String username = etUsername.getText().toString();
        String Password = etPassword.getText().toString();
        if(db.chackUsername(username)) {
            if (name.isEmpty() && username.isEmpty() && Password.isEmpty()) {
                displayToast("Name/Username/password field empty");
            } else {
                db.addUser(name, username, Password);
                displayToast("Create Acount suscessfully");
                finish();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }else{
                displayToast("Username alerady exsit");
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
