package simple.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComponentDto {
    private String name;
    private String fullname;
    private String phase;
    private String ticketType;
    private String description;
    private String ownerType;
}
