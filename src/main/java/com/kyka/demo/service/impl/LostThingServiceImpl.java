package com.kyka.demo.service.impl;

import com.kyka.demo.dao.LostThingDao;
import com.kyka.demo.entity.LostThing;
import com.kyka.demo.service.LostThingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


public class LostThingServiceImpl implements LostThingService {

    @Autowired
    private LostThingDao lostThingDao;
    @Override
    public List<LostThing> queryLostThing() {
        return lostThingDao.queryLostThing();
    }

    @Override
    public List<LostThing> querySchoolCard() {
        return lostThingDao.querySchoolCard();
    }

    @Override
    public List<LostThing> queryCard() {
        return lostThingDao.queryCard();
    }

    @Override
    public List<LostThing> queryOthers() {
        return lostThingDao.queryOthers();
    }

//    @Override
//    public List<LostThing> queryByTime(Date date) {
//        return lostThingDao.queryByTime(date);
//    }

    @Override
    public LostThing queryLostThingById(int lostThingId) {
        return lostThingDao.queryLostThingById(lostThingId);
    }

    @Override
    public LostThing queryLostThingByDescription(String description) {
        return lostThingDao.queryLostThingByDescription(description);
    }

    @Override
    public boolean insertSchoolCard(LostThing lostThing) {
        if(lostThing.getName()!=null&& !"".equals(lostThing.getName())){
            lostThing.setLostTime(new Date());
            try{
                int efficeedNum=lostThingDao.insertSchoolCard(lostThing);
                if(efficeedNum>0){
                    return true;
                }
                else {
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败:"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public boolean insertCard(LostThing lostThing) {
        if(lostThing.getName()!=null&& !"".equals(lostThing.getName())){
            lostThing.setLostTime(new Date());
            try{
                int efficeedNum=lostThingDao.insertCard(lostThing);
                if(efficeedNum>0){
                    return true;
                }
                else {
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败:"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public boolean insertOthers(LostThing lostThing) {
        if(lostThing.getName()!=null&& !"".equals(lostThing.getName())){
            lostThing.setLostTime(new Date());
            try{
                int efficeedNum=lostThingDao.insertOthers(lostThing);
                if(efficeedNum>0){
                    return true;
                }
                else {
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败:"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public boolean updataLostThing(LostThing lostThing) {
        if(lostThing.getName()!=null&& !"".equals(lostThing.getName())){
            try{
                int efficeedNum=lostThingDao.updataLostThing(lostThing);
                if(efficeedNum>0){
                    return true;
                }
                else {
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败:"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public boolean deleteLostThing(int lostThingId) {
        if(lostThingId>0){
            try{
                int efficeedNum=lostThingDao.deleteLostThing(lostThingId);
                if(efficeedNum>0){
                    return true;
                }
                else {
                    throw new RuntimeException("删除信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("删除信息失败:"+e.toString());
            }
        }else{
            throw new RuntimeException("信息不能为空");
        }
    }
}
