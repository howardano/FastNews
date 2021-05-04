package ru.mail.park.fastnews.repositories;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ru.mail.park.fastnews.models.Articles;

public class NewsRepository {
    private static NewsRepository instance;
    private ArrayList<Articles> dataSet = new ArrayList<>();

    public static NewsRepository getInstance() {
        if (instance == null) {
            instance = new NewsRepository();
        }
        return instance;
    }

    public String getCountry() {
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country;
    }
}
