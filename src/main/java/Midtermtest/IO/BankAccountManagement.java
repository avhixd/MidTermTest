package Midtermtest.IO;

import Midtermtest.DTO.BankAccount;
import Midtermtest.SERVICE.BankAccountService;
import Midtermtest.SERVICE.BankAccountServiceImpl;

import java.util.List;

public class BankAccountManagement {

    private static BankAccountService service = new BankAccountServiceImpl();

    public static void main(String[] args) {


         createAccounts();
//         readAccount(1);
//         updateAccount();
//         deleteAccount(2);
//         findByCustomerName("Rahul");
//         findByBranchCode(103);
         findAllGroupedByCity();
    }

    private static void createAccounts() {
        service.create(new BankAccount(1, "Rahul", 1000.0, "New York", 101));
        service.create(new BankAccount(2, "Sai", 2000.0, "Los Angeles", 102));
        service.create(new BankAccount(3, "Satyam", 1500.0, "San Francisco", 103));
    }

    private static void readAccount(int accountId) {
        BankAccount account = service.read(accountId);
        System.out.println(account);
    }

    private static void updateAccount() {

        BankAccount account = service.read(1);
        if (account != null) {
            account.setActBalance(1200.0);
            service.update(account);
        }
    }

    private static void deleteAccount(int accountId) {
        service.delete(accountId);
    }

    private static void findByCustomerName(String customerName) {
        List<BankAccount> accountsByName = service.findByCustomerName(customerName);
        accountsByName.forEach(System.out::println);
    }

    private static void findByBranchCode(int branchCode) {
        List<BankAccount> accountsByBranch = service.findByBranchCode(branchCode);
        accountsByBranch.forEach(System.out::println);
    }

    private static void findAllGroupedByCity() {
        List<Object[]> groupedByCity = service.findAllGroupedByCity();
        groupedByCity.forEach(result -> {
            System.out.println("ActNumber: " + result[0] + ", CustomerName: " + result[1] + ", City: " + result[2]);
        });
    }
}
