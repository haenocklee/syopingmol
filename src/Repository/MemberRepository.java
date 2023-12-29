package Repository;

import Common.CommonVariables;
import DTO.AccountDTO;
import DTO.ItemsForSaleDTO;
import DTO.MemberDTO;
import DTO.SellerDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    List<MemberDTO> memberDTOList = new ArrayList<>();
    AccountRepository accountRepository = new AccountRepository();
    ItemsForSaleRepository itemsForSaleRepository = new ItemsForSaleRepository();
    SellerRepository sellerRepository = new SellerRepository();

    public MemberDTO login(String memberId, String pass) {//로그인
        MemberDTO result = null;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberId.equals(memberDTOList.get(i).getMemberId()) && pass.equals(memberDTOList.get(i).getPass())) {
                CommonVariables.loginId = memberId;
                result = memberDTOList.get(i);
            } else {
                result = null;
            }
        }
        return result;
    }


    public void buy(ItemsForSaleDTO itemsForSaleDTO, int buyItemNum) {//구매
        SellerDTO sellerDTO = sellerRepository.chackSellerDTOByItemsForSaleDTO(itemsForSaleDTO);//아이템 정보로 판매자 정보 변수대입
        AccountDTO SellerAccount = accountRepository.chackSellerAccountBySellerDTO(sellerDTO);//판매자 정보로 판매자 계좌 정보 변수대입
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (CommonVariables.loginId.equals(memberDTOList.get(i).getMemberId())) {//로그인 아이디와 일치하는 계좌번호 찾기
                String accountNum = memberDTOList.get(i).getAccount();//계좌번호 변수대입
                int balance = accountRepository.chckBal(accountNum);//계좌내 잔액 변수대입
                int itemprice = itemsForSaleDTO.getPrice();//물건 가격 변수대입
                if (balance >= (itemprice * buyItemNum)) {//잔액이 (물건값 * 물건개수)보다 작을 경우 실행
                    int withdrawMonney = balance - (itemprice * buyItemNum);//출금액 이거 acccountaccountRepository에서 작업하자....
                    accountRepository.deposit(SellerAccount, withdrawMonney);//판매자 입금

                    boolean drawResult = accountRepository.withdraw(accountNum, withdrawMonney);//
                    if (drawResult) {
                        System.out.println(CommonVariables.loginId + "님 " + itemsForSaleDTO.getItemName() + "가 구매 완료되었습니다.");
                    }
                } else {
                    System.out.println("잔액이 부족합니다.");
                }
            }
        }
    }

    public boolean save(MemberDTO memberDTO) {//일반회원리스트 저장
        memberDTOList.add(memberDTO);
        return true;
    }

    public boolean chackEamil(String email) {//이메일 중복 체크
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (email.equals(memberDTOList.get(i).getEmail())) {
                result = true;
            }
        }
        return result;
    }
}

