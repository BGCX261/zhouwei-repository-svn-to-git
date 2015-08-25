package com.techstar.framework.demo.dictionary.web.form;

import java.util.Hashtable;
import java.util.Map;

import com.techstar.framework.demo.dto.CompanyDto;
import com.techstar.framework.service.dto.DictionaryBaseDto;
import com.techstar.framework.web.form.BaseForm;

public class DictionaryBaseForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	private CompanyDto companyDto = new CompanyDto();
	private Map instanceMap = new Hashtable();
	
	public DictionaryBaseForm() {
		instanceMap.put("Company", this.getCompanyDto());		
	}

	public void setDtoInstance(Object dtoobj){
		if (dtoobj instanceof CompanyDto) {
			CompanyDto dto = (CompanyDto) dtoobj;
			this.setCompanyDto(dto);			
		}
	}

	public DictionaryBaseDto getCompanyDto() {
		return companyDto;
	}

	public void setCompanyDto(DictionaryBaseDto companyDto) {
		this.companyDto = (CompanyDto)companyDto;
	}
	
	public DictionaryBaseDto getDtoInstance(String poName){
		if( instanceMap.containsKey(poName)){			
			return (DictionaryBaseDto)instanceMap.get(poName);
		}else{
			return null;
		}
	}
}
