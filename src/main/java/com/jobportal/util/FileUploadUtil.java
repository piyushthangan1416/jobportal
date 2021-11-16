package com.jobportal.util;

import com.jobportal.entities.UserProfile;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {

    public static void saveFile(MultipartFile multipartFile, UserProfile userProfile) {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = "user-photos/" + userProfile.getUserId();
        userProfile.setProfilePhotoFileName("/"+uploadDir+"/"+fileName);
        Path uploadPath = Paths.get(uploadDir);
        try (InputStream inputStream = multipartFile.getInputStream()) {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            userProfile.setProfilePhotoPath(filePath.toFile().getAbsolutePath());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void saveResumeFile(MultipartFile resume, UserProfile profile) {
        String fileName = StringUtils.cleanPath(resume.getOriginalFilename());
        String uploadDir = "user-photos/" + profile.getUserId();
        profile.setResumeFileName("/"+uploadDir+"/"+fileName);
        Path uploadPath = Paths.get(uploadDir);
        try (InputStream inputStream = resume.getInputStream()) {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            profile.setResumePath(filePath.toFile().getAbsolutePath());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
