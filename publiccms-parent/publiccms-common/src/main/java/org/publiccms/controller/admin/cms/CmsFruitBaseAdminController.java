package org.publiccms.controller.admin.cms;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.publiccms.common.base.AbstractController;
import org.publiccms.entities.cms.CmsFruitBase;
import org.publiccms.entities.cms.CmsMap;
import org.publiccms.logic.component.template.TemplateComponent;
import org.publiccms.logic.service.cms.CmsFruitBaseService;
import org.publiccms.logic.service.cms.CmsMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.publiccms.common.handler.PageHandler;

import static com.publiccms.common.tools.CommonUtils.notEmpty;


/**
 * 
 * CmsFruitBaseController
 *
 */
@Controller
@RequestMapping("cmsFruitBase")
public class CmsFruitBaseAdminController extends AbstractController {
    @Autowired
    private CmsFruitBaseService service;
   
    @Autowired
    private TemplateComponent templateComponent;


    private final ObjectMapper objectMapper = new ObjectMapper();
    
    private String[] ignoreProperties = new String[] { "siteId", "childIds", "tagTypeIds", "url", "disabled", "extendId",
            "contents", "typeId" };

    /**
     * @param entity
     * @param request
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("save")
    public String save(CmsFruitBase entity,HttpServletRequest request, HttpSession session, ModelMap model) {
        if(null!=entity.getId()){
            entity = service.update(entity.getId(), entity);
        }else{
            service.save(entity); 
        }
        return TEMPLATE_DONE;
    }
    
   /* @RequestMapping("query")
    @ResponseBody
    public List<CmsMap> query(CmsMap entity){
        PageHandler  pageHandler= (PageHandler ) service.getPage(1, 2);
        return (List<CmsMap>) pageHandler.getList();
    }  */
    
    
    @RequestMapping("delete")
    public String delete(Integer[] ids, HttpServletRequest request, HttpSession session){
    	if(notEmpty(ids)){
    		service.delete(ids);
    	}
    	return TEMPLATE_DONE;
    }

}