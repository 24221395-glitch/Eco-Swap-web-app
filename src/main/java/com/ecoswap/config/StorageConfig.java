package com.ecoswap.config;

import com.ecoswap.storage.LocalStorageService;
import com.ecoswap.storage.StorageService;
import java.nio.file.Path;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Selects the storage implementation. Only local disk exists today; an object-storage bean
 * (S3 / R2) would be returned here based on configuration.
 */
@Configuration
public class StorageConfig {

    @Bean
    StorageService storageService(AppProperties props) {
        return new LocalStorageService(Path.of(props.storage().localDir()));
    }
}
