package simple.calculator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Calculation {
    private int id;
    private int firstNumber;
    private int secondNumber;
    private String operator;
    private double result;
    private String name;
    private String fullname;
    private String ticketType;
    private String description;
    private String ownerType;
}
