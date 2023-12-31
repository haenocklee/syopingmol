package MainControler;

import Service.BankService;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService();
        boolean run = true;
        while(run){
            System.out.println("----------");
            System.out.println("1.고객등록 | 2.잔액조회 | 3.입금 | 4.출금 | 5.거래내역확인 | 6.계좌이체 | 0.종료");
            System.out.println("----------");
            System.out.print("(번호)선택> ");
            int select = scanner.nextInt();
            if(select == 0){
                System.out.println("종료합니다");
                run = false;
            } else if (select == 1) {
                bankService.save();
            } else if (select == 2) {
                bankService.balance();
            } else if (select == 3) {
                bankService.deposit();
            } else if (select == 4) {
                bankService.withdraw();
            } else if (select == 5) {
                bankService.findAllBanking();
            } else if (select == 6) {
                bankService.transfer();
            }
        }

    }
}