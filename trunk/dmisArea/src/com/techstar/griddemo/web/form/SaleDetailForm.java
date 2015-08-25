package com.techstar.griddemo.web.form;

import com.techstar.framework.web.form.BaseForm;
import com.techstar.griddemo.dto.SaleBillDto;
import com.techstar.griddemo.dto.SaleDetailDto;

public class SaleDetailForm extends BaseForm{
	SaleDetailDto saleDetailDto = new SaleDetailDto();

	public SaleDetailDto getSaleDetailDto() {
		return saleDetailDto;
	}

	public void setSaleDetailDto(SaleDetailDto saleDetailDto) {
		this.saleDetailDto = saleDetailDto;
	}
}
