package org.publiccms.views.directive.cms;

// Generated 2015-5-10 17:54:56 by com.publiccms.common.source.SourceGenerator

import com.publiccms.common.handler.PageHandler;
import com.publiccms.common.handler.RenderHandler;
import org.publiccms.common.base.AbstractTemplateDirective;
import org.publiccms.logic.service.cms.CmsAttractInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 *
 * CmsAttractInvestmentListDirective
 * 
 */
@Component
public class CmsAttractInvestmentListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Boolean disabled = false;
        Boolean hidden = false;
        Boolean queryAll = handler.getBoolean("queryAll");
        if (handler.getBoolean("advanced", false)) {
            disabled = handler.getBoolean("disabled", false);
            hidden = handler.getBoolean("hidden");
        }
        PageHandler page = service.getPage(handler.getString("username"),handler.getInteger("pageIndex", 1), handler.getInteger("count", 30));
        handler.put("page", page).render();
    }

    @Autowired
    private CmsAttractInvestmentService service;

}