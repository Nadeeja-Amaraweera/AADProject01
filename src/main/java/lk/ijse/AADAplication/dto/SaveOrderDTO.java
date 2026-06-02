package lk.ijse.AADAplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaveOrderDTO {
    private double total;
    private String description;
    private long customerId;
}
