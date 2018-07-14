package org.publiccms.controller.admin.cms;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.publiccms.common.base.AbstractController;
import org.publiccms.entities.cms.CmsComment;
import org.publiccms.entities.cms.CmsMap;
import org.publiccms.logic.component.template.TemplateComponent;
import org.publiccms.logic.service.cms.CmsCommentService;
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
 * CmsCommentController
 *
 */
@Controller
@RequestMapping("cmsComment")
public class CmsCommentAdminController extends AbstractController {
    @Autowired
    private CmsCommentService service;
   
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
    @ResponseBody
    public String save(CmsComment entity,HttpServletRequest request, HttpSession session, ModelMap model) {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    	entity.setCreate_date(df.format(new Date()));
        if(null!=entity.getId()){
            entity = service.update(entity.getId(), entity);
        }else{
            service.save(entity);
        }
        return SUCCESS;
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