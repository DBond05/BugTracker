package com.electratech.bugTracker.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bug {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String projectName;
	private String issueType;
	private String description;
	private String troubleShooting;
	private boolean isResolved;
	private String resolution;
	@CreationTimestamp
	private Date recordedDate;
	@UpdateTimestamp
	private Date updateDate;
	
	
	public Bug(String projectName, String issueType, String description, String troubleShooting, boolean isResolved,
			String resolution) {
		super();
		this.projectName = projectName;
		this.issueType = issueType;
		this.description = description;
		this.troubleShooting = troubleShooting;
		this.isResolved = isResolved;
		this.resolution = resolution;
		
	}
	
	@Override
	public String toString() {
		return "Bug [projectName=" + projectName + ", issueType=" + issueType + ", Description=" + description
				+ ", troubleShooting=" + troubleShooting + ", isResolved=" + isResolved + ", resolution=" + resolution
				+ ", recordedDate=" + recordedDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
