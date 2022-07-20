package simple.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
@CrossOrigin(origins="http://localhost:4200", methods = {RequestMethod.POST, RequestMethod.GET}, exposedHeaders = "Content-Disposition")
public class CalculatorController {
    @Autowired
    private SimpleCalculator service;
    @Autowired
    private JdbcTemplate jdbcTemplate;
  //  @CrossOrigin(origins="http://localhost:4200", exposedHeaders = "Content-Disposition")
    @PostMapping("/add")
    public double addCalculation(@RequestBody Calculation calculation) {
        String sql = "insert into calculation values (?,?,?,?,?)";

        System.out.println("add Pair: "+ calculation);
        Calculation entity =  service.add(calculation);
        int a = jdbcTemplate.update(sql, 4,  entity.getFirstNumber(), entity.getSecondNumber(), "add", entity.getResult());
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
        List calculations = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Calculation.class));

//        calculations.add(Calculation.builder()
//                .id(1)
//                .firstNumber(2)
//                .secondNumber(5)
//                .result(7.0)
//                .build());
//        calculations.add(Calculation.builder()
//                .id(2)
//                .firstNumber(6)
//                .secondNumber(5)
//                .result(11.0)
//                .build());
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
