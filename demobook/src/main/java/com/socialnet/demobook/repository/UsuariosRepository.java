package com.socialnet.demobook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnet.demobook.entity.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String> {
	Optional<Usuarios> findById(String id);
	Optional<Usuarios> findByMail(String mail);
	Optional<Usuarios> findByTag(String tag);
}
