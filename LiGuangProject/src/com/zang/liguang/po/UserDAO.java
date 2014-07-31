package com.zang.liguang.po;

import java.util.Date;
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
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zang.liguang.po.User
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	// property constants
	public static final String LOGINNAME = "loginname";
	public static final String PWD = "pwd";
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String PHONENUM = "phonenum";
	public static final String EMAIL = "email";
	public static final String IDENTITY = "identity";

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

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.String id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getCurrentSession().get(
					"com.zang.liguang.po.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List<User> results = (List<User>) getCurrentSession()
					.createCriteria("com.zang.liguang.po.User")
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
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<User> findByLoginname(Object loginname) {
		return findByProperty(LOGINNAME, loginname);
	}

	public List<User> findByPwd(Object pwd) {
		return findByProperty(PWD, pwd);
	}

	public List<User> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<User> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<User> findByPhonenum(Object phonenum) {
		return findByProperty(PHONENUM, phonenum);
	}

	public List<User> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<User> findByIdentity(Object identity) {
		return findByProperty(IDENTITY, identity);
	}

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserDAO) ctx.getBean("UserDAO");
	}
}