package ru.mail.park.fastnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText emailId, passwordId;
    Button btnCreateAcc;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailId = findViewById(R.id.EmailAddress);
        passwordId = findViewById(R.id.password);
        btnCreateAcc = findViewById(R.id.newAccountButton);
        mFirebaseAuth = FirebaseAuth.getInstance();
        btnCreateAcc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String password = passwordId.getText().toString();
                if (email.isEmpty()){
                    emailId.setError("Please, enter your email");
                    emailId.requestFocus();
                } else if (password.isEmpty()) {
                    passwordId.setError("Please, enter your password");
                    passwordId.requestFocus();
                } else if (email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Fields Are Empty", Toast.LENGTH_SHORT);
                } else if (!(email.isEmpty() && password.isEmpty())) {
                    Toast.makeText(RegisterActivity.this, "You are here", Toast.LENGTH_SHORT);
                    mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Sign Up is not successfull. Please, try again", Toast.LENGTH_SHORT);
                            } else {
                                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(RegisterActivity.this, "Error Occured", Toast.LENGTH_SHORT);
                }
            }
        });

    }
}