package com.example.bmbfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmbfinal.Model.UserModel;
import com.example.bmbfinal.Service.DBUserService;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
public  static String onlineData;

    Button login,insertFirstUser;

    DBUserService dbUserService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login = findViewById(R.id.btnLogin);
        insertFirstUser = findViewById(R.id.btnInsert);

        dbUserService = new DBUserService(this);

        insertFirstUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                UserModel userModel = new UserModel();
                userModel.setEmail("11@11.11");
                userModel.setPassword("111");
                Boolean res = dbUserService.InsertUser(userModel);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User");

                if (res) {
                    builder.setMessage("Email: " + userModel.getEmail() + "\n" + "Password: " + userModel.getPassword());

                } else {
                    builder.setMessage(res.toString());

                }
                builder.show();

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserModel userModel = new UserModel();
                userModel.setEmail(email.getText().toString());
                userModel.setPassword(password.getText().toString());
                Boolean res = dbUserService.LoginUser(userModel);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");

                if (res) {
                    builder.setMessage("Success");
                    Intent intent = new Intent(MainActivity.this,OrderListingActivity.class);
                    startActivity(intent);

                } else {
                    builder.setMessage("Unsuccessful");
                }
                builder.show();
            }
        });
    }
}