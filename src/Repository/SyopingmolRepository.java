package Repository;

import Common.CommonVariables;
import DTO.ItemsForSaleDTO;
import DTO.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class SyopingmolRepository {
    List<ItemsForSaleDTO> itemsForSaleDTOList = new ArrayList<>();
    List<MemberDTO> memberDTOList = new ArrayList<>();


    public List<ItemsForSaleDTO> search(String sea) {
        List<ItemsForSaleDTO> result = new ArrayList<>();
        for (int i = 0; i < itemsForSaleDTOList.size(); i++) {
            if (itemsForSaleDTOList.get(i).getItemName().contains(sea)) {
                result.add(itemsForSaleDTOList.get(i));
            }
        }
        return result;
    }

    public MemberDTO login(String memberId, String pass) {
        MemberDTO result = null;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberId.equals(memberDTOList.get(i).getMemberId()) && pass.equals(memberDTOList.get(i).getPass())) {
                CommonVariables.loginId = memberId;
                result = memberDTOList.get(i);
            }else {
                result = null;
            }
        }
        return result;
    }
}
