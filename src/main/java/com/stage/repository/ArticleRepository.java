package com.stage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stage.entity.Article;
import com.stage.entity.Facture;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	
	
	@Query(value="SELECT * FROM article a,categorie c Where((a.categorie_idcat=c.idcat)AND(c.idcat=:id))",nativeQuery =true)
	List<Article> FindArticlebyCategorie(@Param ("id")long id);
}
