package Repository;

import DTO.ManagerDTO;

import java.util.ArrayList;
import java.util.List;

public class ManagerRepository {
    List<ManagerDTO>managerDTOList = new ArrayList<>();
    public boolean ChackEmail(String email) {//이메일 체크
        boolean result = false;
        for (int i = 0; i < managerDTOList.size(); i++) {
            if(email.equals(managerDTOList.get(i).getEmail())){
                result = true;
            }
        }
        return result;
    }
    public ManagerDTO save(ManagerDTO managerDTO) {//관리자 회원가입
        managerDTOList.add(managerDTO);
        return managerDTO;
    }
}
