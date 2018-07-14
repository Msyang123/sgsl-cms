package org.publiccms.logic.service.home;

import org.publiccms.entities.home.HomeGroupUser;
import org.publiccms.logic.dao.home.HomeGroupUserDao;

// Generated 2016-11-19 9:58:46 by com.publiccms.common.source.SourceGenerator

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.publiccms.common.base.BaseService;
import com.publiccms.common.handler.PageHandler;

/**
 *
 * HomeGroupUserService
 * 
 */
@Service
@Transactional
public class HomeGroupUserService extends BaseService<HomeGroupUser> {

    /**
     * @param disabled
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Transactional(readOnly = true)
    public PageHandler getPage(Boolean disabled, Integer pageIndex, Integer pageSize) {
        return dao.getPage(disabled, pageIndex, pageSize);
    }

    @Autowired
    private HomeGroupUserDao dao;
    
}