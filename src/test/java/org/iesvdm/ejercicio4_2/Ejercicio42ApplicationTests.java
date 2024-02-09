package org.iesvdm.ejercicio4_2;

import org.iesvdm.ejercicio4_2.domain.Categoria;
import org.iesvdm.ejercicio4_2.domain.Pelicula;
import org.iesvdm.ejercicio4_2.repository.CategoriaRepository;
import org.iesvdm.ejercicio4_2.repository.PeliculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class Ejercicio42ApplicationTests {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void guardarManyToMany(){
        Pelicula pelicula1 = new Pelicula(0, "pelicula1", new HashSet<>());
        peliculaRepository.save(pelicula1);

        Categoria categoria1 = new Categoria(0, "categoria1", new HashSet<>());
        categoriaRepository.save(categoria1);

        Categoria categoria2 = new Categoria(0, "categoria2", new HashSet<>());
        categoriaRepository.save(categoria2);

        pelicula1.getCategorias().add(categoria1);
        pelicula1.getCategorias().add(categoria2);

        categoria1.getPeliculas().add(pelicula1);
        categoria2.getPeliculas().add(pelicula1);

        peliculaRepository.save(pelicula1);
        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);

    }

}
