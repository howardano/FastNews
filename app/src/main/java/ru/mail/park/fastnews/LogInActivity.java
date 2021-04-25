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
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {
    EditText emailId, passwordId;
    Button btnLogIn;
    FirebaseAuth mFirebaseAuth;

    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        emailId = findViewById(R.id.EmailAddress);
        passwordId = findViewById(R.id.password);
        btnLogIn = findViewById(R.id.logInButton);
        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(LogInActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LogInActivity.this, HomeActivity.class));
                }
                else {
                    Toast.makeText(LogInActivity.this, "Please, log in", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnLogIn.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(LogInActivity.this, "Fields Are Empty", Toast.LENGTH_SHORT);
                } else if (!(email.isEmpty() && password.isEmpty())) {
                    Toast.makeText(LogInActivity.this, "You are here", Toast.LENGTH_SHORT);
                    mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LogInActivity.this, "Login Error Occured. Please, Try Again", Toast.LENGTH_SHORT);
                            } else {
                                startActivity(new Intent(LogInActivity.this, HomeActivity.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(LogInActivity.this, "Error Occured", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}