package com.project.swipe.fileManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileManagerImpl implements FileManager {
    public static final Path NAME_ROOT_FOLDER = Paths.get("swipeFiles");
    public static final Path ABSOLUTE_FILE_SOURCE_FOLDER_PATH = Paths.get(System.getProperty("user.dir")).getParent();

    private Path relativePathToFile;
    private Logger logger = LogManager.getLogger(FileManagerImpl.class.getName());

    private void createDirectory(Path path) {
        logger.info("create directory");

        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);

            } catch (IOException exception) {
                logger.error(exception.getMessage());
            }

        }
    }

    @Override
    public Path uploadFile(TypesFile fileType, MultipartFile userFile) {
        try {
            logger.info("uploading file");
            relativePathToFile = NAME_ROOT_FOLDER.resolve(fileType.getNameFolder()).resolve(UUID.randomUUID().toString()
                    + userFile.getOriginalFilename());
            createDirectory(ABSOLUTE_FILE_SOURCE_FOLDER_PATH.resolve(relativePathToFile.getParent()));
            userFile.transferTo(ABSOLUTE_FILE_SOURCE_FOLDER_PATH.resolve(relativePathToFile));

            return relativePathToFile;
        } catch (IOException exception) {
            logger.error(exception.getMessage());
            exception.fillInStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteFile(Path path) {
        logger.info("delete file" + path);
        try {
            Files.delete(ABSOLUTE_FILE_SOURCE_FOLDER_PATH.resolve(path));
            return true;
        } catch (IOException exception) {
            logger.error(exception.getMessage());
            return false;
        }

    }
}
