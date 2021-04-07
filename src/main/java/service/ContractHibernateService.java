package service;

import dao.HibernateContractDao;
import dao.HibernateUnivesalDao;
import dao.IContractDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ContractHibernateService implements IContractService{

    @Autowired
    private HibernateContractDao dao;

    @Override
    public IContractDao<Contract> getDao() {
        return dao;
    }


    public void hCreate(Contract entity, ContractBuilder contractBuilder) {
        dao.create(entity,contractBuilder);
    }

    public void hCreate(Contract entity) {
        dao.create(entity);
    }

    public Contract hRead(long id) {
        return (Contract)dao.read(id);
    }


    public void hUpdate(Contract entity, ContractBuilder contractBuilder) {
        dao.update(entity,contractBuilder);
    }

    public void hUpdate(Contract entity) {
        dao.update(entity);
    }


    public void hDelete(long id) {
        dao.delete(id);
    }

    public void setDao(HibernateContractDao dao) {
        this.dao = dao;
    }
}
