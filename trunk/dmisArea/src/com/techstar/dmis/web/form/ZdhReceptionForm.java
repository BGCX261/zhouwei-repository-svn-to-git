package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.ZdhReceptionDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class ZdhReceptionForm extends BaseForm {
	
	private ZdhReceptionDto zdhReceptionDto = new ZdhReceptionDto();

	
				      private FormFile freceptiongraph;
	   	      private FormFile freceptionreport;
	   	      private FormFile fsequence;
	   	      private FormFile ftranrec;
	   	      private String runeqpcontent;
	   		
	public ZdhReceptionForm() {

	}

	public ZdhReceptionDto getZdhReceptionDto() {
		return zdhReceptionDto;
	}

	public void setZdhReceptionDto(ZdhReceptionDto zdhReceptionDto) {
		this.zdhReceptionDto = zdhReceptionDto;
	}

						
	public FormFile getFreceptiongraph() {
		return freceptiongraph;
	}

	public void setFreceptiongraph(FormFile freceptiongraph) {
		this.freceptiongraph = freceptiongraph;
	}
				
	public FormFile getFreceptionreport() {
		return freceptionreport;
	}

	public void setFreceptionreport(FormFile freceptionreport) {
		this.freceptionreport = freceptionreport;
	}
				
	public FormFile getFsequence() {
		return fsequence;
	}

	public void setFsequence(FormFile fsequence) {
		this.fsequence = fsequence;
	}
				
	public FormFile getFtranrec() {
		return ftranrec;
	}

	public void setFtranrec(FormFile ftranrec) {
		this.ftranrec = ftranrec;
	}
				
	public String getRuneqpcontent() {
		return runeqpcontent;
	}

	public void setRuneqpcontent(String runeqpcontent) {
		
		this.runeqpcontent = runeqpcontent;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
