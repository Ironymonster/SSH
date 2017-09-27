package com.ssh.demo.staff.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.ssh.demo.staff.entity.Assets;

public interface IAssetsService {

	//增加（修改）、删除、
		public void save(Assets entity);
		public void delete(Assets entity);
		public void delete(Long id);
		public void delete(Long[] ids);
		//通用查询
		public Assets findOne(Long id);
		public List<Assets> findAll();
		public List<Assets> findAll(Sort sort);
		public Page<Assets> findAll(Pageable pageable);
//		//高级查询（动态条件查询）
//		public Page<Assets> findAll(Specification<Assets> spec, Pageable pageable);
//		
//		//自定义查询
//		public Page<Assets> findByQuery(String assetsNumber,Double assetsPrice,Pageable pageable);
//		public Page<Assets> findByAssetsNumberLikeAndPrice(String assetsNumber, Double assetsPrice, Pageable pageable);
}
