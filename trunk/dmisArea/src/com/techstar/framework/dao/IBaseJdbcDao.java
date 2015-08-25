//Source file: C:\\test\\com\\techstar\\framework\\dao\\IBaseJdbcDao.java

package com.techstar.framework.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;


public interface IBaseJdbcDao 
{
   
   /**
    * @param queryNames
    * @return int[]
    * @throws DataAccessException
    * @roseuid 44E56A4C0021
    */
   public int[] batchUpdate(String[] queryNames) throws DataAccessException;
   
   /**
    * @param queryName
    * @param pss
    * @return int[]
    * @throws DataAccessException
    * @roseuid 44E56A4C0023
    */
   public int[] batchUpdate(String queryName, BatchPreparedStatementSetter pss) throws DataAccessException;
   
   /**
    * @param queryName
    * @throws DataAccessException
    * @roseuid 44E56A4C0026
    */
   public void execute(String queryName) throws DataAccessException;
   
   /**
    * @param queryName
    * @param action
    * @return Object
    * @throws DataAccessException
    * @roseuid 44E56A4C0028
    */
   public Object execute(String queryName, PreparedStatementCallback action) throws DataAccessException;
   
   /**
    * @param callString
    * @param action
    * @return Object
    * @throws DataAccessException
    * @roseuid 44E56A4C002B
    */
   public Object execute(String callString, CallableStatementCallback action) throws DataAccessException;
   
   /**
    * @param queryName
    * @return List
    * @throws DataAccessException
    * @roseuid 44E56A4C002E
    */
   public List queryForList(String queryName) throws DataAccessException;
   
   /**
    * @param sql
    * @return List
    * @throws DataAccessException
    * @roseuid 44E56A4C002E
    */
   public List queryForListBySql(String sql) throws DataAccessException;
   
   /**
    * @param queryName
    * @param args
    * @return List
    * @throws DataAccessException
    * @roseuid 44E56A4C0030
    */
   public List queryForList(String queryName, Object[] args) throws DataAccessException;
   
   /**
    * @param queryName
    * @return Map
    * @throws DataAccessException
    * @roseuid 44E56A4C0033
    */
   public Map queryForMap(String queryName) throws DataAccessException;
   
   /**
    * @param queryName
    * @param args
    * @return Map
    * @throws DataAccessException
    * @roseuid 44E56A4C0035
    */
   public Map queryForMap(String queryName, Object[] args) throws DataAccessException;
   
   /**
    * @param queryName
    * @param args
    * @param argsTypes
    * @param rowMapper
    * @return Object
    * @throws DataAccessException
    * @roseuid 44E56A4C0038
    */
   public Object queryForObject(String queryName, Object[] args, int[] argsTypes, RowMapper rowMapper) throws DataAccessException;
   
   public void executeSql(String sql) throws DataAccessException;
}
