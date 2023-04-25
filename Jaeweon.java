package Bank;

public class Jaeweon extends Bank{
    // 입금 시 수수료 50%

    @Override
    public void deposit(int money) {
        money *= 0.5;
        super.deposit(money);
    }
}
