package com.techstar.framework.ui.web.tag.engine;

import org.apache.struts.util.MessageResources;

public class ApplicationResourcesUtil {


	
    public static String getMessage(String strKey) {
        return messages.getMessage(strKey);
    }

    protected static MessageResources messages = MessageResources
            .getMessageResources("ApplicationResources_zh_CN");
}
