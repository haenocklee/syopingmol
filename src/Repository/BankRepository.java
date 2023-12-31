package Repository;

import DTO.AccountDTO;
import DTO.BankDTO;
import DTO.SellerDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankRepository {
    List<BankDTO> clientList = new ArrayList<>();//고객정보 리스트
    List<AccountDTO> bankingList = new ArrayList<>();//입출금리스트
    //현재시간
    String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));

    //게좌번호확인 전용 매서드
    public BankDTO accountCheck(String accountNumber) {
        BankDTO result = null;
        for (BankDTO bankDTO : clientList) {
            if (accountNumber.equals(bankDTO.getAccountNumber())) {
                result = bankDTO;
            }
        }
        return result;
    }

    //고객등록
    public BankDTO save(BankDTO bankDTO) {
        BankDTO result = null;
        clientList.add(bankDTO);
        for (BankDTO dto : clientList) {
            if (bankDTO.equals(dto)) {
                result = dto;
            }
        }
        return result;
    }

    //잔액조회
    public long balance(String accountNumber) {
        long result = 0;
        for (BankDTO bankDTO : clientList) {
            if (accountNumber.equals(bankDTO.getAccountNumber())) {
                result = bankDTO.getBalance();
            }
        }
        return result;
    }

    //입금
    public long deposit(String accountNumber, long dep) {
        long result = 0;
        for (int i = 0; i < clientList.size(); i++) {
            if (accountNumber.equals(clientList.get(i).getAccountNumber())) {
                long bal = clientList.get(i).getBalance();
                long sum = bal + dep;
                clientList.get(i).setBalance(sum);
                result = clientList.get(i).getBalance();
                AccountDTO accountDTO = new AccountDTO(accountNumber, dep, 0, createdAt);
                bankingList.add(accountDTO);
            }
        }
        return result;
    }


    //출금
    public long withdraw(String accountNumber, String clientPass, long draw) {
        long result = 0;
        for (int i = 0; i < clientList.size(); i++) {
            if (accountNumber.equals(clientList.get(i).getAccountNumber())) {
                if (clientPass.equals(clientList.get(i).getClientPass())) {
                    long sumBal = clientList.get(i).getBalance();
                    if (sumBal >= draw) {
                        long bal = sumBal - draw;
                        clientList.get(i).setBalance(bal);
//                        bankingList.get(i).setWithdraw(draw);
//                        bankingList.get(i).setBankingAt(createdAt);
                        result = clientList.get(i).getBalance();
                        AccountDTO accountDTO = new AccountDTO(accountNumber, 0, draw, createdAt);
                        bankingList.add(accountDTO);
                    } else {
                        System.out.println("출금액이 부족합니다");
                    }
                } else {
                    System.out.println("입력 정보다 틀립니다.");
                }
            }
        }
        return result;
    }

    //입출금내역 조회
    public boolean findAllBanking(String accountNumber) {
        boolean result = false;
        for (int i = 0; i < bankingList.size(); i++) {
            if (accountNumber.equals(bankingList.get(i).getAccountNumber())) {
                System.out.println(bankingList.get(i));
                result = true;
            }
        }
        return result;
    }

    //입금내역 조회
    public boolean findDeposit(String accountNumber) {
        boolean result = false;
        for (int i = 0; i < bankingList.size(); i++) {
            if (accountNumber.equals(bankingList.get(i).getAccountNumber())) {
                System.out.println(bankingList.get(i).getDeposit());
                result = true;
            }
        }
        return result;
    }

    //출금내역 조회
    public boolean findWithdraw(String accountNumber) {
        boolean result = false;
        for (int i = 0; i < bankingList.size(); i++) {
            if (accountNumber.equals(bankingList.get(i).getAccountNumber())) {
                System.out.println(bankingList.get(i).getWithdraw());
                result = true;
            }
        }
        return result;
    }

    public void transfer(String accountNumberFrom, String accountNumberTo, long money) {
        for (int i = 0; i < clientList.size(); i++) {
            if (accountNumberFrom.equals(clientList.get(i).getAccountNumber())) {
                long balance = clientList.get(i).getBalance();
                balance = balance - money;
                clientList.get(i).setBalance(balance);
                AccountDTO accountDTO = new AccountDTO(accountNumberFrom, 0, money, createdAt);
                bankingList.add(accountDTO);
            } else if (accountNumberTo.equals(bankingList.get(i).getAccountNumber())) {
                long balance = clientList.get(i).getBalance();
                balance = balance + money;
                clientList.get(i).setBalance(balance);
                AccountDTO accountDTO = new AccountDTO(accountNumberTo, money, 0, createdAt);
                bankingList.add(accountDTO);
            }
        }
    }

    public BankDTO chackSellerAccountBySellerDTO(SellerDTO sellerDTO) {
        BankDTO result = null;
        for (int i = 0; i < clientList.size(); i++) {
            if (sellerDTO.getAccount().equals(clientList.get(i).getAccountNumber())) {
                result = clientList.get(i);
            }
        }
        return result;
    }

    public String AcccountPass(String accountNum) {
        String result =  null;
        for (int i = 0; i < clientList.size(); i++) {
            if(accountNum.equals(clientList.get(i).getAccountNumber())){
                result=clientList.get(i).getClientPass();

            }
        }
        return  result;
    }
}
