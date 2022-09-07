package com.stage.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.stage.entity.Article;
import com.stage.entity.Categorie;

public interface ICategorieService {

	List<Categorie> retrieveCategorie();
	Categorie retrieveById(Long id);
	Categorie saveCategorie(Categorie a);
	Categorie updateCategorie(Categorie a);
	void deleteCategorie(Long id);
}
