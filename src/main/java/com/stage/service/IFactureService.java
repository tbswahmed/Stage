package com.stage.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.stage.entity.Article;
import com.stage.entity.Facture;

public interface IFactureService {
	List<Facture> retrieveFacture();
	Facture retrieveById(Long id);
	Facture addFacture(Facture a, long devisId);
	Facture updateFacture(Facture a);
	void deleteFacture(Long id);
	
	List<Facture> retrieveFactureByArticle( long id);
	List<Facture> retrieveFactureByArticleDesc( String name);
	

	Facture addFactureByConfirmedDevis(Facture a, long devisId);
}
