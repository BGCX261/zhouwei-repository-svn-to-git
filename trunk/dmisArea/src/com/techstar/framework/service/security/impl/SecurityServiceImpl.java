//Source file: C:\\test\\com\\techstar\\framework\\service\\security\\RoleServiceImpl.java

package com.techstar.framework.service.security.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.techstar.framework.exception.BaseException;
import com.techstar.framework.exception.BaseSecurityException;
import com.techstar.framework.service.ServiceLocator;
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.ISecurityService;
import com.techstar.framework.service.security.SecurityContext;
import com.techstar.framework.service.security.filter.EditResource;
import com.techstar.framework.service.security.filter.FilterBase;
import com.techstar.framework.service.security.filter.QueryResource;
import com.techstar.framework.service.security.filter.QueryResourceByRole;
import com.techstar.framework.service.security.filter.QueryUnit;
import com.techstar.framework.service.security.filter.QueryUser;
import com.techstar.framework.service.security.filter.QueryUserByName;
import com.techstar.framework.service.security.filter.QueryUserByRole;
import com.techstar.framework.service.security.filter.QueryUserByUnit;
import com.techstar.framework.service.security.helper.WSHelper;
import com.techstar.framework.service.security.helper.X2OHelper;
import com.techstar.framework.service.security.modelin.Resource;
import com.techstar.framework.service.security.modelin.ResourceAttr;
import com.techstar.framework.service.security.modelin.Unit;
import com.techstar.framework.service.security.modelin.User;
import com.techstar.framework.service.security.modelout.LoginOut;
import com.techstar.framework.service.security.modelout.Mode2Xml;
import com.techstar.framework.service.security.modelout.UnitOut;
import com.techstar.framework.service.security.modelout.UserOut;
import com.techstar.framework.utils.ConfigurationHelper;

/**
 * 角色实现类
 */
public class SecurityServiceImpl implements ISecurityService {
	public SecurityServiceImpl() {
	}

	// String token = ServiceLocator.getToken();

