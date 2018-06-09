package com.kyka.demo.dao;

import com.kyka.demo.entity.LostThing;

import java.util.Date;
import java.util.List;

public interface LostThingDao {
    List<LostThing> queryLostThing();
    List<LostThing> querySchoolCard();
    List<LostThing> queryCard();
    List<LostThing> queryOthers();
    LostThing queryLostThingById(int lostThingId);
    LostThing queryLostThingByDescription(String description);
    int insertSchoolCard(LostThing lostThing);
    int insertCard(LostThing lostThing);
    int insertOthers(LostThing lostThing);
    int updataLostThing(LostThing lostThing);
    int deleteLostThing(int lostThingId);
}
