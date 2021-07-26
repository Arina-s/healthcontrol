package com.arinauniversity.healthcontrol.dao;

import com.arinauniversity.healthcontrol.model.Headache;

import java.util.List;

public interface HeadacheDao {

    List<Headache> getHeadaches();

    void addHeadache(Headache headache);

    void deleteHeadacheById(int id);

    void updateHeadache(Headache headache);

}
