package lesson2.account;

import lesson2.account.BankAccount;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestAccount {
    @Test
    public void testAccount()
    {
        BankAccount b1 = new BankAccount("123", "Ivan Sidorov", 30);
        BankAccount b2 = new BankAccount("456", "Masha Petrova", 50);
        assertEquals(35, b2.transfer(b1, 15));

        assertEquals(35, b2.getBalance());

        assertEquals(45, b1.getBalance());

    }

}
