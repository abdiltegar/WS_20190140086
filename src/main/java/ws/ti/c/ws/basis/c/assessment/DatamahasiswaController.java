/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.ti.c.ws.basis.c.assessment;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Tegar
 */
@Controller
public class DatamahasiswaController {
    @CrossOrigin
    @RequestMapping(value = "/assessment_json", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseBody
    public List<Datamahasiswa> getJSONMahasiswa() {
        DatamahasiswaJpaController controller = new DatamahasiswaJpaController();
        List<Datamahasiswa> buffer = new ArrayList<>();
        try{
            buffer = controller.findDatamahasiswaEntities();
        }catch(Exception error){}
        
        return buffer;
    }
    
    @CrossOrigin
    @RequestMapping(value = "/assessment_xml", produces = {
        MediaType.APPLICATION_XML_VALUE
    })
    @ResponseBody
    public List<Datamahasiswa> getXMLMahasiswa() {
        DatamahasiswaJpaController controller = new DatamahasiswaJpaController();
        List<Datamahasiswa> buffer = new ArrayList<>();
        try{
            buffer = controller.findDatamahasiswaEntities();
        }catch(Exception error){}
        
        return buffer;
    }
}
