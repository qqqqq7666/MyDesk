package com.jkc.mydesk.file.adapter.out;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties("cloudflare.r2")
public record R2Properties(
        String endpoint,
        String bucket,
        String accessKey,
        String secretKey,
        Duration presignedUrlExpiration
) {
}
