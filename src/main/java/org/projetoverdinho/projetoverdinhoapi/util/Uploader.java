package org.projetoverdinho.projetoverdinhoapi.util;

import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public class Uploader {
    public static String image(MultipartFile image){
           /*Inicio trabalhar no sistema de arquivos*/
           if(!image.isEmpty()){
               try {
               /* Inicio Area de criação de arquivos para uploads */
               String uploadsPath = System.getProperty("user.dir") + File.separator +
                       "uploads";
               File novoArquivo = new File(uploadsPath  + File.separator  + "images");
               if(!novoArquivo.isFile()){
                   novoArquivo.mkdirs();
               }
               /* Fim Area de criação de arquivos para uploads */



               /* Inicio Salvar imagem */

                   File arquivoImagem = new File(uploadsPath + File.separator  + "images" + File.separator + System.currentTimeMillis() + image.getOriginalFilename());
                   BufferedImage inputImage = ImageIO.read(image.getInputStream());

                   String contentType = image.getContentType();
                   String extensao = contentType.substring(contentType.indexOf("/") + 1);

                   Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(extensao);
                   ImageWriter writer = writers.next();


                   /* Inicio Area de compressão */
                   ImageWriteParam params = writer.getDefaultWriteParam();
                   params.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                   params.setCompressionQuality(0.5f);
                   /* Fim Area de compressão */

                   ImageOutputStream outputStream = ImageIO.createImageOutputStream(arquivoImagem);
                   writer.setOutput(outputStream);

                   writer.write(null, new IIOImage(inputImage, null, null), params);
                   outputStream.close();
                   writer.dispose();
                   /*BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(arquivoImagem));
               stream.write(image.getBytes());
               stream.close();
*/

               System.out.println("Imagem carregada no sistema");
               System.out.println("Path :" + arquivoImagem.getAbsolutePath());
               /* Fim Salvar imagem*/
               return arquivoImagem.getAbsolutePath();
            }catch (Exception e){
               e.printStackTrace();
               }
           }
           /*Fim trabalhar no sistema de arquivos*/

        return null;
    }
}
