import java.util.*;
import java.awt.*;
import java.awt.event.*;

class Bingkai extends Frame{
    private static final long serialVersionUID = 1L;

    Bingkai() {
        super.setTitle("GAME COCOK ANGKA");
        // Untuk menutup window
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
            dispose();
            System.exit(1);
            }
        });
    }
    void launch(int kotak,int kotak1,Panel selatan,Panel tengah,Panel utara){
        setSize(600,500);
        setVisible(true);
        setBackground(Color.GRAY);
        add(tengah,BorderLayout.CENTER);
        add(selatan,BorderLayout.SOUTH);
        add(utara,BorderLayout.NORTH);
        selatan.setLayout(new BorderLayout());
        utara.setLayout(new BorderLayout());
        selatan.add(new Label("Dikerjakan : STEVEN Manuel"),BorderLayout.EAST);
        tengah.setLayout(new GridLayout(kotak,kotak1));
    }
    void muncul(Panel tengah){
        setSize(300,300);
        setVisible(true);
        add(tengah,BorderLayout.CENTER);
        tengah.setLayout(new BorderLayout());
        
    }
}