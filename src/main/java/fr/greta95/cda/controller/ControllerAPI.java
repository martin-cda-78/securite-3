package fr.greta95.cda.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.greta95.cda.model.AppUser;
@RestController
public class ControllerAPI {
	@GetMapping("/defaut")
	public AppUser getDefaut() {
		return AppUser.builder().username("Palmer").email("j.palmer@gmail.com").build();
	}

	@GetMapping("/home")
	String getHome() {
		return "home";
	}

	@GetMapping("/admin")
	String getAdm() {
		return "admin";
	}

	@GetMapping("/user")
	String getEmp() {
		return "user";
	}

	@GetMapping("/manager")
	String getMgr() {
		return "manager";
	}

	@GetMapping("/common")
	String getCom() {
		return "common";
	}

	@GetMapping("/perso/name")
	public String getNomUtilisateur(Principal principal) {
		String nom = principal.getName();
		return nom;
	}
	@GetMapping("/perso/role")
	public List<String> getRoleUtilisateur(Principal principal) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
		ArrayList<String> nomsdesRoles = new ArrayList<String>();
		roles.forEach(r -> nomsdesRoles.add(r.getAuthority()));
		return nomsdesRoles;
	}

}
