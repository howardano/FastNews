package ru.mail.park.fastnews.model.repository.impl;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.List;

import ru.mail.park.fastnews.model.entity.Article;
import ru.mail.park.fastnews.model.repository.ArticleRepository;

/**
 * Получение данных новостей.
 */
class ArticleRepositoryImpl implements ArticleRepository {

    /*
     * Должны быть интерфейсы по получению данных от API сервиса.
     */

    /**
     * Получение статей по тикерам
     */
    @NonNull
    @Override
    public List<Article> findAllByTickers(@NonNull Collection<String> tickers) {
        return null;
    }

}
