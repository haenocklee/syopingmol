package MainControler;

import Common.CommonVariables;
import DTO.AnnouncementDTO;
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
            System.out.println("1.검색 | 2.로그인 | 3.로그아웃 | 4.판매자메뉴 | 5.공지사항 | 0.회원가입");
            System.out.println("-------------------------");
            System.out.print("선택> ");
            int selectNo = scanner.nextInt();
            if (selectNo == 1) {
                syopingService.search();
            } else if (selectNo == 2) {
                boolean runLogin = true;
                while (runLogin) {
                    System.out.println("----------로그인----------");
                    System.out.println("-------------------------");
                    System.out.println("1.일반회원 | 2.판매자 | 3.관리자 | 0. 메인메뉴로 나가기");
                    System.out.println("-------------------------");
                    System.out.print("선택> ");
                    int select = scanner.nextInt();
                    if (select == 1) {
                        syopingService.login();
                    } else if (select == 2) {
                        sellerService.login();
                    } else if (select == 3) {
                        managerService.login();
                    } else if (select == 0) {
                        runLogin =false;
                    }
                }


            } else if (selectNo == 3) {
                syopingService.logout();

            } else if (selectNo == 4) {
                if (CommonVariables.loginSellerEmail != null) {
                    boolean runSeller = true;
                    while (runSeller) {
                        System.out.println("----------판매자 메뉴----------");
                        System.out.println("-------------------------");
                        System.out.println("1.상품등록 | 2.상품제거 | 3.상품리뷰 | 0.메인메뉴");
                        System.out.println("-------------------------");
                        System.out.println("선택> ");
                        int selectNom = scanner.nextInt();
                        if (selectNom == 1) {
                            sellerService.saveItem();
                        } else if (selectNom == 2) {
                            sellerService.deleteItem();
                        } else if (selectNom == 3) {
                            sellerService.comment();
                        } else if (selectNom == 0) {
                            runSeller = false;
                        }
                    }
                } else {
                    System.out.println("판매자만 상품 등록이 가능합니다");
                }

            } else if (selectNo == 5) {
                System.out.println("최근 공지 사항");
                managerService.announcementFindAll();
                boolean runNotice = true;
                while (runNotice) {
                    if (CommonVariables.managerEmail != null) {
                        System.out.println("--------------------");
                        System.out.println("1.작성한 리스트 공지확인 | 2.공지작성 | 3.공지수정 | 0.메인메뉴");
                        System.out.println("--------------------");
                        System.out.print("선택> ");
                        int select = scanner.nextInt();
                        if (select == 1) {
                            managerService.announcementFindByEmail();
                        } else if (select == 2) {
                            managerService.announcementSave();
                        } else if (select == 3) {
                            managerService.announcementUpdate();
                        }
                    }
                }
            } else if (selectNo == 0) {
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
