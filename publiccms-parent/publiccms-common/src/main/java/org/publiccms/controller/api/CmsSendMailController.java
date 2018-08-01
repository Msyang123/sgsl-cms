package org.publiccms.controller.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.publiccms.common.base.AbstractController;
import org.publiccms.common.tools.SendmailUtil;
import org.publiccms.logic.component.template.TemplateComponent;
import org.publiccms.logic.service.cms.CmsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
 * CmsCommentController
 *
 */
@Controller
@RequestMapping("cmsMail")
public class CmsSendMailController extends AbstractController {
    @Autowired
    private CmsCommentService service;
   
    @Autowired
    private TemplateComponent templateComponent;


    private final ObjectMapper objectMapper = new ObjectMapper();
    
    private String[] ignoreProperties = new String[] { "siteId", "childIds", "tagTypeIds", "url", "disabled", "extendId",
            "contents", "typeId" };

  
    
    @RequestMapping("sendMail")
    public void sendMail(String pageId, HttpServletRequest request, @ModelAttribute("pojo") Pojo pojo, HttpServletResponse resp) throws IOException{
		SendmailUtil se = new SendmailUtil(request.getSession().getServletContext().getRealPath("/"));
		// receptAddress 可以是多人
		String[] receptAddress = { "343048470@qq.com" };
		
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
        /** 构建文件保存的目录* */
        String logoPathDir = "/data/publiccms/web/site_1/upload/jianli/"
                + dateformat.format(new Date());
        /** 得到文件保存目录的真实路径* */
        String logoRealPathDir = request.getSession().getServletContext()
                .getRealPath(logoPathDir);
        /** 根据真实路径创建目录* */
        File logoSaveFile = new File(logoRealPathDir);
        if (!logoSaveFile.exists())
            logoSaveFile.mkdirs();
        /** 页面控件的文件流* */
        MultipartFile multipartFile = pojo.getFile().get(0);
        /** 使用UUID生成文件名称* */
        String logImageName = multipartFile.getOriginalFilename();// 构建文件名称
        /** 拼成完整的文件保存路径加文件* */
        String fileName = logoRealPathDir + File.separator + logImageName;
        File file = new File(fileName);
        try {
            multipartFile.transferTo(file);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /** 打印出上传到服务器的文件的绝对路径* */
        System.out.println("****************"+fileName+"**************");

		se.doSendHtmlEmail("简历邮件", "收到一份从水果熟了官网发送过来的简历邮件", receptAddress,fileName);

    	resp.sendRedirect("/talentsDetails.html?id="+pageId+"&type=1");
    	
    	   
    }
    

}

class Pojo{
    private List<MultipartFile> file = new ArrayList<MultipartFile>();

	public List<MultipartFile> getFile() {
		return file;
	}

	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}

	

	
}  