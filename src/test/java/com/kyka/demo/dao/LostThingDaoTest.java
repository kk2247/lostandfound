package com.kyka.demo.dao;

import com.kyka.demo.entity.LostThing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LostThingDaoTest {
    @Autowired
    private LostThingDao lostThingDao;

    @Test
    public void queryLostThing() {
        List<LostThing> list=lostThingDao.queryLostThing();
        assertEquals(3,list.size());
    }

    @Test
    public void querySchoolCard() {
    }

    @Test
    public void queryCard() {
    }

    @Test
    public void queryOthers() {
    }

    @Test
    public void queryLostThingById() {
        LostThing lostThing=lostThingDao.queryLostThingById(2);
        assertEquals(2,lostThing.getLostThingId());
    }

    @Test
    public void queryLostThingByDescription() {
    }

    @Test
    public void insertSchoolCard() {
        LostThing lostThing=new LostThing();
        lostThing.setContactWay("电话：110");
        lostThing.setDescription("qqq");
        lostThing.setLostTime(new Date());
        lostThing.setName("雨伞");
        lostThing.setPlace("饭堂");
        lostThing.setPicturePath("1.jpg");
        lostThingDao.insertOthers(lostThing);
    }

    @Test
    public void insertCard() {
    }

    @Test
    public void insertOthers() {
        LostThing lostThing=new LostThing();
        lostThing.setContactWay("电话：110");
        lostThing.setDescription("qqq");
        lostThing.setLostTime(new Date());
        lostThing.setName("雨伞");
        lostThing.setPlace("饭堂");
        lostThing.setPicturePath("1.jpg");
        lostThingDao.insertOthers(lostThing);
    }

    @Test
    public void updataLostThing() {
        LostThing lostThing=new LostThing();
        lostThing.setLostThingId(5);
        lostThing.setContactWay("电话：120");
        int eff=lostThingDao.updataLostThing(lostThing);
        assertEquals(1,eff);
    }

    @Test
    public void deleteLostThing() {
        int eff=lostThingDao.deleteLostThing(2);
        assertEquals(1,eff);
    }
}