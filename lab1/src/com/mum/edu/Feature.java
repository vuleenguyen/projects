package com.mum.edu;

import java.util.List;

public class Feature {
	private String name;
	private String description;
	private String complexity;
	private String status;
	private Double effort;
	private Developer developerResponsibility;
	private List<Feature> subFeatures;

	public Feature() {
	}

	public Feature(String name, String description, String complexity,
			String status, Double effort, Developer developerImplement,
			List<Feature> subFeatures) {
		this.name = name;
		this.description = description;
		this.complexity = complexity;
		this.status = status;
		this.effort = effort;
		this.developerResponsibility = developerImplement;
		this.subFeatures = subFeatures;
	}

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

	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getEffort() {
		return effort;
	}

	public void setEffort(Double effort) {
		this.effort = effort;
	}

	public Developer getDeveloperResponsibility() {
		return developerResponsibility;
	}

	public void setDeveloperResponsibility(Developer developerResponsibility) {
		this.developerResponsibility = developerResponsibility;
	}

	public List<Feature> getSubFeatures() {
		return subFeatures;
	}

	public void setSubFeatures(List<Feature> subFeatures) {
		this.subFeatures = subFeatures;
	}

}
