package com.socialnet.amigos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.socialnet.amigos.entity.SolicitudesAmistad;

public interface SolicitudesAmistadRepository extends JpaRepository<SolicitudesAmistad, String> {
	
	Optional<SolicitudesAmistad> findById(String id);
	List<SolicitudesAmistad> findByUsuarioGenera(String usuarioGenera);
	List<SolicitudesAmistad> findByUsuarioRecibe(String usuarioRecibe);
	
	@Query(nativeQuery = true, value = "SELECT * FROM solicitudes_amistad u WHERE u.usuario_genera = :usuarioGenera AND u.usuario_recibe = :usuarioRecibe")
	Optional<SolicitudesAmistad> findSolicitudesByUsuarioGeneraAndUsuarioRecibe(
			@Param("usuarioGenera") String usuarioGenera, 
			@Param("usuarioRecibe") String usuarioRecibe);
}
