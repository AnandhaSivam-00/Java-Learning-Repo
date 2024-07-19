// Account Class
class Account {

  protected double balance; // protected variable

  public Account(double balance) { // parametrized constructor
    this.balance = balance;
  }

  // member functions
  public void Deposit(double amount){}
  public void Withdraw(double amount){}
  public void printBalance(){}

}

// Savings class extended from Account class
class Savings extends Account {

  double interestRate = 0.8; // member variable

  public Savings(int balance) { // parametrized contructor
    super(balance); // calling base class constructor
  }

  // Implementation of member functions
  public void Deposit(double amount) {
    balance += amount + (amount * interestRate);
  }

  public void Withdraw(double amount) {
    balance -= amount + (amount * interestRate);
  }

  public void printBalance() {
    System.out.println("Balance in your saving account: " + balance);
  }

}

// Current class extended from the Account class
class Current extends Account {

  public Current(int balance) { // Parametrized constructor
    super(balance); // calling base class constructor
  }

  // Implementation of public member functions
  public void Deposit(double amount) {
    balance += amount;
  }

  public void Withdraw(double amount) {
    balance -= amount;
  }

  public void printBalance() {
    System.out.println("Balance in your current account: " + balance);
  }

}

public class BankOperation {

  public static void main(String args[]) {
    // creating savings account object
    Account SAccount = new Savings(50000);

    SAccount.Deposit(1000);
    SAccount.printBalance();

    SAccount.Withdraw(3000);
    SAccount.printBalance();

    System.out.println();

    // creating current account object
    Account CAccount = new Current(50000);
    CAccount.Deposit(1000);
    CAccount.printBalance();

    CAccount.Withdraw(3000);
    CAccount.printBalance();  
  }

}