/*
 *
 * Copyright (c) 2006- CE, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * CE Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with CE.
 */
package com.sitechasia.webx.core.dao.impl;

import com.sitechasia.webx.core.dao.IDomainObjectQueryCache;

public class DomainObjectQueryCache implements IDomainObjectQueryCache {

	private boolean cachedWithoutPage;
	private boolean cachedWithPage;

	public boolean isCached(String hql, Object... values) {
		return cachedWithoutPage;
	}

	public boolean isCached(String hql, int pageNo, int pageSize, Object... args) {
		return cachedWithPage;
	}

	public void setCachedWithoutPage(boolean cachedWithoutPage) {
		this.cachedWithoutPage = cachedWithoutPage;
	}

	public void setCachedWithPage(boolean cachedWithPage) {
		this.cachedWithPage = cachedWithPage;
	}
}
