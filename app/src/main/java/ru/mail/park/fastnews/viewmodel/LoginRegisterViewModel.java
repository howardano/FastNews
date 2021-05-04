package ru.mail.park.fastnews.viewmodel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;

import ru.mail.park.fastnews.repositories.AppRepository;

public class LoginRegisterViewModel extends AndroidViewModel {
    private final AppRepository appRepository;
    private final MutableLiveData<FirebaseUser> userMutableLiveData;

    public LoginRegisterViewModel(@NonNull Application application) {
        super(application);
        appRepository = new AppRepository(application);
        userMutableLiveData = appRepository.getUserMutableLiveData();
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void register (String email, String password) {
        appRepository.register(email, password);
    }

    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void login(String email, String password) {
        appRepository.login(email, password);
    }
}
