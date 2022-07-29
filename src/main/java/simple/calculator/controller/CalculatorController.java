package simple.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import simple.calculator.Calculation;
import simple.calculator.SimpleCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE}, exposedHeaders = "Content-Disposition")
public class CalculatorController {
    @Autowired
    private SimpleCalculator service;
  //  @CrossOrigin(origins="http://localhost:4200", exposedHeaders = "Content-Disposition")
    @PostMapping("/add")
    public double addCalculation(@RequestBody Calculation calculation) {
        String sql = "insert into calculation values (?,?,?,?,?)";

        System.out.println("add Pair: "+ calculation);
        Calculation entity =  service.add(calculation);
       // int a = jdbcTemplate.update(sql, 4,  entity.getFirstNumber(), entity.getSecondNumber(), "add", entity.getResult());
        return entity.getResult();
    }
    @DeleteMapping("/delete")
    public double deleteCredential() {
        String sql = "insert into calculation values (?,?,?,?,?)";
        Calculation calculation = null;
        System.out.println("deleting credential : "+ calculation);
        Calculation entity =  service.add(calculation);
        // int a = jdbcTemplate.update(sql, 4,  entity.getFirstNumber(), entity.getSecondNumber(), "add", entity.getResult());
        return entity.getResult();
    }
    @PostMapping("/subtract")
    public double subtract (@RequestParam(name = "first") int first, @RequestParam(name = "second") int second) {
        return service.subtract(first, second);
    }
    @GetMapping("/calculations")
    public List<Calculation> getCalculations () {
        System.out.println(Arrays.asList("GET","POST"));
        System.out.println("get Pair: ");
        String sql = "select * from calculation";
        List calculations = new ArrayList();
        Calculation calculation1 = Calculation.builder()
                .id(1)
                .firstNumber(2)
                .secondNumber(3)
                .result(5)
                .build();
        calculations.add(calculation1);
        Calculation calculation2 = Calculation.builder()
                .id(2)
                .firstNumber(5)
                .secondNumber(6)
                .result(11)
                .build();
        calculations.add(calculation2);

                //jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Calculation.class));

        return calculations;
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://example.com"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
