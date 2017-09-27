package com.ssh.demo.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.demo.staff.dao.IAssetDao;
import com.ssh.demo.staff.entity.Asset;

@Service
@Transactional
public class AssetService implements IAssetService {

	@Autowired
	private IAssetDao assetDao;
	
	public void setAssetDao(IAssetDao assetDao) {
		this.assetDao = assetDao;
	}
	
	
	
	
	@Override
	public void save(Asset entity) {
	}

	@Override
	public void delete(Asset entity) {
	}

	@Override
	public void delete(Long id) {
	}

	@Override
	public void delete(Long[] ids) {
	}

	@Transactional(readOnly=true)
	public Asset findOne(Long id) {
		return assetDao.findOne(id);
	}

	@Transactional(readOnly=true)
	public List<Asset> findAll() {
		return (List<Asset>) assetDao.findAll();
	}

	@Override
	public List<Asset> findAll(Sort sort) {
		return (List<Asset>) assetDao.findAll(sort);
	}

	@Override
	public Page<Asset> findAll(Pageable pageable) {
		return assetDao.findAll(pageable);
	}

	@Override
	public Page<Asset> findAll(Specification<Asset> spec, Pageable pageable) {
		return assetDao.findAll(spec, pageable);
	}

	@Override
	public Page<Asset> findByAssetNumberLikeAndPrice(String assetsNumber, Double assetsPrice, Pageable pageable) {
		return assetDao.findByAssetNumberLikeAndPrice(assetsNumber, assetsPrice, pageable);
	}

	@Override
	public Page<Asset> findByQuery(String assetsNumber, Double assetsPrice, Pageable pageable) {
		return assetDao.findByQuery(assetsNumber, assetsPrice, pageable);
	}



}
