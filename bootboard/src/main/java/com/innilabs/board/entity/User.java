package com.innilabs.board.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor

public class User {
	
	@Id
	@Column(name = "id")
    private String userId;
	
	@Column(name = "pwd")
    private String password;
	
	@Column
	private String name;
	
	
}