package com.last_climb.climb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Commentaire;
import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.exception.CantFindUserException;
import com.last_climb.climb.model.exception.NoCommentaryException;
import com.last_climb.climb.model.exception.NoSiteException;
import com.last_climb.climb.repo.CommentaireRepository;
import com.last_climb.climb.repo.SiteRepository;
import com.last_climb.climb.repo.UserRepo;

@Service
public class CheckOptionalGetObjectImpl<T> implements CheckOptionalGetObjectService<T> {

	@Autowired
	private UserRepo userRepository;
	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;

	@Override
	public Utilisateur findAndCheckUserByUsernameAndPassword(String username, String password)
			throws CantFindUserException {
		Optional<Utilisateur> newUser = userRepository.findByUsernameAndPassword(username, password);
		if (newUser.isPresent()) {
			Utilisateur user = newUser.get();
			return user;
		} else {
			throw new CantFindUserException();
		}

	}

	@Override
	public Utilisateur findAndCheckUserById(Long id) throws CantFindUserException {
		Optional<Utilisateur> newUser = userRepository.findById(id);
		if (newUser.isPresent()) {
			Utilisateur user = newUser.get();
			return user;
		} else {
			throw new CantFindUserException();
		}
	}

	@Override
	public Site findANdCheckSiteById(Long id) throws NoSiteException {
		Optional<Site> newSite = siteRepository.findById(id);
		if (newSite.isPresent()) {
			return newSite.get();
		} else {
			throw new NoSiteException();
		}
	}

	@Override
	public Commentaire findANdCheckCommentaireById(Long id) throws NoCommentaryException {
		Optional<Commentaire> newComm = commentaireRepository.findById(id);
		if (newComm.isPresent()) {
			Commentaire comm = newComm.get();
			return comm;
		} else {
			throw new NoCommentaryException();
		}

	}

}