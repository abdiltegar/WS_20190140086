/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.ti.c.ws.basis.c.dummy;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Tegar
 */
@Controller
public class PribadiLogicController {
    @RequestMapping(value = "/cobadummy", produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Pribadi> getDummyData(){
        
        PribadiJpaController controller = new PribadiJpaController();
        List<Pribadi> buffer = new ArrayList<>();
        try{
            buffer = controller.findPribadiEntities();
        }catch(Exception error){}
        
        return buffer;
    }
}
