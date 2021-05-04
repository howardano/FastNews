package ru.mail.park.fastnews.viewmodel;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import ru.mail.park.fastnews.model.googleapi.dump.GoogleAuthAPI;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public final class GoogleLoginViewModel extends AppCompatActivity {
    private GoogleAuthAPI googleAuthRepository;
    private GoogleSignInClient mGoogleSignInClient;

    public GoogleLoginViewModel(@NonNull Application application) {
        googleAuthRepository = new GoogleAuthAPI(application);
    }

    public void login() {
        googleAuthRepository.login();
    }

    public void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, googleAuthRepository.getRcSignIn());
    }
}
