package simple.calculator.repository;

import org.springframework.stereotype.Repository;
import simple.calculator.Calculation;
import simple.calculator.entity.Component;
import software.amazon.awssdk.core.async.SdkPublisher;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class ComponentRepository  extends GenericRepository {
    public void create (Calculation calculation) {
        DynamoDbAsyncTable<Component> table =  getAsyncTable(Component.class);
        Component component = Component.builder()
                .name("PAO")
                .fullname("to do")
                .ticketType("")
                .description("marktprijs 2 jr broker, API")
                .ownerType("external")
                .build();
        Component component1 = Component.builder()
                .name(calculation.getName())
                .fullname(calculation.getFullname())
                .phase(calculation.getPhase())
                .ticketType(calculation.getTicketType())
                .description(calculation.getDescription())
                .ownerType(calculation.getOwnerType())
                .build();
        table.putItem(component1);
    }
    public Set<Component> findAll () {
        DynamoDbAsyncTable<Component> table =  getAsyncTable(Component.class);
        SdkPublisher<Page<Component>> publisher =table.scan();
        Set<Component> entities = new HashSet<>();
        publisher.subscribe(connectorPage -> {
                    connectorPage.items().forEach(connector -> {
                                entities.add(connector);
                            }
                    );
                }
        ).join();

        return entities;
    }
}
