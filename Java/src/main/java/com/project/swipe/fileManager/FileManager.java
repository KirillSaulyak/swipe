package com.project.swipe.fileManager;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileManager {

    Path uploadFile(TypesFile fileType, MultipartFile userFile);

    boolean deleteFile(Path path);
}
