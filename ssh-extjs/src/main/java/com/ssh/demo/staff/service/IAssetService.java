package com.ssh.demo.staff.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.ssh.demo.staff.entity.Asset;

public interface IAssetService {

	//增加（修改）、删除、
		public void save(Asset entity);
		public void delete(Asset entity);
		public void delete(Long id);
		public void delete(Long[] ids);
		//通用查询
		public Asset findOne(Long id);
		public List<Asset> findAll();
		public List<Asset> findAll(Sort sort);
		public Page<Asset> findAll(Pageable pageable);
		//高级查询（动态条件查询）
		public Page<Asset> findAll(Specification<Asset> spec, Pageable pageable);
		
		//自定义查询
		public Page<Asset> findByQuery(String assetsNumber,Double assetsPrice,Pageable pageable);
		public Page<Asset> findByAssetNumberLikeAndPrice(String assetsNumber, Double assetsPrice, Pageable pageable);
}
