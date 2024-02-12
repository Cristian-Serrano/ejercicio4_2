package org.iesvdm.ejercicio4_2;

import org.iesvdm.ejercicio4_2.domain.Actor;
import org.iesvdm.ejercicio4_2.domain.Categoria;
import org.iesvdm.ejercicio4_2.domain.Idioma;
import org.iesvdm.ejercicio4_2.domain.Pelicula;
import org.iesvdm.ejercicio4_2.repository.ActorRepository;
import org.iesvdm.ejercicio4_2.repository.CategoriaRepository;
import org.iesvdm.ejercicio4_2.repository.IdiomaRepository;
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

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    IdiomaRepository idiomaRepository;

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

    @Test
    void guardarManyToManyActorPelicula(){
        Pelicula pelicula1 = new Pelicula(0, "pelicula1", new HashSet<>(), new HashSet<>());
        peliculaRepository.save(pelicula1);

        Actor actor1 = new Actor(0, "actor1", "actor1", new HashSet<>());
        actorRepository.save(actor1);

        Actor actor2 = new Actor(0, "actor2","actor2", new HashSet<>());
        actorRepository.save(actor2);

        pelicula1.getActores().add(actor1);
        pelicula1.getActores().add(actor2);

        actor1.getPeliculas().add(pelicula1);
        actor2.getPeliculas().add(pelicula1);

        peliculaRepository.save(pelicula1);
        actorRepository.save(actor1);
        actorRepository.save(actor2);

    }

    @Test
    void guardarOnetoManyIdiomaPelicula(){
        Idioma idioma1 = new Idioma(0, "idioma1", new HashSet<>());
        idiomaRepository.save(idioma1);

        Pelicula pelicula1 = new Pelicula(0, "pelicula1", new HashSet<>(), new HashSet<>(), idioma1);
        peliculaRepository.save(pelicula1);

        Pelicula pelicula2 = new Pelicula(0, "pelicula2", new HashSet<>(), new HashSet<>(), idioma1);
        peliculaRepository.save(pelicula2);

        idioma1.getPeliculas().add(pelicula1);
        idioma1.getPeliculas().add(pelicula2);

        idiomaRepository.save(idioma1);

    }

}
