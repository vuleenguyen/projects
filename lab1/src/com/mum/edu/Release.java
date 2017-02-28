package com.mum.edu;

import java.util.Date;
import java.util.List;

public class Release {
	private String name;
	private Date releaseDate;
	private String information;
	private List<Feature> releaseFeatures;
	private String version;
	private List<Sprint> sprints;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public List<Feature> getReleaseFeatures() {
		return releaseFeatures;
	}

	public void setReleaseFeatures(List<Feature> releaseFeatures) {
		this.releaseFeatures = releaseFeatures;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

}
