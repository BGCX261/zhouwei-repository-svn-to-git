package com.techstar.griddemo.web.facade;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.techstar.griddemo.service.IDictionaryService;
import com.techstar.framework.service.dto.DictionaryBaseDto;
import com.techstar.framework.utils.SequenceCreator;
//please add your business methods start
	// to do it
//add your business method end

/**
 * 业务字典统一处理facade类
 * @author 
 * @date
 */
public class DictionaryBaseFacade {
	/**
	 * 注册字典服务对象
	 * */
	private IDictionaryService dicService;

	/**
	 * 得到字典列表
	 * @param poName 该参数是字典实体的英文名
	 * @return List
	 */
	public List listDic(String poName) {
		return dicService.getQueryList(poName).getElemList();
	}

	/**
	 * 增加字典对象
	 * @param poName 要保存的字典实体对象英文名
	 * @param dto 要保存的字典传输对象名
	 */
	public List addDic(String poName , DictionaryBaseDto dto) {
		if( StringUtils.isEmpty(dto.getId())){
			dto.setId( new SequenceCreator().getUID() ); //生成内部序列号
		}
		dicService.saveOrUpdate(poName, dto);
		return dicService.getQueryList(poName).getElemList();
	}

	/**
	 * 根据ID得到指定的字典对象
	 * 
	 * @param id  Object 主键值ֵ
	 */
	public Object getDicById(String poName , Object id) {
		Object dto = dicService.findById(poName, id);
		return dto;
	}

	/**
	 * 删除指定的字典对象并且重新查询字典列表
	 * 
	 * @param id
	 * Integer 主键值ֵ
	 */
	public List deleteDic(String poName , Object id) {
		dicService.deleteById(poName, id);
		return this.listDic(poName);
	}

	


	public void setDicService(IDictionaryService dicService) {
		this.dicService = dicService;
	}
	//please add your business methods start
	// to do it
    //add your business method end
}
