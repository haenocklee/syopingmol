package Service;

import Common.CommonVariables;
import DTO.ItemsForSaleDTO;
import DTO.MemberDTO;
import DTO.SyupingmolDTO;
import Repository.ItemsForSaleRepository;
import Repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SyopingService {
    MemberRepository memberRepository = new MemberRepository();
    ItemsForSaleRepository itemsForSaleRepository = new ItemsForSaleRepository();
    Scanner scanner = new Scanner(System.in);

    //회원가입
    public void save() {
        System.out.println("[회원가입]");
        System.out.print("아이디를 입력하세요: ");
        String memberId = scanner.next();
        System.out.print("이름을 입력하세요: ");
        String name = scanner.next();
        System.out.print("비밀번호를 입력하세요: ");
        String pass = scanner.next();
        System.out.print("이메일을 입력하세요: ");
        String email = scanner.next();
        boolean chackEamilResult = memberRepository.chackEamil(email);
        if (chackEamilResult) {
            System.out.println("등록된 이메일입니다.");
            save();
        }
        System.out.print("폰번호를 입력하세요: ");
        String mobile = scanner.next();
        System.out.print("계좌를 입력하세요: ");
        String account = scanner.next();
        MemberDTO memberDTO = new MemberDTO(memberId, name, pass, email, mobile, account);
        boolean saveResult = memberRepository.save(memberDTO);
        if (saveResult) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("회원가입실패");
        }
    }

    //검색>>  구매,장바구니 장바구니 구매
    public void search() {
        List<SyupingmolDTO> basketList  =  new ArrayList<>();
        boolean searchRun = true;
        while (searchRun) {
            System.out.print("검색: ");
            String sea = scanner.next();
            System.out.println("검색 결과");
            List<ItemsForSaleDTO> itemsForSaleDTOList = itemsForSaleRepository.search(sea);
            System.out.println(itemsForSaleDTOList);
            System.out.println("1.물건 구매밑 장바구니 담기 | 0.검색 종료");
            int selectSerch =  scanner.nextInt();
            if(selectSerch ==  1){
                System.out.print("선택할 물건의 id를 입력해주세요>");
                Long itemId = scanner.nextLong();
                ItemsForSaleDTO itemsForSaleDTO = itemsForSaleRepository.findById(itemId);
                if (itemsForSaleDTO != null) {
                    boolean run = true;
                    while (run) {
                        System.out.println(itemsForSaleDTO);
                        System.out.println("-------------------------");
                        System.out.println("1.구매 | 2.장바구니 넣기 | 3.장바구니 물건 구매 |0.검색화면으로 나가기");
                        System.out.println("-------------------------");
                        System.out.print("선택> ");
                        int select = scanner.nextInt();
                        if (select == 1) {//구매
                            if (CommonVariables.loginSellerEmail != null) {
                                System.out.println("몇개구매하시겠습니까?");
                                System.out.print("수량: ");
                                int num = scanner.nextInt();
                                boolean stockResult = itemsForSaleRepository.chackStock(itemsForSaleDTO, num);
                                if (stockResult) {
                                    memberRepository.buy(itemsForSaleDTO, num);
                                } else {
                                    System.out.println("제고가없습니다.");
                                }
                            } else {
                                System.out.println("회원전용 서비스입니다 로그인을해주세요");
                            }
                        } else if (select == 2) {//장바구니 넣기
                            if (CommonVariables.loginEmail != null) {
                                System.out.println("몇개를 장바구니에 넣겠습니까");
                                System.out.print("수량: ");
                                int num = scanner.nextInt();
                                boolean stockResult = itemsForSaleRepository.chackStock(itemsForSaleDTO, num);
                                if (stockResult) {
                                    SyupingmolDTO putInBasket = new SyupingmolDTO(CommonVariables.loginEmail,itemsForSaleDTO.getSellerEmail(),itemsForSaleDTO.getItemId(),itemsForSaleDTO.getPrice(),num);
                                    basketList.add(putInBasket);
                                } else {
                                    System.out.println("제고가없습니다.");
                                }
                            } else {
                                System.out.println("회원전용 서비스입니다 로그인을해주세요");
                            }
                        } else if (select == 3) {
                            memberRepository.basketListBuy(basketList);
                        } else if (select == 0) {//검색화면으로 나가기
                            run = false;
                        }
                    }
                } else {
                    System.out.println("없는 물건id입니다 정확히 입력해주세요");
                    search();
                }
            } else if (selectSerch == 0) {
                searchRun  = false;
            }
        }

    }


    //로그인
    public void login() {
        System.out.print("이메일 입력: ");
        String memberEmail = scanner.next();
        System.out.print("비밀번호 입력:");
        String pass = scanner.next();
        MemberDTO memberDTO = memberRepository.login(memberEmail, pass);
        if (memberDTO != null) {
            System.out.println(memberDTO.getMemberId() + "님 어서오세요!");
            System.out.println("로그인 완료");
        } else {
            System.out.println("없는 아이디 이거나 비밀번호가 틀렸습니다.");
        }
    }

    //로그아웃
    public void logout() {
        CommonVariables.loginEmail = null;
        CommonVariables.loginManagerEmail = null;
        CommonVariables.loginSellerEmail = null;
        System.out.println("로그아웃 되었습니다.");
    }
}
