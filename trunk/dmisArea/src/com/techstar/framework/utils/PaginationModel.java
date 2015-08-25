package com.techstar.framework.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 参考Tapestry4分页组件
 * 
 * @author caojian May 8, 2007
 *
 */
public class PaginationModel implements Serializable{
    protected int rowCount;
    protected int pageSize;
    protected int currentPage;
    protected List dataList;
    
    /**
     * 通过数据列表创建模型,适用于小表分页
     * @param data 数据列表
     * @param pageSize 每页行数
     */
    public PaginationModel(List data, int pageSize) {
        //Defense.notNull(data, "数据列表");
        if (pageSize <= 0) {
            throw new IllegalArgumentException("分页尺寸非正数");
        }
        this.dataList = data;
        this.rowCount = data.size();
        this.pageSize = pageSize;
        this.currentPage = 1;
        //Log.getLogger().debug("建立分页模型: " + toString());

    }

    public PaginationModel(int rowCount, int pageSize) {
        if (rowCount < 0) {
            throw new IllegalArgumentException("行数为负数");
        }
        if (pageSize <= 0) {
            throw new IllegalArgumentException("分页尺寸非正数");
        }
        this.dataList = new ArrayList();
        this.rowCount = rowCount;
        this.pageSize = pageSize;
        this.currentPage = 1;
        //Log.getLogger().debug("建立分页模型: " + toString());
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public boolean hasNextPage() {
        return currentPage * pageSize < rowCount;
    }

    public boolean hasPrevPage() {
        return currentPage > 1;
    }

    public int getPageCount() {
        if (rowCount == 0) {
            return 1;
        }
        return (rowCount - 1) / pageSize + 1;
    }

    public void goTo(int toPage) {
        if (toPage < 1) {
            currentPage = 1;
        }
        else if (toPage > getPageCount()) {
            currentPage = getPageCount();
        }
        else {
            currentPage = toPage;
        }
        //Log.getLogger().debug("转到第 " + currentPage + " 页");
    }

    public List getPaginationData() {
        int from = (currentPage - 1) * pageSize;
        int to = from + pageSize;
        if (to <= rowCount) {
            return dataList.subList(from, to);
        }
        else {
            return dataList.subList(from, rowCount);
        }

    }

    public String toString() {
    	return null;
//        return String.format(
//            "总行数=%d,每页行数=%d,页数=%d,当前页=%d",
//            rowCount, pageSize, this.getPageCount(), currentPage)
//                + super.toString();
    }

}
