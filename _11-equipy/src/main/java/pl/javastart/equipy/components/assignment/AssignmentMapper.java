package pl.javastart.equipy.components.assignment;

import pl.javastart.equipy.components.inventory.asset.Asset;
import pl.javastart.equipy.components.user.User;

public class AssignmentMapper {

    static AssignmentDto toDto(Assignment assignment) {
        AssignmentDto dto = new AssignmentDto();
        User user = assignment.getUser();
        Asset asset = assignment.getAsset();
        dto.setId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());
        dto.setUserId(user.getId());
        dto.setAssetId(asset.getId());
        return dto;
    }

}
