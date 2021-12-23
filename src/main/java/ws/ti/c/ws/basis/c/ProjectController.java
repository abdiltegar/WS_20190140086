/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.ti.c.ws.basis.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author Tegar
 */
@Controller
public class ProjectController {
    
    ArrayList<String> buku = new ArrayList<>();
        
    @RequestMapping("/addbook")
    @ResponseBody
    public String createbook(HttpServletRequest data){
        String result = "One book added successfully";
        String title = data.getParameter("buku");
        buku.add(title);
        return result+title;
    }
    
    @RequestMapping(value = "/data/mahasiswa", produces={
        MediaType.APPLICATION_XML_VALUE
    })
    @ResponseBody
    public ArrayList<String> getDataMhs(){
        ArrayList<String> result = new ArrayList<>();
        result.add("2019C");
        result.add("2020A");
        result.add("2021B");
        return result;
    }
    
    @GetMapping(value = "/data/product", produces={
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseBody
    public ArrayList<String> getDataProduct(){
        ArrayList<String> result = new ArrayList<>();
        result.add("Mouse");
        result.add("Keyboard");
        result.add("Monitor");
        return result;
    }
    
    @GetMapping(value = "/data/tes", produces={
        MediaType.APPLICATION_XML_VALUE
    })
    @ResponseBody
    public ArrayList<List<String>> getDataTes(){
        ArrayList<List<String>> daftar = new ArrayList<>();//resource data
        ArrayList<List<String>> senddata = new ArrayList<>();//data setelah search
        
        daftar.add(Arrays.asList("Motor","Sapra"));
        daftar.add(Arrays.asList("Mobil","Nyaris"));
        daftar.add(Arrays.asList("Pesawat","Airbis"));
        return daftar;
    }
    
//    @CrossOrigin
//    @RequestMapping(value = "/xmlBook", produces = {
//        MediaType.APPLICATION_XML_VALUE
//    })
//    @ResponseBody
//    public ArrayList<String> getXMLBook() {
//        Book buku = new Book();
//        return buku.newBook();
//    }
//    
//    @CrossOrigin
//    @RequestMapping(value = "/jsonBook", produces = {
//        MediaType.APPLICATION_JSON_VALUE
//    })
//    @ResponseBody
//    public ArrayList<String> getJSONBook() {
//        Book buku = new Book();
//        return buku.newBook();
//    }
    
    @CrossOrigin
    @RequestMapping(value = "/xmlBook", produces = {
        MediaType.APPLICATION_XML_VALUE
    })
    @ResponseBody
    public ArrayList<String> getXMLBook() {
//        buku.add("Pemrograman Web");
//        buku.add("Pemrograman Web Dinamis");
//        buku.add("Sistem Operasi");
//        buku.add("Bahasa Inggris");
        return buku;
    }
    
//    @CrossOrigin
//    @RequestMapping(value = "/jsonBook", produces = {
//        MediaType.APPLICATION_JSON_VALUE
//    })
//    @ResponseBody
//    public ArrayList<String> getJSONBook() {
////        buku.add("Pemrograman Web");
////        buku.add("Pemrograman Web Dinamis");
////        buku.add("Sistem Operasi");
////        buku.add("Bahasa Inggris");
//        return buku;
//    }
    
    @CrossOrigin
    @RequestMapping(value = "/jsonBook", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseBody
    public ArrayList<String> getFromDB() {
//        buku.add("Pemrograman Web");
//        buku.add("Pemrograman Web Dinamis");
//        buku.add("Sistem Operasi");
//        buku.add("Bahasa Inggris");
        return buku;
    }
}
