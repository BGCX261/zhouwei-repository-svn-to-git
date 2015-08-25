package com.techstar.framework.ui.utils.tree;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.ApplicationContext;
public class CreateBeanUtil {
	protected static ApplicationContext ctx;

    public static Object createBean(String beanName) {
        
            String[] paths = { "D:\\workplain\\framework\\WebRoot\\WEB-INF\\spring\\applicationContext_demo_dao.xml", "D:\\workplain\\framework\\WebRoot\\WEB-INF\\spring\\applicationContext.xml" ,"D:\\workplain\\framework\\WebRoot\\WEB-INF\\spring\\applicationContext_Tree.xml"};
            ctx = new FileSystemXmlApplicationContext(paths);
            Object obj  =  ctx.getBean(beanName);
  
        return obj;
    }

}
