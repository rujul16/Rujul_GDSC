package com.example.rujul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTextPersonName;
    private EditText editTextTextPersonName2;
    private Button button;
    private String UserName = "test@admin.com";
    private String Password = "12345678";
    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = editTextTextPersonName.getText().toString();
                String inputPw = editTextTextPersonName2.getText().toString();
                if (inputName.isEmpty() || inputPw.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter the Details Properly", Toast.LENGTH_SHORT).show();
                }
                else {
                    isValid = validate(inputName, inputPw);
                    if (!isValid){
                        Toast.makeText(MainActivity.this, "Wrong Details, Try Again", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this , Saved.class);
                        startActivity(intent);

                    }
                }

            }
        });
    }
    private boolean validate(String name , String password){
        if (name.equals(UserName) && password.equals(Password)){
            return true;
        }
        return false;
    }

}