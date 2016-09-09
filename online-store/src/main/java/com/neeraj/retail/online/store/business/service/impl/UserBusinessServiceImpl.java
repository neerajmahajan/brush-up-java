package com.neeraj.retail.online.store.business.service.impl;

import com.neeraj.retail.online.store.business.service.UserBusinessService;
import com.neeraj.retail.online.store.dto.User;

public class UserBusinessServiceImpl implements UserBusinessService{
	
	public User getUser(String userId){
		return new User().getDummyUser();
		
	}

}
