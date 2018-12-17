import java.util.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Collections;
import java.awt.*;
import java.awt.event.*;

class Level3 extends Frame implements ActionListener{

    private static final long serialVersionUID = 1L;
    List<Integer> ngawur = new ArrayList<Integer>();
    int acak[]= new int[30];
    public long waktu = 1000; //dijankan dalam waktu 1 detik
    int masukan=0;
    int sisa = 1;
    int tersisa=84; //menghitung sisa klik
    String kotak1="";
    String kotak2="";
    int giliran=0; //menghitung jumlah giliran
    boolean tidaktekan=true;
    int a=0;  //menguji bilangan yang sama sebanyak 2 kali
    int clicked=0; //menghitung jumlah klik
    Label perhitungan = new Label("Sisa Klik : "+this.tersisa);
    Label label = new Label("Jumlah Klik : "+ clicked);
    Button[][] buttons = new Button[5][6];
    int matching=0;
    Bingkai tampil = new Bingkai();

    Level3(Panel tengah,Panel selatan,Panel utara){
        tampil.launch(6,5,selatan,tengah,utara);
        for (int i=0;i<5;i++){ //cetak baris
            for (int z=0;z<6;z++){ //cetak kolom
                this.buttons [i][z]= new Button();
                tengah.add(this.buttons [i][z]); //menambahkan button
                this.buttons[i][z].setFont(new Font("",4,40)); //memberi font button
            }
        }
        //input angka
        for (int angka=0;angka<15;angka++){
            ngawur.add(angka);
            ngawur.add(angka);
        }
        //acak angka
        Collections.shuffle(this.ngawur);
        //mengambil angkanya
        for (int ambilan :this.ngawur){
            this.acak[a]=ambilan;
            a++;
        }
        a=0;
        for (int i=0;i<5;i++){ //baris
            for (int z=0;z<6;z++){ //kolom
            this.buttons[i][z].setName(Integer.toString(acak[this.masukan])); //memasukkan nama button diambil dari array
            this.buttons[i][z].addActionListener(this);
            masukan++;
            }
        }
        masukan=0;
        selatan.add(label);
        utara.add(perhitungan);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof Button){
            Button btn = (Button)source;
            if (btn.getLabel()==""&& tidaktekan==true){
                btn.setLabel(btn.getName());
                if (kotak1=="" && kotak2=="" && giliran==0){    //Ambil Nilai pertama(N1)
                    kotak1=btn.getName();
                    giliran=1;
                    clicked++;
                    this.tersisa--;
                    label.setText("Jumlah Klik : "+Integer.toString(clicked));
                    perhitungan.setText("Sisa Klik : "+tersisa);
                }
                else{
                    kotak2=btn.getName();   //Ambil nilai kedua(N2)
                    giliran=2;
                    clicked++;
                    this.tersisa--;
                    label.setText("Jumlah Klik : "+Integer.toString(clicked));
                    perhitungan.setText("Sisa Klik : "+tersisa);
                    tidaktekan=false;
                 }
            }

            if (!kotak1.equals(kotak2) && giliran==2){  //kalau N1 dan N2 tidak sama
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (sisa==2){
                    System.out.println(kotak1);
                    System.out.println(kotak2);
                    cocok();
                    kotak1="";
                    kotak2="";
                    timer.cancel();
                    timer.purge();
                    tidaktekan=true;
                }
                sisa++;
            }
            }, 0, this.waktu);
                sisa=1;
                giliran=0;
                if (tersisa==0){
                    endandrestart();
                    akhir();
                }
            }
            if (kotak1.equals(kotak2) && giliran==2){   //kalau N1 dan N2 sama
                System.out.println("AYE");
                cocok(kotak1,kotak2);
                kotak1="";
                kotak2="";
                giliran=0;
                tidaktekan=true;
                matching++;
                if (tersisa==0){
                    endandrestart();
                    akhir();
                }
            }
            if (matching==15 && tersisa!=0){
                endandrestart();
                akhir();
            }
            
        }
                 
    }

    private void akhir(){
        JOptionPane.showMessageDialog(null, "GAME OVER");
        int jawab=JOptionPane.showConfirmDialog(null, "RESTART");
        switch(jawab){
            case JOptionPane.YES_OPTION:
                endandrestart(a);
                tersisa=84;
                perhitungan.setText("Sisa Klik : "+tersisa);
                giliran=0;
                clicked=0;
                matching=0;
                label.setText("Jumlah Klik : "+Integer.toString(clicked));
                break;
            case JOptionPane.NO_OPTION:
            tampil.setVisible(false);
            tampil.dispose();
                new CocokAngka();
                break;

        }
    }

    //teknik overloading
    private void endandrestart(int a){ //kalau mau restart
        for (int i=0;i<5;i++){ //baris
            for (int z=0;z<6;z++){ //kolom
                this.buttons[i][z].setEnabled(true);
                this.buttons[i][z].setVisible(true);
                this.buttons[i][z].setLabel("");
            }
        }
    }

    private void endandrestart(){ //kalau game over
        for (int i=0;i<5;i++){ 
            for (int z=0;z<6;z++){ 
                this.buttons[i][z].setEnabled(false);;
            }
        }
    }
    //teknik overloading
    private void cocok(String kotak1,String kotak2){ //kalau sama
        for (int i=0;i<5;i++){ 
            for (int z=0;z<6;z++){ 
            if(this.buttons[i][z].getLabel().equals(kotak1)){
                this.buttons[i][z].setVisible(false);
            }
            if(this.buttons[i][z].getLabel().equals(kotak2)){
                this.buttons[i][z].setVisible(false);
            }
            }
        }
    }
    private void cocok(){ //kalau gk sama
        for (int i=0;i<5;i++){ 
            for (int z=0;z<6;z++){ 
                if(this.buttons[i][z].getLabel().equals(kotak1)){
                    this.buttons[i][z].setLabel("");
                }
                if(this.buttons[i][z].getLabel().equals(kotak2)){
                    this.buttons[i][z].setLabel("");
                }
            }
        }
    }


}


