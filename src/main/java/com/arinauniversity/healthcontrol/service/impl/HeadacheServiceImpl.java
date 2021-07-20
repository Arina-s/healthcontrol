package com.arinauniversity.healthcontrol.service.impl;

import com.arinauniversity.healthcontrol.dao.HeadacheDao;
import com.arinauniversity.healthcontrol.model.Headache;
import com.arinauniversity.healthcontrol.service.HeadacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeadacheServiceImpl implements HeadacheService {

    private final HeadacheDao headacheDao;

    @Override
    public List<Headache> getHeadaches() {
        return headacheDao.getHeadaches();
    }

    @Override
    public void addHeadache(Headache headache) {
        headacheDao.addHeadache(headache);
    }

    @Override
    public void deleteHeadacheById(int id) {
        headacheDao.deleteHeadacheById(id);
    }

    @Override
    public void updateHeadache(Headache headache) {
        headacheDao.updateHeadache(headache);
    }

    @Override
    public Headache getHeadacheById(int id) {
        return getHeadaches().stream()
                .filter(headache -> headache.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
