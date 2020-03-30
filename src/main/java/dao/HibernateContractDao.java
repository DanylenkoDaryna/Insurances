package dao;

import data.InsuredPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import service.Contract;
import service.ContractBuilder;

public class HibernateContractDao implements IContractDao {

    @Autowired
    private HibernateUnivesalDao entityPersister;


    @Transactional
    @Override
    public void create(Object entity, ContractBuilder contractBuilder) {
        setDbKeys((Contract) entity);

        entityPersister.getCurrentSession().save((Contract) entity);

        entityPersister.getCurrentSession().save(contractBuilder.getResult().getMan());

        for (InsuredPerson o : contractBuilder.getResult().getPersonList()) {
            entityPersister.getCurrentSession().save(o);
        }
    }

    @Transactional
    @Override
    public void create(Object entity) {

        Contract c = (Contract) entity;
        entityPersister.getCurrentSession().save(c);
        setDbKeys(c);
        entityPersister.getCurrentSession().save(c.getMan());
        for (InsuredPerson o : c.getPersonList()) {
            entityPersister.getCurrentSession().save(o);
        }

    }

    /**
     * Set Keys for objects, connected to Contract: Insured Persons and Client
     *
     * @param entity Contract object
     */
    private void setDbKeys(Contract entity) {
        entity.getMan().setId(entity.getId() * 2);
        for (InsuredPerson o : entity.getPersonList()) {
            o.setNumber(entity.getId() * 3);
        }
    }


    @Transactional
    @Override
    public Object read(long id) {

        return entityPersister.getCurrentSession().load(Contract.class, id);
    }

    @Transactional
    @Override
    public void update(Object entity, ContractBuilder contractBuilder) {
        entityPersister.getCurrentSession().update((Contract) entity);
    }

    @Transactional

    public void update(Object entity) {
        entityPersister.getCurrentSession().update((Contract) entity);
    }

    @Transactional
    @Override
    public void delete(long id) {

        Contract entity = (Contract) this.read(id);
        entityPersister.getCurrentSession().remove(entity);
    }
}
