package Service;

import DTO.ItemsForSaleDTO;
import DTO.MemberDTO;
import Repository.SyopingmolRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SyopingService {
    SyopingmolRepository syopingmolRepository = new SyopingmolRepository();
    Scanner scanner = new Scanner(System.in);
    //검색
    public void search() {
        System.out.print("검색: ");
        String sea = scanner.next();
        List<ItemsForSaleDTO> itemsForSaleDTOList  = syopingmolRepository.search(sea);
        System.out.println("검색 결과");
        System.out.println(itemsForSaleDTOList);
    }
    //로그인
    public void login() {
        System.out.print("아이디입력: ");
        String memberId = scanner.next();
        System.out.print("비밀번호 입력:");
        String pass = scanner.next();
        MemberDTO memberDTO = syopingmolRepository.login(memberId,pass);
        if(memberDTO != null){
            System.out.println(memberDTO.getMemberId()+"님 어서오세요!");
            System.out.println("로그인 완료");
        }else {
            System.out.println("없는 아이디 이거나 비밀번호가 틀렸습니다.");
        }
    }
}
