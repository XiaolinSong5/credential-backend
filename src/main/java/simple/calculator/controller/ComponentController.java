package simple.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import simple.calculator.Calculation;
import simple.calculator.repository.ComponentRepository;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE}, exposedHeaders = "Content-Disposition")
public class ComponentController {
    @Autowired
    private ComponentRepository repository;
    @PostMapping("/create")
    public void create (@RequestBody Calculation calculation) {
        repository.create(calculation);
    }
}
