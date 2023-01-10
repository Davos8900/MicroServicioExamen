package com.socialnet.posts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnet.posts.entity.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, String> {
	Optional<Posts> findById(String id);
	List<Posts> findByPropietarioTag(String propietarioTag);
}
