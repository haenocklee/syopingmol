package Repository;

import Common.CommonVariables;
import DTO.ItemsForSaleDTO;
import DTO.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class SyopingmolRepository {
    List<ItemsForSaleDTO> itemsForSaleDTOList = new ArrayList<>();
    List<MemberDTO> memberDTOList = new ArrayList<>();


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


