package br.edu.ufersa.blockbuster.libs;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class UploadImage {

    public static boolean makeUploadImage(MultipartFile image) {

        boolean successUpload = false;

        if (!image.isEmpty()) {
            String filename = image.getOriginalFilename();

            try {
                String dirUploadImage = "src/main/resources/uploads";
                File dir = new File(dirUploadImage);

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + filename);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(image.getBytes());
                stream.close();

                successUpload = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return successUpload;
    }

}
