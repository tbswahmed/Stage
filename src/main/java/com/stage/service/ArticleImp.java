package com.stage.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.stage.entity.Article;
import com.stage.entity.Categorie;
import com.stage.repository.ArticleRepository;
import com.stage.repository.CategorieRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ArticleImp implements IArticleService {

	@Autowired
	ArticleRepository artRepo;
	@Autowired
	CategorieRepository catrepo;
	
	@Override
	public List<Article> retrieveArticle() {
		return artRepo.findAll();
	}

	@Override
	public Article retrieveById(Long id) {
		return artRepo.findById(id).orElse(null);
	}

	@Override
	public Article addArticle(Article a,MultipartFile file ,long categorieId) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			a.setArticleImg(Base64.getEncoder().encodeToString(file.getBytes()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Categorie cat = catrepo.findById(categorieId).orElse(null);
		a.setCategorie(cat);
		return artRepo.save(a);
	}

	@Override
	public Article updateArticle(Article a) {
		return artRepo.save(a);
	}

	@Override
	public void deleteArticle(Long id) {
		artRepo.deleteById(id);
		
	}

	@Override
	public List<Article> getArticleByCategorie(long id) {
		return artRepo.FindArticlebyCategorie(id);
	}

	
	
}
