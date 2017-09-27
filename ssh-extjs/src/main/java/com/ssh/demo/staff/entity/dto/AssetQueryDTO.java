package com.ssh.demo.staff.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.ssh.demo.staff.entity.Asset;

public class AssetQueryDTO {

	private String assetsNumber;
	private String assetsName;
	private Double assetsPrice;
	private Date assetsUsedTime;

	public String getAssetsNumber() {
		return assetsNumber;
	}

	public String getAssetsName() {
		return assetsName;
	}

	public Double getAssetsPrice() {
		return assetsPrice;
	}

	public Date getAssetsUsedTime() {
		return assetsUsedTime;
	}

	public void setAssetsNumber(String assetsNumber) {
		this.assetsNumber = assetsNumber;
	}

	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}

	public void setAssetsPrice(Double assetsPrice) {
		this.assetsPrice = assetsPrice;
	}

	public void setAssetsUsedTime(Date assetsUsedTime) {
		this.assetsUsedTime = assetsUsedTime;
	}

	@SuppressWarnings("unused")
	public static Specification<Asset> getWhereClause(AssetQueryDTO assetQueryDTO) {
		return new Specification<Asset>() {
			public Predicate toPredicate(Root<Asset> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.声明Predicate集合
				List<Predicate> predicate = new ArrayList<>();
				// 2.根据orderQueryDTO查询条件动态添加Predicate
				if (assetQueryDTO.getAssetsNumber() != null) {
					predicate.add(cb.like(root.get("assetNumber").as(String.class),
							"%" + assetQueryDTO.getAssetsNumber() + "%"));
				}
				if (assetQueryDTO.getAssetsUsedTime() != null) {
					predicate.add(cb.greaterThanOrEqualTo(root.get("assetsUsedTime").as(Date.class),
							assetQueryDTO.getAssetsUsedTime()));
				}

				if (assetQueryDTO.getAssetsPrice() != null) {
					predicate.add(cb.equal(root.get("assetprice").as(Float.class), assetQueryDTO.getAssetsPrice()));
				}

				if (assetQueryDTO.getAssetsName() != null) {
					predicate.add(cb.equal(root.get("assetName").as(Float.class), assetQueryDTO.getAssetsName()));
				}

				// 3.根据Predicate集合生成并返回and 连接的 where条件
				return cb.and(predicate.toArray(new Predicate[predicate.size()]));
			}
		};
	}
}
