package Repository;

import Common.CommonVariables;
import DTO.AccountDTO;
import DTO.ItemsForSaleDTO;
import DTO.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    List<MemberDTO> memberDTOList = new ArrayList<>();
    AccountRepository accountRepository = new AccountRepository();
    ItemsForSaleRepository itemsForSaleRepository = new ItemsForSaleRepository();

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


    public boolean buy(ItemsForSaleDTO itemsForSaleDTO, int num) {//구매
        boolean result = false;
        boolean stockResult = itemsForSaleRepository.chackStock(itemsForSaleDTO,num);
        if(stockResult){//제고확인
            for (int i = 0; i < memberDTOList.size(); i++) {
                if (CommonVariables.loginId.equals(memberDTOList.get(i).getMemberId())) {//로그인 아이디와 일치하는 계좌번호 찾기
                    String accountnum = memberDTOList.get(i).getAccount();
                    int balance = accountRepository.chckBal(accountnum);//계좌내 잔액확인
                    int itemprice = itemsForSaleDTO.getPrice();
                    if (balance >= (itemprice * num)) {
                        int monney = balance - (itemprice * num);
                        boolean drawResult = accountRepository.withdraw(accountnum,monney);
                        if(drawResult){
                            System.out.println("출금완료");
                            result = true;
                        }
                    }
                }
            }
        }else {
            System.out.println("제고가 부족합니다.");
        }
        return result;
    }

    public boolean save(MemberDTO memberDTO) {//일반회원리스트 저장
        memberDTOList.add(memberDTO);
        return true;
    }

    public boolean chackEamil(String email) {//이메일 중복 체크
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (email.equals(memberDTOList.get(i).getEmail())){
                result = true;
            }
        }
        return result;
    }
}

