package Service;

import Common.CommonVariables;
import DTO.ItemsForSaleDTO;
import DTO.MemberDTO;
import DTO.SyopingmolDTO;
import Repository.SyopingmolRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SyopingService {
    SyopingmolRepository syopingmolRepository = new SyopingmolRepository();
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
        System.out.print("폰번호를 입력하세요: ");
        String mobile = scanner.next();
        System.out.print("계좌를 입력하세요: ");
        String account = scanner.next();
        MemberDTO memberDTO = new MemberDTO(memberId,name,pass,email,mobile,account);
    }

    //검색
    public void search() {
        System.out.print("검색: ");
        String sea = scanner.next();
        List<ItemsForSaleDTO> itemsForSaleDTOList = syopingmolRepository.search(sea);
        System.out.println("검색 결과");
        System.out.println(itemsForSaleDTOList);
    }

    //로그인
    public void login() {
        System.out.print("아이디입력: ");
        String memberId = scanner.next();
        System.out.print("비밀번호 입력:");
        String pass = scanner.next();
        MemberDTO memberDTO = syopingmolRepository.login(memberId, pass);
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
