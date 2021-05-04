package ru.mail.park.fastnews.views;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Build;
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

import ru.mail.park.fastnews.R;
import ru.mail.park.fastnews.viewmodel.LoginRegisterViewModel;

import static java.security.AccessController.getContext;

public class RegisterActivity extends AppCompatActivity {
    private EditText emailId, passwordId;
    private Button btnCreateAcc;
    private LoginRegisterViewModel loginRegisterViewModel;
    //FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        loginRegisterViewModel = ViewModelProviders.of(this).get(LoginRegisterViewModel.class);
        loginRegisterViewModel.getUserMutableLiveData().observe(this, new Observer<FirebaseUser>() {

            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null) {
                    Toast.makeText(RegisterActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Please, log in", Toast.LENGTH_SHORT).show();
                }
            }
        });
        emailId = findViewById(R.id.EmailAddress);
        passwordId = findViewById(R.id.password);
        btnCreateAcc = findViewById(R.id.newAccountButton);
        //mFirebaseAuth = FirebaseAuth.getInstance();
        btnCreateAcc.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.P)
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
                    Toast.makeText(RegisterActivity.this, "Fields Are Empty", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && password.isEmpty())) {
                    loginRegisterViewModel.register(email, password);
                } else {
                    Toast.makeText(RegisterActivity.this, "Error Occured", Toast.LENGTH_SHORT);
                }
            }
        });

    }
}