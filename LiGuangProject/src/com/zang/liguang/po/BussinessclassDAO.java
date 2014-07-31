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
 * Bussinessclass entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.zang.liguang.po.Bussinessclass
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class BussinessclassDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BussinessclassDAO.class);
	// property constants
	public static final String BCLASSNAME = "bclassname";
	public static final String ORDERNUM = "ordernum";

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

	public void save(Bussinessclass transientInstance) {
		log.debug("saving Bussinessclass instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bussinessclass persistentInstance) {
		log.debug("deleting Bussinessclass instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bussinessclass findById(java.lang.String id) {
		log.debug("getting Bussinessclass instance with id: " + id);
		try {
			Bussinessclass instance = (Bussinessclass) getCurrentSession().get(
					"com.zang.liguang.po.Bussinessclass", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Bussinessclass> findByExample(Bussinessclass instance) {
		log.debug("finding Bussinessclass instance by example");
		try {
			List<Bussinessclass> results = (List<Bussinessclass>) getCurrentSession()
					.createCriteria("com.zang.liguang.po.Bussinessclass")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Bussinessclass instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Bussinessclass as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Bussinessclass> findByBclassname(Object bclassname) {
		return findByProperty(BCLASSNAME, bclassname);
	}

	public List<Bussinessclass> findByOrdernum(Object ordernum) {
		return findByProperty(ORDERNUM, ordernum);
	}

	public List findAll() {
		log.debug("finding all Bussinessclass instances");
		try {
			String queryString = "from Bussinessclass";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bussinessclass merge(Bussinessclass detachedInstance) {
		log.debug("merging Bussinessclass instance");
		try {
			Bussinessclass result = (Bussinessclass) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bussinessclass instance) {
		log.debug("attaching dirty Bussinessclass instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bussinessclass instance) {
		log.debug("attaching clean Bussinessclass instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BussinessclassDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (BussinessclassDAO) ctx.getBean("BussinessclassDAO");
	}
}