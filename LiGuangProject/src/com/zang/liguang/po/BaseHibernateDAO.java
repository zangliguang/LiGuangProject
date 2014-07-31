
package com.zang.liguang.po;   

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.web.context.WebApplicationContext;

/**
* DAO操作基类 本DAO层实现了通用的数据操作
*
* @param <T>
*             POJO实体对象
* @param <ID>
*             ID
*/  
public class BaseHibernateDAO<T, ID extends Serializable> extends HibernateDaoSupport {   

    private static final Logger logger = Logger.getLogger(BaseHibernateDAO.class);   

    /**
      * 保存指定实体类
      *
      * @param entityobj
      *             实体类
      */  
    public void save(T entity) {           
        try {   
             getHibernateTemplate().save(entity);   
         } catch (RuntimeException e) {   
             logger.error("保存实体异常", e);   
            throw e;   
         }   
     }   

    /**
      * 删除指定实体
      *
      * @param entityobj
      *             实体类
      */  
    public void delete(T entity) {   
        try {   
             getHibernateTemplate().delete(entity);   
         } catch (RuntimeException e) {   
             logger.error("删除实体异常", e);   
            throw e;   
         }   
     }   
       
    /**
      * 更新或保存指定实体
      *
      * @param entity 实体类
      */  
    public void saveOrUpdate(T entity) {   
        try {   
             getHibernateTemplate().saveOrUpdate(entity);   
         } catch (RuntimeException e) {   
             logger.error("更新或保存实体异常", e);   
            throw e;   
         }   
     }   

    /**
      * 查找指定ID实体类对象
      *
      * @param entityClass
      *             实体Class
      * @param id
      *             实体ID
      * @return 实体对象
      */  
    @SuppressWarnings("unchecked")   
    public T findById(Class<T> entityClass, ID id) {   
        try {   
            return (T) getHibernateTemplate().get(entityClass, id);   
         } catch (RuntimeException e) {   
             logger.error("查找指定ID实体异常，ID：" + id, e);   
            throw e;   
         }   
     }   

    /**
      * 查找指定属性的实体集合
      *
      * @param entityClass
      *             实体
      * @param propertyName
      *             属性名
      * @param value
      *             条件
      * @return 实体集合
      */  
    @SuppressWarnings("unchecked")   
    public List<T> findByProperty(Class<T> entityClass, String propertyName,   
             Object value) {   
        try {   
             String queryStr = "from " + entityClass.getName()   
                     + " as model where model." + propertyName + "=?";              
            return (List<T>) getHibernateTemplate().find(queryStr, value);   
         } catch (RuntimeException e) {   
             logger.error("查找指定条件实体集合异常，条件：" + propertyName, e);   
            throw e;   
         }   
     }   

    /**
      * 查询指定HQL语句的分页数据集合
      *
      * @param hsql
      *             HQL语句
      * @param firstRow
      *             开始记录号
      * @param maxRow
      *             最大记录号
      * @return 分页数据集合
      * @throws Exception
      *              抛出异常
      */  
    @SuppressWarnings("unchecked")   
    public List<T> findByPage(final String hsql, final int firstRow,   
            final int maxRow) {        
        try {   
            return getHibernateTemplate().execute(new HibernateCallback() {   
                public Object doInHibernate(Session s)   
                        throws HibernateException {   
                     Query query = s.createQuery(hsql);   
                     query.setFirstResult(firstRow);   
                     query.setMaxResults(maxRow);   
                     List list = query.list();   
                    return list;   
                 }   
             });   
         } catch (RuntimeException e) {   
             logger.error("分页查询异常，HQL：" + hsql, e);   
            throw e;   
         }   
     }      
       
    /**
     * 执行sql
     *
     * @param sql
     */  
    @SuppressWarnings("unchecked")   
    public List<T> executebysql(final String hsql) {        
    	try {   
    		return getHibernateTemplate().execute(new HibernateCallback() {   
    			public Object doInHibernate(Session s)   
    					throws HibernateException {   
    				Query query = s.createQuery(hsql);   
    				List list = query.list();   
    				return list;   
    			}   
    		});   
    	} catch (RuntimeException e) {   
    		logger.error("分页查询异常，HQL：" + hsql, e);   
    		throw e;   
    	}   
    }     
    /**
     * update 执行sql
     *
     * @param sql
     */  
    @SuppressWarnings("unchecked")   
    public void update(final String hsql,final HashMap<String, Object> params) {        
    		
    		  Query query = createQuery(hsql,params);  
    		  query.executeUpdate(); 
    }     
    
    
    
    
    public List createHQLQuery(final String hsql, final HashMap<String, Object> params){  
        Query q = createQuery(hsql,params);  
       // Query q = getSession().createSQLQuery(hsql).addEntity(ClassifyVO.class);  
        List l = q.list();  
       return l;  
   }  
    
    private Query createQuery(final String hsql, final HashMap<String, Object> params){  
   	 Query q = currentSession().createQuery(hsql);  
   	//Query q = getSession().createSQLQuery(hsql);  
   	String[] keys = q.getNamedParameters();  
   	if(null != keys && null != params){  
   		for(String key : keys){  
   			if(!params.containsKey(key)){  
   				throw new RuntimeException("没有设置query语句中参数"+key+"的值");  
   			}  
   			Object v = params.get(key);  
   			q.setParameter(key, v);  
   		}  
   	}  
   	return q;  
   }  
    
    
    /**
      * 从Spring上下文中获取本类对象
      * 此方法可能存在线程并发问题（待测）
      *
      * @param context Spring上下文
      * @return 本类对象
      */  
    @SuppressWarnings("unchecked")   
    public static BaseHibernateDAO getFromApplicationContext(WebApplicationContext context) {   
        return (BaseHibernateDAO)context.getBean("BaseHibernateDAO");   
     }

       
}  