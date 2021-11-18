package serhii.orlov.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import serhii.orlov.spring.dao.AbstractDao;
import serhii.orlov.spring.dao.CinemaHallDao;
import serhii.orlov.spring.model.CinemaHall;

@Repository
public class CinemaHallDaoImpl extends AbstractDao<CinemaHall> implements CinemaHallDao {
    public CinemaHallDaoImpl(SessionFactory factory) {
        super(factory, CinemaHall.class);
    }
}
