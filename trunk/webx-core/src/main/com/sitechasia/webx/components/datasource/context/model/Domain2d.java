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
package com.sitechasia.webx.components.datasource.context.model;

import com.sitechasia.webx.core.model.IValueObject;

/** @author Hibernate CodeGenerator */
public class Domain2d implements IValueObject {

	private static final long serialVersionUID = -3196110417002642040L;

	/** identifier field */
    private String domain;

    /** nullable persistent field */
    private String ds;

    /** full constructor */
    public Domain2d(String domain, String ds) {
        this.domain = domain;
        this.ds = ds;
    }

    /** default constructor */
    public Domain2d() {
    }

    /** minimal constructor */
    public Domain2d(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDs() {
        return this.ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }
}
