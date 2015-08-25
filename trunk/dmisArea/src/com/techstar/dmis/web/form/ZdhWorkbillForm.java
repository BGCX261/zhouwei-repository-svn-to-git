package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.ZdhWorkbillDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class ZdhWorkbillForm extends BaseForm {
	
	private ZdhWorkbillDto zdhWorkbillDto = new ZdhWorkbillDto();

	
    private FormFile safetyremarks;
	private FormFile analysereport;
	   		
	public ZdhWorkbillForm() {

	}

	public ZdhWorkbillDto getZdhWorkbillDto() {
        //考虑级联问题		
		if (zdhWorkbillDto.getZzdhworkbill2() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhworkbill2 = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhWorkbillDto.setZzdhworkbill2(zzdhworkbill2);
		}		
		if (zdhWorkbillDto.getZzdhworkbill4() == null) {
			com.techstar.dmis.dto.EtsEquipmentDto zzdhworkbill4 = new com.techstar.dmis.dto.EtsEquipmentDto();
			zdhWorkbillDto.setZzdhworkbill4(zzdhworkbill4);
		}
		return zdhWorkbillDto;
	}
    
	public void setZdhWorkbillDto(ZdhWorkbillDto zdhWorkbillDto) {
		//考虑级联问题		
		if (zdhWorkbillDto.getZzdhworkbill2() == null) {
			com.techstar.dmis.dto.ZdhAutoondutylogDto zzdhworkbill2 = new com.techstar.dmis.dto.ZdhAutoondutylogDto();
			zdhWorkbillDto.setZzdhworkbill2(zzdhworkbill2);
		}
		
		if (zdhWorkbillDto.getZzdhworkbill4() == null) {
			com.techstar.dmis.dto.EtsEquipmentDto zzdhworkbill4 = new com.techstar.dmis.dto.EtsEquipmentDto();
			zdhWorkbillDto.setZzdhworkbill4(zzdhworkbill4);
		}
		
		this.zdhWorkbillDto = zdhWorkbillDto;
	}

						
	public FormFile getSafetyremarks() {
		return safetyremarks;
	}

	public void setSafetyremarks(FormFile safetyremarks) {
		this.safetyremarks = safetyremarks;
	}
				
	public FormFile getAnalysereport() {
		return analysereport;
	}

	public void setAnalysereport(FormFile analysereport) {
		this.analysereport = analysereport;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
