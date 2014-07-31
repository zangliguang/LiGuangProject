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
 * A data access object (DAO) providing persistence and search support for City
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zang.liguang.po.City
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CityDAO {
	private static final Logger log = LoggerFactory.getLogger(CityDAO.class);
	// property constants
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String PROVINCECODE = "provincecode";

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

	public void save(City transientInstance) {
		log.debug("saving City instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(City persistentInstance) {
		log.debug("deleting City instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public City findById(java.lang.Integer id) {
		log.debug("getting City instance with id: " + id);
		try {
			City instance = (City) getCurrentSession().get(
					"com.zang.liguang.po.City", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<City> findByExample(City instance) {
		log.debug("finding City instance by example");
		try {
			List<City> results = (List<City>) getCurrentSession()
					.createCriteria("com.zang.liguang.po.City")
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
		log.debug("finding City instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from City as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<City> findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List<City> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<City> findByProvincecode(Object provincecode) {
		return findByProperty(PROVINCECODE, provincecode);
	}

	public List findAll() {
		log.debug("finding all City instances");
		try {
			String queryString = "from City";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public City merge(City detachedInstance) {
		log.debug("merging City instance");
		try {
			City result = (City) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(City instance) {
		log.debug("attaching dirty City instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(City instance) {
		log.debug("attaching clean City instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CityDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CityDAO) ctx.getBean("CityDAO");
	}
}