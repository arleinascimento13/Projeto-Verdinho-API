package org.projetoverdinho.projetoverdinhoapi.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

public class Optimizer {
    public static FileOutputStream image(MultipartFile image) throws IOException {
        BufferedImage inputImage = ImageIO.read( image.getInputStream());
/*
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(image.getContentType());
        ImageWriter writer = writers.next();

        OutputStream writer = new BufferedOutputStream(new);
        ImageWriteParam params = writer.getDefaultWriteParam();
        params.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        params.setCompressionQuality(0.5f);
*/
        //writer.write(null, new IIOImage(inputImage, null, null), params);
        return null;
    }
}
