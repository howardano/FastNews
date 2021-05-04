package ru.mail.park.fastnews.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mail.park.fastnews.models.Articles;
import ru.mail.park.fastnews.models.Headlines;
import ru.mail.park.fastnews.models.Source;

public class HomeActivityViewModel extends ViewModel {

    private MutableLiveData<List<Articles>> mArticles;
    private MutableLiveData<List<Headlines>> mHeadlines;
    private MutableLiveData<List<Source>> mSources;

    public void init() {

    }

    public LiveData<List<Articles>> getArticles() {
        return mArticles;
    };

    public MutableLiveData<List<Headlines>> getHeadlines() {
        return mHeadlines;
    }

    public MutableLiveData<List<Source>> getSources() {
        return mSources;
    }
}
