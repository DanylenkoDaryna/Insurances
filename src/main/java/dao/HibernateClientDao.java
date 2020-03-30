package dao;

import data.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class HibernateClientDao implements IClientDao {

    @Autowired
    private HibernateUnivesalDao entityPersister;


    @Override
    public void create(Object entity) {
        entityPersister.getCurrentSession().save((Client)entity);
    }

    @Override
    public Object read(long id) {
        return entityPersister.getCurrentSession().load(Client.class,id);
    }

    @Override
    public void update(Object entity) {
        entityPersister.getCurrentSession().update((Client)entity);
    }

    @Override
    public void delete(long id) {
        Client entity = (Client)this.read(id);
        entityPersister.getCurrentSession().remove(entity);
    }

    @Override
    public void insert(Object man, int id) {
        //недоделан
        entityPersister.getCurrentSession().update(man);
    }
}
