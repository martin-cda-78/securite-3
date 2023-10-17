package fr.greta95.cda.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id ;
	@Column(unique=true)
	String username ;
	String password ;
	String email ;
	@ManyToMany (fetch = FetchType.EAGER)
	List<AppRole> lesroles ;
}
