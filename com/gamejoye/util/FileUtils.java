package com.gamejoye.util;

import com.gamejoye.constant.URLConstants;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileUtils {
    public static boolean upload(MultipartFile file, String path, String fileName) {
        String realPath = path + fileName;
        File dest = new File(realPath);
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Map<String, String> uploadFiles(Map<String, MultipartFile> multipartFileMap) {
        Map<String, String> accessPaths = new HashMap<>();
        multipartFileMap.forEach((key, file) -> {
            String uuid = UUID.randomUUID().toString();
            String[] fileNameSplits = file.getOriginalFilename().split("\\.");
            String newName = uuid + '.' + fileNameSplits[fileNameSplits.length - 1];
            accessPaths.put(key, URLConstants.URL_PATH + newName);
            upload(file, URLConstants.LOCAL_Path, newName);
        });
        return accessPaths;
    }
}
