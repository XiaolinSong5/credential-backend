package simple.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculator {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleCalculator.class);
    public Calculation add(Calculation calculation) {
        LOGGER.debug("first + second is " , calculation.getFirstNumber() + calculation.getSecondNumber());
        calculation.setResult(calculation.getFirstNumber() + calculation.getSecondNumber());
        return calculation;
    }
    public double subtract(int a, int b) {
        return a - b;
    }
    public double multiply(int a, int b) {
        return a*b;
    }
    public double divide(int a, int b) {
        return a / b;
    }
}
