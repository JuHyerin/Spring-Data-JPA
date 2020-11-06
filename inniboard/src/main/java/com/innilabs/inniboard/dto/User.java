package com.innilabs.inniboard.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity(name = "user")
@Data
@Builder
public class User {
	
	@Id
	@Column(name = "id")
    private String userId;
	
	@Column(name = "pwd")
    private String password;
	
	@Column
    private String name;
}