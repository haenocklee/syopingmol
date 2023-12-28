package Service;

import Common.CommonVariables;
import DTO.ItemsForSaleDTO;
import DTO.MemberDTO;
import Repository.MemberRepository;
import Repository.SyopingmolRepository;

import java.util.List;
import java.util.Scanner;

public class SyopingService {
    SyopingmolRepository syopingmolRepository = new SyopingmolRepository();
    MemberRepository memberRepository = new MemberRepository();
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
        if(chackEamilResult){
            System.out.println("등록된 이메일입니다.");
            save();
        }
        System.out.print("폰번호를 입력하세요: ");
        String mobile = scanner.next();
        System.out.print("계좌를 입력하세요: ");
        String account = scanner.next();
        MemberDTO memberDTO = new MemberDTO(memberId, name, pass, email, mobile, account);
        boolean saveResult = memberRepository.save(memberDTO);
        if(saveResult){
            System.out.println("회원가입 성공");
        }else {
            System.out.println("회원가입실패");
        }

    }

    //검색 장바구니 구매
    public void search() {
        System.out.print("검색: ");
        String sea = scanner.next();
        List<ItemsForSaleDTO> itemsForSaleDTOList = syopingmolRepository.search(sea);
        System.out.println("검색 결과");
        for (int i = 0; i < itemsForSaleDTOList.size(); i++) {
            System.out.println(itemsForSaleDTOList.get(i).getItemName());
        }
        System.out.print("선택할 물건의 id를 입력해주세요>");
        Long itemId = scanner.nextLong();
        ItemsForSaleDTO itemsForSaleDTO = syopingmolRepository.findById(itemId);
        if (itemsForSaleDTO != null) {
            boolean run = true;
            while (run) {
                System.out.println(itemsForSaleDTO);
                System.out.println("1.구매 | 2.장바구니 넣기 | 3.리뷰작성 |0.나가기");
                int select = scanner.nextInt();
                if (select == 1) {//구매
                    if (CommonVariables.loginId != null) {
                        System.out.println("몇개구매하시겠습니까?");
                        System.out.print("수량: ");
                        int num = scanner.nextInt();
                        boolean result = memberRepository.buy(itemsForSaleDTO,num);
                        if (result) {
                            System.out.println(CommonVariables.loginId + "님 구매가 완료되었습니다.");
                        }
                    } else {
                        System.out.println("회원전용 서비스입니다 로그인을해주세요");
                    }
                } else if (select == 2) {//장바구니
                    if(CommonVariables.loginId != null) {

                    }else {
                        System.out.println("회원전용 서비스입니다 로그인을해주세요");
                    }
                } else if (select == 3) {//리뷰작성

                } else if (select == 0) {//나가기
                    run = false;
                }
            }
        } else {
            System.out.println("없는 물건입니다 정확히 입력해주세요");
            search();
        }
    }

    //로그인
    public void login() {
        System.out.print("아이디입력: ");
        String memberId = scanner.next();
        System.out.print("비밀번호 입력:");
        String pass = scanner.next();
        MemberDTO memberDTO = memberRepository.login(memberId, pass);
        if (memberDTO != null) {
            System.out.println(memberDTO.getMemberId() + "님 어서오세요!");
            System.out.println("로그인 완료");
        } else {
            System.out.println("없는 아이디 이거나 비밀번호가 틀렸습니다.");
        }
    }

    //로그아웃
    public void logout() {
        CommonVariables.loginId = null;
        CommonVariables.manager = null;
        CommonVariables.loginSellerEmail = null;
        System.out.println("로그아웃 되었습니다.");
    }
}
