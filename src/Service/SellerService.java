package Service;

import Common.CommonVariables;
import DTO.CommentDTO;
import DTO.ItemsForSaleDTO;
import DTO.SellerDTO;
import Repository.CommentRepository;
import Repository.ItemsForSaleRepository;
import Repository.SellerRepository;

import java.util.List;
import java.util.Scanner;

public class SellerService {
    Scanner scanner = new Scanner(System.in);
    SellerRepository sellerRepository = new SellerRepository();
    ItemsForSaleRepository itemsForSaleRepository = new ItemsForSaleRepository();
    CommentRepository commentRepository = new CommentRepository();

    public void save() {
        System.out.println("[판매자 회원가입]");
        System.out.print("이름:");
        String name = scanner.next();
        System.out.print("비밀번호: ");
        String pass = scanner.next();
        System.out.print("이메일: ");
        String email = scanner.next();
        boolean result = sellerRepository.ChackEmail(email);
        if (result) {
            System.out.println("이미사용중인 이메일 입니다.");
            save();
        }
        System.out.print("폰번호: ");
        String mobile = scanner.next();
        System.out.print("계좌: ");
        String account = scanner.next();
        SellerDTO sellerDTO = new SellerDTO(name, pass, email, mobile, account);
        SellerDTO saved = sellerRepository.save(sellerDTO);
        if (saved != null) {
            System.out.println("회원가입 완료");
            System.out.println(saved);
        } else {
            System.out.println("회원가입 실패");
        }
    }

    public void saveItem() {
        System.out.println("상품등록");
        System.out.print("상품명: ");
        String itemName = scanner.next();
        System.out.println("판매자:" + sellerRepository.chackSeller().getName());
        String sellerEmail = sellerRepository.chackSeller().getName();
        System.out.print("가격: ");
        int price = scanner.nextInt();
        System.out.print("제고: ");
        int stock = scanner.nextInt();
        System.out.print("제품설명: ");
        String contents = scanner.next();
        ItemsForSaleDTO itemsForSaleDTO = new ItemsForSaleDTO(itemName,sellerEmail,price,stock,contents);
        boolean SIResult = itemsForSaleRepository.save(itemsForSaleDTO);
        if(SIResult){
            System.out.println("상품등록완료");
        }
    }

    public void deleteItem() {
        List<ItemsForSaleDTO>itemsForSaleDTOS = itemsForSaleRepository.chackItemList();
        System.out.println(itemsForSaleDTOS);
        System.out.println("제거할 상품 id를 입력하세요");
        System.out.print("선택> ");
        Long itemId = scanner.nextLong();
        boolean delResult =itemsForSaleRepository.delete(itemId);
        if(delResult){
            System.out.println("삭제완료");
        }else{
            System.out.println("삭제실패");
        }
    }

    public void comment() {
        List<ItemsForSaleDTO>itemsForSaleDTOS = itemsForSaleRepository.chackItemList();
        System.out.println(itemsForSaleDTOS);
        System.out.println("리뷰를 확인할 상품 id를 입력하세요");
        System.out.print("선택> ");
        Long itemId = scanner.nextLong();
        List<CommentDTO>commentDTOS = commentRepository.checkCommentById(itemId);
        System.out.println(commentDTOS);
    }

    public void login() {
        if(CommonVariables.loginSellerEmail == null) {
            System.out.print("이메일 입력: ");
            String email = scanner.next();
            System.out.print("비밀번호 입력: ");
            String pass = scanner.next();
            boolean result = sellerRepository.login(email,pass);
            if(result){
                System.out.println("로그인 완료 " + email+ "님 환영합니다.");
            }else {
                System.out.println("로그인 실패 입력하신 정보가 틀립니다.");
            }
        }else{
            System.out.println("이미 로그인 상태입니다.");
        }
    }
}
