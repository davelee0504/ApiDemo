package com.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dao.ImageRepositoryDao;
import com.api.model.ImageInfo;

@Service
@Transactional
public class ImageApiServiceImpl implements ImageApiService {
	
	@Autowired
	ImageRepositoryDao imageInfoDao;

	@Override
	public List<ImageInfo> getAllImage() {
		return imageInfoDao.findAllImages();
	}

	@Override
	public ImageInfo getImage(String companyId, String imageId) {
		return imageInfoDao.findImage(companyId, imageId);
	}

	@Override
	public void saveImage(ImageInfo image) {
		imageInfoDao.saveImage(image);
	}

}
