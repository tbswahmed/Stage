package com.stage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.entity.Categorie;
import com.stage.entity.Devis;
import com.stage.entity.Facture;
import com.stage.repository.DevisRepository;
import com.stage.repository.FactureRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class FactureImp implements IFactureService{

	@Autowired
	DevisRepository drepo;
	@Autowired
	FactureRepository factRepo;
	
	@Override
	public List<Facture> retrieveFacture() {
		return 		factRepo.findAll();
	}

	@Override
	public Facture retrieveById(Long id) {
		return 		factRepo.findById(id).orElse(null);
	}

	@Override
	public Facture addFacture(Facture a, long devisId) {
		Devis devis = drepo.findById(devisId).orElse(null);
		a.setDevis(devis);
		return factRepo.save(a);
		
	}

	@Override
	public Facture updateFacture(Facture a) {
		return factRepo.save(a);
	}

	@Override
	public void deleteFacture(Long id) {
		factRepo.deleteById(id);
		
	}

	@Override
	public List<Facture> retrieveFactureByArticle( long id) {
		return factRepo.FindFactureByArticle(id);
		}

	@Override
	public List<Facture> retrieveFactureByArticleDesc(String name) {
		return factRepo.FindFactureByArticleDescription(name);
	}

	@Override
	public Facture addFactureByConfirmedDevis(Facture a, long devisId) {
		Devis devis = drepo.findById(devisId).orElse(null);
		a.setDevis(devis);
		if (devis.isConfirmerDevis() != true)
		{
			long d= devis.getIdDevis();
			 
			System.out.println("Devis pas encore confirmer" + "" + d);
		}
		else {
			return	factRepo.save(a);
		}
		//return factRepo.save(a);
		 return a;
	}

}
