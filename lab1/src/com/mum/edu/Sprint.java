package com.mum.edu;

import java.util.Date;
import java.util.List;

public class Sprint {
	private List<Feature> features;
	private Date dueDate;

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
