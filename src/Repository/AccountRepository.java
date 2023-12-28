package Repository;

import Common.CommonVariables;
import DTO.AccountDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    List<AccountDTO> accountDTOList = new ArrayList<>();
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
    public boolean withdraw(String accountnum, int monney) {
        boolean result = false;
        for (int i = 0; i < accountDTOList.size(); i++) {
            if(accountnum.equals(accountDTOList.get(i).getNumber())){
                accountDTOList.get(i).setBalance(monney);
                result = true;
            }
        }
        return result;
    }
}
