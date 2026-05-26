package lk.ijse.AADAplication.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lk.ijse.AADAplication.enumaration.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long userId;
    private String firstName;
    private String lastName;
    private Date dob;
    private UserStatus userStatus;
}
