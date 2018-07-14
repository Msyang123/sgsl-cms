package org.publiccms.logic.service.home;

import org.publiccms.entities.home.HomeDialog;
import org.publiccms.logic.dao.home.HomeDialogDao;

// Generated 2016-11-19 9:58:46 by com.publiccms.common.source.SourceGenerator

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.publiccms.common.base.BaseService;
import com.publiccms.common.handler.PageHandler;

/**
 *
 * HomeDialogService
 * 
 */
@Service
@Transactional
public class HomeDialogService extends BaseService<HomeDialog> {

    /**
     * @param disabled
     * @param orderType
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Transactional(readOnly = true)
    public PageHandler getPage(Boolean disabled, String orderType, Integer pageIndex, Integer pageSize) {
        return dao.getPage(disabled, orderType, pageIndex, pageSize);
    }

    @Autowired
    private HomeDialogDao dao;

}