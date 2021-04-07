package service;

import dao.IClientDao;
import data.Client;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientHibernateService implements IClientService{

    @Autowired
    private IClientDao<Client> dao;

    @Override
    public IClientDao<Client> getDao() {
        return dao;
    }
    public void setDao(IClientDao<Client> operation) {
        dao = operation;
    }


    public void hCreate(Client entity) {
        dao.create(entity);
    }


    public void hRead(Client entity) {
        dao.read(entity.getId());
    }


    public void hUpdate(Client entity) {
        dao.update(entity);
    }


    public void hDelete(Client entity) {
        dao.delete(entity.getId());
    }
}
