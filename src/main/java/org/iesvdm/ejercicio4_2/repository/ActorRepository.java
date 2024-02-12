package org.iesvdm.ejercicio4_2.repository;

import org.iesvdm.ejercicio4_2.domain.Actor;
import org.iesvdm.ejercicio4_2.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
}
