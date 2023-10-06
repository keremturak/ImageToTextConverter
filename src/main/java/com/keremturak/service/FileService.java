package com.keremturak.service;

import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileService {
    public ModelAndView returnHello() {
        ModelAndView md = new ModelAndView();
        md.setViewName("deneme");
        return md;
    }

    public ModelAndView dosyaYukle(@RequestParam("dosya") MultipartFile dosya) throws IOException, TesseractException {
        String tessDataPath = System.getenv("C:\\Users\\kerim\\Desktop\\Yeni klasör\\boşjava\\Tess4J\\tessdata");
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(tessDataPath);
        File tempFile = File.createTempFile("tempImage", dosya.getOriginalFilename());
        dosya.transferTo(tempFile);
        String text = tesseract.doOCR(tempFile);
        tempFile.delete();
        ModelAndView md = new ModelAndView();
        md.setViewName("deneme");
        md.addObject("yuklenenMetin", text);
        return md;
    }

}
