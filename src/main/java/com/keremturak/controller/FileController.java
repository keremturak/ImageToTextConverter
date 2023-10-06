package com.keremturak.controller;

import com.keremturak.service.FileService;
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
@RequestMapping("/file")
public class FileController {
    private final FileService fileService;
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/hello")
    public ModelAndView returnHello() {
        return fileService.returnHello();
    }

    @PostMapping("/dosya-yukle")
    public ModelAndView dosyaYukle(@RequestParam("dosya") MultipartFile dosya) throws IOException, TesseractException {
        return fileService.dosyaYukle(dosya);
    }

}
