//package com.test.controller;
//
//import com.amarsoft.lease.common.constant.LeaseConst;
//import com.amarsoft.lease.dto.TreeDto;
//import com.amarsoft.lease.dto.TreeState;
//import com.amarsoft.lease.lact.entity.LactLoanBakEntity;
//import com.amarsoft.lease.lact.entity.LactLoanRelationBakEntity;
//import com.amarsoft.lease.project.entity.ProjArrivalPO;
//import com.amarsoft.lease.project.entity.ProjContractPO;
//import com.aspose.words.Bookmark;
//import com.aspose.words.BookmarkCollection;
//import com.aspose.words.Document;
//import com.zhuozhengsoft.pageoffice.FileSaver;
//import com.zhuozhengsoft.pageoffice.OpenModeType;
//import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
//import group.rober.common.CommonConsts;
//import group.rober.common.autoconfigure.CommonProperties;
//import group.rober.common.fileman.entity.FileEntity;
//import group.rober.common.fileman.service.FileManageService;
//import group.rober.common.fileman.service.FileNaming;
//import group.rober.common.fileman.service.FileStorageService;
//import group.rober.common.fileman.service.impl.FileSystemFileNaming;
//import group.rober.office.autoconfigure.OfficeProperties;
//import group.rober.office.pageoffice.PageOfficeCtrl;
//import group.rober.runtime.holder.WebHolder;
//import group.rober.runtime.kit.HttpKit;
//import group.rober.runtime.kit.IOKit;
//import group.rober.runtime.kit.JSONKit;
//import group.rober.runtime.kit.StringKit;
//import group.rober.runtime.lang.MapData;
//import group.rober.sql.core.DataAccessor;
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//import sun.reflect.generics.tree.Tree;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.InputStream;
//import java.io.UnsupportedEncodingException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
///**
// * Created by sylu on 2019/5/13.
// */
//@RestController
//@RequestMapping(ManageReportController.BASE_URL)
//public class ManageReportController {
//    public static final String BASE_URL = "/manageReport";
//
//    protected Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    @Qualifier(CommonConsts.DOC_FILE_SERVICE_NAME)
//    FileManageService docFileManageService;
//
//    @Autowired
//    @Qualifier(CommonConsts.DOC_STORAGE_SERVICE)
//    FileStorageService docStorageService;
//
//    @Autowired
//    private OfficeProperties properties;
//
//    @Autowired
//    CommonProperties commonProperties;
//
//    @Autowired
//    DataAccessor dataAccessor;
//
//    private static final String directory = "/document/";
//
//
//    @GetMapping("/pageoffice/EditAndSave/{fileId}")
//    public ModelAndView C13WordEditAndSave(
//            HttpServletRequest request, Map<String, Object> map,@PathVariable("fileId")String fileId) throws UnsupportedEncodingException {
//        PageOfficeCtrl poCtrl = createPageOfficeCtrl();
//        poCtrl.addCustomToolButton("保存", "save", 1);
//        poCtrl.addCustomToolButton("预览", "preview", 2);
//
//        WordDocument woDoc = new WordDocument();
//        woDoc.openDataTag("【※承租人_1_抵押物】").setValue("【※示例承租人-地址-上海陆嘴】");
//        woDoc.openDataTag("【※承租人_1_承租人住所】").setValue("【※示例承租人-地址-上海陆嘴】");
//        poCtrl.setWriter(woDoc);
//
////        poCtrl.setSaveDataPage(request.getContextPath() + BASE_URL + "/save/" + fileId);
//        poCtrl.setSaveFilePage(request.getContextPath() + BASE_URL + "/save/" + fileId);
//        poCtrl.setMenubar(false);
//        String opener = WebHolder.getRequestParameter("opener").strValue();
//        String userName = StringKit.nvl(opener, "江小安");
//        FileEntity fileEntity = docFileManageService.getFileEntity(fileId);
//        FileNaming fileNaming = new FileSystemFileNaming(commonProperties);
//        fileNaming.setDirectory(directory);
////        String url = request.getContextPath() + BASE_URL + "/show/" + fileId;
//        String fileRealPath = fileNaming.getFileRealPath(fileEntity.getName(), fileId);
//        Path path = Paths.get(fileRealPath);
//        Path absolutePath = path.toAbsolutePath();
//        String filePath = String.valueOf(absolutePath);
//        logger.info("filePath: " + filePath);
//        String osName = System.getProperty("os.name");
//        if("linux".equals(osName.toLowerCase())){
//            filePath = "file://" + filePath;
//        }
//        poCtrl.webOpen(filePath, OpenModeType.docAdmin, userName);
//        map.put("banner", "管理报告在线编辑");
//        map.put("ctxPath",request.getContextPath());
//        map.put("requestPath","http://"+request.getRemoteAddr().concat(request.getContextPath()));
//        List<TreeDto> treeDtos  = new ArrayList<>();
//        List<MapData> textList = new ArrayList<>();
//        for (int i = 1; i < 10; i++) {
//            TreeDto treeDto = new TreeDto();
//            treeDto.setName("parent"+i);
//            treeDto.setId(i);
//            treeDto.setPid(0);
//            treeDto.setT("id="+i);
//            treeDto.setClick(false);
//            if(i==1){
//                treeDto.setOpen(true);
//            }
//            List<TreeDto> childes = new ArrayList<>();
//            for (int i1 = i; i1 < 5; i1++) {
//                TreeDto treeDto1 = new TreeDto();
//                String id = String.join("", Integer.toString(i), Integer.toString(i1));
//                treeDto1.setName("child"+id);
//                treeDto1.setClick(true);
//                treeDto1.setId( Integer.parseInt(id));
//                treeDto1.setPid(i);
//                treeDto1.setT("id="+ id);
//                childes.add(treeDto1);
//            }
//
//            treeDto.setChildren(childes);
//            treeDtos.add(treeDto);
//        }
//        List<Map<String,Object>> list = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            for (int i1 = 1; i1 < 5; i1++) {
//                Map<String, Object> map1 = new HashMap<>();
//                if(i == 0){
//                    String name = String.join("","父节点", Integer.toString(i1));
//                    if(i1==1){
//                        map1.put("open",true);
//                    }
//                    map1.put("click",false);
//                    map1.put("pId",i);
//                    map1.put("t","id="+i1);
//                    map1.put("name",name);
//                    map1.put("id",i1);
//                }else{
//                    String id = String.join("", Integer.toString(i), Integer.toString(i1));
//                    String name = String.join("","叶子节点", id);
//                    map1.put("pId",i);
//                    map1.put("id",id);
//                    map1.put("name",name);
//                    map1.put("t","id="+id);
//                }
//                list.add(map1);
//            }
//        }
//        JSONObject json = new JSONObject();
//        json.accumulate("listNew", list);
//        json.accumulate("list", treeDtos);
//        json.accumulate("listSearch",textList);
//        map.put("upstream",json);
//        map.put("default",json);
//        map.put("formula",json);
//        map.put("construction",json);
////        map.put("tree", json);
//        return createModelAndView(poCtrl,"office/pageoffice/Office2", map);
//    }
//    @RequestMapping("/save/{fileId}")
//    public void saveFile(@PathVariable("fileId") String fileId,HttpServletRequest request, HttpServletResponse response) {
//        FileEntity fileEntity = docFileManageService.getFileEntity(fileId);
//        FileSaver saver = new FileSaver(request, response);
//        InputStream inputStream = saver.getFileStream();
//        InputStream updateStream = saver.getFileStream();
//        try {
//            docStorageService.store(inputStream, fileEntity.getStoredContent(), fileId, fileEntity.getStoredContent());
//            PageOfficeCtrl poCtrl = createPageOfficeCtrl();
//            FileNaming fileNaming = new FileSystemFileNaming(commonProperties);
//            fileNaming.setDirectory(directory);
//            //        String url = request.getContextPath() + BASE_URL + "/show/" + fileId;
//            String fileRealPath = fileNaming.getFileRealPath(fileEntity.getName(), fileId);
//            Path path = Paths.get(fileRealPath);
//            Path absolutePath = path.toAbsolutePath();
//            String filePath = String.valueOf(absolutePath);
//            logger.info("filePath: " + filePath);
//            String osName = System.getProperty("os.name");
//            if("linux".equals(osName.toLowerCase())){
//                filePath = "file://" + filePath;
//            }
//            WordDocument woDoc = new WordDocument();
//            woDoc.openDataTag("【※示例承租人-地址-上海陆嘴】").setValue("【※承租人_1_抵押物】");
//            poCtrl.setWriter(woDoc);
//            String opener = WebHolder.getRequestParameter("opener").strValue();
//            String userName = StringKit.nvl(opener, "江小安");
//            poCtrl.webOpen(filePath, OpenModeType.docAdmin, userName);
//            docStorageService.store(inputStream, fileEntity.getStoredContent(), fileEntity.getFileId(), fileEntity.getStoredContent());
//            // 在线合同编辑完成同步保存需要更新到数据库的数据
//            updateDatabase(fileId, updateStream);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            IOKit.close(inputStream);
//            saver.close();
//        }
//    }
//
//    /**
//     * 在线合同编辑完成同步保存需要更新到数据库的数据
//     * @author: rtao
//     * @date: 2020/12/10 15:30
//     * @param: [fileId, updateStream]
//     * @return: void
//     **/
//    private void updateDatabase(String fileId, InputStream updateStream) throws Exception {
//        // 获取保存后的文档书签内容
//        Document document = new Document(updateStream);
//        BookmarkCollection bookmarkCollection = document.getRange().getBookmarks();
//        Bookmark bk_setPlace = bookmarkCollection.get("【※设置场所】");
//        Bookmark bk_startDate = bookmarkCollection.get("【※起租日】");
//        // 执行数据库同步更新操作
//        // 获取 projectId
//        ProjContractPO projContractPO = dataAccessor.selectOne(ProjContractPO.class, "SELECT * FROM PROJ_CONTRACT where FILE_ID = :fileId", "fileId", fileId);
//        String projectId = projContractPO.getProjectId();
//        String projApplyId = projContractPO.getProjApplyId();
//
//        // 更新【※设置场所】到数据库
//        ProjArrivalPO projArrivalPO = dataAccessor.selectOne(ProjArrivalPO.class, "SELECT * FROM PROJ_ARRIVAL WHERE PROJECT_ID = :projectId AND PROJECT_APPLY_ID = :projApplyId",
//                "projectId", projectId, "projApplyId", projApplyId);
//        if (StringUtils.hasText(bk_setPlace.getText()) && bk_setPlace.getText().length() > 3) {
//            String setPlaceText = bk_setPlace.getText().substring(2, bk_setPlace.getText().length() - 1);
//            MapData place = JSONKit.jsonToBean(projArrivalPO.getSetPlace(), MapData.class);
//            if (Objects.equals(LeaseConst.YES_NO_N, projArrivalPO.getIsSameAddress()) && !Objects.equals(setPlaceText, place.getValue("address").strValue())) {
//                place.put("address", setPlaceText);
//                projArrivalPO.setSetPlace(place.toJsonString());
//                dataAccessor.save(projArrivalPO);
//            }
//        }
//
//        // 更新【※起租日】到数据库
//        LactLoanRelationBakEntity lactLoanRelationBakEntity = dataAccessor.selectOne(LactLoanRelationBakEntity.class,
//                "select * from LACT_LOAN_RELATION_BAK where object_no = :projectId AND PROJECT_APPLY_ID = :projApplyId", "projectId", projectId, "projApplyId", projApplyId);
//        LactLoanBakEntity lactLoanBakEntity = dataAccessor.selectOne(LactLoanBakEntity.class,
//                "SELECT * FROM LACT_LOAN_BAK WHERE LOAN_ID = :loanId AND VERSION_ID = :versionId",
//                "loanId", lactLoanRelationBakEntity.getLoanId(), "versionId", lactLoanRelationBakEntity.getVersionId());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//        if (!bk_startDate.getText().isEmpty() && !bk_startDate.getText().equals(sdf.format(lactLoanBakEntity.getStartDate()))) {
//            lactLoanBakEntity.setStartDate(sdf.parse(bk_startDate.getText()));
//            dataAccessor.save(lactLoanBakEntity);
//        }
//    }
//
//    /** @deprecated */
//    @GetMapping("/show/{fileId}")
//    public void showFile(@PathVariable("fileId") String fileId, HttpServletResponse response, HttpServletRequest request) {
////        docFileManageService.servletDownloadFile(fileId, response);
//        InputStream inputStream = null;
//        try {
//            inputStream = docFileManageService.openFileInputStream(fileId);
//            HttpKit.renderStream(response, inputStream, "octets/stream", null);
//        } catch (Exception e) {
//            logger.error("打开文件资源失败，请检查文件资源是否存在,fileId=" + fileId, e);
//        } finally {
//            IOKit.close(inputStream);
//        }
//    }
//
//    /** @deprecated */
//    @GetMapping("/showInt")
//    public int showInt() {
//        return 1;
//    }
//
//    public ModelAndView createModelAndView(PageOfficeCtrl poCtrl,String viewName,Map<String, Object> map){
//
//        String title = WebHolder.getRequestParameter("title").strValue("文档编辑");
//        map.put("pageOfficeHtml", poCtrl.getHtmlCode("PageOfficeCtrl"));
//        map.put("title", WebHolder.getRequestParameter("title").strValue("文档编辑"));
//
//        ModelAndView mv = new ModelAndView(viewName);
//        return mv;
//    }
//
//    public PageOfficeCtrl createPageOfficeCtrl(){
//        HttpServletRequest request = WebHolder.getRequest();
//        String staticResourceUrl = properties.getPageOffice().getStaticResourceUrl();
//
//        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
//        poCtrl.setServerPage(request.getContextPath() + staticResourceUrl +"/poserver.zz");//设置服务页面
//        return  poCtrl;
//    }
//}
