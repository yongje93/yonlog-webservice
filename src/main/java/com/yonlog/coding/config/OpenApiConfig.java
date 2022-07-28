package com.yonlog.coding.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringDoc 설정
 *
 * @author yonlog
 */
@OpenAPIDefinition(info =
    @Info(title = "검색엔진을 활용한 검색 시스템",
            description = "API 명세서",
            version = "1.0"
    )
)
@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi defaultApi() {
        String[] packagesToScan = {"com.yonlog.coding"};

        return GroupedOpenApi.builder().group("default").packagesToScan(packagesToScan).build();
    }
}
