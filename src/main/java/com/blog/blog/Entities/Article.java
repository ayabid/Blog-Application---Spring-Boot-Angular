package com.blog.blog.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
 // Génère automatiquement les getters, setters, toString, equals, et hashCode
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@NoArgsConstructor // Génère un constructeur sans arguments
 // Permet de construire des objets avec un pattern Builder
@Table(name = "article") // Spécifie le nom de la table
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String contenu;

    @ElementCollection
    private List<String> imagePaths; // Liste des chemins des images

    @ElementCollection
    private List<String> videoPaths; // Liste des chemins des vidéos

    private String categorie; // Catégorie de l'article

    private LocalDateTime dateCreation; // Date de création

    // Définit automatiquement la date de création avant la sauvegarde
    @PrePersist
    protected void onCreate() {
        this.dateCreation = LocalDateTime.now(); // Date et heure actuelles
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<String> imagePaths) {
        this.imagePaths = imagePaths;
    }

    public List<String> getVideoPaths() {
        return videoPaths;
    }

    public void setVideoPaths(List<String> videoPaths) {
        this.videoPaths = videoPaths;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    // Pas de setter pour dateCreation, car elle est générée automatiquement

}