	public 	LoginOut  singleLogin(String userName) throws BaseException {
		try {
			String resultXml = WSHelper.callWS("singleLogin",
					ConfigurationHelper.getSystemId(), userName);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.singleLogin");
			}
			LoginOut loginout = (LoginOut) Mode2Xml.loginOut().fromXML(
					resultXml);
			return loginout;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException(
					"pps.securityException.singleLogin", e);
		}
	}

	public List queryUserByUnit(QueryUserByUnit queryUserByUnit)
			throws BaseException {
		try {
			queryUserByUnit.setAPPID(ConfigurationHelper.getSystemId());
			queryUserByUnit.setTOKEN(ServiceLocator.getToken());
			String filter = FilterBase.beanToXml(queryUserByUnit);
			String resultXml = WSHelper.callWS("queryUserByUnit", filter);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.userbyunit");
			}
			List result = (List) Mode2Xml.users().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.userbyunit",
					e);
		}
	}

	public List queryUserByRole(QueryUserByRole queryUserByRole)
			throws BaseException {
		try {
			queryUserByRole.setAPPID(ConfigurationHelper.getSystemId());
			if (StringUtils.isEmpty(ServiceLocator.getToken())){
				LoginOut out =  singleLogin("gongnianen");
				queryUserByRole.setTOKEN(out.getUSERINFO().getTOKEN()); 
			}else {
				queryUserByRole.setTOKEN(ServiceLocator.getToken());
			}
			  
			String filter = FilterBase.beanToXml(queryUserByRole);
			String resultXml = WSHelper.callWS("queryUserByRole", filter);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.userbyrole");
			}
			List result = (List) Mode2Xml.users().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.userbyrole",
					e);
		}
	}

	public List queryUserByName(QueryUserByName queryUserByName)
			throws BaseException {
		try {
			queryUserByName.setAPPID(ConfigurationHelper.getSystemId());
			queryUserByName.setTOKEN(ServiceLocator.getToken());
			String filter = FilterBase.beanToXml(queryUserByName);
			String resultXml = WSHelper.callWS("queryUserByName", filter);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.userbyname");
			}
			List result = (List) Mode2Xml.users().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.userbyname",
					e);
		}
	}

	public List queryUser(QueryUser queryUser) throws BaseException {
		try {
			queryUser.setAPPID(ConfigurationHelper.getSystemId());
			queryUser.setTOKEN(ServiceLocator.getToken());
			String filter = FilterBase.beanToXml(queryUser);
			System.out.println(filter);
			String resultXml = WSHelper.callWS("queryUser", filter);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException("pps.securityException.user");
			}
			List result = (List) Mode2Xml.users().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.user", e);
		}
	}

	public List queryUnit(QueryUnit queryUnit) throws BaseException {
		try {
			queryUnit.setAPPID(ConfigurationHelper.getSystemId());
			queryUnit.setTOKEN(ServiceLocator.getToken());
			String filter = FilterBase.beanToXml(queryUnit);
			String resultXml = WSHelper.callWS("queryUnit", filter);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException("pps.securityException.unit");
			}
			List result = (List) Mode2Xml.units().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.unit", e);
		}
	}

	public List queryUnitByUser(String userName) throws BaseException {
		try {
			String resultXml = WSHelper.callWS("queryUnitByUser",
					ServiceLocator.getToken(), ConfigurationHelper
							.getSystemId(), userName);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.unitbyuser");
			}
			List result = (List) Mode2Xml.units().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.unitbyuser",
					e);
		}
	}
	
	public UnitOut queryDirectUnitByUser(String userName) throws BaseException {
		try {
			LoginOut login = this.singleLogin(userName);
			String unitCode = login.getUSERINFO().getUNITCODE();
	
			QueryUnit qu = new QueryUnit();
			Unit unit = new Unit();
			unit.setOPER_TYPE("equal");
			unit.setUNITCODE(unitCode);
			unit.setRETURNMODE("-2");
			qu.setUNIT(unit);
			
			List result = this.queryUnit(qu);			
			UnitOut out = null;
			for (int i = 0; i < result.size(); i++) {
				UnitOut uo = (UnitOut)result.get(i);
				int level = uo.getUNITLEVEL();
				if (level == 2){
					out = uo;
				}
			}
			return out;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.unitbyuser",
					e);
		}
	}
	
	public List queryRoleAll() throws BaseException {
		try {
			String resultXml = WSHelper.callWS("queryRoleAll",
					ServiceLocator.getToken(), ConfigurationHelper
							.getSystemId());
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException("pps.securityException.roleall");
			}
			List result = (List) Mode2Xml.roles().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.roleall", e);
		}
	}

	public List queryRoleByUser(String userName) throws BaseException {
		try {
			String resultXml = WSHelper.callWS("queryRoleByUser",
					ServiceLocator.getToken(), ConfigurationHelper
							.getSystemId(), userName);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.rolebyuser");
			}
			List result = (List) Mode2Xml.roles().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.rolebyuser",
					e);
		}
	}
	
	public List queryRoleByType(String type) throws BaseException {
		try {
			String resultXml = WSHelper.callWS("queryRoleByType",
					ServiceLocator.getToken(), ConfigurationHelper
							.getSystemId(), type);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.rolebytype");
			}
			List result = (List) Mode2Xml.roles().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.rolebytype",
					e);
		}
	}

	public List queryRoleByGroup(String group) throws BaseException {
		try {
			String resultXml = WSHelper.callWS("queryRoleByGroup",
					ServiceLocator.getToken(), ConfigurationHelper
							.getSystemId(), group);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.rolebygroup");
			}
			List result = (List) Mode2Xml.roles().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.rolebygroup",
					e);
		}
	}

	public List queryRoleGroupAll() throws BaseException {
		try {
			String resultXml = WSHelper.callWS("queryRoleGroupAll",
					ServiceLocator.getToken(), ConfigurationHelper
							.getSystemId());
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.rolegroupall");
			}
			List result = (List) Mode2Xml.roleGroups().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.rolegroupall",
					e);
		}
	}
	
	public boolean addResource(EditResource editResource) throws BaseException {
		try {
			editResource.setAPPID(ConfigurationHelper.getSystemId());
			editResource.setTOKEN(ServiceLocator.getToken());
			String filter = FilterBase.beanToXml(editResource);
			String resultXml = WSHelper.callWS("addResource", filter);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.addResource");
			}
			if (resultXml.equalsIgnoreCase("true")) {
				return true;
			} else {
				return false;
			}
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException(
					"pps.securityException.addResource", e);
		}
	}

	public boolean modifyResource(EditResource editResource)
			throws BaseException {
		try {
			editResource.setAPPID(ConfigurationHelper.getSystemId());
			editResource.setTOKEN(ServiceLocator.getToken());
			String filter = FilterBase.beanToXml(editResource);
			String resultXml = WSHelper.callWS("modifyResource", filter);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.modifyResource");
			}
			if (resultXml.equalsIgnoreCase("true")) {
				return true;
			} else {
				return false;
			}
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException(
					"pps.securityException.modifyResource", e);
		}
	}

	public boolean deleteResource(EditResource editResource)
			throws BaseException {
		try {
			editResource.setAPPID(ConfigurationHelper.getSystemId());
			editResource.setTOKEN(ServiceLocator.getToken());
			String filter = FilterBase.beanToXml(editResource);
			String resultXml = WSHelper.callWS("deleteResource", filter);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.deleteResource");
			}
			if (resultXml.equalsIgnoreCase("true")) {
				return true;
			} else {
				return false;
			}
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException(
					"pps.securityException.deleteResource", e);
		}
	}

	public boolean moveResource(EditResource editResource) throws BaseException {
		try {
			editResource.setAPPID(ConfigurationHelper.getSystemId());
			editResource.setTOKEN(ServiceLocator.getToken());
			String filter = FilterBase.beanToXml(editResource);
			String resultXml = WSHelper.callWS("moveResource", filter);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.moveResource");
			}
			if (resultXml.equalsIgnoreCase("true")) {
				return true;
			} else {
				return false;
			}
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException(
					"pps.securityException.moveResource", e);
		}
	}

	public List queryResourceAll() throws BaseException {
		try {
			String resultXml = WSHelper.callWS("queryResourceAll",
					ServiceLocator.getToken(), ConfigurationHelper
							.getSystemId());
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.resourceall");
			}
			List result = (List) Mode2Xml.resources().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException(
					"pps.securityException.resourceall", e);
		}
	}

	public List queryResourceByRole(QueryResourceByRole queryResourceByRole)
			throws BaseException {
		try {
			queryResourceByRole.setAPPID(ConfigurationHelper.getSystemId());
			queryResourceByRole.setTOKEN(ServiceLocator.getToken());
			String filter = FilterBase.beanToXml(queryResourceByRole);
			String resultXml = WSHelper.callWS("queryResourceByRole", filter);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.resourcebyrole");
			}
			List result = (List) Mode2Xml.resources().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException(
					"pps.securityException.resourcebyrole", e);
		}
	}

	public List queryResource(QueryResource queryResource) throws BaseException {
		try {
			queryResource.setAPPID(ConfigurationHelper.getSystemId());
			queryResource.setTOKEN(ServiceLocator.getToken());
			String filter = FilterBase.beanToXml(queryResource);
			String resultXml = WSHelper.callWS("queryResource", filter);
			resultXml = X2OHelper.validateResult(resultXml);
			if (resultXml == null) {
				throw new BaseSecurityException(
						"pps.securityException.resource");
			}
			List result = (List) Mode2Xml.resources().fromXML(resultXml);
			return result;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException("pps.securityException.resource", e);
		}
	}

	public UserProfile authenticate(UserProfile up) throws BaseException {
		try {
			String userName = up.getUserName();
			
			//单点登录
			LoginOut login = this.singleLogin(userName);
			UserOut user = login.getUSERINFO();
			
			//设置token
			ServiceLocator.setToken(user.getTOKEN());
			
			//设置用户信息
			up.setUser(user);

			//设置组织机构
			List units = this.queryUnitByUser(userName);
			if (units.size() != 0){
				UnitOut unit = (UnitOut)units.get(0);
				up.setUnit(unit);
			}

			// 取菜单资源
			QueryResource queryR = new QueryResource();
			queryR.setISRETURNATTR(true);
			queryR.setISRETURNCHILD(true);

			User quser = new User();
			quser.setOPER_TYPE("equals");
			quser.setUSERNAME(userName);
			queryR.setUSER(quser);

			ResourceAttr resourceAttr = new ResourceAttr();
			resourceAttr.setNAME("可见");
			resourceAttr.setSTATE("1");
			List resourceattrs = new ArrayList();
			resourceattrs.add(resourceAttr);

			Resource resource = new Resource();
			resource.setOPER_TYPE("equal");
			resource.setRESOURCEID(SecurityContext.SECURITY_IMRP_MENU_KEY);
			resource.setRESOURCEATTRS_REF("and");
			resource.setRESOURCEATTRS(resourceattrs);
			queryR.setRESOURCE(resource);
			UnitOut out = this.queryDirectUnitByUser(userName);
			up.setUnitOfDatas(out);
			List result = this.queryResource(queryR);			
			up.setMeun(result);
            
			List roleAll = queryRoleByUser(userName);
			up.setRoles(roleAll);
			return up;
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseSecurityException(
					"pps.securityException.authenticate", e);
		}
	}
}
