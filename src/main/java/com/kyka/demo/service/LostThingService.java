package com.kyka.demo.service;

import com.kyka.demo.entity.LostThing;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface LostThingService {
    List<LostThing> queryLostThing();
    List<LostThing> querySchoolCard();
    List<LostThing> queryCard();
    List<LostThing> queryOthers();
//    List<LostThing> queryByTime(Date date);
    LostThing queryLostThingById(int lostThingId);
    LostThing queryLostThingByDescription(String description);
    boolean insertSchoolCard(LostThing lostThing);
    boolean insertCard(LostThing lostThing);
    boolean insertOthers(LostThing lostThing);
    boolean updataLostThing(LostThing lostThing);
    boolean deleteLostThing(int lostThingId);
}
