package com.info2020.ejercicio3.repository;

import com.info2020.ejercicio3.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
