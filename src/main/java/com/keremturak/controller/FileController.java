package com.keremturak.controller;

import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    @GetMapping("/hello")
    public ModelAndView returnHello() {
        ModelAndView md = new ModelAndView();
        md.setViewName("deneme");
        return md;
    }

    @PostMapping("/dosya-yukle")
    public ModelAndView dosyaYukle(@RequestParam("dosya") MultipartFile dosya) throws IOException, TesseractException {
        String tessDataPath = System.getenv("TESSDATA_PREFIX");
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(tessDataPath);
        File tempFile = File.createTempFile("tempImage", dosya.getOriginalFilename());
        dosya.transferTo(tempFile);
        String text = tesseract.doOCR(tempFile);
        System.out.println(text);
        tempFile.delete();
        ModelAndView md = new ModelAndView();
        md.setViewName("deneme");
        md.addObject("yuklenenMetin", text);
        return md;
    }

}
