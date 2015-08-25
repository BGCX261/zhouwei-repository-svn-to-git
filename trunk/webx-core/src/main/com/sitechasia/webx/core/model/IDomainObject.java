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
package com.sitechasia.webx.core.model;

/**
 * 表示对业务对象，指在业务操作时与业务流程直接相关的对象。本规范认为Domain Object和Business
 * Object表示的是相同的意思，因此在今后的沟通和开发中将不使用Business Object或其缩写BO对业务对象进行称呼。
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public interface IDomainObject extends IValueObject {
}
