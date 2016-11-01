package com.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class ImageInfo extends ResourceSupport {

	@Id
	String imageId;

	String companyId;

	String imageDescription;

	String imageUrl;

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
