package com.sitechasia.webx.example.category.web;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.commons.validator.ValidatorException;
import org.extremecomponents.table.limit.Limit;
import org.extremecomponents.util.ServletUtils;
import org.extremecomponents.util.ExtremeUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sitechasia.webx.core.annotation.Out;
import com.sitechasia.webx.core.annotation.Read;
import com.sitechasia.webx.core.support.Page;
import com.sitechasia.webx.core.web.struts1.action.BaseCRUDAction;
import com.sitechasia.webx.example.category.service.CategoryIService;
import com.sitechasia.webx.example.category.vo.CategoryVo;
import com.sitechasia.webx.validator.BindingErrorProcessorStrutsSupport;
import com.sitechasia.webx.validator.DefaultBindingErrorProcessor;
import com.sitechasia.webx.validator.test.ValidateBean;
import com.sitechasia.webx.core.annotation.Scope;

/**
 * CategoryAction
 * 
 * @author Administrator
 * @version
 */
public class CategoryAction extends
		BaseCRUDAction<CategoryVo, java.lang.Integer> {

	private CategoryIService categoryIService;

	public void setCategoryIService(CategoryIService categoryIService) {
		this.categoryIService = categoryIService;
		this.setService(categoryIService);
	}

	private BindingErrorProcessorStrutsSupport bindingErrorProcessorStrutsSupport;

	public void setBindingErrorProcessorStrutsSupport(
			BindingErrorProcessorStrutsSupport bindingErrorProcessorStrutsSupport) {
		this.bindingErrorProcessorStrutsSupport = bindingErrorProcessorStrutsSupport;
	}

	private DefaultBindingErrorProcessor defaultBindingErrorProcessor;

	public void setDefaultBindingErrorProcessor(
			DefaultBindingErrorProcessor defaultBindingErrorProcessor) {
		this.defaultBindingErrorProcessor = defaultBindingErrorProcessor;
	}

	private final static ValidateBean bean = new ValidateBean();

	private void print() throws ValidatorException {

		String[] errors = defaultBindingErrorProcessor.getErrors(bean,
				"ValidateBean", this.getRequest().getLocale());

		if (errors.length > 0) {
			System.out.println("print errors: " + errors.length);
		} else {
			return;
		}

		for (String error : errors)
			System.out.println(error);
	}

	private void printStruts() throws ValidatorException {

		bindingErrorProcessorStrutsSupport.setStrutsServletRequest(this
				.getRequest());

		String[] errors = bindingErrorProcessorStrutsSupport.getErrors(bean,
				"ValidateBean");

		if (errors.length > 0) {
			System.out.println("print errors: " + errors.length);
		} else {
			return;
		}

		for (String error : errors)
			System.out.println(error);
	}

	// 默认每页显示的记录条数
	protected static int DEFAULT_PAGE_SIZE = 5;
	protected static int DEFAULT_PAGENO = 1;

	/**
	 * list 查询
	 * 
	 * @param
	 * @throws
	 * @exception
	 * @return List
	 */
	@Out(key = "CategoryVos")
	public List list() {
		int nPageNo = DEFAULT_PAGENO;
		int nPageSize = ExtremeUtils.getPageSize(getRequest(),
				DEFAULT_PAGE_SIZE);
		// 取得总行数
		int totalRows = ExtremeUtils.getTotalRowsFromRequest(getRequest());
		if (totalRows > 0) {
			// 校验值
			Limit limit = ExtremeUtils.getLimit(getRequest(), totalRows,
					DEFAULT_PAGE_SIZE);
			// 取得欲显示列表数据的页号
			nPageNo = ExtremeUtils.getPageNo(limit);
			// 取得列表每页显示的行数
			nPageSize = ExtremeUtils.getPageSize(limit);
		}
		String orderStr = ExtremeUtils.getOrderString(getRequest());
		Page page = null;
		// 取查询条件
		Object[] t = new Object[0];
		page = categoryIService
				.searchCategorys(nPageNo, nPageSize, orderStr, t);
		ExtremeUtils.setTotalRows(getRequest(), (int) (page.getTotalCount()));
		//
		try {
			print();
			System.out.println("$$$$$$$$$$$");
			printStruts();
		} catch (ValidatorException e) {
			e.printStackTrace();
		}

		return page.getResult();
	}

	/**
	 * delete 删除
	 * 
	 * @param recordKeys
	 * @throws
	 * @exception Exception
	 * @return List
	 */
	public void delete(@Read(key = "recordKey") java.lang.Integer[] recordKeys)
			throws Exception {
		int[] results = new int[recordKeys.length];
		try {
			doDeleteByIds(recordKeys);
			Arrays.fill(results, 1);
		} catch (Exception e) {
			Arrays.fill(results, 0);
		}
		List userInfoList = ServletUtils.getParameterMaps(getRequest());
		ServletUtils.defaultAjaxResopnse(userInfoList, results, getRequest(),
				getResponse());
	}

	/**
	 * doEdit 编辑
	 * 
	 * @param
	 * @throws
	 * @exception
	 * @return void
	 */
	// public void doEdit() {
	// String id = this.getRequest().getParameter("id");
	// CategoryVo categoryVo = categoryIService
	// .findById(new java.lang.Integer(id));
	// //this.getRequest().setAttribute("currentEntity", categoryVo);
	// this.setAttribute("currentEntity", categoryVo);
	// }
	public void doEdit(@Read(key = "catid", scope = Scope.REQUEST) String id) {
		CategoryVo categoryVo = categoryIService
				.findById(new java.lang.Integer(id));
		this.getRequest().setAttribute("ak47", categoryVo);
		this.setAttribute("currentEntity", categoryVo);
	}

	/**
	 * doAdd 添加
	 * 
	 * @param
	 * @throws
	 * @exception
	 * @return String
	 */
	public String doAdd() {
		return "doAdd";
	}

	public void fileUpload(
			@Read(key = "photo", scope = Scope.REQUEST) MultipartFile photo) {
		String name=photo.getOriginalFilename();
		long size=photo.getSize();
		String type=photo.getContentType();
		System.out.println("file name :"+name+"\nfile size :"+size+"\nfile type :"+type);
	}
}