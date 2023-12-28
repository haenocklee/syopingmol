package Repository;

import Common.CommonVariables;
import DTO.ItemsForSaleDTO;

import java.util.ArrayList;
import java.util.List;

public class ItemsForSaleRepository {
    List<ItemsForSaleDTO> itemsForSaleDTOList = new ArrayList<>();

    public boolean save(ItemsForSaleDTO itemsForSaleDTO) {//아이템 리스트 저장용 메서드
        itemsForSaleDTOList.add(itemsForSaleDTO);
        return true;
    }


    public boolean chackStock(ItemsForSaleDTO itemsForSaleDTO, int buynum) {//제고확인용 메서드
        boolean result = false;
        for (int i = 0; i < itemsForSaleDTOList.size(); i++) {
            if (itemsForSaleDTO.equals(itemsForSaleDTOList.get(i))) {
                if (itemsForSaleDTOList.get(i).getStock() >= buynum) {
                    result = true;
                }
            }
        }
        return result;
    }

    public List<ItemsForSaleDTO> chackItemList() {//판매자 아이템 리스트 확인용 메서드
        List<ItemsForSaleDTO> result = null;
        for (int i = 0; i < itemsForSaleDTOList.size(); i++) {
            if(CommonVariables.loginSellerEmail.equals(itemsForSaleDTOList.get(i).getSellerEmail()));
            result.add(itemsForSaleDTOList.get(i));
        }
        return result;
    }

    public boolean delete(Long itemId) {
        boolean result = false;
        for (int i = 0; i < itemsForSaleDTOList.size(); i++) {
            //판매자 로그인 이메일과 입력받은 itemId가 같을때
            if(CommonVariables.loginSellerEmail.equals(itemsForSaleDTOList.get(i).getSellerEmail()) && itemId.equals(itemsForSaleDTOList.get(i).getItemId())){
            itemsForSaleDTOList.remove(i);
            result = true;
            }
        }
        return result;
    }
}
