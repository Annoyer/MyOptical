package daos;

import framework.dao.ExtHibernateDaoSupport;
import model.CommentEntity;
import model.FrameEntity;
import model.GlassesItemEntity;
import model.InCartEntity;
import org.hibernate.*;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.*;

/**
 * 数据库操作封装层，供service使用
 */
@SuppressWarnings("ALL")
@Repository("baseDAO")
@Transactional
public class BaseDAO extends ExtHibernateDaoSupport {
    private static final Logger log = LoggerFactory
            .getLogger(BaseDAO.class);

    @Autowired
    public void setMySessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void save(Object transientInstance) {
        log.debug("saving Object instance");
        try {
            getHibernateTemplate().save(transientInstance);
            //getSession().flush();//save直接flush
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Object persistentInstance) {
        log.debug("deleting Object instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public void update(Object persistentInstance) {
        try {
            getHibernateTemplate().update(persistentInstance);
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public <T> T findById(Object id, Class<T> cls) {
        String tableName = cls.getName();
        log.debug("getting " + tableName + " instance with id: " + id);
        try {
            T instance = (T) getHibernateTemplate().get(
                    tableName, (Serializable) id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    //cls
    public List findByExample(Object instance, Class cls) {
        String tableName = cls.getName();
        log.debug("finding " + tableName + " instance by example");
        try {
            List results = getSession()
                    .createCriteria(tableName)
                    .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: "
                    + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    //cls
    public List findByProperty(String propertyName, Object value, Class cls) {
        System.out.println("start findByProperty");
        String tableName = cls.getName();
        System.out.println("tableName: " + tableName + "   propertyName:" + propertyName + "value" + value.toString());
        log.debug("finding " + tableName + " instance with property: "
                + propertyName + ", value: " + value);
        try {
            String queryString = "from " + tableName + " as model where model."
                    + propertyName + "= ?";
            System.out.println(queryString);
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List find(String sql) {
        try {
            String queryString = sql;
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    //cls
    public List findAll(Class cls) {
        String tableName = cls.getName();
        log.debug("finding all " + tableName + " instances");
        try {
            String queryString = "from " + tableName;
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public <T> T merge(T detachedInstance) {
        log.debug("merging Object instance");
        try {
            T result = (T) getSession().merge(
                    detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void saveOrUpdate(Object instance) {
        log.debug("attaching dirty Object instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Object instance) {
        log.debug("attaching clean Object instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void saveAuto(final Object instance) {
        log.debug("saving instance");
        try {
            Session session = getSession();
            session.setFlushMode(FlushMode.AUTO);
            session.save(instance);
            session.flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public List<CommentEntity> getCommentsByPage(final Integer frameId, final int pageNumber, final int pageSize) {
        List<CommentEntity> result = (List<CommentEntity>) getHibernateTemplate().executeFind(new HibernateCallback<List<CommentEntity>>() {
            @Override
            public List<CommentEntity> doInHibernate(Session session) throws HibernateException, SQLException {
                SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM comment WHERE frame_id = ? ORDER BY comm_time DESC");
                sqlQuery.setParameter(0, frameId).setMaxResults(pageSize).setFirstResult(pageNumber * pageSize);
                List<CommentEntity> list = new ArrayList<CommentEntity>();
                list.addAll(sqlQuery.list());
                System.out.println("找到" + list.size() + "条关于" + frameId + "的评论");
                return list;
            }
        });
        return result;
    }

    public List<Integer> getCartItemByCustomerId(final String customerId) {
        List<Integer> list = (List<Integer>) getHibernateTemplate().executeFind(new HibernateCallback<List<Integer>>() {
            @Override
            public List<Integer> doInHibernate(Session session) {
                SQLQuery sqlQuery = session.createSQLQuery(("SELECT glasses_item_id FROM in_cart WHERE customer_id=?"));
                sqlQuery.setParameter(0, customerId);
                List<Integer> result = new ArrayList<Integer>();
                result.addAll(sqlQuery.list());
                return result;
            }
        });
        return list;
    }

    public List<Integer> getCollectionByCustomerId(final String customerId) {
        System.out.println("baseDAO");
        List<Integer> list = (List<Integer>) getHibernateTemplate().executeFind(new HibernateCallback<List<Integer>>() {
            @Override
            public List<Integer> doInHibernate(Session session) {
                System.out.println("List:  " + customerId);
                SQLQuery sqlQuery = session.createSQLQuery(("SELECT frame_id FROM collects WHERE customer_id=?"));
                System.out.println("sql~");
                sqlQuery.setParameter(0, customerId);
                List<Integer> result = new ArrayList<Integer>();
                result.addAll(sqlQuery.list());
                System.out.println("result~");
                return result;
            }
        });
        return list;
    }

    public List<FrameEntity> findFramesByAttr(final Map<String, String> attrMap) {
        System.out.println("baseDAO");
        List<FrameEntity> list = (List<FrameEntity>) getHibernateTemplate().executeFind(new HibernateCallback<List<FrameEntity>>() {
            @Override
            public List<FrameEntity> doInHibernate(Session session) {
                List result = new ArrayList();
                StringBuilder hql = new StringBuilder("from FrameEntity as f where ");
                boolean firstFlag = true;

                //构造查询语句，在这6个属性上建立非聚簇索引，一次查找以减少数据传输时间
                for (Map.Entry<String,String> entry : attrMap.entrySet()) {
                    Set<FrameEntity> singleResult = new HashSet<FrameEntity>();
                    String key = entry.getKey();//属性名
                    String value = entry.getValue();//属性值字符串
                    System.out.println("SearchService_getFramesByAttrs::key=" + key + "  value=" + value);

                    if (value != null && !value.isEmpty() && !value.contentEquals("") && !value.contentEquals(":")) {
                        value = value.replaceAll(":", "','").substring(2);
                        if (!firstFlag) {
                            hql.append(" and ");
                        }
                        hql.append("f.").append(key).append(" in (").append(value).append("')");

                        firstFlag = false;
                    }
                }

                System.out.println(hql.toString());
                Query query = session.createQuery(hql.toString());

                result.addAll(query.list());
                return result;
            }
        });
        return list;
    }

    public List<FrameEntity> findFramesByKeyword(final String keyword) {
        System.out.println("baseDAO");
        List<FrameEntity> list = (List<FrameEntity>) getHibernateTemplate().executeFind(new HibernateCallback<List<FrameEntity>>() {
            @Override
            public List<FrameEntity> doInHibernate(Session session) {
                List<FrameEntity> result = new ArrayList<FrameEntity>();
                SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM find_by_keyword2(?)").addEntity(FrameEntity.class);
                sqlQuery.setParameter(0,keyword);
                result.addAll(sqlQuery.list());
                return result;
            }
        });
        return list;
    }

}