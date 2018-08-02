package org.publiccms.logic.dao.cms;


import com.publiccms.common.base.BaseDao;
import com.publiccms.common.handler.PageHandler;
import com.publiccms.common.handler.QueryHandler;
import org.publiccms.entities.cms.CmsAttractInvestment;
import org.springframework.stereotype.Repository;

// Generated 2016-1-19 11:41:45 by com.publiccms.common.source.SourceGenerator

/**
 *
 * CmsAttractInvestmentDao
 * 
 */
@Repository
public class CmsAttractInvestmentDao extends BaseDao<CmsAttractInvestment> {

    public PageHandler getPage( String username,Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from CmsAttractInvestment bean");
        if(username !=null){
        	queryHandler.condition("bean.username like '%"+username+"%'");
        }
        queryHandler.order("bean.id asc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

	@Override
	protected CmsAttractInvestment init(CmsAttractInvestment entity) {
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