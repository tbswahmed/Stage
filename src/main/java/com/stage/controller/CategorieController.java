package com.stage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stage.entity.Categorie;
import com.stage.service.CategorieImp;


@RestController  
@RequestMapping("categorieController")
public class CategorieController {
	@Autowired
	CategorieImp catimp;

	@GetMapping("/affichercat")
	@ResponseBody 
	List<Categorie> afficherAllCategories(){
	return catimp.retrieveCategorie();
	}
	
	@GetMapping("/affichercatById/{id}")
	@ResponseBody 
	Categorie afficherCategorie(@PathVariable("id")Long id) {
	return catimp.retrieveById(id);
	}
	
	
	
	
	@PostMapping(value="/addCat" )
    @ResponseBody
	public Categorie ajoutersubscription(@RequestBody Categorie cat){
		return catimp.saveCategorie(cat);
	
}
	
	@PutMapping("/updatecat")
	@ResponseBody
	Categorie updateCategorie(@RequestBody Categorie c) { 
	return catimp.updateCategorie(c);
	}
	
	
	
	@DeleteMapping("/deletecat/{id}")
	@ResponseBody
	void supprimerCategorie(@PathVariable("id") Long id) {
	catimp.deleteCategorie(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
