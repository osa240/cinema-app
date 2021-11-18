package serhii.orlov.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import serhii.orlov.spring.dao.AbstractDao;
import serhii.orlov.spring.dao.TicketDao;
import serhii.orlov.spring.model.Ticket;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
