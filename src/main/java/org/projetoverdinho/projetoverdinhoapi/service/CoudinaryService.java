package org.projetoverdinho.projetoverdinhoapi.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Configuration
public class CoudinaryService {

    private Cloudinary cloudinary;

    public void CloudinaryService() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "SEU_CLOUD_NAME",
                "api_key", "SUA_API_KEY",
                "api_secret", "SEU_API_SECRET"
        ));
    }

    public String upload(MultipartFile file, String folder) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder", folder));
        return (String) uploadResult.get("secure_url");
    }
}
