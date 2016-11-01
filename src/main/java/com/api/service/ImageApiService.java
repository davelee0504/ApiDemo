package com.api.service;

import java.util.Collection;

import com.api.model.ImageInfo;

public interface ImageApiService {
	Collection<ImageInfo> getAllImage();

	ImageInfo getImage(String companyId, String imageId);
	
	void saveImage(ImageInfo image);
}
