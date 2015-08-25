//model
//.java
package com.sitechasia.webx.example.category.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.sitechasia.webx.core.model.IDomainObject;
import com.sitechasia.webx.core.model.IValueObjectValidator;

 
public class CategoryDo implements IDomainObject, IValueObjectValidator {
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
	

	public boolean equals(Object obj) {
		if (obj != null && obj instanceof CategoryDo) {
			java.lang.Integer tempId = ((CategoryDo)obj).catid;
			if (tempId == null) return false;
			return tempId.equals(this.catid);
		}
		return false;
	}

	public boolean validate() {
		return true;
	}

	public int hashCode() {
		return this.catid == null ? 0 : this.catid.hashCode();
	}
}