package org.publiccms.logic.service.cms;

import java.util.List;

import org.publiccms.entities.cms.CmsFruitBase;

// Generated 2015-5-8 16:50:23 by com.publiccms.common.source.SourceGenerator

import org.publiccms.entities.cms.CmsMap;
import org.publiccms.logic.dao.cms.CmsFruitBaseDao;
import org.publiccms.logic.dao.cms.CmsMapDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.publiccms.common.base.BaseService;
import com.publiccms.common.handler.PageHandler;

/**
 *
 * CmsMapService
 * 
 */
@Service
@Transactional
public class CmsFruitBaseService extends BaseService<CmsFruitBase> {

    @Autowired
    private CmsFruitBaseDao dao;
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
    public PageHandler getPage(String title,Integer pageIndex, Integer pageSize) {
        return dao.getPage(title,pageIndex, pageSize);
    }

 
    /*public List<CmsMap> query(CmsMap entity){
        return dao.query(entity);
    }*/
    
}