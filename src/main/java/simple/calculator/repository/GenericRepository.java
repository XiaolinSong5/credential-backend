package simple.calculator.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;

public class GenericRepository {
    @Autowired
    DynamoDbEnhancedAsyncClient dbEnhancedAsyncClient;
    DynamoDbAsyncTable table;
    DynamoDbAsyncTable getAsyncTable(@NonNull final Class tableClass) {
        try {
            table = dbEnhancedAsyncClient.table(tableClass.getSimpleName(), TableSchema.fromImmutableClass(tableClass));
        } catch (ResourceNotFoundException exception) {
            throw exception;
        }
        return table;
    }
}
