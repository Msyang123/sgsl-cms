package org.publiccms.views.directive.cms;

// Generated 2015-5-10 17:54:56 by com.publiccms.common.source.SourceGenerator

import com.publiccms.common.handler.RenderHandler;
import org.publiccms.common.base.AbstractTemplateDirective;
import org.publiccms.entities.cms.CmsAttractInvestment;
import org.publiccms.entities.sys.SysSite;
import org.publiccms.logic.service.cms.CmsAttractInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.publiccms.common.tools.CommonUtils.notEmpty;

/**
 *
 * CmsAttractInvestmentDirective
 * 
 */
@Component
public class CmsAttractInvestmentDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        SysSite site = getSite(handler);
        if (notEmpty(id)) {
        	CmsAttractInvestment entity = service.getEntity(id);
            if (null != entity ) {
                handler.put("object", entity).render();
            }
        } else {
            Integer[] ids = handler.getIntegerArray("ids");
            if (notEmpty(ids)) {
                List<CmsAttractInvestment> entityList = service.getEntitys(ids);
                Map<String, CmsAttractInvestment> map = new LinkedHashMap<String, CmsAttractInvestment>();
                for (CmsAttractInvestment entity : entityList) {
                        map.put(String.valueOf(entity.getId()), entity);
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private CmsAttractInvestmentService service;

}
