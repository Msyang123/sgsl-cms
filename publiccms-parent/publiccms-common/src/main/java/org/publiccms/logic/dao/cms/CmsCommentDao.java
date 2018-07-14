package org.publiccms.logic.dao.cms;


import org.publiccms.entities.cms.CmsComment;

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
public class CmsCommentDao extends BaseDao<CmsComment> {
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
    public PageHandler getPage( String email,Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from CmsComment bean");
        if(email !=null){
        	queryHandler.condition("bean.email like '%"+email+"%'");
        }
        queryHandler.order("bean.id asc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

	@Override
	protected CmsComment init(CmsComment entity) {
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