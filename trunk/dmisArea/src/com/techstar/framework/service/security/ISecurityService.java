//Source file: C:\\test\\com\\techstar\\framework\\service\\security\\IRoleService.java

package com.techstar.framework.service.security;

import java.util.List;

import com.techstar.framework.exception.BaseException;
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.filter.EditResource;
import com.techstar.framework.service.security.filter.QueryResource;
import com.techstar.framework.service.security.filter.QueryResourceByRole;
import com.techstar.framework.service.security.filter.QueryUnit;
import com.techstar.framework.service.security.filter.QueryUser;
import com.techstar.framework.service.security.filter.QueryUserByName;
import com.techstar.framework.service.security.filter.QueryUserByRole;
import com.techstar.framework.service.security.filter.QueryUserByUnit;
import com.techstar.framework.service.security.modelout.LoginOut;
import com.techstar.framework.service.security.modelout.UnitOut;

/**
 * 安全服务接口 具体使用请对照《权限系统WEBSERVICES接口说明-3.0.0.doc》相关文档
 * 
 * 
 * @author caojian Apr 20, 2007
 * 
 */
public interface ISecurityService {
	/**
	 * 单点登陆
	 * 
	 * @param userName
	 *            用户登录名称
	 * @return LoginOut
	 * @throws BaseException
	 */
	public LoginOut singleLogin(String userName) throws BaseException;

	/**
	 * 通过组织机构查询用户信息
	 * 
	 * @param queryUserByUnit
	 * @return List 用户信息，其中每个元素为UserOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryUserByUnit(QueryUserByUnit queryUserByUnit)
			throws BaseException;

	/**
	 * 通过角色查询用户信息
	 * 
	 * @param queryUserByRole
	 * @return List 用户信息，其中每个元素为UserOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryUserByRole(QueryUserByRole queryUserByRole)
			throws BaseException;

	/**
	 * 通过用户名称模糊查询用户信息 如果不输入应用ID则返回用户在tam上的信息，否则返回用户在业务系统的信息
	 * 
	 * 支持根据用户名或用户中文名查询，可以模糊查询
	 * 
	 * @param queryUserByName
	 * @return List 用户信息，其中每个元素为UserOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryUserByName(QueryUserByName queryUserByName)
			throws BaseException;

	/**
	 * 通过资源（允许多项）、组织机构、用户名、角色查询用户信息 其中资源、组织机构、用户、角色可任意组合，其关系为逻辑与"and"
	 * 
	 * @param queryUser
	 * @return List 用户信息，其中每个元素为UserOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryUser(QueryUser queryUser) throws BaseException;

	/**
	 * 通过组织机构CODE查询本级别及下属组织机构信息
	 * 
	 * @param queryUnit
	 * @return List 组织机构信息，其中每个元素为UnitOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryUnit(QueryUnit queryUnit) throws BaseException;

	/**
	 * 通过用户查询组织机构信息
	 * 
	 * @param userName
	 *            用户登录名称
	 * @return List 组织机构信息，其中每个元素为UnitOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryUnitByUser(String userName) throws BaseException;

	/**
	 * 
	 * @param userName
	 *            用户登录名称
	 * @return UnitOut
	 * @throws BaseException
	 */
	public UnitOut queryDirectUnitByUser(String userName) throws BaseException;

	/**
	 * 查询所有角色信息
	 * 
	 * 
	 * @return List 角色信息，其中每个元素为RoleOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryRoleAll() throws BaseException;

	/**
	 * 通过用户查询角色信息
	 * 
	 * @param userName
	 *            用户登录名称
	 * @return List 角色信息，其中每个元素为RoleOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryRoleByUser(String userName) throws BaseException;

	/**
	 * 通过类型查询角色
	 * 
	 * @param type
	 *            类型
	 * @return List 角色信息，其中每个元素为RoleOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryRoleByType(String type) throws BaseException;

	/**
	 * 通过组查询角色
	 * 
	 * 
	 * @param group
	 *            组
	 * 
	 * @return List 角色信息，其中每个元素为RoleOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryRoleByGroup(String group) throws BaseException;

	/**
	 * 查询全部角色分组信息
	 * 
	 * @return List 角色分组信息，其中每个元素为RoleGroup，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryRoleGroupAll() throws BaseException;

	/**
	 * 增加资源
	 * 
	 * @param editResource
	 * @return boolean
	 * @throws BaseException
	 */
	public boolean addResource(EditResource editResource) throws BaseException;

	/**
	 * 修改资源
	 * 
	 * @param editResource
	 * @return boolean
	 * @throws BaseException
	 */
	public boolean modifyResource(EditResource editResource)
			throws BaseException;

	/**
	 * 删除资源
	 * 
	 * @param editResource
	 * @return boolean
	 * @throws BaseException
	 */
	public boolean deleteResource(EditResource editResource)
			throws BaseException;

	/**
	 * 迁移资源
	 * 
	 * @param editResource
	 * @return boolean
	 * @throws BaseException
	 */
	public boolean moveResource(EditResource editResource) throws BaseException;

	/**
	 * 查询所有资源信息
	 * 
	 * 
	 * @return List 资源信息，其中每个元素为ResourceOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryResourceAll() throws BaseException;

	/**
	 * 通过角色查询资源信息
	 * 
	 * @param queryResourceByRole
	 * @return List 资源信息，其中每个元素为ResourceOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryResourceByRole(QueryResourceByRole queryResourceByRole)
			throws BaseException;

	/**
	 * 通过用户、资源ID源属性查询子资源信息 用户与资源ID必须输入 如果ISRETURNCHILD 为1 ，则输入的资源属性输入无效
	 * 
	 * 
	 * @param queryResource
	 * @return List 资源信息，其中每个元素为ResourceOut，没查到返回size为0
	 * @throws BaseException
	 */
	public List queryResource(QueryResource queryResource) throws BaseException;

	/**
	 * 验证用户 系统登录时，验证登录用户名称并取得相关的权限信息
	 * 
	 * @param up
	 * @return
	 * @throws BaseException
	 */
	public UserProfile authenticate(UserProfile up) throws BaseException;
}
