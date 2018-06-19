package com.kyka.demo.service;

import com.kyka.demo.entity.LostThing;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
public interface LostThingService {
    List<LostThing> queryLostThing();
    List<LostThing> querySchoolCard();
    List<LostThing> queryCard();
    List<LostThing> queryOthers();
//    List<LostThing> queryByTime(Date date);
    LostThing queryLostThingById(int lostThingId);
    List<LostThing> queryLostThingByDescription(String description);
    int insertSchoolCard(LostThing lostThing);
    int insertCard(LostThing lostThing);
    int insertOthers(LostThing lostThing);
    boolean updataLostThing(LostThing lostThing);
    boolean deleteLostThing(int lostThingId);
    boolean confirm(int lostThingId);
}
