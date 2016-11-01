package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.ImageInfo;
import com.api.service.ImageApiService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/image/")
public class ImageApiController {

	@Autowired
	ImageApiService imageApiService;

	// get images
	@RequestMapping(value = "{companyId}/{imageId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImageInfo> getImage(@PathVariable String companyId,
			@PathVariable String imageId) {
		ImageInfo image = imageApiService.getImage(companyId, imageId);
		if (image == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ImageInfo>(image, HttpStatus.OK);

	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ResponseEntity<List<ImageInfo>> getImage() {
		List<ImageInfo> imageList = (List<ImageInfo>) imageApiService
				.getAllImage();

		if (imageList == null || imageList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(imageList, HttpStatus.OK);

	}

	// create image
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> createImageInfo(
			@RequestBody ImageInfo newImageInfo) {

		ImageInfo image = imageApiService.getImage(newImageInfo.getCompanyId(),
				newImageInfo.getImageId());

		if (image != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		imageApiService.saveImage(newImageInfo);
		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	// update image
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateImageInfo(
			@RequestBody ImageInfo newImageInfo) {
		return null;
	}

	// delete image
	@RequestMapping(value = "{companyId}/{imageId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteImageInfo(@PathVariable String companyId,
			@PathVariable String imageId) {
		return null;
	}
}
