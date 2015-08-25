package com.techstar.griddemo.web.form;


import com.techstar.framework.web.form.BaseForm;
import com.techstar.griddemo.dto.SaleBillDto;

public class SaleBillForm extends BaseForm{
	SaleBillDto saleBillDto = new SaleBillDto();

	public SaleBillDto getSaleBillDto() {
		return saleBillDto;
	}

	public void setSaleBillDto(SaleBillDto saleBillDto) {
		this.saleBillDto = saleBillDto;
	}
}
