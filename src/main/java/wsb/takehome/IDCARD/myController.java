/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wsb.takehome.IDCARD;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author OS
 */
@Controller
public class myController {
    @RequestMapping("/kirimData")
    @ResponseBody
    public String getData(){
        
        return "oke";
    }
}
