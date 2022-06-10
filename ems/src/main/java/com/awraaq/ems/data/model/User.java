package com.awraaq.ems.data.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor 
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String email;

	private String password;
	
    public User(String email, String password ) {
        this.email = email;
        this.password = password;
         
    }

	// getters and setters...
}