import java.util.*;
import java.util.ArrayList;
import java.util.List;


import java.util.Collections;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;

class Level1 extends Frame implements ActionListener{

    private static final long serialVersionUID = 1L;
    List<Integer> ngawur = new ArrayList<Integer>();
    int acak[]= new int[10];
    public long waktu = 1000; //dijankan dalam waktu 1 detik
    int masukan=0;
    int sisa=1;
    String kotak1="";
    String kotak2="";
    int giliran=0;
    int clicked=0;
    Label label = new Label("Jumlah Klik : "+ clicked);
    Button[][] buttons = new Button[5][2];

    Level1(Panel tengah,Panel selatan){
        int a=0;  //menguji bilangan yang sama sebanyak 2 kali
        for (int i=0;i<5;i++){ //cetak baris
            for (int z=0;z<2;z++){ //cetak kolom
                this.buttons [i][z]= new Button();
                tengah.add(this.buttons [i][z]); //menambahkan button
                this.buttons[i][z].setFont(new Font("",4,40)); //memberi font button
            }
        }
        //input angka
        for (int angka=0;angka<5;angka++){
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

         for (int i=0;i<5;i++){ //baris
             for (int z=0;z<2;z++){ //kolom
             this.buttons[i][z].setName(Integer.toString(acak[this.masukan])); //memasukkan nama button diambil dari array
             this.buttons[i][z].addActionListener(this);
             masukan++;
             }
         }
         selatan.add(label);
         
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof Button){
            Button btn = (Button)source;
            Panel selatan = new Panel();
            if (btn.getLabel()==""){
                btn.setLabel(btn.getName());
                if (kotak1=="" && kotak2=="" && giliran==0){    //Ambil Nilai pertama(N1)
                    kotak1=btn.getName();
                    giliran=1;
                    clicked++;
                    label.setText("Jumlah Klik : "+Integer.toString(clicked));

                }
                else{
                    kotak2=btn.getName();   //Ambil nilai kedua(N2)
                    giliran=2;
                    clicked++;
                    label.setText("Jumlah Klik : "+Integer.toString(clicked));

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
                    coba();
                    kotak1="";
                    kotak2="";
                    timer.cancel();
                    timer.purge();
                }
                sisa++;
   
            }
            }, 0, this.waktu);
                sisa=1;
                giliran=0;
            
            }
            if (kotak1.equals(kotak2) && giliran==2){   //kalau N1 dan N2 sama
                System.out.println("AYE");
                cocok();
                kotak1="";
                kotak2="";
                giliran=0;
            }
            
        }
                 
    }

    private void cocok(){
        for (int i=0;i<5;i++){ //cetak baris
            for (int z=0;z<2;z++){ //cetak kolom
            if(this.buttons[i][z].getLabel().equals(kotak1)){
                this.buttons[i][z].setVisible(false);


            }
            if(this.buttons[i][z].getLabel().equals(kotak2)){
                this.buttons[i][z].setVisible(false);

            }
            }
        }
    }
    private void coba(){
        for (int i=0;i<5;i++){ //cetak baris
            for (int z=0;z<2;z++){ //cetak kolom
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


