package pl.adam.puremvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by SkyNET on 2017-11-14.
 */

@Controller
@RequestMapping("file")
public class FileController {

    //Pobieranie pliku z resource
    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        File file = new File(getClass().getClassLoader().getResource("WEB-INF/download/justin.jpg").getFile());
        System.out.println("---------------------------------");
        System.out.println((file == null)+ " size: " + file.length());
        InputStream inputStream = new FileInputStream(file);
        response.setContentType("image/jpg");
//        response.setContentLengthLong(file.length()); A Strange Error
        response.setHeader("Content-Disposition", "attachment; fileName=profesor.jpg");//Pozwala ściagac jako plik(załącznik, bez tego nagłówka wstawiany jest do przegladarki)
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

}
