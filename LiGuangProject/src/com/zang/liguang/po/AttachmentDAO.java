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
 * Attachment entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zang.liguang.po.Attachment
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class AttachmentDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AttachmentDAO.class);
	// property constants
	public static final String FILENAME = "filename";
	public static final String FILETYPE = "filetype";
	public static final String FILESIZE = "filesize";
	public static final String FILEURL = "fileurl";
	public static final String SMALLURL = "smallurl";
	public static final String UID = "uid";
	public static final String BELONGID = "belongid";
	public static final String IP = "ip";

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

	public void save(Attachment transientInstance) {
		log.debug("saving Attachment instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Attachment persistentInstance) {
		log.debug("deleting Attachment instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Attachment findById(java.lang.String id) {
		log.debug("getting Attachment instance with id: " + id);
		try {
			Attachment instance = (Attachment) getCurrentSession().get(
					"com.zang.liguang.po.Attachment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Attachment> findByExample(Attachment instance) {
		log.debug("finding Attachment instance by example");
		try {
			List<Attachment> results = (List<Attachment>) getCurrentSession()
					.createCriteria("com.zang.liguang.po.Attachment")
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
		log.debug("finding Attachment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Attachment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Attachment> findByFilename(Object filename) {
		return findByProperty(FILENAME, filename);
	}

	public List<Attachment> findByFiletype(Object filetype) {
		return findByProperty(FILETYPE, filetype);
	}

	public List<Attachment> findByFilesize(Object filesize) {
		return findByProperty(FILESIZE, filesize);
	}

	public List<Attachment> findByFileurl(Object fileurl) {
		return findByProperty(FILEURL, fileurl);
	}

	public List<Attachment> findBySmallurl(Object smallurl) {
		return findByProperty(SMALLURL, smallurl);
	}

	public List<Attachment> findByUid(Object uid) {
		return findByProperty(UID, uid);
	}

	public List<Attachment> findByBelongid(Object belongid) {
		return findByProperty(BELONGID, belongid);
	}

	public List<Attachment> findByIp(Object ip) {
		return findByProperty(IP, ip);
	}

	public List findAll() {
		log.debug("finding all Attachment instances");
		try {
			String queryString = "from Attachment";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Attachment merge(Attachment detachedInstance) {
		log.debug("merging Attachment instance");
		try {
			Attachment result = (Attachment) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Attachment instance) {
		log.debug("attaching dirty Attachment instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Attachment instance) {
		log.debug("attaching clean Attachment instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AttachmentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AttachmentDAO) ctx.getBean("AttachmentDAO");
	}
}