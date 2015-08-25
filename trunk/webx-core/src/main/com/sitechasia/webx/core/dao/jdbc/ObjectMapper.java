/**
 * @{#} BaseJdbcDomainDao.java Create on 2008-5-12 下午01:19:40
 *
 * Copyright (c) 2006- by CE.
 */
package com.sitechasia.webx.core.dao.jdbc;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 对一个类或者对象进行包装,得到这个类或者这个对象的所有成员(方法或者成员变量)
 *
 * @author Sunzhenying
 *
 */
public class ObjectMapper {
	private final Logger logger = Logger.getLogger(getClass());

	private Object object;

	/** 实例的类型 */
	private Class classType;

	/** 类的名字 */
	private String className;

	/** 对应的表的名字 */
	private String tableName;

	/** 表中所有的字段的名字 */
	private String tableFieldNames[];

	/** 类的所有属性 */
	private Field fields[];

	/** 类的所有get方法 */
	private Method getMethods[];

	/** 类的所有set方法 */
	private Method setMethods[];

	/** 类的getId方法 */
	private Method getIdMethod;

	/** 类的setId方法 */
	private Method setIdMethod;

	/** 对象的id */
	private Serializable id;

	public ObjectMapper(Class classType) throws Exception {// 构造函数
		this(classType.getConstructor(new Class[] {}).newInstance(
				new Object[] {}));
	}

