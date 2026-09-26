package com.jkc.mydesk.file.domain.model;

import com.jkc.mydesk.common.domain.model.BaseModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class File extends BaseModel {
    private Long id;
    private Long folderId;
    private String originalName;
    private String objectKey;
    private String contentType;
    private long size;

    private FileUploadStatus uploadStatus;

    public void changeFileUploadStatus(FileUploadStatus uploadStatus) {
        this.uploadStatus = uploadStatus;
    }
}
