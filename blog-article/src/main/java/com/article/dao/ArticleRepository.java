package com.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.article.domain.Article;

public interface ArticleRepository extends JpaRepository<Article,String>{

}
