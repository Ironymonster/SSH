package com.ssh.demo.staff.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssh.demo.staff.entity.Assets;
import com.ssh.demo.staff.entity.UserInfornation;
import com.ssh.demo.util.enums.AssetsType;

public class AssetsDTO {

	private String assetsNumber; //资产编号
	private String assetsName;   //资产名称
	private AssetsType assetsType;     //资产类型
	private Double assetsPrice;  //资产估价
	private Date assetsUsedTime; //使用时间
	
	private String userId; //维护关联关系
	private String userName;
	
	//前台ajax、form到后台 关联关系维护
		public static void  dtoToEntity(AssetsDTO dto,Assets entity) {
			BeanUtils.copyProperties(dto, entity);
			String userId = dto.getUserId();
			
			if(userId!=null && !"".equals(userId.trim())) {
				UserInfornation user = new UserInfornation();
				user.setUserId(userId);//关联关系维护		
				entity.setUser(user);
			}		
		}
		
		//后台反回针对View封装DTO
		public static void  entityToDto(Assets entity , AssetsDTO dto) {
			BeanUtils.copyProperties(entity, dto);
			
			UserInfornation user = entity.getUser();
			if(user!=null) {
				dto.setUserId(user.getUserId());
				dto.setUserName(user.getUserName());
			}			
		}
	
	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getAssetsNumber() {
		return assetsNumber;
	}

	public String getAssetsName() {
		return assetsName;
	}

	public Double getAssetsPrice() {
		return assetsPrice;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getAssetsUsedTime() {
		return assetsUsedTime;
	}
	

	public AssetsType getAssetsType() {
		return assetsType;
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
		
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public void setAssetsType(AssetsType assetsType) {
		this.assetsType = assetsType;
	}

	@SuppressWarnings("unused")
	public static Specification<Assets> getWhereClause(AssetsDTO assetsDTO) {
		return new Specification<Assets>() {
			public Predicate toPredicate(Root<Assets> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.声明Predicate集合
				List<Predicate> predicate = new ArrayList<>();
				// 2.根据orderQueryDTO查询条件动态添加Predicate
				if (assetsDTO.getAssetsNumber() != null) {
					predicate.add(cb.like(root.get("assetsNumber").as(String.class),
							"%" + assetsDTO.getAssetsNumber() + "%"));
				}
				if (assetsDTO.getAssetsUsedTime() != null) {
					predicate.add(cb.greaterThanOrEqualTo(root.get("assetsUsedTime").as(Date.class),
							assetsDTO.getAssetsUsedTime()));
				}

				if (assetsDTO.getAssetsPrice() != null) {
					predicate.add(cb.equal(root.get("assetsprice").as(Float.class), assetsDTO.getAssetsPrice()));
				}

				if (assetsDTO.getAssetsName() != null) {
					predicate.add(cb.equal(root.get("assetsName").as(Float.class), assetsDTO.getAssetsName()));
				}

				// 3.根据Predicate集合生成并返回and 连接的 where条件
				return cb.and(predicate.toArray(new Predicate[predicate.size()]));
			}
		};
	}
}
