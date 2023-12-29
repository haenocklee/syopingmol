package Service;

import Common.CommonVariables;
import DTO.AnnouncementDTO;
import DTO.ManagerDTO;
import Repository.AnnouncementRepository;
import Repository.ManagerRepository;

import java.util.List;
import java.util.Scanner;

public class ManagerService {
    Scanner scanner = new Scanner(System.in);
    ManagerRepository managerRepository = new ManagerRepository();
    AnnouncementRepository announcementRepository = new AnnouncementRepository();


    public void save() {
        System.out.println("[관리자 회원가입]");
        System.out.print("이름: ");
        String name = scanner.next();
        System.out.print("비밀번호: ");
        String pass = scanner.next();
        System.out.print("이메일: ");
        String email = scanner.next();
        System.out.print("전화번호: ");
        String mobile = scanner.next();
        System.out.print("계좌: ");
        String account = scanner.next();
        ManagerDTO managerDTO = new ManagerDTO(name, pass, email, mobile, account);
        ManagerDTO result = managerRepository.save(managerDTO);
        if (result != null) {
            System.out.println("회원가입 완료");
        } else {
            System.out.println("회원가입 실패");
        }
    }

    public void announcementSave() {
        System.out.println("작성자: " + CommonVariables.managerEmail);
        String managerEmail = CommonVariables.managerEmail;
        System.out.print("제목: ");
        String title = scanner.next();
        System.out.print("내용: ");
        String contents = scanner.next();
        AnnouncementDTO announcementDTO = new AnnouncementDTO(managerEmail, title, contents);
        AnnouncementDTO resultSave = announcementRepository.announcementSave(announcementDTO);
        if (resultSave != null) {
            System.out.println("resultSave = " + resultSave);
            System.out.println("저장완료");
        } else {
            System.out.println("저장실패");
        }
    }

    public void announcementFindAll() {
        List<AnnouncementDTO> announcementDTOS = announcementRepository.announcementFindAll();
        if (announcementDTOS != null) {
            System.out.println("announcementDTOS = " + announcementDTOS);
        }
        System.out.println("정보가 없습니다.");
    }

    public void announcementFindByEmail() {
        List<AnnouncementDTO> announcementDTOS = announcementRepository.announcementFindByEmail();
        if (announcementDTOS != null) {
            System.out.println("announcementDTOS = " + announcementDTOS);
        }
        System.out.println("정보가 없습니다.");
    }

    public void announcementUpdate() {
        System.out.print("수정할 공지사항 id 입력: ");
        Long id = scanner.nextLong();
        boolean resultchackById = announcementRepository.chackById(id);
        if (!resultchackById) {
            System.out.println("자신이 작성한 공지만 수정가능합니다");
            System.out.println("id값이 틀립니다 다시입력해주세요.");
            announcementUpdate();
        }
        System.out.print("제목 수정: ");
        String title = scanner.next();
        System.out.print("내용 수정: ");
        String contents = scanner.next();
        boolean resultUpdate = announcementRepository.announcementUpdate(id, title, contents);
        if (resultUpdate) {
            System.out.println("수정완료");
        } else {
            System.out.println("수정실패");
        }
    }

    public void login() {
        if (CommonVariables.managerEmail == null) {
            System.out.print("이메일 입력: ");
            String email = scanner.next();
            System.out.print("비밀번호 입력: ");
            String pass = scanner.next();
            boolean result = managerRepository.login(email, pass);
            if (result) {
                System.out.println("로그인 완료 " + email + "님 환영합니다.");
            } else {
                System.out.println("로그인 실패 입력하신 정보가 틀립니다.");
            }
        } else {
            System.out.println("이미 로그인 상태입니다.");
        }
    }

}
