package com.techstar.dmis.web.form;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.form.BaseForm;
import com.techstar.dmis.dto.FsApprovebookDto;
//please add your business methods start
	// to do it
//add your business method end

/**
 * @author 
 * @date
 */
public class FsApprovebookForm extends BaseForm {
	
	private FsApprovebookDto fsApprovebookDto = new FsApprovebookDto();

	
				      private FormFile feqpcontent;
	   		
	public FsApprovebookForm() {

	}

	public FsApprovebookDto getFsApprovebookDto() {
		return fsApprovebookDto;
	}

	public void setFsApprovebookDto(FsApprovebookDto fsApprovebookDto) {
		this.fsApprovebookDto = fsApprovebookDto;
	}

						
	public FormFile getFeqpcontent() {
		return feqpcontent;
	}

	public void setFeqpcontent(FormFile feqpcontent) {
		this.feqpcontent = feqpcontent;
	}
			
	//please add your business methods start
	// to do it
    //add your business method end
}
