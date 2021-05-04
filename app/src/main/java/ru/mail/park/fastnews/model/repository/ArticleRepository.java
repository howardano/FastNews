package ru.mail.park.fastnews.model.repository;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.List;

import ru.mail.park.fastnews.model.entity.Article;

public interface ArticleRepository {

    @NonNull
    List<Article> findAllByTickers(@NonNull Collection<String> tickers);

}
