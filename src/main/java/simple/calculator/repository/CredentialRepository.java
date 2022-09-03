package simple.calculator.repository;

import org.springframework.beans.factory.annotation.Autowired;
import simple.calculator.entity.Component;
import simple.calculator.entity.Credential;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;

public class CredentialRepository extends GenericRepository implements Repository {
    @Autowired
    DynamoDbEnhancedAsyncClient dbEnhancedAsyncClient;
    @Override
    public void create(Credential credential) {
        DynamoDbAsyncTable<Credential> table =  getAsyncTable(Credential.class);
        Credential credential1 = Credential.builder()
                .id(1)
                .company("X")
                .passCode("123")
                .userName("xiaolin")
                .build();

    }
}
