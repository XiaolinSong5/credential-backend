package simple.calculator.repository;

import org.springframework.beans.factory.annotation.Autowired;
import simple.calculator.entity.Credential;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;

public class CredentialRepository implements Repository {
    @Autowired
    DynamoDbEnhancedAsyncClient dbEnhancedAsyncClient;
    @Override
    public void create(Credential credential) {

    }
}
