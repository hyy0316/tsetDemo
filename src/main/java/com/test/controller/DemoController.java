package com.test.controller;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.zhuozhengsoft.pageoffice.*;

/**
 * @author Administrator
 *
 */
@RestController
public class DemoController {

	@Value("${server.port}")
	String port;
	@Value("${posyspath}") 
	private String poSysPath;
	
	@Value("${popassword}") 
	private String poPassWord;

	@RequestMapping("/hello")
	public String test() throws IOException {
		System.out.println("hello run");


		try {
			String filePath = "E:\\Temp\\file\\newConstructionLabel.docx";
			File file = new File(filePath);

			XWPFDocument document= new XWPFDocument();

//Write the Document in file system


//添加标题
//			XWPFParagraph titleParagraph = document.createParagraph();


			if(file.exists()) {
				//已存在文件，对其文件名进行"加1"方式重命名
				File children[]=file.getParentFile().listFiles();
				int nextSeq=1;
				int max=-1;
				for(File child:children) {
					if(child.getName().contains("_")) {
						String cName=child.getName();
						String numStr=cName.substring(cName.lastIndexOf("_")+1,cName.lastIndexOf(".")).trim();
						try {
							Integer n=Integer.valueOf(numStr);
							if(n>max) {
								max=n;
							}
						}catch(Exception e) {
							System.out.println("导出文件名错误，解析数据异常:"+filePath+ e.getMessage());
						}
					}
				}
				if(max!=-1) {
					nextSeq=max+1;
				}
				int end=filePath.lastIndexOf(".");

				file =new File(filePath.substring(0,end)+"_"+nextSeq+".docx");

			}
			System.out.println(file.getName());
			file.createNewFile(); // 创建新文件
			FileOutputStream out = new FileOutputStream(file);
			out.flush();
			out.close();
			document.createTOC();

			document.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Hello";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView showIndex(){
		ModelAndView mv = new ModelAndView("Index");
		return mv;
	}


	@RequestMapping(value="/word2", method=RequestMethod.GET)
	public ModelAndView showWord(HttpServletRequest request, Map<String,Object> map){

		ModelAndView mv = new ModelAndView("Word1");
		return mv;
	}


	@RequestMapping(value="/word", method=RequestMethod.GET)
	public ModelAndView showWord(HttpServletRequest request, Map<String,Object> map,@RequestParam(value = "fileId") String fileId)throws Exception{
		PageOfficeCtrl poCtrl=new PageOfficeCtrl(request);
		poCtrl.setServerPage("/poserver.zz");//设置服务页面
		poCtrl.addCustomToolButton("保存","Save",1);//添加自定义保存按钮
		poCtrl.addCustomToolButton("预览", "preview", 2);
		poCtrl.setSaveFilePage("/save");//设置处理文件保存的请求方法
		poCtrl.setJsFunction_BeforeDocumentSaved("/BeforeDocumentSaved");//设置处理文件保存的请求方法
		WordDocument woDoc = new WordDocument();
		woDoc.openDataTag("【※承租人_1_抵押物】").setValue("【※示例承租人-地址-上海陆嘴】");
		woDoc.openDataTag("【※承租人_1_承租人住所】").setValue("【※示例承租人-地址-上海陆嘴】");
		poCtrl.setWriter(woDoc);
		if("null".equals(fileId)){
			System.out.println("id为空");
				poCtrl.webCreateNew("张三", DocumentVersion.Word2007);
		}
		//打开word
		poCtrl.webOpen("e:\\file\\templet\\generateReplace.docx",OpenModeType.docAdmin,"张三");

		map.put("banner", "管理报告在线编辑");
		map.put("ctxPath",request.getContextPath());
		map.put("pageOfficeHtml", poCtrl.getHtmlCode("PageOfficeCtrl"));
		map.put("requestPath","http://"+request.getRemoteAddr().concat(":"+port).concat(request.getContextPath()));
		List<Map<String,Object>> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			for (int i1 = 1; i1 < 5; i1++) {
				Map<String, Object> map1 = new HashMap<>();
				if(i == 0){
					String name = String.join("","父节点", Integer.toString(i1));
					if(i1==1){
						map1.put("open",true);
					}
					map1.put("click",false);
					map1.put("pId",i);
					map1.put("t","id="+i1);
					map1.put("name",name);
					map1.put("id",i1);
				}else{
					String id = String.join("", Integer.toString(i), Integer.toString(i1));
					String name = String.join("","叶子节点", id);
					map1.put("pId",i);
					map1.put("id",id);
					map1.put("name",name);
					map1.put("t","id="+id);
				}
				list.add(map1);
			}
		}

		JSONObject json = new JSONObject();
		json.accumulate("listNew", list);
		map.put("upstream",json);
		map.put("default",json);
		map.put("formula",json);
		map.put("construction",json);
		map.put("pageoffice",poCtrl.getHtmlCode("PageOfficeCtrl1"));
		map.put("title", "文档编辑");
		ModelAndView mv = new ModelAndView("Word");
		return mv;
	}

