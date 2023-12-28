package Repository;

import Common.CommonVariables;
import DTO.CommentDTO;

import java.util.ArrayList;
import java.util.List;

public class CommentRepository {
    List<CommentDTO> commentDTOList = new ArrayList<>();

    public boolean save(CommentDTO commentDTO) {//리뷰 리스트 저장
        boolean result = false;
        commentDTOList.add(commentDTO);
        return result;
    }

    public List<CommentDTO> checkCommentById(Long itemId) {//판매자 itemid로 리뷰찾기
        List<CommentDTO> result = null;
        for (int i = 0; i < commentDTOList.size(); i++) {
            if (itemId.equals(commentDTOList.get(i).getItemId())) {
                result.add(commentDTOList.get(i));
            }
        }
        return result;
    }
}
