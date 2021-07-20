package com.arinauniversity.healthcontrol.service;

import com.arinauniversity.healthcontrol.model.Headache;

import java.util.List;

public interface HeadacheService {

    List<Headache> getHeadaches();

    void addHeadache(Headache headache);

    void deleteHeadacheById(int id);

    void updateHeadache(Headache headache);

    Headache getHeadacheById(int id);

}
