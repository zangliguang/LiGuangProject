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
 * Information entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.zang.liguang.po.Information
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class InformationDAO {
	private static final Logger log = LoggerFactory.getLogger(InformationDAO.class);
	// property constants
	public static final String OWNERID = "ownerid";
	public static final String BID = "bid";
	public static final String SUBJECT = "subject";
	public static final String CONTENT = "content";

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

	public void save(Information transientInstance) {
		log.debug("saving Information instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Information persistentInstance) {
		log.debug("deleting Information instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Information findById(java.lang.String id) {
		log.debug("getting Information instance with id: " + id);
		try {
			Information instance = (Information) getCurrentSession().get("com.zang.liguang.po.Information", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Information> findByExample(Information instance) {
		log.debug("finding Information instance by example");
		try {
			List<Information> results = (List<Information>) getCurrentSession().createCriteria("com.zang.liguang.po.Information").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Information instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Information as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Information> findByOwnerid(Object ownerid) {
		return findByProperty(OWNERID, ownerid);
	}

	public List<Information> findByBid(Object bid) {
		return findByProperty(BID, bid);
	}

	public List<Information> findBySubject(Object subject) {
		return findByProperty(SUBJECT, subject);
	}

	public List<Information> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all Information instances");
		try {
			String queryString = "from Information";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Information merge(Information detachedInstance) {
		log.debug("merging Information instance");
		try {
			Information result = (Information) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Information instance) {
		log.debug("attaching dirty Information instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Information instance) {
		log.debug("attaching clean Information instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InformationDAO getFromApplicationContext(ApplicationContext ctx) {
		return (InformationDAO) ctx.getBean("InformationDAO");
	}
}