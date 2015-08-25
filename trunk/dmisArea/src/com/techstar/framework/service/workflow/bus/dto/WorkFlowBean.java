//Source file: C:\\j2re1.4.2_05\\com\\techstar\\jhop\\cms\\model\\WorkFlowBean.java

package  com.techstar.framework.service.workflow.bus.dto;

import org.apache.commons.lang.WordUtils;



/**
 * 工作流服务类模型
 * 
 * @author xiongcf
 */
public class WorkFlowBean {
	private String wfDesc;

	private String entityName;

	private java.util.List functions;

	/**
	 * @roseuid 45496D3F0213
	 */
	public WorkFlowBean() {

	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public java.util.List getFunctions() {
		return functions;
	}

	public void setFunctions(java.util.List functions) {
		this.functions = functions;
	}

	public String getWfDesc() {
		return wfDesc;
	}

	public void setWfDesc(String wfDesc) {
		this.wfDesc = wfDesc;
	}
	public String getUpEntityName() {
		return WordUtils.capitalize(getEntityName());
	}
	public String getLowEntityName() {
		return WordUtils.uncapitalize(getEntityName());
	}
}
