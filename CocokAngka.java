import java.util.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

class CocokAngka extends Frame{
    private static final long serialVersionUID = 1L;

    CocokAngka() {
        Panel selatan = new Panel();
        Panel tengah = new Panel();
        Panel utara = new Panel();
        Bingkai tampil = new Bingkai();
        String angka;
        angka=JOptionPane.showInputDialog(null, "MASUKKAN ANGKA");
        int angka1=Integer.parseInt(angka);
        if (angka1==1){
            tampil.launch(2,5,selatan,tengah,utara);
           Level1 mudah = new Level1(tengah,selatan,utara); 
           this.dispose();   
        }
        //new Menu();
    }
    public static void main(String[] args) {
        
        new CocokAngka();

    }
}