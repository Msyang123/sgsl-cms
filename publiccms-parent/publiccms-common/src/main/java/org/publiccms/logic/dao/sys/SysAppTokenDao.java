package org.publiccms.logic.dao.sys;

// Generated 2016-3-2 20:55:08 by com.publiccms.common.source.SourceGenerator
import static com.publiccms.common.tools.CommonUtils.empty;
import static com.publiccms.common.tools.CommonUtils.getDate;
import static com.publiccms.common.tools.CommonUtils.notEmpty;

import java.util.Date;

import org.publiccms.entities.sys.SysAppToken;
import org.springframework.stereotype.Repository;

import com.publiccms.common.base.BaseDao;
import com.publiccms.common.handler.PageHandler;
import com.publiccms.common.handler.QueryHandler;

/**
 *
 * SysAppTokenDao
 * 
 */
@Repository
public class SysAppTokenDao extends BaseDao<SysAppToken> {

    /**
     * @param appId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageHandler getPage(Integer appId, Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from SysAppToken bean");
        if (notEmpty(appId)) {
            queryHandler.condition("bean.appId = :appId").setParameter("appId", appId);
        }
        queryHandler.order("bean.id desc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

    /**
     * @param createDate
     * @return
     */
    public int delete(Date createDate) {
        if (notEmpty(createDate)) {
            QueryHandler queryHandler = getDeleteQueryHandler("from SysAppToken bean");
            queryHandler.condition("bean.createDate <= :createDate").setParameter("createDate", createDate);
            return delete(queryHandler);
        }
        return 0;
    }

    @Override
    protected SysAppToken init(SysAppToken entity) {
        if (empty(entity.getCreateDate())) {
            entity.setCreateDate(getDate());
        }
        return entity;
    }

}