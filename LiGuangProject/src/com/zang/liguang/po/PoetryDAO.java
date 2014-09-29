package com.zang.liguang.po;

import java.sql.Timestamp;
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
 * Poetry entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zang.liguang.po.Poetry
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class PoetryDAO {
	private static final Logger log = LoggerFactory.getLogger(PoetryDAO.class);
	// property constants
	public static final String REMARKS = "remarks";
	public static final String POETRY = "poetry";
	public static final String TITLE = "title";
	public static final String AUTHOR = "author";
	public static final String CLASSID = "classid";

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

	public void save(Poetry transientInstance) {
		log.debug("saving Poetry instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Poetry persistentInstance) {
		log.debug("deleting Poetry instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Poetry findById(java.lang.String id) {
		log.debug("getting Poetry instance with id: " + id);
		try {
			Poetry instance = (Poetry) getCurrentSession().get("com.zang.liguang.po.Poetry", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Poetry> findByExample(Poetry instance) {
		log.debug("finding Poetry instance by example");
		try {
			List<Poetry> results = (List<Poetry>) getCurrentSession().createCriteria("com.zang.liguang.po.Poetry").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Poetry instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Poetry as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Poetry> findByRemarks(Object remarks) {
		return findByProperty(REMARKS, remarks);
	}

	public List<Poetry> findByPoetry(Object poetry) {
		return findByProperty(POETRY, poetry);
	}

	public List<Poetry> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List<Poetry> findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List<Poetry> findByClassid(Object classid) {
		return findByProperty(CLASSID, classid);
	}

	public List findAll() {
		log.debug("finding all Poetry instances");
		try {
			String queryString = "from Poetry";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Poetry merge(Poetry detachedInstance) {
		log.debug("merging Poetry instance");
		try {
			Poetry result = (Poetry) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Poetry instance) {
		log.debug("attaching dirty Poetry instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Poetry instance) {
		log.debug("attaching clean Poetry instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PoetryDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PoetryDAO) ctx.getBean("PoetryDAO");
	}
}