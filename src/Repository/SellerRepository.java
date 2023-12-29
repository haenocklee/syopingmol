package Repository;

import Common.CommonVariables;
import DTO.ItemsForSaleDTO;
import DTO.SellerDTO;

import java.util.ArrayList;
import java.util.List;

public class SellerRepository {
    List<SellerDTO>sellerDTOList = new ArrayList<>();
    public SellerDTO chackSeller(){//판매자
        SellerDTO result = null;
        for (int i = 0; i < sellerDTOList.size(); i++) {
            if(CommonVariables.loginSellerEmail.equals(sellerDTOList.get(i).getEmail())){
                result = sellerDTOList.get(i);
            }
        }
        return result;
    }
    public SellerDTO save(SellerDTO sellerDTO) {//판매자 회원가입
        sellerDTOList.add(sellerDTO);
        return sellerDTO;
    }

    public boolean ChackEmail(String email) {//이메일 체크
        boolean result = false;
        for (int i = 0; i < sellerDTOList.size(); i++) {
            if(email.equals(sellerDTOList.get(i).getEmail())){
                result = true;
            }
        }
        return result;
    }

    public boolean login(String email, String pass) {
        boolean result = false;
        for (int i = 0; i < sellerDTOList.size(); i++) {
            if(email.equals(sellerDTOList.get(i).getEmail())&&pass.equals(sellerDTOList.get(i).getPass())){
                CommonVariables.loginSellerEmail = email;
                result = true;
            }
        }
        return result;
    }

    public SellerDTO chackSellerDTOByItemsForSaleDTO(ItemsForSaleDTO itemsForSaleDTO) {
        SellerDTO result = null;
        for (int i = 0; i < sellerDTOList.size(); i++) {
            if(itemsForSaleDTO.getSellerEmail().equals(sellerDTOList.get(i).getEmail())){
                result = sellerDTOList.get(i);
            }
        }
        return result;
    }
}
