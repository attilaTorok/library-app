package com.library.repository.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * {@link com.library.repository.repository.domain.UserEntity UserEntity} is a class which defines a user in the database.
 * 
 * @author Török Attila
 *
 */
@Getter
@Setter
@Entity
@Table(name = "User")
public class UserEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
	private String username;
	private String password;
	
}
