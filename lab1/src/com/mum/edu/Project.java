package com.mum.edu;

import java.util.Date;
import java.util.List;

public class Project {
	private String name;
	private String description;
	private Date dateStart;
	private ProductBackLog productBackLog;
	private List<Release> releases;
	private List<Sprint> sprints;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public ProductBackLog getProductBackLog() {
		return productBackLog;
	}

	public void setProductBackLog(ProductBackLog productBackLog) {
		this.productBackLog = productBackLog;
	}

	public List<Release> getReleases() {
		return releases;
	}

	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}

	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

}
