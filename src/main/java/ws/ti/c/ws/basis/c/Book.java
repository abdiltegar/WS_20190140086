/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.ti.c.ws.basis.c;

import java.util.ArrayList;

/**
 *
 * @author Tegar
 */
public class Book {
    public ArrayList<String> book = new ArrayList<>();
    
    public ArrayList<String> newBook() {
        book.add("Fisika 12");
        book.add("Biologi 11");
        book.add("Matematika 10");
        
        return book;
    }
}
