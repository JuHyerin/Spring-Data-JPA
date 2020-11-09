package com.innilabs.board.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Post implements Serializable{
    
	private static final long serialVersionUID = 3351906259819685774L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int postId;
	
	@Column
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, /*targetEntity = User.class*/)
	@JoinColumn(name = "writer")
	private User writer;
	
	@Column
	private String contents;
	
	@Column(name = "created_at")
	private Timestamp createdAt;
	
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	@Column(name = "deleted_at")
	private Timestamp deletedAt;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
}