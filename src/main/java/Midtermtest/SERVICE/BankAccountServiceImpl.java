package Midtermtest.SERVICE;
import Midtermtest.DAO.BankAccountDao;
import Midtermtest.DAO.BankAccountDaoImpl;
import Midtermtest.DTO.BankAccount;

import java.util.List;

public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountDao bankAccountDao = new BankAccountDaoImpl();

    @Override
    public void create(BankAccount account) {
        bankAccountDao.create(account);
    }

    @Override
    public BankAccount read(int actNumber) {
        return bankAccountDao.read(actNumber);
    }

    @Override
    public void update(BankAccount account) {
        bankAccountDao.update(account);
    }

    @Override
    public void delete(int actNumber) {
        bankAccountDao.delete(actNumber);
    }

    @Override
    public List<BankAccount> findByCustomerName(String customerName) {
        return bankAccountDao.findByCustomerName(customerName);
    }

    @Override
    public List<BankAccount> findByBranchCode(int branchCode) {
        return bankAccountDao.findByBranchCode(branchCode);
    }

    @Override
    public List<Object[]> findAllGroupedByCity() {
        return bankAccountDao.findAllGroupedByCity();
    }
}
