package com.techstar.dmis.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.EtsEquipmentDto;
import com.techstar.dmis.entity.EtsEquipment;
import com.techstar.dmis.service.IEtsEquipmentService;
import org.springframework.dao.DataAccessException;

//please add your business methods start
	// to do it
//add your business method end

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class EtsEquipmentServiceImpl implements IEtsEquipmentService {
   //注册DAO
   private IEtsEquipmentDao etsEquipmentDao;
   private IBaseJdbcDao baseJdbcDao ;
   
  	//注册管理DAO
    	 private IBhFaultlistDao bhFaultlistDao;
	 public void setBhFaultlistDao
	    (IBhFaultlistDao bhFaultlistDao) {
		 this.bhFaultlistDao = bhFaultlistDao;
     }
		 private IFsLfparalistDao fsLfparalistDao;
	 public void setFsLfparalistDao
	    (IFsLfparalistDao fsLfparalistDao) {
		 this.fsLfparalistDao = fsLfparalistDao;
     }
		 private IZdhFaultlistDao zdhFaultlistDao;
	 public void setZdhFaultlistDao
	    (IZdhFaultlistDao zdhFaultlistDao) {
		 this.zdhFaultlistDao = zdhFaultlistDao;
     }
		 private IZdhSrappeqprelDao zdhSrappeqprelDao;
	 public void setZdhSrappeqprelDao
	    (IZdhSrappeqprelDao zdhSrappeqprelDao) {
		 this.zdhSrappeqprelDao = zdhSrappeqprelDao;
     }
		 private IDdSasusprecordDao ddSasusprecordDao;
	 public void setDdSasusprecordDao
	    (IDdSasusprecordDao ddSasusprecordDao) {
		 this.ddSasusprecordDao = ddSasusprecordDao;
     }
		 private IDdHloadrecordDao ddHloadrecordDao;
	 public void setDdHloadrecordDao
	    (IDdHloadrecordDao ddHloadrecordDao) {
		 this.ddHloadrecordDao = ddHloadrecordDao;
     }
		 private IDdAccidentbriefDao ddAccidentbriefDao;
	 public void setDdAccidentbriefDao
	    (IDdAccidentbriefDao ddAccidentbriefDao) {
		 this.ddAccidentbriefDao = ddAccidentbriefDao;
     }
		 private IZdhWorkbillDao zdhWorkbillDao;
	 public void setZdhWorkbillDao
	    (IZdhWorkbillDao zdhWorkbillDao) {
		 this.zdhWorkbillDao = zdhWorkbillDao;
     }
		 private IBhActionrecordDao bhActionrecordDao;
	 public void setBhActionrecordDao
	    (IBhActionrecordDao bhActionrecordDao) {
		 this.bhActionrecordDao = bhActionrecordDao;
     }
		 private IDdSwitchseqbillDao ddSwitchseqbillDao;
	 public void setDdSwitchseqbillDao
	    (IDdSwitchseqbillDao ddSwitchseqbillDao) {
		 this.ddSwitchseqbillDao = ddSwitchseqbillDao;
     }
		 private IFsLfeqpfixinformDao fsLfeqpfixinformDao;
	 public void setFsLfeqpfixinformDao
	    (IFsLfeqpfixinformDao fsLfeqpfixinformDao) {
		 this.fsLfeqpfixinformDao = fsLfeqpfixinformDao;
     }
		 private IParaWaterTBSysDao paraWaterTBSysDao;
	 public void setParaWaterTBSysDao
	    (IParaWaterTBSysDao paraWaterTBSysDao) {
		 this.paraWaterTBSysDao = paraWaterTBSysDao;
     }
		 private IParaWaterTBDao paraWaterTBDao;
	 public void setParaWaterTBDao
	    (IParaWaterTBDao paraWaterTBDao) {
		 this.paraWaterTBDao = paraWaterTBDao;
     }
		 private IParaWaterMonEqpDao paraWaterMonEqpDao;
	 public void setParaWaterMonEqpDao
	    (IParaWaterMonEqpDao paraWaterMonEqpDao) {
		 this.paraWaterMonEqpDao = paraWaterMonEqpDao;
     }
		 private IParaVQCDao paraVQCDao;
	 public void setParaVQCDao
	    (IParaVQCDao paraVQCDao) {
		 this.paraVQCDao = paraVQCDao;
     }
		 private IParaUPSDao paraUPSDao;
	 public void setParaUPSDao
	    (IParaUPSDao paraUPSDao) {
		 this.paraUPSDao = paraUPSDao;
     }
		 private IParaTurBineAdjusterDao paraTurBineAdjusterDao;
	 public void setParaTurBineAdjusterDao
	    (IParaTurBineAdjusterDao paraTurBineAdjusterDao) {
		 this.paraTurBineAdjusterDao = paraTurBineAdjusterDao;
     }
		 private IParaTelCommWorkSTDao paraTelCommWorkSTDao;
	 public void setParaTelCommWorkSTDao
	    (IParaTelCommWorkSTDao paraTelCommWorkSTDao) {
		 this.paraTelCommWorkSTDao = paraTelCommWorkSTDao;
     }
		 private IParaTBPowCtrlSysDao paraTBPowCtrlSysDao;
	 public void setParaTBPowCtrlSysDao
	    (IParaTBPowCtrlSysDao paraTBPowCtrlSysDao) {
		 this.paraTBPowCtrlSysDao = paraTBPowCtrlSysDao;
     }
		 private IParaTBHydroSysDao paraTBHydroSysDao;
	 public void setParaTBHydroSysDao
	    (IParaTBHydroSysDao paraTBHydroSysDao) {
		 this.paraTBHydroSysDao = paraTBHydroSysDao;
     }
		 private IParaSwitchDao paraSwitchDao;
	 public void setParaSwitchDao
	    (IParaSwitchDao paraSwitchDao) {
		 this.paraSwitchDao = paraSwitchDao;
     }
		 private IParaStoreEQPDao paraStoreEQPDao;
	 public void setParaStoreEQPDao
	    (IParaStoreEQPDao paraStoreEQPDao) {
		 this.paraStoreEQPDao = paraStoreEQPDao;
     }
		 private IParaSeverDao paraSeverDao;
	 public void setParaSeverDao
	    (IParaSeverDao paraSeverDao) {
		 this.paraSeverDao = paraSeverDao;
     }
		 private IParaRTUDao paraRTUDao;
	 public void setParaRTUDao
	    (IParaRTUDao paraRTUDao) {
		 this.paraRTUDao = paraRTUDao;
     }
		 private IParaRouterDao paraRouterDao;
	 public void setParaRouterDao
	    (IParaRouterDao paraRouterDao) {
		 this.paraRouterDao = paraRouterDao;
     }
		 private IParaRelayProtecDao paraRelayProtecDao;
	 public void setParaRelayProtecDao
	    (IParaRelayProtecDao paraRelayProtecDao) {
		 this.paraRelayProtecDao = paraRelayProtecDao;
     }
		 private IParaPowerMeterDao paraPowerMeterDao;
	 public void setParaPowerMeterDao
	    (IParaPowerMeterDao paraPowerMeterDao) {
		 this.paraPowerMeterDao = paraPowerMeterDao;
     }
		 private IParaPMUDao paraPMUDao;
	 public void setParaPMUDao
	    (IParaPMUDao paraPMUDao) {
		 this.paraPMUDao = paraPMUDao;
     }
		 private IParaParallReactorDao paraParallReactorDao;
	 public void setParaParallReactorDao
	    (IParaParallReactorDao paraParallReactorDao) {
		 this.paraParallReactorDao = paraParallReactorDao;
     }
		 private IParaOthersDao paraOthersDao;
	 public void setParaOthersDao
	    (IParaOthersDao paraOthersDao) {
		 this.paraOthersDao = paraOthersDao;
     }
		 private IParaMonitorStationDao paraMonitorStationDao;
	 public void setParaMonitorStationDao
	    (IParaMonitorStationDao paraMonitorStationDao) {
		 this.paraMonitorStationDao = paraMonitorStationDao;
     }
		 private IParaMonitorDevDao paraMonitorDevDao;
	 public void setParaMonitorDevDao
	    (IParaMonitorDevDao paraMonitorDevDao) {
		 this.paraMonitorDevDao = paraMonitorDevDao;
     }
		 private IParaMainTRFDao paraMainTRFDao;
	 public void setParaMainTRFDao
	    (IParaMainTRFDao paraMainTRFDao) {
		 this.paraMainTRFDao = paraMainTRFDao;
     }
		 private IParaLanEncDevDao paraLanEncDevDao;
	 public void setParaLanEncDevDao
	    (IParaLanEncDevDao paraLanEncDevDao) {
		 this.paraLanEncDevDao = paraLanEncDevDao;
     }
		 private IParaIsoDevDao paraIsoDevDao;
	 public void setParaIsoDevDao
	    (IParaIsoDevDao paraIsoDevDao) {
		 this.paraIsoDevDao = paraIsoDevDao;
     }
		 private IParaHISwitchDao paraHISwitchDao;
	 public void setParaHISwitchDao
	    (IParaHISwitchDao paraHISwitchDao) {
		 this.paraHISwitchDao = paraHISwitchDao;
     }
		 private IParaGroudTransferDao paraGroudTransferDao;
	 public void setParaGroudTransferDao
	    (IParaGroudTransferDao paraGroudTransferDao) {
		 this.paraGroudTransferDao = paraGroudTransferDao;
     }
		 private IParaGPSDao paraGPSDao;
	 public void setParaGPSDao
	    (IParaGPSDao paraGPSDao) {
		 this.paraGPSDao = paraGPSDao;
     }
		 private IParaGeneratorDao paraGeneratorDao;
	 public void setParaGeneratorDao
	    (IParaGeneratorDao paraGeneratorDao) {
		 this.paraGeneratorDao = paraGeneratorDao;
     }
		 private IParaFirewallDao paraFirewallDao;
	 public void setParaFirewallDao
	    (IParaFirewallDao paraFirewallDao) {
		 this.paraFirewallDao = paraFirewallDao;
     }
		 private IParaFaullistDao paraFaullistDao;
	 public void setParaFaullistDao
	    (IParaFaullistDao paraFaullistDao) {
		 this.paraFaullistDao = paraFaullistDao;
     }
		 private IParaEngTermDao paraEngTermDao;
	 public void setParaEngTermDao
	    (IParaEngTermDao paraEngTermDao) {
		 this.paraEngTermDao = paraEngTermDao;
     }
		 private IParaDryReactorDao paraDryReactorDao;
	 public void setParaDryReactorDao
	    (IParaDryReactorDao paraDryReactorDao) {
		 this.paraDryReactorDao = paraDryReactorDao;
     }
		 private IParaDeliverDao paraDeliverDao;
	 public void setParaDeliverDao
	    (IParaDeliverDao paraDeliverDao) {
		 this.paraDeliverDao = paraDeliverDao;
     }
		 private IParaDCSysInfoDao paraDCSysInfoDao;
	 public void setParaDCSysInfoDao
	    (IParaDCSysInfoDao paraDCSysInfoDao) {
		 this.paraDCSysInfoDao = paraDCSysInfoDao;
     }
		 private IParaCAPBankDao paraCAPBankDao;
	 public void setParaCAPBankDao
	    (IParaCAPBankDao paraCAPBankDao) {
		 this.paraCAPBankDao = paraCAPBankDao;
     }
		 private IParaBigScreenDao paraBigScreenDao;
	 public void setParaBigScreenDao
	    (IParaBigScreenDao paraBigScreenDao) {
		 this.paraBigScreenDao = paraBigScreenDao;
     }
		 private IParaAVRDao paraAVRDao;
	 public void setParaAVRDao
	    (IParaAVRDao paraAVRDao) {
		 this.paraAVRDao = paraAVRDao;
     }
		 private IParaAuxTRFDao paraAuxTRFDao;
	 public void setParaAuxTRFDao
	    (IParaAuxTRFDao paraAuxTRFDao) {
		 this.paraAuxTRFDao = paraAuxTRFDao;
     }
		 private IParaAuxProtectDao paraAuxProtectDao;
	 public void setParaAuxProtectDao
	    (IParaAuxProtectDao paraAuxProtectDao) {
		 this.paraAuxProtectDao = paraAuxProtectDao;
     }
		 private IEqpAttachmentDao eqpAttachmentDao;
	 public void setEqpAttachmentDao
	    (IEqpAttachmentDao eqpAttachmentDao) {
		 this.eqpAttachmentDao = eqpAttachmentDao;
     }
		 private IZdhReceptioneqprelDao zdhReceptioneqprelDao;
	 public void setZdhReceptioneqprelDao
	    (IZdhReceptioneqprelDao zdhReceptioneqprelDao) {
		 this.zdhReceptioneqprelDao = zdhReceptioneqprelDao;
     }
		 private IStdManufacturerDao stdManufacturerDao;
	 public void setStdManufacturerDao
	    (IStdManufacturerDao stdManufacturerDao) {
		 this.stdManufacturerDao = stdManufacturerDao;
     }
		 private IStdUnitDao stdUnitDao;
	 public void setStdUnitDao
	    (IStdUnitDao stdUnitDao) {
		 this.stdUnitDao = stdUnitDao;
     }
		 private IEQPTypeDao eqPTypeDao;
	 public void setEqPTypeDao
	    (IEQPTypeDao eqPTypeDao) {
		 this.eqPTypeDao = eqPTypeDao;
     }
		 private IMbayDao mbayDao;
	 public void setMbayDao
	    (IMbayDao mbayDao) {
		 this.mbayDao = mbayDao;
     }
	  	

	public EtsEquipmentServiceImpl() {}
	
	public void addEtsEquipment(EtsEquipmentDto dto) {
	
    	if (StringUtils.isEmpty(dto.getFeqpid())){
		      if( StringUtils.isEmpty(dto.getFeqpid())){
		          dto.setFeqpid(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		EtsEquipment etsEquipment = (EtsEquipment) BeanHelper.buildBean(EtsEquipment.class, dto);
		etsEquipmentDao.saveOrUpdate(etsEquipment);		
	}
	
    //用于实现基本增加或修改操作
	public void saveOrUpdateEtsEquipment(EtsEquipmentDto dto) {
		if (StringUtils.isEmpty(dto.getFeqpid())){
		      if( StringUtils.isEmpty(dto.getFeqpid())){
		          dto.setFeqpid(new SequenceCreator().getUID());
		       }
		}
		EtsEquipment etsEquipment = (EtsEquipment) BeanHelper.buildBean(EtsEquipment.class, dto);
		etsEquipmentDao.saveOrUpdate(etsEquipment);
	}
    //用于实现基本删除操作
	public void deleteEtsEquipment(String etsEquipmentId) {
		EtsEquipment etsEquipment = new EtsEquipment();
		etsEquipment.setFeqpid(etsEquipmentId);
		etsEquipmentDao.delete(etsEquipment);
	}
   //用于实现基本DTOLOAD操作
	public EtsEquipmentDto loadEtsEquipment(String feqpid) {
		EtsEquipment etsEquipment = (EtsEquipment) etsEquipmentDao.findByPk(feqpid);
		EtsEquipmentDto dto = (EtsEquipmentDto) BeanHelper.buildBean(EtsEquipmentDto.class, etsEquipment);
		return dto;
	}
//用于实现列表操作
   public QueryListObj listEtsEquipment() {
		QueryListObj obj = etsEquipmentDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(EtsEquipmentDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj listEtsEquipmentByHql(String hql) {
		QueryListObj obj = etsEquipmentDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(EtsEquipment.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
	
	public QueryListObj getEtsEquipmentByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = etsEquipmentDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(EtsEquipment.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = etsEquipmentDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	
  /**
    * @business method list
	     */

	//please add your business methods start
	// to do it
	//add your business method end
	
	public IEtsEquipmentDao getEtsEquipmentDao() {
		return etsEquipmentDao;
	}

	public void setEtsEquipmentDao(IEtsEquipmentDao etsEquipmentDao) {
		this.etsEquipmentDao = etsEquipmentDao;
	}
	
	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}
	
	public void saveOrUpdateEtsEquipment(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			EtsEquipmentDto etsEquipmentDto = (EtsEquipmentDto)dtos.get(i);
			EtsEquipment etsEquipment = (EtsEquipment) BeanHelper.buildBean(EtsEquipment.class, etsEquipmentDto);
		    pos.add(etsEquipment);
		}
		
		etsEquipmentDao.saveOrUpdateAll(pos);	
	}
	
		


	
}
