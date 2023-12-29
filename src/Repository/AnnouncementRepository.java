package Repository;

import Common.CommonVariables;
import DTO.AnnouncementDTO;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementRepository {
    List<AnnouncementDTO> announcementDTOList = new ArrayList<>();

    public AnnouncementDTO announcementSave(AnnouncementDTO announcementDTO) {//공지 저장
        announcementDTOList.add(announcementDTO);
        return announcementDTO;
    }

    public List<AnnouncementDTO> announcementFindAll() {//전체공지 확인
        return announcementDTOList;
    }

    public List<AnnouncementDTO> announcementFindByEmail() {//관리자가 작성한 모든 공지확인
        List<AnnouncementDTO> result = null;
        String managerEmail = CommonVariables.managerEmail;
        for (int i = 0; i < announcementDTOList.size(); i++) {
            if (managerEmail.equals(announcementDTOList.get(i).getManagerEmail())) {
                result.add(announcementDTOList.get(i));
            }
        }
        return result;
    }

    public boolean chackById(Long id) {//관리자의 작성 공지가 맞는지 id와 email을 비교
        boolean result = false;
        for (int i = 0; i < announcementDTOList.size(); i++) {
            if(id.equals(announcementDTOList.get(i).getAnnouncementId())&&CommonVariables.managerEmail.equals(announcementDTOList.get(i).getManagerEmail())){
                result = true;
            }
        }
        return result;
    }

    public boolean announcementUpdate(Long id, String title,String contents) {
        boolean result = false;
        String managerEmail  = CommonVariables.managerEmail;
        for (int i = 0; i < announcementDTOList.size(); i++) {
            if(id.equals(announcementDTOList.get(i).getAnnouncementId())&&managerEmail.equals(announcementDTOList.get(i).getManagerEmail())){
                announcementDTOList.get(i).setTitle(title);
                announcementDTOList.get(i).setContents(contents);
                result = true;
            }
        }
        return result;
    }
}
