package com.techstar.framework.ui.utils.tree;

import java.util.*;

public  class NodesListPool {

		private static Map pool = new HashMap();
		
		
		
		public static void setObject(Object key ,Object value){
			pool.put(key, value);
		}
		
		public static Object getObject(Object key ){
			return pool.get(key);
		}
		
		public static void initPool(int size){
			pool = new HashMap(size);
		}
		
		public static void removeObj(Object key){
			pool.remove(key);
		}
		
		public static void initPool(){
			pool = new HashMap();
		}
		
		public static Map getPool(){
			return pool;
		}
		
		public static void destoryPool(){
			pool =null;
		}
		
		public static boolean isObjectInPool(Object key){
			Object o = pool.get(key);
			if(o!=null){
				return true;
			}else{
				return false;
			}
			
		}
		
}
