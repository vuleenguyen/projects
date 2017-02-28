package com.mum.edu;

import java.util.List;

public class Manager extends Person {
	private Project projectManaging;
	private List<Developer> developers;

	public Project getProjectManaging() {
		return projectManaging;
	}

	public void setProjectManaging(Project projectManaging) {
		this.projectManaging = projectManaging;
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}

	public void addToSprint(List<Feature> backlogFeatures) {

	}

	public void addToRelease(List<Feature> backlogFeatures) {

	}

	public List<Feature> reportAmountOfWorkCompleted(Sprint sprint) {
		return null;
	}

	public List<Feature> reportAmountOfWorkRemaining(Sprint sprint) {
		return null;
	}

	public void assignToDeveloper(Feature feature) {

	}
}
