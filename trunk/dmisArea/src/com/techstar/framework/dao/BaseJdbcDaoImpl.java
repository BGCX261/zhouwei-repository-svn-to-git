package com.techstar.framework.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.techstar.framework.utils.ConfigurationHelper;

//by yangjianbao

public class BaseJdbcDaoImpl extends JdbcDaoSupport implements IBaseJdbcDao {

	public int[] batchUpdate(String[] queryNames) throws DataAccessException {
		// TODO Auto-generated method stub
		String[] strQuery = new String[queryNames.length];
 		for(int i=0;i<queryNames.length;i++){
 			strQuery[i] = ConfigurationHelper.getNamedSqlQuery(queryNames[i]);
		}
		return this.getJdbcTemplate().batchUpdate(strQuery);
	}

	public int[] batchUpdate(String queryName, BatchPreparedStatementSetter pss)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().batchUpdate(ConfigurationHelper.getNamedSqlQuery(queryName),pss);
	}

	public void execute(String queryName) throws DataAccessException {
		// TODO Auto-generated method stub
		this.getJdbcTemplate().execute(ConfigurationHelper.getNamedSqlQuery(queryName));
	}

	public Object execute(String queryName, PreparedStatementCallback action)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().execute(ConfigurationHelper.getNamedSqlQuery(queryName),action);
	}

	public Object execute(String callString, CallableStatementCallback action)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().execute(ConfigurationHelper.getNamedSqlQuery(callString), action);
	}

	public List queryForList(String queryName) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().queryForList(ConfigurationHelper.getNamedSqlQuery(queryName));
	}

	public List queryForList(String queryName, Object[] args)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
		return this.getJdbcTemplate().queryForList(ConfigurationHelper.getNamedSqlQuery(queryName),args);
	}

	public Map queryForMap(String queryName) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().queryForMap(ConfigurationHelper.getNamedSqlQuery(queryName));
	}

	public Map queryForMap(String queryName, Object[] args)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().queryForMap(ConfigurationHelper.getNamedSqlQuery(queryName),args);
	}

	public Object queryForObject(String queryName, Object[] args,
			int[] argsTypes, RowMapper rowMapper) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().queryForObject(ConfigurationHelper.getNamedSqlQuery(queryName), args, argsTypes, rowMapper);
	}

	public List queryForListBySql(String sql) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.getJdbcTemplate().queryForList(sql);
	}

	/* (non-Javadoc)
	 * @see com.techstar.framework.dao.IBaseJdbcDao#executeSql(java.lang.String)
	 */
	public void executeSql(String sql) throws DataAccessException {
		// TODO Auto-generated method stub
		 this.getJdbcTemplate().execute(sql);
	}

}
