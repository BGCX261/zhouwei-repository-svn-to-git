package com.sitechasia.webx.core.dao.jdbc;

import com.sitechasia.webx.core.model.IDomainObject;

public class Customer implements IDomainObject{
    private Long id;
    private String name;
    private int age;
    private String memo;

    /** 完整的构造方法*/
    public Customer(long id,String name, int age,String memo) {
    	this.id=id;
        this.name = name;
        this.age = age;
        this.memo=memo;
    }

    /** 默认构造方法*/
    public Customer() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString(){
    	return "id是:"+id+",name是:"+name+",age 是:"+age+",memo是"+memo;
    }

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
