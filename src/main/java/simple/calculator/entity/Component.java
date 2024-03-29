package simple.calculator.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbImmutable;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
@DynamoDbImmutable(builder = Component.Builder.class)
public class Component {
    private final String name;
    private final String fullname;
    private final String phase;
    private final String ticketType;
    private final String description;
    private final String ownerType;
    public Component(Component.Builder b) {
        this.name = b.name;
        this.fullname = b.fullname;
        this.phase = b.phase;
        this.ticketType = b.ticketType;
        this.description = b.description;
        this.ownerType = b.ownerType;
    }
    public static Component.Builder builder() {
        return new Component.Builder();
    }
    @DynamoDbPartitionKey
    public String name() {
        return this.name;
    }

    public String fullname() {
        return this.fullname;
    }
    public String phase() {
        return this.phase;
    }
    public String ticketType() {
        return this.ticketType;
    }

    public String description() {
        return this.description;
    }

    public String ownerType() {
        return this.ownerType;
    }
    public static final class Builder {
        private String name;
        private String fullname;
        private String phase;
        private String ticketType;
        private String description;
        private String ownerType;

        public Component.Builder name(String name) {
            this.name = name;
            return this;
        }
        public Component.Builder fullname(String fullname) {
            this.fullname = fullname;
            return this;
        }
        public Component.Builder phase(String phase) {
            this.phase = phase;
            return this;
        }
        public Component.Builder ticketType(String ticketType) {
            this.ticketType = ticketType;
            return this;
        }
        public Component.Builder description(String description) {
            this.description = description;
            return this;
        }
        public Component.Builder ownerType(String ownerType) {
            this.ownerType = ownerType;
            return this;
        }
        public Component build() {
            return new Component(this);
        }
    }
}
