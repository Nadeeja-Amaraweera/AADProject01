package lk.ijse.AADAplication.Entity;

import jakarta.persistence.*;
import lk.ijse.AADAplication.enumaration.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String firstName;
    private String lastName;
    private Date dob;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
}
