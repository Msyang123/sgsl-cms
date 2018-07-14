package org.publiccms.views.directive.cms;

// Generated 2015-5-10 17:54:56 by com.publiccms.common.source.SourceGenerator

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.publiccms.common.base.AbstractTemplateDirective;
import org.publiccms.entities.cms.CmsCategory;
import org.publiccms.entities.cms.CmsComment;
import org.publiccms.entities.cms.CmsMap;
import org.publiccms.entities.sys.SysSite;
import org.publiccms.logic.service.cms.CmsCategoryService;
import org.publiccms.logic.service.cms.CmsCommentService;
import org.publiccms.logic.service.cms.CmsMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publiccms.common.handler.RenderHandler;

import static com.publiccms.common.tools.CommonUtils.notEmpty;

/**
 *
 * CmsCommentDirective
 * 
 */
@Component
public class CmsCommentDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        SysSite site = getSite(handler);
        if (notEmpty(id)) {
        	CmsComment entity = service.getEntity(id);
            if (null != entity ) {
                handler.put("object", entity).render();
            }
        } else {
            Integer[] ids = handler.getIntegerArray("ids");
            if (notEmpty(ids)) {
                List<CmsComment> entityList = service.getEntitys(ids);
                Map<String, CmsComment> map = new LinkedHashMap<String, CmsComment>();
                for (CmsComment entity : entityList) {
                        map.put(String.valueOf(entity.getId()), entity);
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private CmsCommentService service;

}
