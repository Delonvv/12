package com.example.delivery;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText phoneEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);

        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        Button register = findViewById(R.id.register_but);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String phone =  phoneEditText.getText().toString();
                String password = passwordEditText.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    showErrorDialog("Both email and password are required.");
                } else if (!isValidEmail(email)) {
                    showErrorDialog("Please enter a valid email address.");
                } else  if (!isValidPhoneNumber(phone)){
                    showErrorDialog("Please enter a valid phone number.");
                    // Continue with login process
                }
            }
        });

    }

    private boolean isValidPhoneNumber(String phone) {

        Pattern phonePattern = Pattern.compile("^[+]?[0-9]{10,13}$");
        Matcher phoneMatcher = phonePattern.matcher(phone);
        return phoneMatcher.matches();
    }


    private boolean isValidEmail(String email) {
        String emailPattern = "^[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?@[a-z0-9]+(?:\\.[a-z0-9]+)*(\\.[a-z]{2,3})$";
        return Pattern.matches(emailPattern, email);
    }

    private void showErrorDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setTitle("Error")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();


    }
}
