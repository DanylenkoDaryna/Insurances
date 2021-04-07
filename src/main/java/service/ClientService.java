package service;

import dao.ClientDao;
import dao.IClientDao;
import data.Client;

public class ClientService implements IClientService {
    @Override
    public IClientDao<Client> getDao() {
        return new ClientDao() ;
    }
}
