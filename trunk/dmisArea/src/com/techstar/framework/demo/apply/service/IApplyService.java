package com.techstar.framework.demo.apply.service;

import java.util.List;

import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.demo.dto.ApplyDto;

public interface IApplyService {
	/**
	 * �����������ӻ��޸Ĳ���ҵ����
	 * 
	 * @param dto
	 *            ApplyDto ҵ�������
	 * 
	 */
	public void saveOrUpdateApply(ApplyDto dto);

	/**
	 * ����������ص�ҵ�����
	 * 
	 * @param applyId
	 *            Integer ����ֵ
	 * 
	 */
	public ApplyDto loadApply(String applyId);

	/**
	 * ɾ��ָ����ҵ��
	 * 
	 * @param applyId
	 *            Integer ����ֵ
	 * 
	 */
	public void deleteApply(String applyId);

	/**
	 * ���������ѯ����ҵ����
	 * 
	 * @return QueryListObj ��װ�˽��������¼�����Ķ���
	 */
	public QueryListObj listApply();
	/**
	 * ���������ѯ����ҵ����(��ҳ)
	 * 
	 * @return QueryListObj ��װ�˽��������¼�����Ķ���
	 */
	public QueryListObj getQueryList(int beginPage, int pageSize);

	public List getLogicElemDtoList(CommonQueryObj queryobj);
	
	/**
	 * ��������
	 */
	public void start(String processDefinition); 
	/**
	 * ��������
	 */	    
	public void start(String processDefinition,String businessId) ;	    
	/**
	 * 
	 */
    public  List findTransitionLog(long processInstance) ;

	/**
	 * 
	 */
    public List findPooledTaskInstances(String actorId) ;
	/**
	 * ���̹���
	 */
    public void suspend(long processInstance);
	/**
	 * ��������
	 */		
    public void endTask(long taskInstance,String applyId);
	/**
	 * ���̹���
	 */		
    public String retrieveByteArraysOfGpd(long taskInstanceId);
    
	/**
	 * function :��ȡ��ǰ�û�������ҵ�����뵥�������û�����,����Ҫ���û���������������б�,�÷���Ϊ������й�����-demo,�ݲ�����Ч������
	 * date : 2006-12-06
	 */
    public List getApplyList(String actorid) ;
	
}
