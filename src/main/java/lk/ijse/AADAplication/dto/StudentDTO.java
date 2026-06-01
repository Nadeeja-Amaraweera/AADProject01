package lk.ijse.AADAplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private long studentId;
    private String firstName;
    private String lastName;
    private String dob;
    private String address;

    private long schoolId;

    public StudentDTO(long studentId, String firstName, String lastName, String dob, String address) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
    }
}
