package Repository;

import Common.CommonVariables;
import DTO.AccountDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    List<AccountDTO> accountDTOList = new ArrayList<>();
    //계좌생성
     public boolean saveAccount(AccountDTO accountDTO){
         boolean result = false;
         if(accountDTO != null){
             accountDTOList.add(accountDTO);
             result = true;
         }
         return result;
     }
    //잔고확인
    public int chckBal(String account) {
        int result = 0;
        for (int i = 0; i < accountDTOList.size(); i++) {
            if (account.equals(accountDTOList.get(i).getNumber())) {
                result = accountDTOList.get(i).getBalance();
            }
        }
        return result;
    }
    //출금
    public boolean withdraw(String accountnum, int withdrawMonney) {
        boolean result = false;
        for (int i = 0; i < accountDTOList.size(); i++) {
            if(accountnum.equals(accountDTOList.get(i).getNumber())){
                accountDTOList.get(i).setBalance(withdrawMonney);
                result = true;
            }
        }
        return result;
    }
}
