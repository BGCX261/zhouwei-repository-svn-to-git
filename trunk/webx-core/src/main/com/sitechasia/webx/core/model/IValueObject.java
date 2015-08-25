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

import java.io.Serializable;

/**
 * 泛指用于表示和携带数据的对象。它其中又包含了一些特殊的，对我们的系统有特殊作用的对象，有Persistent Object、Domain
 * Object和View Object对象。这些特殊对象将在以下做具体定义。
 *
 * @author Administrator
 * @author todd
 * @version 1.2 , 2008/5/6
 * @since JDK1.5
 */
public interface IValueObject extends Serializable {
}
