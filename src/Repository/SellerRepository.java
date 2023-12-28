package Repository;

import DTO.SellerDTO;

import java.util.ArrayList;
import java.util.List;

public class SellerRepository {
    List<SellerDTO>sellerDTOList = new ArrayList<>();
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
}
