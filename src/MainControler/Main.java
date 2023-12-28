package MainControler;

import Common.CommonVariables;
import Service.ManagerService;
import Service.SellerService;
import Service.SyopingService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SyopingService syopingService = new SyopingService();
        SellerService sellerService = new SellerService();
        ManagerService managerService = new ManagerService();
        boolean run = true;
        while (run) {
            System.out.println("----------쇼핑몰----------");
            System.out.println("-------------------------");
            System.out.println("1.검색 | 2.로그인 | 3.로그아웃 | 4.장바구니 | 5.구매 | 6.판매자메뉴 | 7.고객센터 | 8.공지사항 | 9.회원가입");
            System.out.println("-------------------------");
            System.out.println("선택> ");
            int selectNo = scanner.nextInt();
            if (selectNo == 1) {
                syopingService.search();
            } else if (selectNo == 2) {
                if (CommonVariables.loginId != null) {
                    syopingService.login();
                } else {
                    System.out.println("이미 로그인 상태입니다.");
                }

            } else if (selectNo == 3) {
                if (CommonVariables.loginId != null) {
                    syopingService.logout();
                } else {
                    System.out.println("이미 로그아웃 상태입니다.");
                }

            } else if (selectNo == 4) {

            } else if (selectNo == 5) {

            } else if (selectNo == 6) {
                if (CommonVariables.loginSellerEmail != null) {
                    boolean sellRun = true;
                    while (sellRun) {
                        System.out.println("--------------------");
                        System.out.println("-------------------------");
                        System.out.println("1.상품등록 | 2.상품제거 | 3.상품리뷰 | 0.메인메뉴");
                        System.out.println("-------------------------");
                        System.out.println("선택> ");
                        int selectNom = scanner.nextInt();
                        if (selectNom == 1) {

                        } else if (selectNom == 2) {

                        } else if (selectNom == 3) {

                        } else if (selectNom == 0) {

                        }
                    }
                } else {
                    System.out.println("판매자만 상품 등록이 가능합니다");
                }

            } else if (selectNo == 7) {

            } else if (selectNo == 8) {

            } else if (selectNo == 9) {
                boolean saveRun = true;
                while (saveRun) {
                    System.out.println("--------------------");
                    System.out.println("1.일반회원가입 | 2.판매자가입 | 3.관리자가입 | 0.메인메뉴");
                    System.out.println("--------------------");
                    System.out.print("선택> ");
                    int select = scanner.nextInt();
                    if (select == 1) {
                        syopingService.save();
                    } else if (select == 2) {
                        sellerService.save();
                    } else if (select == 3) {
                        managerService.save();
                    } else if (select == 0) {
                        saveRun = false;
                    }
                }
            }
        }
    }
}
