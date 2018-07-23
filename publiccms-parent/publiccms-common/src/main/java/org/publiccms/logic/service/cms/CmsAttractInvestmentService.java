package org.publiccms.logic.service.cms;

import com.publiccms.common.base.BaseService;
import com.publiccms.common.handler.PageHandler;
import org.publiccms.entities.cms.CmsAttractInvestment;
import org.publiccms.logic.dao.cms.CmsAttractInvestmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Generated 2015-5-8 16:50:23 by com.publiccms.common.source.SourceGenerator

/**
 *
 * CmsAttractInvestmentService
 * 
 */
@Service
@Transactional
public class CmsAttractInvestmentService extends BaseService<CmsAttractInvestment> {

    @Autowired
    private CmsAttractInvestmentDao dao;
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
    @Transactional(readOnly = true)
    public PageHandler getPage(String username,Integer pageIndex, Integer pageSize) {
        return dao.getPage(username,pageIndex, pageSize);
    }

 
    /*public List<CmsMap> query(CmsMap entity){
        return dao.query(entity);
    }*/
    
}