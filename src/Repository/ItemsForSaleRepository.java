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
            if (CommonVariables.loginSellerEmail.equals(itemsForSaleDTOList.get(i).getSellerEmail())) ;
            result.add(itemsForSaleDTOList.get(i));
        }
        return result;
    }


    public boolean delete(Long itemId) {
        boolean result = false;
        for (int i = 0; i < itemsForSaleDTOList.size(); i++) {
            //판매자 로그인 이메일과 입력받은 itemId가 같을때
            if (CommonVariables.loginSellerEmail.equals(itemsForSaleDTOList.get(i).getSellerEmail()) && itemId.equals(itemsForSaleDTOList.get(i).getItemId())) {
                itemsForSaleDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }


    public int updateItemStock(Long transactionItemId, int sellItemCount) {
        int result = 0;
        for (int i = 0; i < itemsForSaleDTOList.size(); i++) {
            if (transactionItemId.equals(itemsForSaleDTOList.get(i).getItemId())) {
                int stock = itemsForSaleDTOList.get(i).getStock();
                stock = stock - sellItemCount;
                itemsForSaleDTOList.get(i).setStock(stock);
                result = itemsForSaleDTOList.get(i).getStock();
            }
        }
        return result;
    }


    public List<ItemsForSaleDTO> search(String sea) {//검색
        List<ItemsForSaleDTO> result = new ArrayList<>();
        for (int i = 0; i < itemsForSaleDTOList.size(); i++) {
            if (itemsForSaleDTOList.get(i).getItemName().contains(sea)) {
                result.add(itemsForSaleDTOList.get(i));
            }
        }
        return result;
    }


    public ItemsForSaleDTO findById(Long itemId) {//물건 아이디로 찾기
        ItemsForSaleDTO result = null;
        for (int i = 0; i < itemsForSaleDTOList.size(); i++) {
            if (itemId.equals(itemsForSaleDTOList.get(i).getItemId())) {
                result = itemsForSaleDTOList.get(i);
            }
        }
        return result;
    }
}
