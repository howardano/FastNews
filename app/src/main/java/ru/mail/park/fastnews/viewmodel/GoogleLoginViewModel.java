package ru.mail.park.fastnews.viewmodel;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import ru.mail.park.fastnews.models.GoogleAuthRepository;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class GoogleLoginViewModel extends AppCompatActivity {
    private GoogleAuthRepository googleAuthRepository;
    private GoogleSignInClient mGoogleSignInClient;
    public GoogleLoginViewModel(@NonNull Application application) {
        googleAuthRepository = new GoogleAuthRepository(application);

    }
    public void login() {
        googleAuthRepository.login();
    }
    public void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, googleAuthRepository.getRcSignIn());
    }
}
