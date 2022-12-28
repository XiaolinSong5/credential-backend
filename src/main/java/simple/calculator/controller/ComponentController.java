package simple.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import simple.calculator.Calculation;
import simple.calculator.dto.ComponentDto;
import simple.calculator.entity.Component;
import simple.calculator.repository.ComponentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins="http://localhost:4200", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE}, exposedHeaders = "Content-Disposition")
public class ComponentController {
    @Autowired
    private ComponentRepository repository;
    @PostMapping("/create")
    public void create (@RequestBody Calculation calculation) {
        repository.create(calculation);
    }
    @GetMapping("/components")
    public ResponseEntity getCalculations () {
        Set<Component> a = repository.findAll();
        return new ResponseEntity(getConnectorDtos(a), HttpStatus.OK);
    }
    List<ComponentDto> getConnectorDtos(Set<Component> entities) {
        List<ComponentDto> dtos = new ArrayList<>();
        entities.forEach(component -> {
            dtos.add(ComponentDto.builder()
                            .name(component.name())
                            .description(component.description())
                            .phase(component.phase())
                    .build());
        }
        );
        return dtos;
    }
}
