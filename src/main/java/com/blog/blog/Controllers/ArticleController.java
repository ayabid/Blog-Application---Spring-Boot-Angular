package com.blog.blog.Controllers;
import com.blog.blog.DTO.ArticleDTO;
import com.blog.blog.Entities.Article;
import com.blog.blog.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // Ajouter un article
    @PostMapping
    public ArticleDTO createArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    // Obtenir tous les articles
    @GetMapping
    public List<ArticleDTO> getAllArticles() {
        return articleService.getAllArticles();
    }

    // Obtenir un article par ID
    @GetMapping("/{id}")
    public ArticleDTO getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    // Supprimer un article
    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
