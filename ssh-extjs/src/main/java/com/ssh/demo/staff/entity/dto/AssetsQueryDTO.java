package com.ssh.demo.staff.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.ssh.demo.staff.entity.Assets;

public class AssetsQueryDTO {

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
	public static Specification<Assets> getWhereClause(AssetsQueryDTO assetsQueryDTO) {
		return new Specification<Assets>() {
			public Predicate toPredicate(Root<Assets> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.声明Predicate集合
				List<Predicate> predicate = new ArrayList<>();
				// 2.根据orderQueryDTO查询条件动态添加Predicate
				if (assetsQueryDTO.getAssetsNumber() != null) {
					predicate.add(cb.like(root.get("assetsNumber").as(String.class),
							"%" + assetsQueryDTO.getAssetsNumber() + "%"));
				}
				if (assetsQueryDTO.getAssetsUsedTime() != null) {
					predicate.add(cb.greaterThanOrEqualTo(root.get("assetsUsedTime").as(Date.class),
							assetsQueryDTO.getAssetsUsedTime()));
				}

				if (assetsQueryDTO.getAssetsPrice() != null) {
					predicate.add(cb.equal(root.get("assetsprice").as(Float.class), assetsQueryDTO.getAssetsPrice()));
				}

				if (assetsQueryDTO.getAssetsName() != null) {
					predicate.add(cb.equal(root.get("assetsName").as(Float.class), assetsQueryDTO.getAssetsName()));
				}

				// 3.根据Predicate集合生成并返回and 连接的 where条件
				return cb.and(predicate.toArray(new Predicate[predicate.size()]));
			}
		};
	}
}
