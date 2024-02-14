package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.CommunityPosts;

public interface CommunityPostsDao extends JpaRepository<CommunityPosts, Long> {

}
