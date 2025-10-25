package com.revature.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.revature.model.Chef;


// NOTE: This file is part of the backend implementation. No changes are required.


/**
 * The AuthenticationService class handles user authentication, including login,
 * logout, registration, and session management for users.
 * 
 * This class utilizes the ChefService to interact with chef data.
 */
public class AuthenticationService {

    /**
     * The service used for managing Chef objects and their operations.
     */

	 @SuppressWarnings("unused")
	 private ChefService chefService;
 
	 /** A map that keeps track of currently logged in users, indexed by session token. */
	 public static Map<String, Chef> loggedInUsers = new HashMap<>();
 
	 /**
	  * Constructs an AuthenticationService with the specified ChefService.
	  *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	  */
	 public AuthenticationService(ChefService chefService) {
		 this.chefService = chefService;
		 loggedInUsers = new HashMap<>();
	 }

	/**
	 * Authenticates a chef by verifying the provided credentials. If successful, a session token is generated and stored in the logged in users map.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	public String login(Chef chef) {
		List<Chef> existingChefs = chefService.searchChefs(chef.getUsername());
		
		for (Chef c : existingChefs) {
			if (c.getUsername().equals(chef.getUsername()) && c.getPassword().equals(chef.getPassword())) {
				String token = UUID.randomUUID().toString();
				// add to map
				loggedInUsers.put(token, c);

				return token;
			}
		
		}

		return null;
	}

	/**
	 * Logs out a chef by removing the associated session token from the session
	 * map.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	public void logout(String token) {
		loggedInUsers.remove(token);
	}

	/**
	 * Registers a new chef by saving the chef's information using ChefService.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	public Chef registerChef(Chef chef) {
		chefService.saveChef(chef);
		return chef;
	}

	/**
	 * Retrieves the chef associated with a specific session token.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	public Chef getChefFromSessionToken(String token) {
		return loggedInUsers.get(token);
	}

}