package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="events")
public class Event extends BaseEntity {
	
	@Column(name="event_name",length=100)
	private String eventName;
	
	@Column(name= "event_date",columnDefinition = "TIMESTAMP")
	private LocalDateTime eventDate;
	
	@Column(name="event_description" , length=250)
	private String eventDescription;
}
