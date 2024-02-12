package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="community_posts")
public class CommunityPosts extends BaseEntity {
	
	@Column(name="post_content")
	private String postContent;
	
	@Column(name= "post_date",columnDefinition = "TIMESTAMP")
	private LocalDateTime postDate;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
}
