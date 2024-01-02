package dev.repository;

import dev.domain.TaxTable;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxRepository {

    private SessionFactory sessionFactory;

    public TaxRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(TaxTable tax) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tax);
    }

    public void edit(TaxTable tax) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tax);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        TaxTable tax = get(id);
        session.delete(tax);
    }

    public List<TaxTable> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<TaxTable> userQuery = session.createQuery("from TaxTable", TaxTable.class);
        return userQuery.getResultList();
    }
    public TaxTable get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(TaxTable.class, id);
    }


}
