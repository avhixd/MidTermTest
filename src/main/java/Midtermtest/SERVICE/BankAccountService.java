package Midtermtest.SERVICE;

import Midtermtest.DTO.BankAccount;

import java.util.List;

public interface BankAccountService {

    public void create(BankAccount account);
    public BankAccount read(int actNumber);
    public void update(BankAccount account);
    public void delete(int actNumber);
    List<BankAccount> findByCustomerName(String customerName);
    List<BankAccount> findByBranchCode(int branchCode);
    List<Object[]> findAllGroupedByCity();
}