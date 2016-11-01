package com.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.sql2o.Connection;

import com.api.model.ImageInfo;

//@RepositoryRestResource
@Repository
public class ImageRepositoryDaoImpl extends ApiDemoDao implements
		ImageRepositoryDao {

	@Override
	public List<ImageInfo> findAllImages() {
		String sql = "SELECT image_id imageId, company_id companyId, image_description imageDescription, image_url imageUrl "
				+ "FROM image_info";
		try (Connection con = sqlDao.open()) {
			return con.createQuery(sql).executeAndFetch(ImageInfo.class);
		}
	}

	@Override
	public ImageInfo findImage(String companyId, String imageId) {
		String sql = "SELECT * FROM image_info WHERE company_id = :companyId AND image_id = :imageId";
		try (Connection con = sqlDao.open()) {
			return con.createQuery(sql).addParameter("companyId", companyId)
					.addParameter("imageId", imageId)
					.addColumnMapping("image_id", "imageId")
					.addColumnMapping("company_id", "companyId")
					.addColumnMapping("image_description", "imageDescription")
					.addColumnMapping("image_url", "imageUrl")
					.executeAndFetchFirst(ImageInfo.class);
		}
	}

	@Override
	public void saveImage(ImageInfo image) {
		String sql = "INSERT INTO image_info(image_id, company_id, image_description, image_url) "
				+ "VALUES (:imageId, :companyId, :imageDescription, :imageUrl)";
		try (Connection con = sqlDao.open()) {
			con.createQuery(sql)
					.addParameter("imageId", image.getImageId())
					.addParameter("companyId", image.getCompanyId())
					.addParameter("imageDescription",
							image.getImageDescription())
					.addParameter("imageUrl", image.getImageUrl())
					.executeUpdate();
		}

	}
}
