package Service;

import DTO.SellerDTO;
import Repository.SellerRepository;

import java.util.Scanner;

public class SellerService {
    Scanner scanner = new Scanner(System.in);
    SellerRepository sellerRepository = new SellerRepository();

    public void save() {
        System.out.println("[판매자 회원가입]");
        System.out.print("이름:");
        String name = scanner.next();
        System.out.print("비밀번호: ");
        String pass = scanner.next();
        System.out.print("이메일: ");
        String email = scanner.next();
        boolean result = sellerRepository.ChackEmail(email);
        if(result){
            System.out.println("이미사용중인 이메일 입니다.");
            save();
        }
        System.out.print("폰번호: ");
        String mobile = scanner.next();
        System.out.print("계좌: ");
        String account = scanner.next();
        SellerDTO sellerDTO = new SellerDTO(name,pass,email,mobile,account);
        SellerDTO saved = sellerRepository.save(sellerDTO);
        if(saved != null){
            System.out.println("회원가입 완료");
            System.out.println(saved);
        }else{
            System.out.println("회원가입 실패");
        }
    }
}
