package com.ssh.demo.staff.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.ssh.demo.staff.entity.Assets;

@Component
public interface IAssetsDao extends PagingAndSortingRepository<Assets, Long>,JpaSpecificationExecutor<Assets> {
//
//	public Page<Assets> findByAssetsNumberLikeAndPrice(String assetsNumber,Double assetsPrice,Pageable pageable);
//
//	@Query("from Asset a where a.assetsNumber like ?1 and a.assetsPrice = ?2")
//	public Page<Assets> findByQuery(String assetsNumber,Double assetsPrice,Pageable pageable);
}
