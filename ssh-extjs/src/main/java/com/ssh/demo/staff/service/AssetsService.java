package com.ssh.demo.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.demo.staff.dao.IAssetsDao;
import com.ssh.demo.staff.entity.Assets;

@Service
@Transactional
public class AssetsService implements IAssetsService {

	@Autowired
	private IAssetsDao assetsDao;
	
	public void setAssetsDao(IAssetsDao assetsDao) {
		this.assetsDao = assetsDao;
	}
		
	@Override
	public void save(Assets entity) {
	}

	@Override
	public void delete(Assets entity) {
	}

	@Override
	public void delete(Integer assetsId) {
	}

	@Override
	public void delete(Integer[] assetsIds) {
		for(Integer assetsId : assetsIds) {
			assetsDao.delete(assetsId);
		}
	}

	@Transactional(readOnly=true)
	public Assets findOne(Integer assetsId) {
		return assetsDao.findOne(assetsId);
	}

	@Transactional(readOnly=true)
	public List<Assets> findAll() {
		return (List<Assets>) assetsDao.findAll();
	}

	@Override
	public List<Assets> findAll(Sort sort) {
		return (List<Assets>) assetsDao.findAll(sort);
	}

	@Override
	public Page<Assets> findAll(Pageable pageable) {
		return assetsDao.findAll(pageable);
	}

//	@Override
//	public Page<Assets> findAll(Specification<Assets> spec, Pageable pageable) {
//		return assetsDao.findAll(spec, pageable);
//	}
//
//	@Override
//	public Page<Assets> findByAssetsNumberLikeAndPrice(String assetsNumber, Double assetsPrice, Pageable pageable) {
//		return assetsDao.findByAssetsNumberLikeAndPrice(assetsNumber, assetsPrice, pageable);
//	}
//
//	@Override
//	public Page<Assets> findByQuery(String assetsNumber, Double assetsPrice, Pageable pageable) {
//		return assetsDao.findByQuery(assetsNumber, assetsPrice, pageable);
//	}
}
