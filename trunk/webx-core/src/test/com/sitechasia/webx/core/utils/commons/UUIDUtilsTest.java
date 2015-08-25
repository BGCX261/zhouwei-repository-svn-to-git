package com.sitechasia.webx.core.utils.commons;

import junit.framework.TestCase;
import com.sitechasia.webx.core.utils.commons.UUIDUtils;

/**
 * <p>Title: UUIDUtilsTest</p>
 * <p>Description: UUIDUtils单元测试类</p>
 *
 * @author mashaojing
 * @version 1.0
 */
public class UUIDUtilsTest extends TestCase {

public void	testgenerateNoNetworkID(){
	System.out.println(UUIDUtils.getUUID());
}
}
