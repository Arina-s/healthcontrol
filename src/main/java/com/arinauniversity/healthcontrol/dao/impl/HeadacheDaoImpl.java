package com.arinauniversity.healthcontrol.dao.impl;

import com.arinauniversity.healthcontrol.dao.HeadacheDao;
import com.arinauniversity.healthcontrol.model.Headache;
import com.arinauniversity.healthcontrol.model.Tablet;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HeadacheDaoImpl implements HeadacheDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Headache> getHeadaches() {
        return jdbcTemplate.query("SELECT * FROM headaches", (resultSet, rowNum) -> {
            Headache headache = new Headache();
            headache.setId(resultSet.getInt("id"));
            headache.setDate(resultSet.getString("date"));
            headache.setPower(resultSet.getInt("power"));
            headache.setDuration(resultSet.getInt("duration"));

            Tablet tablet = new Tablet();
            tablet.setName(resultSet.getString("tablet_name"));
            tablet.setCount(resultSet.getInt("tablet_count"));
            headache.setTablet(tablet);

            return headache;
        });
    }

    @Override
    public void addHeadache(Headache headache) {
        jdbcTemplate.update(
                "INSERT INTO headaches (date, power, duration, tablet_name, tablet_count) VALUES(?, ?, ?, ?, ?)",
                headache.getDate(),
                headache.getPower(),
                headache.getDuration(),
                headache.getTablet().getName(),
                headache.getTablet().getCount()
        );
    }

    @Override
    public void deleteHeadacheById(int id) {
        jdbcTemplate.update("DELETE FROM headaches WHERE id = ?", id);
    }

    @Override
    public void updateHeadache(Headache headache) {
        jdbcTemplate.update(
                "UPDATE headaches SET date = ?, power = ?, duration = ?, tablet_name = ?, tablet_count = ?  WHERE id = ?",
                headache.getDate(),
                headache.getPower(),
                headache.getDuration(),
                headache.getTablet().getName(),
                headache.getTablet().getCount(),
                headache.getId()
        );
    }

}
