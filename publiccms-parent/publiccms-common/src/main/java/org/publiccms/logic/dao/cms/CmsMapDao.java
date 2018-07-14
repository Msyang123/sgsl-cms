package org.publiccms.logic.dao.cms;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.publiccms.entities.cms.CmsCategory;
import org.publiccms.entities.cms.CmsMap;

// Generated 2016-1-19 11:41:45 by com.publiccms.common.source.SourceGenerator

import org.springframework.stereotype.Repository;

import com.publiccms.common.base.BaseDao;
import com.publiccms.common.handler.PageHandler;
import com.publiccms.common.handler.QueryHandler;  

/**
 *
 * CmsDao
 * 
 */
@Repository
public class CmsMapDao extends BaseDao<CmsMap> {
    /**
     * @param siteId
     * @param parentId
     * @param queryAll
     * @param typeId
     * @param allowContribute
     * @param hidden
     * @param disabled
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageHandler getPage( String store_name,Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from CmsMap bean");
        if(store_name !=null){
        	queryHandler.condition("bean.store_name like '%"+store_name+"%'");
        }
        queryHandler.order("bean.id asc");
        return getPage(queryHandler, pageIndex, pageSize);
    }
 
    @Override
    protected CmsMap init(CmsMap entity) {
        // TODO Auto-generated method stub
        return entity;
    }

   /* public List<CmsMap> query(CmsMap entity){
        SessionFactory sf =
                new Configuration().configure().buildSessionFactory();
                Session session = sf.getCurrentSession();
        session.beginTransaction();  
        String hql="select * from CmsMap";
        Query query1 = session.createQuery(hql);
        List<CmsMap> list = query1.list();
        return list;
        
    }*/


}