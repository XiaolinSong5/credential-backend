package simple.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

import java.net.URI;
@Configuration
public class DynamoDbConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamoDbConfig.class);

    @Value("${DYNAMO_ENDPOINT}")
    private String awsDynamoDBEndPoint;

    @Value("${AWS_REGION}")
    private String awsDynamoDBRegion;

    /**
     * Get DynamoDb enhanced async client
     *
     * @return DynamoDbEnhancedAsyncClient
     */
    @Bean
    public DynamoDbEnhancedAsyncClient getDynamoDbEnhancedAsyncClient() {
        return DynamoDbEnhancedAsyncClient.builder()
                .dynamoDbClient(getDynamoDbAsyncClient())
                .build();
    }

    private DynamoDbAsyncClient getDynamoDbAsyncClient() {
        LOGGER.debug("Environment variable awsDynamoDBEndPoint: ", awsDynamoDBEndPoint);
        LOGGER.debug("Environment variable awsDynamoDBRegion: ", awsDynamoDBRegion);
        return DynamoDbAsyncClient.builder()
                .credentialsProvider(DefaultCredentialsProvider.builder().build())
                .region(Region.of(awsDynamoDBRegion))
                .endpointOverride(URI.create(awsDynamoDBEndPoint))
                .build();
    }
}
