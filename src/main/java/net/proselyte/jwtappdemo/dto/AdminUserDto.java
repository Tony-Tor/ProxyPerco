package net.proselyte.jwtappdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import net.proselyte.jwtappdemo.model.Status;
import net.proselyte.jwtappdemo.model.User;

/**
 * DTO class for user requests by ROLE_ADMIN
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String username;
    private String status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setStatus(Status.valueOf(status));
        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUsername(user.getUsername());
        adminUserDto.setStatus(user.getStatus().name());
        return adminUserDto;
    }
}
