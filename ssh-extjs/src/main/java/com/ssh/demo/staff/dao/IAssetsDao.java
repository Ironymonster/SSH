package com.ssh.demo.staff.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssh.demo.staff.entity.Assets;

@Component
public interface IAssetsDao extends PagingAndSortingRepository<Assets, Integer>,JpaSpecificationExecutor<Assets> {

}
