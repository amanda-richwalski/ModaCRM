package com.users.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import com.users.repositories.UserRepository;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;
import org.springframework.beans.factory.annotation.Autowired;
import static com.users.security.Role.USER;
import static com.users.security.Role.ADMIN;





public class PermissionService {
	
	@Autowired
	private UserRepository userRepo;
	

	
	//Simple user name and password authentication when logging in
	private UsernamePasswordAuthenticationToken getToken() {
		return (UsernamePasswordAuthenticationToken) 
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
	public boolean canEditUser(long userId) {
		long currentUserId = userRepo.findByEmail(getToken().getName()).get(0).getId();
		return hasRole(ADMIN) || (hasRole(USER) && currentUserId == userId);
	}


	

}
