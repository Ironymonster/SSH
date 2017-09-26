package com.ssh.demo.staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.demo.staff.dao.IStaffDao;
import com.ssh.demo.staff.entity.UserInfornation;



@Service
public class StaffService implements IStaffService {

	@Autowired
	private IStaffDao staffDao;
	
	@Override
	public UserInfornation findByUserName(String userName) {
		return staffDao.findByUserName(userName);
	}

}
