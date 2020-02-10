package com.last_climb.climb.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.last_climb.climb.model.Utilisateur;

public interface UserRepo extends CrudRepository<Utilisateur, Long> {
	Optional<Utilisateur> findByUsernameAndPassword(String username, String password);
}