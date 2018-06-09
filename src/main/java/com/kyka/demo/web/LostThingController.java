package com.kyka.demo.web;

import com.kyka.demo.entity.LostThing;
import com.kyka.demo.service.LostThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/superadmin")
public class LostThingController {

    @Autowired
    private LostThingService lostThingService;

    @RequestMapping(value = "/listlost",method = RequestMethod.GET)
    private Map<String,Object> listLost(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<LostThing> list=lostThingService.queryLostThing();
        modelMap.put("list",list);
        return modelMap;
    }

    @RequestMapping(value = "/listschoolcard",method = RequestMethod.GET)
    private Map<String,Object> listSchoolCard(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<LostThing> list=lostThingService.querySchoolCard();
        modelMap.put("list",list);
        return modelMap;
    }

    @RequestMapping(value = "/listcard",method = RequestMethod.GET)
    private Map<String,Object> listCard(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<LostThing> list=lostThingService.queryCard();
        modelMap.put("list",list);
        return modelMap;
    }

    @RequestMapping(value = "/listothers",method = RequestMethod.GET)
    private Map<String,Object> listOthers(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<LostThing> list=lostThingService.queryOthers();
        modelMap.put("list",list);
        return modelMap;
    }

    @RequestMapping(value = "/getlostbyid", method = RequestMethod.GET)
    private Map<String,Object> getLostById(Integer lostId){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        LostThing lostThing=lostThingService.queryLostThingById(lostId);
        modelMap.put("lost",lostThing);
        return modelMap;
    }

//    @RequestMapping(value = "/getlostbytime", method = RequestMethod.GET)
//    private Map<String,Object> getLostByTime(Date date){
//        Map<String,Object> modelMap=new HashMap<String,Object>();
//        List<LostThing> lostThing=lostThingService.queryByTime(date);
//        modelMap.put("lost",lostThing);
//        return modelMap;
//    }

    @RequestMapping(value = "/getlostbydescription", method = RequestMethod.GET)
    private Map<String,Object> getLostByDescription(String description){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        LostThing lostThing=lostThingService.queryLostThingByDescription(description);
        modelMap.put("lost",lostThing);
        return modelMap;
    }

    //    需要前端传入一个Json对象,xml等
//    传入xml
    @RequestMapping(value = "/addschoolcard", method = RequestMethod.POST)
    private Map<String,Object> addSchoolCard(@RequestBody LostThing lostThing) {
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",lostThingService.insertSchoolCard(lostThing));
        return modelMap;
    }

    @RequestMapping(value = "/addcard", method = RequestMethod.POST)
    private Map<String,Object> addCard(@RequestBody LostThing lostThing) {
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",lostThingService.insertSchoolCard(lostThing));
        return modelMap;
    }

    @RequestMapping(value = "/addothers", method = RequestMethod.POST)
    private Map<String,Object> addOthers(@RequestBody LostThing lostThing) {
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",lostThingService.insertSchoolCard(lostThing));
        return modelMap;
    }

    @RequestMapping(value = "/modifylost", method = RequestMethod.POST)
    private Map<String,Object> modifyLost(@RequestBody LostThing lostThing) {
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",lostThingService.updataLostThing(lostThing));
        return modelMap;
    }

    @RequestMapping(value = "/removearea", method = RequestMethod.GET)
    private Map<String,Object> removeArea(Integer lostThingId) {
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",lostThingService.deleteLostThing(lostThingId));
        return modelMap;
    }

    //    上传文件，在服务器中保存文件
    //todo
//    无法得到文件数据
    @RequestMapping(value = "/uploadfile",method = RequestMethod.POST)
    public HashMap<String, String> uploadPicture(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws Exception {

        HashMap<String, String> result = new HashMap<>();

        if(file.isEmpty()) {
            result.put("result", "false");
            result.put("message", "请选择一个文件");
            return result;
        }

        String UPLOAD_FOLDER = "static/uploadfiles/";

        File dir = new File(UPLOAD_FOLDER);
        if (!dir.isDirectory())
            dir.mkdirs();
        String fileName=request.getParameter("lostId")+".jpg";
        try {
            File newFile=new File(UPLOAD_FOLDER + fileName);
            OutputStream writer=new FileOutputStream(newFile);
            byte[] bytes = file.getBytes();
            writer.write(bytes);
            writer.close();
//            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);
            //redirectAttributes.addFlashAttribute("message", "已经将 '" + file.getOriginalFilename() + "' 的文件上传成功") ;
            result.put("result", "true");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }



}
