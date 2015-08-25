//vo
//.java
package com.sitechasia.webx.example.category.vo;

import java.util.*;
import com.sitechasia.webx.core.model.IViewObject;

public class CategoryVo implements IViewObject {

			private java.lang.Integer catid;
				private java.lang.String name;
				private java.lang.String descn;
	

			public void setCatid(java.lang.Integer catid) {
			this.catid = catid;
		}
		public java.lang.Integer getCatid() {
			return this.catid;
		}
				public void setName(java.lang.String name) {
			this.name = name;
		}
		public java.lang.String getName() {
			return this.name;
		}
				public void setDescn(java.lang.String descn) {
			this.descn = descn;
		}
		public java.lang.String getDescn() {
			return this.descn;
		}
	

	public boolean validate() {
		return true;
	}
}
