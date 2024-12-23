package com.blog.blog.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Génère automatiquement les getters, setters, toString, equals, et hashCode
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@NoArgsConstructor // Génère un constructeur sans arguments
@Builder // Permet de construire des objets avec un pattern Builder
@Table(name = "user") // Spécifie le nom de la table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String email;


}
