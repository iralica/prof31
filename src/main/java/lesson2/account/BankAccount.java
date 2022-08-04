package lesson2.account;

public class BankAccount {
    private String id;
    private String name;
    private int balance;

    public BankAccount(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BankAccount{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }

    public int сredit(int amount){
        balance += amount;
        return balance;

    }
    public int debit(int amount)
    {
        if(amount <= balance)
            balance -= amount;
        else
            System.out.println("Не хватает денег на счете");

        return balance;
    }

    public int transfer(BankAccount account, int amount)
    {
        if(amount <= balance)
        {
            balance -= amount;
            account.сredit(amount);
        }
        else
            System.out.println("Не хватает денег на счете");
        return balance;
    }


    public static void main(String[] args) {
        BankAccount l = new BankAccount("ifr", "Ira", 5000 );
        System.out.println(l.сredit(20));
        System.out.println(l.debit(20));
        System.out.println(l.debit(6000));
    }
}
