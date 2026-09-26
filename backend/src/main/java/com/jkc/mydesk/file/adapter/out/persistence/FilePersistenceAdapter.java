package com.jkc.mydesk.file.adapter.out.persistence;

import com.jkc.mydesk.file.application.port.out.FileRepository;
import com.jkc.mydesk.file.domain.model.File;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.InputStream;

@Component
@RequiredArgsConstructor
public class FilePersistenceAdapter implements FileRepository {
    private final FileJpaRepository fileJpaRepository;
    private final S3Client s3Client;

    @Value("${cloudflare.r2.bucket}")
    private String bucket;

    @Transactional
    public File upload(File file, InputStream inputStream) {
        FileJpaEntity entity = FileJpaEntity.from(file);

        String objectKey = file.getObjectKey();

        try {
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(objectKey)
                    .contentType(file.getContentType())
                    .contentLength(file.getSize())
                    .build();

            s3Client.putObject(
                    putObjectRequest,
                    RequestBody.fromInputStream(inputStream, file.getSize())
            );
        } catch (RuntimeException e) {
            throw new RuntimeException("임시 조치임. presigned로 변경 예정", e);
        }


        return fileJpaRepository.save(entity)
                .toDomain();
    }
}
