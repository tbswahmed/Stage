package com.stage.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.stage.entity.Article;


public interface IArticleService {
	List<Article> retrieveArticle();
	Article retrieveById(Long id);
	Article addArticle(Article a, MultipartFile file , long categorieId);
	Article updateArticle(Article a);
	void deleteArticle(Long id);
	
	List <Article> getArticleByCategorie(long id);
}
