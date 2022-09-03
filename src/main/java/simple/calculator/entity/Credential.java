package simple.calculator.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbImmutable;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
@DynamoDbImmutable(builder = Credential.Builder.class)
public class Credential {
    private final int id;
    private final String company;
    private final String userName;
    private final String passCode;

    public Credential(Builder b) {
        this.id = b.id;
        this.company = b.company;
        this.userName = b.userName;
        this.passCode = b.passCode;
    }
    public static Builder builder() {
        return new Builder();
    }
    @DynamoDbPartitionKey
    public int id() {
        return this.id;
    }
    public String company () {
        return this.company;
    }
    public String userName () {
        return this.userName;
    }
    public String passCode () {
        return this.passCode;
    }
    public static final class Builder {
        private int id;
        private String company;
        private String userName;
        private String passCode;

        public Builder id(int id) {
            this.id = id;
            return this;
        }
        public Builder company(String company) {
            this.company = company;
            return this;
        }
        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }
        public Builder passCode(String passCode) {
            this.passCode = passCode;
            return this;
        }
        public Credential build() {
            return new Credential(this);
        }
    }
}
