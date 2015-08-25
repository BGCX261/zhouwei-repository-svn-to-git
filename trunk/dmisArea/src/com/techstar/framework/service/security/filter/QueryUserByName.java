package com.techstar.framework.service.security.filter;

import com.techstar.framework.service.security.modelin.User;

public class QueryUserByName extends FilterBase {
	private User USER;

	public User getUSER() {
		return USER;
	}

	public void setUSER(User user) {
		USER = user;
	}

}
