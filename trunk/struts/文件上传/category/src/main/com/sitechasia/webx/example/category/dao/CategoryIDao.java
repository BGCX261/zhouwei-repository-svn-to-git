//dao
//.java
package com.sitechasia.webx.example.category.dao;


import com.sitechasia.webx.core.dao.IDomainObjectDao;
import com.sitechasia.webx.core.support.Page;
import com.sitechasia.webx.example.category.model.CategoryDo;

public interface CategoryIDao extends IDomainObjectDao<CategoryDo> {

    public Page searchCategorys(int pageNo, int pageSize, String sortStr,Object... params);

}
