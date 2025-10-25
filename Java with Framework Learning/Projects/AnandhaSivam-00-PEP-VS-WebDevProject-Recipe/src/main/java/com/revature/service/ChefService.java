package com.revature.service;

import java.util.List;
import java.util.Optional;

import com.revature.model.Chef;
import com.revature.dao.ChefDAO;
import com.revature.util.Page;
import com.revature.util.PageOptions;


// NOTE: This file is part of the backend implementation. No changes are required.



/**
 * The ChefService class provides business logic for operations related to Chef entities.
 * 
 * It interacts with the ChefDAO to perform CRUD operations and search functionality.
 */
public class ChefService {

	/** Data access object for Chef entities. */
	private ChefDAO chefDAO;

	/**
     * Constructs a ChefService with the specified ChefDAO.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
	public ChefService(ChefDAO chefDAO) {
	        this.chefDAO = chefDAO;
	    }

	/**
     * Finds a Chef by their unique identifier.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
	public Optional<Chef> findChef(int id) {
		return Optional.ofNullable(chefDAO.getChefById(id));
	}

	/**
     * Saves a Chef entity. If the Chef's ID is zero, a new Chef is created and the `chef` parameter's ID is updated.
	 * 
     * Otherwise, updates the existing Chef.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
	public void saveChef(Chef chef) {
		if (chef.getId() == 0) {
			int id = chefDAO.createChef(chef);
			chef.setId(id);
		} else {
			chefDAO.updateChef(chef);
		}
	}

	/**
     * Searches for Chefs based on a search term.
     * If the term is null, retrieves all Chefs.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
	public List<Chef> searchChefs(String term) {
		if (term == null) { 
			return chefDAO.getAllChefs();
		} else {
			return chefDAO.searchChefsByTerm(term);
		}
	}

	/**
     * Deletes a Chef based on their unique identifier, if they exist.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
	public void deleteChef(int id) {
		Chef chef = chefDAO.getChefById(id);
		if (chef != null) {
			chefDAO.deleteChef(chef);
		}
	}

	 /**
     * Searches for Chefs based on a search term with pagination and sorting options.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
	public Page<Chef> searchChefs(String term, int page, int pageSize, String sortBy, String sortDirection) {
		PageOptions options = new PageOptions(page, pageSize, sortBy, sortDirection);
		if (term == null ) { 
			return chefDAO.getAllChefs(options);
		} else {
			return chefDAO.searchChefsByTerm(term, options);
		}
	}
}