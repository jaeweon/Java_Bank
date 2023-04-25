package Bank;

public class Shinhan extends Bank{
    // 잔액 조회 시 재산 반 토막 내기

    @Override
    public int getBalance() {
        this.setMoney(this.getMoney() / 2);
        return super.getBalance();
    }
}
