package com.jkc.mydesk.file.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

import java.net.URI;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(R2Properties.class)
public class R2Config {

    // R2는 region 개념이 없어 "auto" 사용
    private static final Region R2_REGION = Region.of("auto");

    private final R2Properties properties;

    // HeadObject, DeleteObject 등 서버에서 직접 호출하는 요청용
    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .endpointOverride(URI.create(properties.endpoint()))
                .region(R2_REGION)
                .credentialsProvider(credentialsProvider())
                .serviceConfiguration(serviceConfiguration())
                .build();
    }

    // 클라이언트가 R2에 직접 업로드/다운로드할 Presigned URL 발급용
    @Bean
    public S3Presigner s3Presigner() {
        return S3Presigner.builder()
                .endpointOverride(URI.create(properties.endpoint()))
                .region(R2_REGION)
                .credentialsProvider(credentialsProvider())
                .serviceConfiguration(serviceConfiguration())
                .build();
    }

    private StaticCredentialsProvider credentialsProvider() {
        return StaticCredentialsProvider.create(
                AwsBasicCredentials.create(properties.accessKey(), properties.secretKey())
        );
    }

    private S3Configuration serviceConfiguration() {
        return S3Configuration.builder()
                .pathStyleAccessEnabled(true)
                .build();
    }
}
