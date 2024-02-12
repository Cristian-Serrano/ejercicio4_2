package org.iesvdm.ejercicio4_2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String titulo;

    @ManyToMany
    private Set<Categoria> categorias = new HashSet<>();

    @ManyToMany
    private Set<Actor> actores = new HashSet<>();

    @ManyToOne
    private Idioma idioma;

    public Pelicula(long id, String titulo, Set<Categoria> categorias) {
        this.id = id;
        this.titulo = titulo;
        this.categorias = categorias;
    }

    public Pelicula(long id, String titulo, Set<Categoria> categorias, Set<Actor> actores) {
        this.id = id;
        this.titulo = titulo;
        this.categorias = categorias;
        this.actores = actores;
    }
}
