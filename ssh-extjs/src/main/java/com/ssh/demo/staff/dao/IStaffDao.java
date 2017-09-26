package com.ssh.demo.staff.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.ssh.demo.staff.entity.UserInfornation;


@Component
public interface IStaffDao extends PagingAndSortingRepository<UserInfornation, String> {

	public UserInfornation findByUserName(String userName);

}
