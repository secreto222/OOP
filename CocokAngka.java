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
        //Bingkai tampil = new Bingkai();
        String angka;
        angka=JOptionPane.showInputDialog(null, "PILIH LEVEL (1-3)");
        if (angka.equals("1")){
           //tampil.launch(2,5,selatan,tengah,utara);
           new Level1(tengah,selatan,utara);
        }
        else if(angka.equals("2")){
            new Level2(tengah, selatan, utara);
        }
        else if(angka.equals("3")){
            new Level3(tengah, selatan, utara);
        }
    }
    public static void main(String[] args) {
        new CocokAngka();
    }
}