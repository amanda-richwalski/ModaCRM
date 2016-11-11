package com.users.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.users.beans.User;
import com.users.repositories.ContactRepository;
import com.users.repositories.UserRepository;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.users.security.Role;

import static com.users.security.Role.ROLE_ADMIN;
import static com.users.security.Role.ROLE_USER;

@Service
public class PermissionService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ContactRepository contactRepo;
	
	//Simple user name and password authentication when logging in
	private AbstractAuthenticationToken getToken() {
		return (AbstractAuthenticationToken) 
				getContext().getAuthentication();
}
	
	//Returns the list GrantedAuthority which denotes roles for those logging in
	public boolean hasRole(Role role) {
		for (GrantedAuthority ga : getToken().getAuthorities()) {
			if (role.toString().equals(ga.getAuthority())) {
				return true;
			}
		}
		return false;
	}
	
	//Allowing the specified role to be able to edit the user role
	
	//step2-the user role is being allowed to edit the contacts, and we're finding the user by userId
	public boolean canEditUser(long userId) {
		return hasRole(ROLE_ADMIN) || (hasRole(ROLE_USER) && findCurrentUserId() == userId);
	}
	
	public boolean canAccessUser(long userId) {
		return hasRole(ROLE_ADMIN) || (hasRole(ROLE_USER) && findCurrentUserId() == userId);
	}
	
	public boolean canEditContact(long contactId) {
		return hasRole(ROLE_USER) && contactRepo.findByUserIdAndId(findCurrentUserId(), contactId) != null;
	}


	public long findCurrentUserId() {
		List<User> users = userRepo.findByEmail(getToken().getName());
		return users != null && !users.isEmpty() ? users.get(0).getId() : -1;
	}



	}

	


