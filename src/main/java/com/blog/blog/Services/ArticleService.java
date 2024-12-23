package com.blog.blog.Services;
import com.blog.blog.DTO.ArticleDTO;
import com.blog.blog.Entities.Article;

import com.blog.blog.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    // Ajouter un article
    public ArticleDTO addArticle(Article article) {
        Article savedArticle = articleRepository.save(article);
        return mapToDTO(savedArticle);
    }

    // Obtenir tous les articles
    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Obtenir un article par ID
    public ArticleDTO getArticleById(Long id) {
        return articleRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Article non trouvé"));
    }

    // Supprimer un article
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    // Mapper une entité Article en DTO
    private ArticleDTO mapToDTO(Article article) {
        return new ArticleDTO(
                article.getId(),
                article.getTitre(),
                article.getContenu(),
                article.getCategorie(),
                article.getDateCreation()
        );
    }
}
