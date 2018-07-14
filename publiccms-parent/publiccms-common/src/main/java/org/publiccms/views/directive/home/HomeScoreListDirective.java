package org.publiccms.views.directive.home;

// Generated 2016-11-19 9:58:46 by com.publiccms.common.source.SourceGenerator

import java.io.IOException;

import org.publiccms.common.base.AbstractTemplateDirective;
import org.publiccms.logic.service.home.HomeScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publiccms.common.handler.PageHandler;
import com.publiccms.common.handler.RenderHandler;

/**
 *
 * HomeScoreListDirective
 * 
 */
@Component
public class HomeScoreListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        PageHandler page = service.getPage(getSite(handler).getId(), handler.getLong("userId"), 
                handler.getString("itemType"), handler.getLong("itemId"), 
                handler.getInteger("pageIndex",1), handler.getInteger("count",30));
        handler.put("page", page).render();
    }

    @Autowired
    private HomeScoreService service;

}