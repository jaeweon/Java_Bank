package Bank;

public class Bank {
   // 모든 은행의 고객을 관리하는 DB
   public static Bank[][] banks = new Bank[3][100];

   // 각 은행별 고객 수
   public static int[] arCount = new int[banks.length];
    // 접근자는 private
    // 예금주, 계좌번호, 핸드폰 번호, 비밀번호, 잔액
    private String accountHolder;
    private String accountNum;
    private String phoneNum;
    private String pw;
    private int money;
    // 기본 생성자

    public Bank(){;}
    // 초기화 생성자
    public Bank(String accountHolder, String accountNum, String phoneNum, String pw, int money) {
        super();
        this.accountHolder = accountHolder;
        this.accountNum = accountNum;
        this.phoneNum = phoneNum;
        this.pw = pw;
        this.money = money;
    }


    // getter, setter

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    // 입금
    public void deposit(int money){
        this.money += money;
    }
    // 출금
    public void withdraw(int money){
         this.money -= money;
    }
    // 잔액조회
    public int getBalance(){
        return this.money;
    }

    // 계좌번호 중복검사
    public static Bank checkAccount(String accountNum){
        Bank user = null;
        for (int i = 0; i < banks.length; i++) {
            int j = 0;
            for (j = 0; j < arCount[i]; j++) {
                if(banks[i][j].accountNum.equals(accountNum)){
                        user = banks[i][j];
                        break;
                }
            }
            if(j != arCount[i]){break;}
        }
        return user;
    }

    // 핸드폰 중복검사
    public static Bank checkPhone(String phoneNum){
        Bank user = null;
        for (int i = 0; i < banks.length; i++) {
            int j = 0;
            for (j = 0; j < arCount[i]; j++) {
                if(banks[i][j].phoneNum.equals(phoneNum)){
                    user = banks[i][j];
                    break;
                }
            }
            if(j != arCount[i]){break;}
        }
        return user;
    }

    // 로그인(계좌번호, 비밀번호)
    public static Bank login(String accountHolder, String pw){
        Bank user = checkAccount(accountHolder);
        if(user != null){
            if(user.pw.equals(pw)){
                return user;
            }
        }
        return null;
    }
}
