package com.jkc.mydesk.file.application.port.out;

import com.jkc.mydesk.file.domain.model.File;

import java.io.InputStream;

public interface FileRepository {
    File upload(File file, InputStream inputStream);
}
