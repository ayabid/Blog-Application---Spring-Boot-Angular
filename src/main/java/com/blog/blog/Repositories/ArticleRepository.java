package com.blog.blog.Repositories;


import com.blog.blog.Entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {


    // Exemple : Trouver les articles par catégorie
    List<Article> findByCategorie(String categorie);

    // Exemple : Trouver les articles contenant un mot-clé dans le titre
    List<Article> findByTitreContaining(String keyword);
}