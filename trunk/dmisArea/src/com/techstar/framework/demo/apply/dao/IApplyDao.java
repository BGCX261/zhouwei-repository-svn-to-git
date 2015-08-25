/**
 * Oct 25, 2006
 * @author xcf
 */
package com.techstar.framework.demo.apply.dao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.demo.entity.Apply;

public interface IApplyDao {
	/**
	 * ������޸�ʵ��
	 * 
	 * @param apply
	 */
	public void saveOrUpdate(Apply apply);

	/**
	 * ɾ��ʵ��
	 * 
	 * @param apply
	 */
	public void delete(Apply apply);

	/**
	 * ������������ʵ��
	 * 
	 * @param pk
	 *            ����ֵ
	 * @return Apply ���ز��ҵ���ʵ�����
	 */
	public Apply findByPk(Object pk);

	/**
	 * �õ�ʵ������м�¼(����ҳ)
	 * 
	 * @param entityName
	 *            
	 * @return QueryListObj ��װ�˽��������¼�����Ķ���
	 */
	public QueryListObj getQueryList();

	/**
	 * �õ�ʵ������м�¼(��ҳ)
	 * 
	 * @param entityName 
	 *            
	 * @param beginPage
	 *            ��ʼҳ
	 * @param pageSize
	 *            ÿҳ��ʾ��¼��
	 * @return QueryListObj ��װ�˽��������¼�����Ķ���
	 */
	public QueryListObj getQueryList( int beginPage,
			int pageSize);
}
