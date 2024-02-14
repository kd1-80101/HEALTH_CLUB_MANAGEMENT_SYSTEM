package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.OtpDetails;

public interface OtpDetailsDao extends JpaRepository<OtpDetails, Long> {

}