	/**
	 * ObjectMapper的构造方法
	 *
	 * @param object
	 */
	public ObjectMapper(Object object) {// 构造函数
		this.classType = object.getClass();
		/** 类的所有属性 */
		Field allFields[];

		/** 类的所有get方法 */
		Method allGetMethods[];

		/** 类的所有set方法 */
		Method allSetMethods[];

		this.object = object;

		// 获得类名，不带包的名字
		int dotLocation = classType.getName().lastIndexOf(".");
		this.className = classType.getName().substring(dotLocation + 1);

		// 获得对应的表名
		this.tableName = className.toUpperCase();

		// 获得类的所有属性
		allFields = classType.getDeclaredFields();

		// 获得表的所有字段名，类的所有get方法和set方法
		allGetMethods = new Method[allFields.length];
		allSetMethods = new Method[allFields.length];
		try {
			for (int i = 0; i < allFields.length; i++) {
				// tableFieldNames[i] = fields[i].getName().toUpperCase();
				allGetMethods[i] = getMethod(allFields[i], "get");
				allSetMethods[i] = getMethod(allFields[i], "set");

				if (allFields[i].getName().equals("id")) {
					this.id = (Long) executeGetMethod(allGetMethods[i]);
					this.getIdMethod = allGetMethods[i];
					this.setIdMethod = allSetMethods[i];
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}

		/**
		 * 取实际表的字段的个数
		 */
		int j = getNumber(allGetMethods, allSetMethods);

		this.fields = new Field[j];
		this.tableFieldNames = new String[j];
		this.getMethods = new Method[j];
		this.setMethods = new Method[j];
		j = 0;
		for (int i = 0; i < allFields.length; i++) {
			if ((allGetMethods[i] == null) || (allSetMethods[i] == null)) {
				// do nothing
			} else {
				fields[j] = allFields[i];
				tableFieldNames[j] = allFields[i].getName().toUpperCase();
				getMethods[j] = allGetMethods[i];
				setMethods[j] = allSetMethods[i];
				j = j + 1;
			}
		}
	}

	/**
	 *
	 * 方法说明：得到具有set和get方法的成员变量的个数
	 *
	 * @author Administrator
	 * @param allGetMethods
	 * @param allSetMethods
	 * @return
	 * @see
	 */
	private int getNumber(Method[] allGetMethods, Method[] allSetMethods) {
		int j = 0;
		for (int i = 0; i < allGetMethods.length; i++) {
			if ((allGetMethods[i] == null) || (allSetMethods[i] == null)) {
				// do nothing
			} else {
				j = j + 1;
			}
		}
		return j;
	}

	/**
	 *
	 * 方法说明：执行某个方法
	 *
	 * @author Sunzhenying
	 * @param method
	 * @return 返回方法执行后的结果
	 * @throws Exception
	 * @see #executeGetMethod(Object o, Method method)
	 */
	private Object executeGetMethod(Method method) throws Exception {
		return method.invoke(this.object, new Object[] {});
	}

	/**
	 *
	 * 方法说明：执行某个对象的某个方法
	 *
	 * @author Sunzhenying
	 * @param o
	 * @param method
	 * @return 返回方法执行的结果
	 * @see #executeGetMethod(Method method)
	 */
	public Object executeGetMethod(Object o, Method method) {
		try {
			return method.invoke(o, new Object[] {});
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/**
	 *
	 * 方法说明：执行某个对象的某个方法
	 *
	 * @author Sunzhenying
	 * @param o
	 * @param method
	 * @param parameter
	 * @throws Exception
	 * @see #executeGetMethod(Object o, Method method)
	 */
	private void executeSetMethod(Object o, Method method, Object parameter)
			throws Exception {
		method.invoke(o, new Object[] { parameter });// 调用某个对象的方法,就是这样来调用
	}

	/**
	 *
	 * 方法说明：得到字段Field的get方法
	 *
	 * @author Sunzhenying
	 * @param field
	 * @param prefix
	 * @return 返回字段Field的get方法
	 * @throws Exception
	 * @see #ObjectMapper(Object object)
	 */
	private Method getMethod(Field field, String prefix) {
		String methodName = prefix;
		String fieldName = field.getName();
		String firstLetter = fieldName.substring(0, 1).toUpperCase();
		methodName = prefix + firstLetter + fieldName.substring(1);

		try {
			if (prefix.equals("set"))
				return this.classType.getMethod(methodName, new Class[] { field
						.getType() });
			else
				return this.classType.getMethod(methodName, new Class[] {});
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 *
	 * 方法说明：将ResultSet逐条解析成实体对象的List
	 *
	 * @author Sunzhenying
	 * @param rs
	 * @return 返回实体对象的List
	 * @throws Exception
	 * @see #getColumns(ResultSet rs)
	 */
	public List parseResultSet(ResultSet rs) throws Exception {
		List list = new ArrayList<Object>();
		Object[] columns = getColumns(rs);
		while (rs.next()) {
			Object o = classType.getConstructor(new Class[] {}).newInstance(
					new Object[] {});
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				Class fieldType = field.getType();
				Method setMethod = setMethods[i];
				String fieldName = field.getName();
				if (contains(columns, fieldName)) {
					if ((fieldType.getName().equals("int"))
							|| (fieldType.getName().equals("java.lang.Integer")))
						executeSetMethod(o, setMethod, new Integer(rs
								.getInt(fieldName)));

					if (fieldType.getName().equals("java.lang.String"))
						executeSetMethod(o, setMethod, rs.getString(fieldName));

					if ((fieldType.getName().equals("java.lang.Long"))
							|| (fieldType.getName().equals("long")))
						executeSetMethod(o, setMethod, new Long(rs
								.getLong(fieldName)));
					if ((fieldType.getName().equals("float"))
							|| (fieldType.getName().equals("java.lang.Float")))
						executeSetMethod(o, setMethod, new Float(rs
								.getFloat(fieldName)));
					if ((fieldType.getName().equals("double"))
							|| (fieldType.getName().equals("java.lang.Double")))
						executeSetMethod(o, setMethod, new Double(rs
								.getDouble(fieldName)));
					if (fieldType.getName().equals("java.util.Date"))
						executeSetMethod(o, setMethod, rs.getDate(fieldName));
					if (fieldType.getName().equals("java.util.Calendar")) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(rs.getDate(fieldName));
						executeSetMethod(o, setMethod, cal);
					}
					//TODO：类别还不全，后期可能需要添加
				}
			}
			list.add(o);
		}
		return list;
	}

	/**
	 *
	 * 方法说明：检查对象数组中是否含有一个字符串
	 *
	 * @author Sunzhenying
	 * @param array
	 * @param value
	 * @return 返回一个boolean值
	 * @see #parseResultSet(ResultSet rs)
	 */
	private boolean contains(Object[] array, String value) {
		boolean isIncluded = false;
		if (array == null || value == null) {
			return false;
		}
		for (int i = 0; i < array.length; i++) {
			if (value.equalsIgnoreCase((String) array[i])) {
				isIncluded = true;
				break;
			}
		}
		return isIncluded;
	}

	/**
	 *
	 * 方法说明：根据ResultSet所查询列的名称
	 *
	 * @author Sunzhenying
	 * @param rs
	 * @return 返回列名称的数组
	 * @see #parseResultSet(ResultSet rs)
	 */
	private Object[] getColumns(ResultSet rs) {
		if (rs == null)
			return null;
		List<String> list = new ArrayList<String>();
		try {
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			int count = resultSetMetaData.getColumnCount();
			for (int i = 0; i < count; i++) {
				list.add(resultSetMetaData.getColumnName(i + 1));
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}
		return (Object[]) list.toArray();
	}

	/**
	 *
	 * 方法说明：得到插入表的insert语句
	 *
	 * @author Sunzhenying
	 * @return 返回insert语句
	 * @see #getUpdateSql()
	 */
	public String getInsertSql() {
		String sql = "insert into " + tableName + "(";

		for (int i = 0; i < tableFieldNames.length; i++) {
			sql = sql + tableFieldNames[i];
			if (i != tableFieldNames.length - 1)
				sql = sql + ",";
		}

		sql = sql + ")values(";

		for (int i = 0; i < tableFieldNames.length; i++) {
			sql = sql + "?";
			if (i != tableFieldNames.length - 1)
				sql = sql + ",";
		}
		sql = sql + ")";
		return sql;
	}

	/**
	 *
	 * 方法说明：按照主键更新表的update语句
	 *
	 * @author Sunzhenying
	 * @return 返回更新表的update语句
	 * @see #getInsertSql()
	 */
	public String getUpdateSql() {
		String updateSql = "update " + tableName + " set ";
		for (int i = 0; i < tableFieldNames.length; i++) {
			if (tableFieldNames[i].equalsIgnoreCase("id"))
				continue;
			updateSql = updateSql + tableFieldNames[i] + " = ?";
			if (i != tableFieldNames.length - 1)
				updateSql = updateSql + ",";
		}
		updateSql = updateSql + " where id = ?";
		return updateSql;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Class getClassType() {
		return classType;
	}

	public void setClassType(Class classType) {
		this.classType = classType;
	}

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field[] fields) {
		this.fields = fields;
	}

	public Method getGetIdMethod() {
		return getIdMethod;
	}

	public void setGetIdMethod(Method getIdMethod) {
		this.getIdMethod = getIdMethod;
	}

	public Method[] getGetMethods() {
		return getMethods;
	}

	public void setGetMethods(Method[] getMethods) {
		this.getMethods = getMethods;
	}

	public Serializable getId() {
		return id;
	}

	public void setId(Serializable id) {
		this.id = id;
	}

	public Method getSetIdMethod() {
		return setIdMethod;
	}

	public void setSetIdMethod(Method setIdMethod) {
		this.setIdMethod = setIdMethod;
	}

	public Method[] getSetMethods() {
		return setMethods;
	}

	public void setSetMethods(Method[] setMethods) {
		this.setMethods = setMethods;
	}

	public String[] getTableFieldNames() {
		return tableFieldNames;
	}

	public void setTableFieldNames(String[] tableFieldNames) {
		this.tableFieldNames = tableFieldNames;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
