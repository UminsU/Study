package w2.w2_16_encapsulation;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // 값의 확인은 공개
    public double getBalance() {
        return balance;
    }

    // 값의 Update or Delete 와 같은 수정행위는
    // 프로그램의 내용적 맥락에 부합하도록 정해진 방법으로만 허용한다
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }
}