package org.projetoverdinho.projetoverdinhoapi.service;

import org.projetoverdinho.projetoverdinhoapi.util.Uploader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
    public String save(MultipartFile image){
            return Uploader.image(image);
    }
}
