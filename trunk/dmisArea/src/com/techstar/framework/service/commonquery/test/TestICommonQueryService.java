package com.techstar.framework.service.commonquery.test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;

import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.dao.model.QueryDetailPair;
import com.techstar.framework.demo.dto.ApplyDto;
import com.techstar.framework.service.commonquery.ICommonQueryService;
import com.techstar.framework.utils.TestHelper;
/**
 * 
 * @author xcf
 *
 */
public class TestICommonQueryService extends TestCase{
	
//	private ICommonQueryDao dao ;
	private ICommonQueryService service;
	public TestICommonQueryService(String name) {
		super(name);
		
	}
	//预先装载一下xml配置文件
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("demo");
		factory.getBean("configurationHelper");
		factory.getBean("exceptionCacheHelper");
//		dao = (ICommonQueryDao)factory.getBean("iCommonQueryDao");
		service = (ICommonQueryService)factory.getBean("iCommonQueryService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
//		dao = null;
		service = null;
	}
	
	/**
	 * 测试通用查询
	 * 返回的结果集是map的集合
	 */
	public void _testQueryList() {
		CommonQueryObj queryobj = new CommonQueryObj();
		queryobj.setEntityName("Apply");
		queryobj.setAlias("app");
		queryobj.setOrderAttr(new String[]{"app.applyId ASC","app.applyTitle DESC"});
//		queryobj.setOrderType("DESC");
		
		//如果需要分页加入这段参数设置 
		/*queryobj.setPageNum(1);
		queryobj.setPageSize(1);*/
		//===
		
		QueryDetailPair qdp = new QueryDetailPair();
		qdp.setName("app.applyer");
		qdp.setStvalue("x%");
		qdp.setOperInfo(QueryDetailPair.OPER_LIKE);
		
	
		
		QueryDetailPair qdp1 = new QueryDetailPair();
		qdp1.setName("app.applyTime");
		qdp1.setStvalue("2006-10-09");
		qdp1.setEnvalue("2006-11-25");
		qdp1.setDatePatten("YYYY-MM-DD");
		qdp1.setOperInfo(QueryDetailPair.OPER_BETWEEN);
		
		QueryDetailPair qdp2 = new QueryDetailPair();
		qdp2.setName("app.applyId");
		qdp2.setStvalue("400");		
		qdp2.setOperInfo(QueryDetailPair.OPER_GT);
		
		List detailPairs = new ArrayList();
		detailPairs.add(qdp);
		detailPairs.add(qdp1);
		detailPairs.add(qdp2);
		
		queryobj.setDetailPairs(detailPairs);
		
		List list = service.getLogicElemList( queryobj );
		for(int i=0; i<list.size(); i++){
			Map map = (Map)list.get(i);
			Set keys = map.keySet();
			for (Iterator iter = keys.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				System.out.println(key + ":" + map.get(key));
			}
		}
	}
	
	/**
	 * 测试通用查询
	 * 返回的结果集是dto的集合
	 */
	public void testGetLogicElemDtoList(){
		CommonQueryObj queryobj = new CommonQueryObj();
		queryobj.setEntityName("Apply");
		queryobj.setAlias("app");
		queryobj.setOrderAttr(new String[]{"app.applyId ASC","app.applyTitle DESC"});
//		queryobj.setOrderType("DESC");
		
		//如果需要分页加入这段参数设置 
		/*queryobj.setPageNum(1);
		queryobj.setPageSize(1);*/
		//===
		
		QueryDetailPair qdp = new QueryDetailPair();
		qdp.setName("app.applyer");
		qdp.setStvalue("x%");
		qdp.setOperInfo(QueryDetailPair.OPER_LIKE);

		List detailPairs = new ArrayList();
		detailPairs.add(qdp);
		
		queryobj.setDetailPairs(detailPairs);
		
		List list = service.getLogicElemDtoList( queryobj );
		for(int i=0; i<list.size(); i++){
			ApplyDto dto = (ApplyDto)list.get(i); 
			System.out.println( dto.toString() );
		}
	}
}
