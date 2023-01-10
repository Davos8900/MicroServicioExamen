package com.socialnet.posts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialnet.posts.entity.Comentarios;

public interface ComentariosRepository extends JpaRepository<Comentarios, String> {
	List<Comentarios> findByIdPost(String idPost);
	List<Comentarios> findByIdUsuario(String idUsuario);

}
