package com.ssh.demo.staff.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.ssh.demo.staff.entity.Assets;
import com.ssh.demo.staff.entity.dto.AssetsDTO;

public interface IAssetsService {

	//增加（修改）、删除、
		public void save(Assets entity);
		public void save(AssetsDTO dto);
		public void delete(Assets entity);
		public void delete(Integer assetsId);
		public void delete(Integer[] assetsIds);
		//通用查询
		public Assets findOne(Integer assetsId);
		public List<AssetsDTO> findAll();
		public Page<AssetsDTO> findAll(Pageable pageable);
		//高级查询（动态条件查询）
		public Page<AssetsDTO> findAll(Specification<Assets> spec, Pageable pageable);
		
//		//自定义查询
//		public Page<Assets> findByQuery(String assetsNumber,Double assetsPrice,Pageable pageable);
//		public Page<Assets> findByAssetsNumberLikeAndAssetsPrice(String assetsNumber, Double assetsPrice, Pageable pageable);
}
