package Repository;

import Common.CommonVariables;
import DTO.*;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    List<MemberDTO> memberDTOList = new ArrayList<>();
    BankRepository bankRepository = new BankRepository();
    ItemsForSaleRepository itemsForSaleRepository = new ItemsForSaleRepository();
    SellerRepository sellerRepository = new SellerRepository();

    public MemberDTO login(String memberEmail, String pass) {//로그인
        MemberDTO result = null;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberEmail.equals(memberDTOList.get(i).getEmail()) && pass.equals(memberDTOList.get(i).getPass())) {
                CommonVariables.loginEmail = memberEmail;
                result = memberDTOList.get(i);
            } else {
                result = null;
            }
        }
        return result;
    }

    //구매
    public void buy(ItemsForSaleDTO itemsForSaleDTO, int buyItemCount) {//구매
        SellerDTO sellerDTO = sellerRepository.chackSellerDTOByItemsForSaleDTO(itemsForSaleDTO);//아이템 정보로 판매자 정보 변수대입
        BankDTO sellerAccount = bankRepository.chackSellerAccountBySellerDTO(sellerDTO);//판매자 정보로 판매자 계좌 정보 변수대입
        String sellerAccountNumber = sellerAccount.getAccountNumber();
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (CommonVariables.loginEmail.equals(memberDTOList.get(i).getEmail())) {//로그인 아이디와 일치하는 계좌번호 찾기
                String accountNum = memberDTOList.get(i).getAccount();//계좌번호 변수대입
                int itemprice = itemsForSaleDTO.getPrice();//물건 가격 변수대입
                long withdrawMonney = (itemprice * buyItemCount);//
                String clientAcountPass = bankRepository.AcccountPass(accountNum);
                long buyMemberResult = bankRepository.withdraw(accountNum, clientAcountPass, withdrawMonney);//고객 계좌 출금
                int itemStock =  itemsForSaleRepository.updateItemStock(itemsForSaleDTO.getItemId(),buyItemCount);
                if(itemStock >  0){
                    System.out.println("itemStock = " + itemStock);
                }
                long sellSellerResult = bankRepository.deposit(sellerAccountNumber, withdrawMonney);//판매자 계좌 입금
                if (buyMemberResult > 0 && sellSellerResult > 0) {
                    System.out.println(CommonVariables.loginEmail + "님" + sellerDTO.getEmail() + "님에게 입금 왑료되었습니다.");
                    System.out.println("구매한 물건> " + itemsForSaleDTO);
                } else {
                    System.out.println("거래에 실패하였습니다.");
                }
            }
        }
    }

    //일반회원리스트 저장
    public boolean save(MemberDTO memberDTO) {
        memberDTOList.add(memberDTO);
        return true;
    }

    //이메일 중복 체크
    public boolean chackEamil(String email) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (email.equals(memberDTOList.get(i).getEmail())) {
                result = true;
            }
        }
        return result;
    }

    public void basketListBuy(List<SyupingmolDTO> basketList) {//장바구니 내에있는 물건  구매
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (CommonVariables.loginEmail.equals(memberDTOList.get(i).getEmail())) {//로그인 아이디와 일치하는 계좌번호 찾기
                String accountNum = memberDTOList.get(i).getAccount();//계좌번호 변수대입}
                String clientAcountPass = bankRepository.AcccountPass(accountNum);
                long priceSum = 0;
                for (int j = 0; j < basketList.size(); j++) {
                    priceSum = priceSum + (basketList.get(j).getSellItemPrice() * basketList.get(j).getSellItemCount());
                    String sellerAccountNumber = sellerRepository.drowAccountNumberByEmail(basketList.get(j).getSellSeller());//이메일로 계좌 가져오기
                    long withdrawMonney = basketList.get(j).getSellItemPrice() * basketList.get(j).getSellItemCount();
                    int itemStock =  itemsForSaleRepository.updateItemStock(basketList.get(j).getTransactionItemId(),basketList.get(j).getSellItemCount());//구매한 물건 개수 줄이기 메서드로 들어가기
                    if(itemStock >  0){
                        System.out.println("itemStock = " + itemStock);
                    }
                    long sellSellerResult = bankRepository.deposit(sellerAccountNumber, withdrawMonney);//판매자 계좌 입금
                    if(sellSellerResult > 0){
                        System.out.println(basketList.get(j).getSellSeller()+"님에게 입금되었습니다.");
                    }else {
                        System.out.println(basketList.get(j).getSellSeller()+"님에게 입금실패");
                    }
                }
                long buyMemberResult = bankRepository.withdraw(accountNum, clientAcountPass, priceSum);//고객 계좌 출금
                if (buyMemberResult > 0) {
                    System.out.println("장바구니에 있는 상품을 구매완료 했습니다.");
                } else {
                    System.out.println("거래에 실패하였습니다.");
                }
            }
        }
    }
}

