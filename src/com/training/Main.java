package com.training;

import com.training.service.AbstractKayitServisi;
import com.training.service.Insan;
import com.training.service.InsanKayitServisi;

public class Main {

    public static void main(String[] args) {
        Main mn = new Main();

        Insan insan1 = new Insan("Ilk isim");
        System.out.println(insan1 + " - " + insan1.getName());

        mn.ismiDegistir(insan1);
        System.out.println(insan1 + " - " + insan1.getName());
        System.out.println("--------------------------------");
        insan1 = mn.yeniInsanOlustur();

        Insan insan2 = insan1;

        System.out.println("insan1: " +insan1 + " - " + insan1.getName());
        System.out.println("------------------");
        System.out.println("insan2: " +insan2 + " - " + insan2.getName());

        System.out.println("insan 2 nin ismi degistiriliyor");
        mn.ismiDegistir(insan2); //77459877  objenini ismini degistir
        System.out.println("---------------------");
        System.out.println("insan1: " + insan1 + " - " + insan1.getName());
        System.out.println("------------------");
        System.out.println("insan2: " + insan2 + " - " + insan2.getName());


    }

    public void ismiDegistir(Insan insan){
        insan.setName("Degistirilmis isim");
    }

    public Insan yeniInsanOlustur(){
        return new Insan("Ikinci insan");
    }
}
