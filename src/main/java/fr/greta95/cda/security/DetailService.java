package fr.greta95.cda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.greta95.cda.dao.AppUserRepository;
import fr.greta95.cda.model.AppUser;

@Service
public class DetailService implements UserDetailsService {
	@Autowired
	AppUserRepository appUserRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AppUser appUser = appUserRepository.findByUsername(username);
		String []roles = appUser.getLesroles().stream().map(role->role.getRolename()).toArray(String[]::new);
		for (String r : roles) 
			System.out.print(r+" ");
		UserDetails userDetails = User.builder()
				.username(appUser.getUsername()).password(appUser.getPassword())
				.roles(roles).build();
		return userDetails;
	}
}
