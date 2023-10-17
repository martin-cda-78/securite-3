package fr.greta95.cda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.greta95.cda.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
	AppUser findByUsername(String usernameString);
}
