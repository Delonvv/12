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



public class SignIn extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.signin_screen);

            emailEditText = findViewById(R.id.editTextUsername);
            passwordEditText = findViewById(R.id.editTextPassword);
            Button loginButton = findViewById(R.id.login_button);

            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = emailEditText.getText().toString().trim();
                    String password = passwordEditText.getText().toString().trim();

                    if (email.isEmpty() || password.isEmpty()) {
                        showErrorDialog("Both email and password are required.");
                    } else if (!isValidEmail(email)) {
                        showErrorDialog("Please enter a valid email address.");
                    } else {
                        // Continue with login process
                    }
                }
            });
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


