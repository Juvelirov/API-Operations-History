package ru.netology.adenisov.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "operations.processing")
public class OperationsProcessingProperties {
    private int timeout;
}
