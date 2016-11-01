package com.api.dao;

import java.util.List;

import com.api.model.ImageInfo;

public interface ImageRepositoryDao {
	List<ImageInfo> findAllImages();

	ImageInfo findImage(String companyId, String imageId);

	void saveImage(ImageInfo image);
}