	@RequestMapping(value="/word3", method=RequestMethod.GET)
	public ModelAndView showWord3(HttpServletRequest request, Map<String,Object> map){

		PageOfficeCtrl poCtrl=new PageOfficeCtrl(request);
		poCtrl.setServerPage("/poserver.zz");//设置服务页面
		poCtrl.addCustomToolButton("保存","Save",1);//添加自定义保存按钮
		poCtrl.addCustomToolButton("盖章","AddSeal",2);//添加自定义盖章按钮
		poCtrl.setSaveFilePage("/save");//设置处理文件保存的请求方法
		map.put("requestPath","http://"+request.getRemoteAddr().concat(":"+port).concat(request.getContextPath()));

		//打开word
		poCtrl.webOpen("e:\\file\\templet\\generateReplace.docx",OpenModeType.docAdmin,"张三");
		map.put("pageoffice",poCtrl.getHtmlCode("PageOfficeCtrl1"));

		ModelAndView mv = new ModelAndView("Word3");
		return mv;
	}
@RequestMapping(value="/word4", method=RequestMethod.GET)
	public ModelAndView showWord4(HttpServletRequest request, Map<String,Object> map){

		PageOfficeCtrl poCtrl=new PageOfficeCtrl(request);
		poCtrl.setServerPage("/poserver.zz");//设置服务页面
		poCtrl.addCustomToolButton("保存","Save",1);//添加自定义保存按钮
		poCtrl.addCustomToolButton("盖章","AddSeal",2);//添加自定义盖章按钮
		poCtrl.setSaveFilePage("/save");//设置处理文件保存的请求方法
		map.put("requestPath","http://"+request.getRemoteAddr().concat(":"+port).concat(request.getContextPath()));

		//打开word
		poCtrl.webOpen("e:\\file\\templet\\generateReplace.docx",OpenModeType.docAdmin,"张三");
		map.put("pageoffice",poCtrl.getHtmlCode("PageOfficeCtrl1"));

		ModelAndView mv = new ModelAndView("Word4");
		return mv;
	}


//	@RequestMapping(value="/word2", method=RequestMethod.GET)
//	public ModelAndView showWord2(HttpServletRequest request, Map<String,Object> map) throws IOException, TemplateException {
//		PageOfficeCtrl poCtrl=new PageOfficeCtrl(request);
//		poCtrl.setServerPage("/poserver.zz");//设置服务页面
//		poCtrl.addCustomToolButton("保存","Save",1);//添加自定义保存按钮
//		poCtrl.addCustomToolButton("盖章","AddSeal",2);//添加自定义盖章按钮
//		poCtrl.setSaveFilePage("/save");//设置处理文件保存的请求方法
//		poCtrl.setJsFunction_BeforeDocumentSaved("/BeforeDocumentSaved");//设置处理文件保存的请求方法
//		WordDocument woDoc = new WordDocument();
//		woDoc.openDataTag("【※承租人_1_抵押物】").setValue("【※示例承租人-地址-上海陆嘴】");
//		woDoc.openDataTag("【※承租人_1_承租人住所】").setValue("【※示例承租人-地址-上海陆嘴】");
//		poCtrl.setWriter(woDoc);
//		//打开word
//		poCtrl.webOpen("e:\\file\\templet\\generateReplace.docx",OpenModeType.docAdmin,"张三");
//
//		map.put("banner", "管理报告在线编辑");
//		map.put("ctxPath",request.getContextPath());
//		map.put("pageOfficeHtml", poCtrl.getHtmlCode("PageOfficeCtrl"));
//		map.put("requestPath","http://"+request.getRemoteAddr().concat(request.getContextPath()));
//		List<Map<String,Object>> list = new ArrayList<>();
//		for (int i = 0; i < 3; i++) {
//			for (int i1 = 1; i1 < 5; i1++) {
//				Map<String, Object> map1 = new HashMap<>();
//				if(i == 0){
//					String name = String.join("","父节点", Integer.toString(i1));
//					if(i1==1){
//						map1.put("open",true);
//					}
//					map1.put("click",false);
//					map1.put("pId",i);
//					map1.put("t","id="+i1);
//					map1.put("name",name);
//					map1.put("id",i1);
//				}else{
//					String id = String.join("", Integer.toString(i), Integer.toString(i1));
//					String name = String.join("","叶子节点", id);
//					map1.put("pId",i);
//					map1.put("id",id);
//					map1.put("name",name);
//					map1.put("t","id="+id);
//				}
//				list.add(map1);
//			}
//		}
//
//		JSONObject json = new JSONObject();
//		json.accumulate("listNew", list);
//		map.put("upstream",json);
//		map.put("default",json);
//		map.put("formula",json);
//		map.put("construction",json);
//		map.put("pageoffice",poCtrl.getHtmlCode("PageOfficeCtrl1"));
//		map.put("title", "文档编辑");
//
//
//		ModelAndView mv = new ModelAndView("Office2");
//		return mv;
//	}
//
//	@RequestMapping("/save")
//	public void saveFile(HttpServletRequest request, HttpServletResponse response){
//		FileSaver fs = new FileSaver(request, response);
//		fs.saveToFile("e:\\file\\templet-value\\" + fs.getFileName());
//
//		PageOfficeCtrl poCtrl=new PageOfficeCtrl(request);
//		WordDocument woDoc = new WordDocument();
//		woDoc.openDataTag("【※示例承租人-地址-上海陆嘴】").setValue("【※承租人_1_抵押物】");
//
//		poCtrl.setWriter(woDoc);
////		poCtrl.webOpen("e:\\file\\templet-value\\" + fs.getFileName(),OpenModeType.docAdmin,"张三");
//		fs.close();
//	}
//
//	//预览
//	@GetMapping("/show")
//    public ModelAndView showFile(HttpServletRequest request, Map<String,Object> map,@RequestParam(value = "fileId") String fileId)throws Exception{
//			PageOfficeCtrl poCtrl=new PageOfficeCtrl(request);
//			poCtrl.setServerPage("/poserver.zz");//设置服务页面
//			poCtrl.addCustomToolButton("保存","Save",1);//添加自定义保存按钮
//			poCtrl.addCustomToolButton("预览", "preview", 2);
//			poCtrl.setSaveFilePage("/save");//设置处理文件保存的请求方法
//			poCtrl.setJsFunction_BeforeDocumentSaved("/BeforeDocumentSaved");//设置处理文件保存的请求方法
//			WordDocument woDoc = new WordDocument();
//			woDoc.openDataTag("【※承租人_1_抵押物】").setValue("【※示例承租人-地址-上海陆嘴】");
//			woDoc.openDataTag("【※承租人_1_承租人住所】").setValue("【※示例承租人-地址-上海陆嘴】");
//			poCtrl.setWriter(woDoc);
//			if("null".equals(fileId)){
//				System.out.println("id为空");
//				poCtrl.webCreateNew("张三", DocumentVersion.Word2007);
//			}
//			//打开word
//			poCtrl.webOpen("e:\\file\\templet\\generateReplace.docx",OpenModeType.docAdmin,"张三");
//
//			map.put("banner", "管理报告在线编辑");
//			map.put("ctxPath",request.getContextPath());
//			map.put("pageOfficeHtml", poCtrl.getHtmlCode("PageOfficeCtrl"));
//			map.put("requestPath","http://"+request.getRemoteAddr().concat(request.getContextPath()));
//			List<Map<String,Object>> list = new ArrayList<>();
//			for (int i = 0; i < 3; i++) {
//				for (int i1 = 1; i1 < 5; i1++) {
//					Map<String, Object> map1 = new HashMap<>();
//					if(i == 0){
//						String name = String.join("","父节点", Integer.toString(i1));
//						if(i1==1){
//							map1.put("open",true);
//						}
//						map1.put("click",false);
//						map1.put("pId",i);
//						map1.put("t","id="+i1);
//						map1.put("name",name);
//						map1.put("id",i1);
//					}else{
//						String id = String.join("", Integer.toString(i), Integer.toString(i1));
//						String name = String.join("","叶子节点", id);
//						map1.put("pId",i);
//						map1.put("id",id);
//						map1.put("name",name);
//						map1.put("t","id="+id);
//					}
//					list.add(map1);
//				}
//			}
//
//			JSONObject json = new JSONObject();
//			json.accumulate("listNew", list);
//			map.put("upstream",json);
//			map.put("default",json);
//			map.put("formula",json);
//			map.put("construction",json);
//			map.put("pageoffice",poCtrl.getHtmlCode("PageOfficeCtrl1"));
//			map.put("title", "文档编辑");
//			ModelAndView mv = new ModelAndView("Office2");
//			return mv;
//    }
//
	/**
	 * 添加PageOffice的服务器端授权程序Servlet（必须）
	 * @return
	 */
	@Bean
    public ServletRegistrationBean servletRegistrationBean() {
		com.zhuozhengsoft.pageoffice.poserver.Server poserver = new com.zhuozhengsoft.pageoffice.poserver.Server();
		poserver.setSysPath(poSysPath);//设置PageOffice注册成功后,license.lic文件存放的目录
		ServletRegistrationBean srb = new ServletRegistrationBean(poserver);
		srb.addUrlMappings("/poserver.zz");
		srb.addUrlMappings("/posetup.exe");
		srb.addUrlMappings("/pageoffice.js");
		srb.addUrlMappings("/jquery.min.js");
		srb.addUrlMappings("/pobstyle.css");
		srb.addUrlMappings("/sealsetup.exe");
        return srb;// 
    }
	
	/**
	 * 添加印章管理程序Servlet（可选）
	 * @return
	 */
	@Bean
    public ServletRegistrationBean servletRegistrationBean2() {
		com.zhuozhengsoft.pageoffice.poserver.AdminSeal adminSeal = new com.zhuozhengsoft.pageoffice.poserver.AdminSeal();
		adminSeal.setAdminPassword(poPassWord);//设置印章管理员admin的登录密码
		adminSeal.setSysPath(poSysPath);//设置印章数据库文件poseal.db存放的目录
		ServletRegistrationBean srb = new ServletRegistrationBean(adminSeal);
		srb.addUrlMappings("/adminseal.zz");
		srb.addUrlMappings("/sealimage.zz");
		srb.addUrlMappings("/loginseal.zz");
        return srb;// 
    }
}
