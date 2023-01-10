package com.socialnet.amigos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnet.amigos.entity.Amigos;

@Repository
public interface AmigosRepository extends JpaRepository<Amigos, String>{
	List<Amigos> findByIdUsuario(String idUsuario);
}
