package com.ssh.demo.staff.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.ssh.demo.staff.entity.Asset;

@Component
public interface IAssetDao extends PagingAndSortingRepository<Asset, Long>,JpaSpecificationExecutor<Asset> {

	public Page<Asset> findByAssetNumberLikeAndPrice(String assetsNumber,Double assetsPrice,Pageable pageable);

	@Query("from Asset o where o.orderNumber like ?1 and o.price = ?2")
	public Page<Asset> findByQuery(String assetsNumber,Double assetsPrice,Pageable pageable);
}
