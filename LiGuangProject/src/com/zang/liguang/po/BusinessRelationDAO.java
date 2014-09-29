package com.zang.liguang.po;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * BusinessRelation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.zang.liguang.po.BusinessRelation
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class BusinessRelationDAO {
	private static final Logger log = LoggerFactory.getLogger(BusinessRelationDAO.class);
	// property constants
	public static final String BUSINESSID = "businessid";
	public static final String BUSINESSCLASSID = "businessclassid";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(BusinessRelation transientInstance) {
		log.debug("saving BusinessRelation instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BusinessRelation persistentInstance) {
		log.debug("deleting BusinessRelation instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BusinessRelation findById(java.lang.String id) {
		log.debug("getting BusinessRelation instance with id: " + id);
		try {
			BusinessRelation instance = (BusinessRelation) getCurrentSession().get("com.zang.liguang.po.BusinessRelation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BusinessRelation> findByExample(BusinessRelation instance) {
		log.debug("finding BusinessRelation instance by example");
		try {
			List<BusinessRelation> results = (List<BusinessRelation>) getCurrentSession().createCriteria("com.zang.liguang.po.BusinessRelation")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BusinessRelation instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from BusinessRelation as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<BusinessRelation> findByBusinessid(Object businessid) {
		return findByProperty(BUSINESSID, businessid);
	}

	public List<BusinessRelation> findByBusinessclassid(Object businessclassid) {
		return findByProperty(BUSINESSCLASSID, businessclassid);
	}

	public List findAll() {
		log.debug("finding all BusinessRelation instances");
		try {
			String queryString = "from BusinessRelation";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BusinessRelation merge(BusinessRelation detachedInstance) {
		log.debug("merging BusinessRelation instance");
		try {
			BusinessRelation result = (BusinessRelation) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BusinessRelation instance) {
		log.debug("attaching dirty BusinessRelation instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BusinessRelation instance) {
		log.debug("attaching clean BusinessRelation instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BusinessRelationDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BusinessRelationDAO) ctx.getBean("BusinessRelationDAO");
	}
}