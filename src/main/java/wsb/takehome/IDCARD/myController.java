/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wsb.takehome.IDCARD;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author OS
 */
@Controller
public class myController {
    @RequestMapping("/kirimData")
    public String getData(@RequestParam("myName") String name,
                          @RequestParam("myImage") MultipartFile image,
                          @RequestParam("myaddress") String address,
                          @RequestParam("myDate")
                          @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
                          Model model) throws IOException{
        String blob = Base64.encodeBase64String(image.getBytes());
        String img ="data:image/png;base64,".concat(blob);
        SimpleDateFormat tanggal = new SimpleDateFormat("dd-MMMM-yyyy");
        String newTanggal = tanggal.format(date);
        
        model.addAttribute("nama", name);
        model.addAttribute("tanggal", newTanggal);
        model.addAttribute("alamat", address);
        model.addAttribute("foto", img);
        
        return"main";
    }
}
