package Repository;

import DTO.ItemsForSaleDTO;
import DTO.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class SyopingmolRepository {
    List<ItemsForSaleDTO> itemsForSaleDTOList = new ArrayList<>();



    public List<ItemsForSaleDTO> search(String sea) {
        List<ItemsForSaleDTO> result = new ArrayList<>();
        for (int i = 0; i < itemsForSaleDTOList.size(); i++) {
            if(itemsForSaleDTOList.get(i).getItemName().contains(sea)){
                result.add(itemsForSaleDTOList.get(i));
            }
        }
        return result;
    }
}
