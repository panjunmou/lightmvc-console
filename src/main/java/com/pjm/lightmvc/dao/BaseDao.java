package com.pjm.lightmvc.dao;

import com.pjm.lightmvc.model.base.IdEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by PanJM on 2016/3/16.
 */
public class BaseDao {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * 保存实体对象
     *
     * @param t
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T extends IdEntity> T save(T t) throws Exception {
        t.setCreateDate(new Date());
        t.setUpdateDate(new Date());
        entityManager.persist(t);
        return t;
    }

    /**
     * 获取单个对象
     * @param query
     * @param parameters
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T extends IdEntity> T getSingleObject(Query query, Map<String, Object> parameters) throws Exception {
        for (String name : parameters.keySet()) {
            query.setParameter(name, parameters.get(name));
        }
        List resultList = query.getResultList();
        if (resultList.size() == 0) {
            return null;
        } else {
            return (T) resultList.get(0);
        }
    }
}
