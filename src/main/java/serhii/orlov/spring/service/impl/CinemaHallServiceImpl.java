package serhii.orlov.spring.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import serhii.orlov.spring.dao.CinemaHallDao;
import serhii.orlov.spring.exception.DataProcessingException;
import serhii.orlov.spring.model.CinemaHall;
import serhii.orlov.spring.service.CinemaHallService;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    private final CinemaHallDao cinemaHallDao;

    public CinemaHallServiceImpl(CinemaHallDao cinemaHallDao) {
        this.cinemaHallDao = cinemaHallDao;
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public CinemaHall get(Long id) {
        return cinemaHallDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get cinema hall by id " + id));
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
