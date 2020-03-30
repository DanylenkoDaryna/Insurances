package service;

import dao.ContractDao;
import dao.IContractDao;

public class ContractService implements IContractService {
    @Override
    public IContractDao<Contract> getDao() {
        return new ContractDao();
    }
}
