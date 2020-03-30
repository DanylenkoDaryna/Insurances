package dao;

import data.InsuredPerson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class HibernatePersonDao implements IPersonDao {

    @Autowired
    private HibernateUnivesalDao entityPersister;

    @Override
    public void create(Object entity, int index) {

        entityPersister.getCurrentSession().save((InsuredPerson)entity);
    }

    @Override
    public Object read(long id) {
        return entityPersister.getCurrentSession().load(InsuredPerson.class,id);
    }

    @Override
    public ArrayList readList(long id, ArrayList o) {


        return null;
    }

    @Override
    public void update(Object entity) {
        entityPersister.getCurrentSession().update((InsuredPerson)entity);
    }

    @Override
    public void delete(long id) {
        InsuredPerson entity = (InsuredPerson)this.read(id);
        entityPersister.getCurrentSession().remove(entity);
    }
}
