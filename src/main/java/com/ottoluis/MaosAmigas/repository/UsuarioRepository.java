package com.ottoluis.MaosAmigas.repository;

import com.ottoluis.MaosAmigas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
