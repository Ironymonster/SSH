package com.ssh.demo.staff.service;

import com.ssh.demo.staff.entity.UserInfornation;

public interface IStaffService {

	public UserInfornation findByUserName(String userName);
	
}
