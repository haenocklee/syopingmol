package Service;

import DTO.ManagerDTO;
import Repository.ManagerRepository;

import java.util.Scanner;

public class ManagerService {
    Scanner scanner = new Scanner(System.in);
    ManagerRepository managerRepository = new ManagerRepository();


    public void save() {
        System.out.println("[관리자 회원가입]");
        System.out.print("이름: ");
        String name = scanner.next();
        System.out.print("비밀번호: ");
        String pass = scanner.next();
        System.out.print("이메일: ");
        String email = scanner.next();
        System.out.print("전화번호: ");
        String mobile = scanner.next();
        System.out.print("계좌: ");
        String account = scanner.next();
        ManagerDTO managerDTO = new ManagerDTO(name,pass,email,mobile,account);
        ManagerDTO result =managerRepository.save(managerDTO);
        if(result != null){
            System.out.println("회원가입 완료");
        }else{
            System.out.println("회원가입 실패");
        }
    }
}
