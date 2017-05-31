package com.nineinfosys.radiologyconverter.Engin;
import java.util.ArrayList;

public class RadiationConverter {
    private double graypersecond,exagraypersecond,petagraypersecond,teragraypersecond,gigagraypersecond,megagraypersecond,kilograypersecond,hectograypersecond,dekagraypersecond
            ,decigraypersecond,centigraypersecond,milligraypersecond,micrograypersecond,nanograypersecond,picograypersecond,femtograypersecond,attograypersecond,radpersecond,jouleperkilogrampersecond
            ,wattperkilogram,sievertpersecond,rempersecond;
    private double edtValue;
    private String conversionFrom;
    //private String conversionTo;
    public RadiationConverter(String conversionFrom, int edtValue){
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }
    public ArrayList<ConversionResults> calculateRadiationConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Gray/second - Gy/s":

                graypersecond=(edtValue)*1;
                exagraypersecond=(edtValue)*1.E-18;
                petagraypersecond=(edtValue)*1.E-15;
                teragraypersecond=(edtValue)*1.E-12;
                gigagraypersecond=(edtValue)*1.E-9;
                megagraypersecond=(edtValue)*0.000001;
                kilograypersecond=(edtValue)*0.001;
                hectograypersecond=(edtValue)*0.01;
                dekagraypersecond=(edtValue)*0.1;
                decigraypersecond=(edtValue)*10;
                centigraypersecond=(edtValue)*100;
                milligraypersecond=(edtValue)*1000;
                micrograypersecond=(edtValue)*1000000;
                nanograypersecond=(edtValue)*1000000000;
                picograypersecond=(edtValue)*1000000000000.0000000000;
                femtograypersecond=(edtValue)*1000000000000000.0000000000;
                attograypersecond=(edtValue)*1000000000000000000.0000000000;
                radpersecond=(edtValue)*100;
                jouleperkilogrampersecond=(edtValue)*1;
                wattperkilogram=(edtValue)*1;
                sievertpersecond=(edtValue)*1;
                rempersecond=(edtValue)*100;

                break;

            case "Exagray/second - EGy/s":

                graypersecond=(edtValue)*1000000000000000000.0000000000;
                exagraypersecond=(edtValue)*1;
                petagraypersecond=(edtValue)*1000;
                teragraypersecond=(edtValue)*1000000;
                gigagraypersecond=(edtValue)*1000000000;
                megagraypersecond=(edtValue)*1000000000000.0000000000;
                kilograypersecond=(edtValue)*1000000000000000.0000000000;
                hectograypersecond=(edtValue)*10000000000000000.0000000000;
                dekagraypersecond=(edtValue)*100000000000000000.0000000000;
                decigraypersecond=(edtValue)*10000000000000000000.0000000000;
                centigraypersecond=(edtValue)*100000000000000000000.0000000000;
                milligraypersecond=(edtValue)*1.E+21;
                micrograypersecond=(edtValue)*1.E+24;
                nanograypersecond=(edtValue)*1.E+27;
                picograypersecond=(edtValue)*1.E+30;
                femtograypersecond=(edtValue)*1.E+33;
                attograypersecond=(edtValue)*1.E+36;
                radpersecond=(edtValue)*100000000000000000000.0000000000;
                jouleperkilogrampersecond=(edtValue)*1000000000000000000.0000000000;
                wattperkilogram=(edtValue)*1000000000000000000.0000000000;
                sievertpersecond=(edtValue)*1000000000000000000.0000000000;
                rempersecond=(edtValue)*100000000000000000000.0000000000;

                break;

            case "Petagray/second - PGy/s":

                graypersecond=(edtValue)*1000000000000000.0000000000;
                exagraypersecond=(edtValue)*0.001;
                petagraypersecond=(edtValue)*1;
                teragraypersecond=(edtValue)*1000;
                gigagraypersecond=(edtValue)*1000000;
                megagraypersecond=(edtValue)*1000000000;
                kilograypersecond=(edtValue)*1000000000000.0000000000;
                hectograypersecond=(edtValue)*10000000000000.0000000000;
                dekagraypersecond=(edtValue)*100000000000000.0000000000;
                decigraypersecond=(edtValue)*10000000000000000.0000000000;
                centigraypersecond=(edtValue)*100000000000000000.0000000000;
                milligraypersecond=(edtValue)*1000000000000000000.0000000000;
                micrograypersecond=(edtValue)*1.E+21;
                nanograypersecond=(edtValue)*1.E+24;
                picograypersecond=(edtValue)*1.E+27;
                femtograypersecond=(edtValue)*9.999999999E+29;
                attograypersecond=(edtValue)*1.E+33;
                radpersecond=(edtValue)*100000000000000000.0000000000;
                jouleperkilogrampersecond=(edtValue)*1000000000000000.0000000000;
                wattperkilogram=(edtValue)*1000000000000000.0000000000;
                sievertpersecond=(edtValue)*1000000000000000.0000000000;
                rempersecond=(edtValue)*100000000000000000.0000000000;

                break;
            case "Teragray/second - TGy/s":

                graypersecond=(edtValue)*1000000000000.0000000000;
                exagraypersecond=(edtValue)*0.000001;
                petagraypersecond=(edtValue)*0.001;
                teragraypersecond=(edtValue)*1;
                gigagraypersecond=(edtValue)*1000;
                megagraypersecond=(edtValue)*1000000;
                kilograypersecond=(edtValue)*1000000000;
                hectograypersecond=(edtValue)*10000000000.0000000000;
                dekagraypersecond=(edtValue)*100000000000.0000000000;
                decigraypersecond=(edtValue)*10000000000000.0000000000;
                centigraypersecond=(edtValue)*100000000000000.0000000000;
                milligraypersecond=(edtValue)*1000000000000000.0000000000;
                micrograypersecond=(edtValue)*1000000000000000000.0000000000;
                nanograypersecond=(edtValue)*1.E+21;
                picograypersecond=(edtValue)*1.E+24;
                femtograypersecond=(edtValue)*1.E+27;
                attograypersecond=(edtValue)*1.E+30;
                radpersecond=(edtValue)*100000000000000.0000000000;
                jouleperkilogrampersecond=(edtValue)*1000000000000.0000000000;
                wattperkilogram=(edtValue)*1000000000000.0000000000;
                sievertpersecond=(edtValue)*1000000000000.0000000000;
                rempersecond=(edtValue)*100000000000000.0000000000;

                break;
            case "Gigagray/second - GGy/s":

                graypersecond=(edtValue)*1000000000;
                exagraypersecond=(edtValue)*1.E-9;
                petagraypersecond=(edtValue)*0.000001;
                teragraypersecond=(edtValue)*0.001;
                gigagraypersecond=(edtValue)*1;
                megagraypersecond=(edtValue)*1000;
                kilograypersecond=(edtValue)*1000000;
                hectograypersecond=(edtValue)*10000000;
                dekagraypersecond=(edtValue)*100000000;
                decigraypersecond=(edtValue)*10000000000.0000000000;
                centigraypersecond=(edtValue)*100000000000.0000000000;
                milligraypersecond=(edtValue)*1000000000000.0000000000;
                micrograypersecond=(edtValue)*1000000000000000.0000000000;
                nanograypersecond=(edtValue)*1000000000000000000.0000000000;
                picograypersecond=(edtValue)*1.E+21;
                femtograypersecond=(edtValue)*1.E+24;
                attograypersecond=(edtValue)*1.E+27;
                radpersecond=(edtValue)*100000000000.0000000000;
                jouleperkilogrampersecond=(edtValue)*1000000000;
                wattperkilogram=(edtValue)*1000000000;
                sievertpersecond=(edtValue)*1000000000;
                rempersecond=(edtValue)*100000000000.0000000000;

                break;
            case "Megagray/second - MGy/s":

                graypersecond=(edtValue)*1000000;
                exagraypersecond=(edtValue)*1.E-12;
                petagraypersecond=(edtValue)*1.E-9;
                teragraypersecond=(edtValue)*0.000001;
                gigagraypersecond=(edtValue)*0.001;
                megagraypersecond=(edtValue)*1;
                kilograypersecond=(edtValue)*1000;
                hectograypersecond=(edtValue)*10000;
                dekagraypersecond=(edtValue)*100000;
                decigraypersecond=(edtValue)*10000000;
                centigraypersecond=(edtValue)*100000000;
                milligraypersecond=(edtValue)*1000000000;
                micrograypersecond=(edtValue)*1000000000000.0000000000;
                nanograypersecond=(edtValue)*1000000000000000.0000000000;
                picograypersecond=(edtValue)*1000000000000000000.0000000000;
                femtograypersecond=(edtValue)*1.E+21;
                attograypersecond=(edtValue)*1.E+24;
                radpersecond=(edtValue)*100000000;
                jouleperkilogrampersecond=(edtValue)*1000000;
                wattperkilogram=(edtValue)*1000000;
                sievertpersecond=(edtValue)*1000000;
                rempersecond=(edtValue)*100000000;

                break;

            case "Kilogray/second - kGy/s":

                graypersecond=(edtValue)*1000;
                exagraypersecond=(edtValue)*1.E-15;
                petagraypersecond=(edtValue)*1.E-12;
                teragraypersecond=(edtValue)*1.E-9;
                gigagraypersecond=(edtValue)*0.000001;
                megagraypersecond=(edtValue)*0.001;
                kilograypersecond=(edtValue)*1;
                hectograypersecond=(edtValue)*10;
                dekagraypersecond=(edtValue)*100;
                decigraypersecond=(edtValue)*10000;
                centigraypersecond=(edtValue)*100000;
                milligraypersecond=(edtValue)*1000000;
                micrograypersecond=(edtValue)*1000000000;
                nanograypersecond=(edtValue)*1000000000000.0000000000;
                picograypersecond=(edtValue)*1000000000000000.0000000000;
                femtograypersecond=(edtValue)*1000000000000000000.0000000000;
                attograypersecond=(edtValue)*1.E+21;
                radpersecond=(edtValue)*100000;
                jouleperkilogrampersecond=(edtValue)*1000;
                wattperkilogram=(edtValue)*1000;
                sievertpersecond=(edtValue)*1000;
                rempersecond=(edtValue)*100000;

                break;

            case "Hectogray/second - hGy/s":

                graypersecond=(edtValue)*100;
                exagraypersecond=(edtValue)*1.E-16;
                petagraypersecond=(edtValue)*1.E-13;
                teragraypersecond=(edtValue)*1.E-10;
                gigagraypersecond=(edtValue)*1.E-7;
                megagraypersecond=(edtValue)*0.0001;
                kilograypersecond=(edtValue)*0.1;
                hectograypersecond=(edtValue)*1;
                dekagraypersecond=(edtValue)*10;
                decigraypersecond=(edtValue)*1000;
                centigraypersecond=(edtValue)*10000;
                milligraypersecond=(edtValue)*100000;
                micrograypersecond=(edtValue)*100000000;
                nanograypersecond=(edtValue)*100000000000.0000000000;
                picograypersecond=(edtValue)*100000000000000.0000000000;
                femtograypersecond=(edtValue)*100000000000000000.0000000000;
                attograypersecond=(edtValue)*100000000000000000000.0000000000;
                radpersecond=(edtValue)*10000;
                jouleperkilogrampersecond=(edtValue)*100;
                wattperkilogram=(edtValue)*100;
                sievertpersecond=(edtValue)*100;
                rempersecond=(edtValue)*10000;

                break;
            case "Dekagray/second - daGy/s":

                graypersecond=(edtValue)*10;
                exagraypersecond=(edtValue)*1.E-17;
                petagraypersecond=(edtValue)*1.E-14;
                teragraypersecond=(edtValue)*1.E-11;
                gigagraypersecond=(edtValue)*1.E-8;
                megagraypersecond=(edtValue)*0.00001;
                kilograypersecond=(edtValue)*0.01;
                hectograypersecond=(edtValue)*0.1;
                dekagraypersecond=(edtValue)*1;
                decigraypersecond=(edtValue)*100;
                centigraypersecond=(edtValue)*1000;
                milligraypersecond=(edtValue)*10000;
                micrograypersecond=(edtValue)*10000000;
                nanograypersecond=(edtValue)*10000000000.0000000000;
                picograypersecond=(edtValue)*10000000000000.0000000000;
                femtograypersecond=(edtValue)*10000000000000000.0000000000;
                attograypersecond=(edtValue)*10000000000000000000.0000000000;
                radpersecond=(edtValue)*1000;
                jouleperkilogrampersecond=(edtValue)*10;
                wattperkilogram=(edtValue)*10;
                sievertpersecond=(edtValue)*10;
                rempersecond=(edtValue)*1000;

                break;
            case "Decigray/second - dGy/s":

                graypersecond=(edtValue)*0.1;
                exagraypersecond=(edtValue)*1.E-19;
                petagraypersecond=(edtValue)*1.E-16;
                teragraypersecond=(edtValue)*1.E-13;
                gigagraypersecond=(edtValue)*1.E-10;
                megagraypersecond=(edtValue)*1.E-7;
                kilograypersecond=(edtValue)*0.0001;
                hectograypersecond=(edtValue)*0.001;
                dekagraypersecond=(edtValue)*0.01;
                decigraypersecond=(edtValue)*1;
                centigraypersecond=(edtValue)*10;
                milligraypersecond=(edtValue)*100;
                micrograypersecond=(edtValue)*100000;
                nanograypersecond=(edtValue)*100000000;
                picograypersecond=(edtValue)*100000000000.0000000000;
                femtograypersecond=(edtValue)*100000000000000.0000000000;
                attograypersecond=(edtValue)*100000000000000000.0000000000;
                radpersecond=(edtValue)*10;
                jouleperkilogrampersecond=(edtValue)*0.1;
                wattperkilogram=(edtValue)*0.1;
                sievertpersecond=(edtValue)*0.1;
                rempersecond=(edtValue)*10;

                break;

            case "Centigray/second - cGy/s":

                graypersecond=(edtValue)*0.01;
                exagraypersecond=(edtValue)*1.E-20;
                petagraypersecond=(edtValue)*1.E-17;
                teragraypersecond=(edtValue)*1.E-14;
                gigagraypersecond=(edtValue)*1.E-11;
                megagraypersecond=(edtValue)*1.E-8;
                kilograypersecond=(edtValue)*0.00001;
                hectograypersecond=(edtValue)*0.0001;
                dekagraypersecond=(edtValue)*0.001;
                decigraypersecond=(edtValue)*0.1;
                centigraypersecond=(edtValue)*1;
                milligraypersecond=(edtValue)*10;
                micrograypersecond=(edtValue)*10000;
                nanograypersecond=(edtValue)*10000000;
                picograypersecond=(edtValue)*10000000000.0000000000;
                femtograypersecond=(edtValue)*10000000000000.0000000000;
                attograypersecond=(edtValue)*10000000000000000.0000000000;
                radpersecond=(edtValue)*1;
                jouleperkilogrampersecond=(edtValue)*0.01;
                wattperkilogram=(edtValue)*0.01;
                sievertpersecond=(edtValue)*0.01;
                rempersecond=(edtValue)*1;

                break;

            case "Milligray/second - mGy/s":

                graypersecond=(edtValue)*0.001;
                exagraypersecond=(edtValue)*1.E-21;
                petagraypersecond=(edtValue)*1.E-18;
                teragraypersecond=(edtValue)*1.E-15;
                gigagraypersecond=(edtValue)*1.E-12;
                megagraypersecond=(edtValue)*1.E-9;
                kilograypersecond=(edtValue)*0.000001;
                hectograypersecond=(edtValue)*0.00001;
                dekagraypersecond=(edtValue)*0.0001;
                decigraypersecond=(edtValue)*0.01;
                centigraypersecond=(edtValue)*0.1;
                milligraypersecond=(edtValue)*1;
                micrograypersecond=(edtValue)*1000;
                nanograypersecond=(edtValue)*1000000;
                picograypersecond=(edtValue)*1000000000;
                femtograypersecond=(edtValue)*1000000000000.0000000000;
                attograypersecond=(edtValue)*1000000000000000.0000000000;
                radpersecond=(edtValue)*0.1;
                jouleperkilogrampersecond=(edtValue)*0.001;
                wattperkilogram=(edtValue)*0.001;
                sievertpersecond=(edtValue)*0.001;
                rempersecond=(edtValue)*0.1;

                break;


            case "Microgray/second - µGy/s":

                graypersecond=(edtValue)*0.000001;
                exagraypersecond=(edtValue)*1.E-24;
                petagraypersecond=(edtValue)*1.E-21;
                teragraypersecond=(edtValue)*1.E-18;
                gigagraypersecond=(edtValue)*1.E-15;
                megagraypersecond=(edtValue)*1.E-12;
                kilograypersecond=(edtValue)*1.E-9;
                hectograypersecond=(edtValue)*1.E-8;
                dekagraypersecond=(edtValue)*1.E-7;
                decigraypersecond=(edtValue)*0.00001;
                centigraypersecond=(edtValue)*0.0001;
                milligraypersecond=(edtValue)*0.001;
                micrograypersecond=(edtValue)*1;
                nanograypersecond=(edtValue)*1000;
                picograypersecond=(edtValue)*1000000;
                femtograypersecond=(edtValue)*1000000000;
                attograypersecond=(edtValue)*1000000000000.0000000000;
                radpersecond=(edtValue)*0.0001;
                jouleperkilogrampersecond=(edtValue)*0.000001;
                wattperkilogram=(edtValue)*0.000001;
                sievertpersecond=(edtValue)*0.000001;
                rempersecond=(edtValue)*0.0001;

                break;
            case "Nanogray/second - nGy/s":

                graypersecond=(edtValue)*1.E-9;
                exagraypersecond=(edtValue)*1.E-27;
                petagraypersecond=(edtValue)*1.E-24;
                teragraypersecond=(edtValue)*1.E-21;
                gigagraypersecond=(edtValue)*1.E-18;
                megagraypersecond=(edtValue)*1.E-15;
                kilograypersecond=(edtValue)*1.E-12;
                hectograypersecond=(edtValue)*1.E-11;
                dekagraypersecond=(edtValue)*1.E-10;
                decigraypersecond=(edtValue)*1.E-8;
                centigraypersecond=(edtValue)*1.E-7;
                milligraypersecond=(edtValue)*0.000001;
                micrograypersecond=(edtValue)*0.001;
                nanograypersecond=(edtValue)*1;
                picograypersecond=(edtValue)*1000;
                femtograypersecond=(edtValue)*1000000;
                attograypersecond=(edtValue)*1000000000;
                radpersecond=(edtValue)*1.E-7;
                jouleperkilogrampersecond=(edtValue)*1.E-9;
                wattperkilogram=(edtValue)*1.E-9;
                sievertpersecond=(edtValue)*1.E-9;
                rempersecond=(edtValue)*1.E-7;

                break;
            case "Picogray/second - pGy/s":

                graypersecond=(edtValue)*1.E-12;
                exagraypersecond=(edtValue)*9.999999999E-31;
                petagraypersecond=(edtValue)*1.E-27;
                teragraypersecond=(edtValue)*1.E-24;
                gigagraypersecond=(edtValue)*1.E-21;
                megagraypersecond=(edtValue)*1.E-18;
                kilograypersecond=(edtValue)*1.E-15;
                hectograypersecond=(edtValue)*1.E-14;
                dekagraypersecond=(edtValue)*1.E-13;
                decigraypersecond=(edtValue)*1.E-11;
                centigraypersecond=(edtValue)*1.E-10;
                milligraypersecond=(edtValue)*1.E-9;
                micrograypersecond=(edtValue)*0.000001;
                nanograypersecond=(edtValue)*0.001;
                picograypersecond=(edtValue)*1;
                femtograypersecond=(edtValue)*1000;
                attograypersecond=(edtValue)*1000000;
                radpersecond=(edtValue)*1.E-10;
                jouleperkilogrampersecond=(edtValue)*1.E-12;
                wattperkilogram=(edtValue)*1.E-12;
                sievertpersecond=(edtValue)*1.E-12;
                rempersecond=(edtValue)*1.E-10;

                break;
            case "Femtogray/second - fGy/s":

                graypersecond=(edtValue)*1.E-15;
                exagraypersecond=(edtValue)*1.E-33;
                petagraypersecond=(edtValue)*1.E-30;
                teragraypersecond=(edtValue)*1.E-27;
                gigagraypersecond=(edtValue)*1.E-24;
                megagraypersecond=(edtValue)*1.E-21;
                kilograypersecond=(edtValue)*1.E-18;
                hectograypersecond=(edtValue)*1.E-17;
                dekagraypersecond=(edtValue)*1.E-16;
                decigraypersecond=(edtValue)*1.E-14;
                centigraypersecond=(edtValue)*1.E-13;
                milligraypersecond=(edtValue)*1.E-12;
                micrograypersecond=(edtValue)*1.E-9;
                nanograypersecond=(edtValue)*0.000001;
                picograypersecond=(edtValue)*0.001;
                femtograypersecond=(edtValue)*1;
                attograypersecond=(edtValue)*1000;
                radpersecond=(edtValue)*1.E-13;
                jouleperkilogrampersecond=(edtValue)*1.E-15;
                wattperkilogram=(edtValue)*1.E-15;
                sievertpersecond=(edtValue)*1.E-15;
                rempersecond=(edtValue)*1.E-13;

                break;

            case "Attogray/second - aGy/s":

                graypersecond=(edtValue)*9.999999999E-19;
                exagraypersecond=(edtValue)*1.E-36;
                petagraypersecond=(edtValue)*9.999999999E-34;
                teragraypersecond=(edtValue)*9.999999999E-31;
                gigagraypersecond=(edtValue)*1.E-27;
                megagraypersecond=(edtValue)*1.E-24;
                kilograypersecond=(edtValue)*1.E-21;
                hectograypersecond=(edtValue)*1.E-20;
                dekagraypersecond=(edtValue)*1.E-19;
                decigraypersecond=(edtValue)*9.999999999E-18;
                centigraypersecond=(edtValue)*1.E-16;
                milligraypersecond=(edtValue)*9.999999999E-16;
                micrograypersecond=(edtValue)*1.E-12;
                nanograypersecond=(edtValue)*1.E-9;
                picograypersecond=(edtValue)*0.000001;
                femtograypersecond=(edtValue)*0.001;
                attograypersecond=(edtValue)*1;
                radpersecond=(edtValue)*1.E-16;
                jouleperkilogrampersecond=(edtValue)*9.999999999E-19;
                wattperkilogram=(edtValue)*9.999999999E-19;
                sievertpersecond=(edtValue)*9.999999999E-19;
                rempersecond=(edtValue)*1.E-16;

                break;

            case "Rad/second - rd/s":

                graypersecond=(edtValue)*0.01;
                exagraypersecond=(edtValue)*1.E-20;
                petagraypersecond=(edtValue)*1.E-17;
                teragraypersecond=(edtValue)*1.E-14;
                gigagraypersecond=(edtValue)*1.E-11;
                megagraypersecond=(edtValue)*1.E-8;
                kilograypersecond=(edtValue)*0.00001;
                hectograypersecond=(edtValue)*0.0001;
                dekagraypersecond=(edtValue)*0.001;
                decigraypersecond=(edtValue)*0.1;
                centigraypersecond=(edtValue)*1;
                milligraypersecond=(edtValue)*10;
                micrograypersecond=(edtValue)*10000;
                nanograypersecond=(edtValue)*10000000;
                picograypersecond=(edtValue)*10000000000.0000000000;
                femtograypersecond=(edtValue)*10000000000000.0000000000;
                attograypersecond=(edtValue)*10000000000000000.0000000000;
                radpersecond=(edtValue)*1;
                jouleperkilogrampersecond=(edtValue)*0.01;
                wattperkilogram=(edtValue)*0.01;
                sievertpersecond=(edtValue)*0.01;
                rempersecond=(edtValue)*1;

                break;
            case "Joule/kilogram/second - J/kg/s":

                graypersecond=(edtValue)*1;
                exagraypersecond=(edtValue)*1.E-18;
                petagraypersecond=(edtValue)*1.E-15;
                teragraypersecond=(edtValue)*1.E-12;
                gigagraypersecond=(edtValue)*1.E-9;
                megagraypersecond=(edtValue)*0.000001;
                kilograypersecond=(edtValue)*0.001;
                hectograypersecond=(edtValue)*0.01;
                dekagraypersecond=(edtValue)*0.1;
                decigraypersecond=(edtValue)*10;
                centigraypersecond=(edtValue)*100;
                milligraypersecond=(edtValue)*1000;
                micrograypersecond=(edtValue)*1000000;
                nanograypersecond=(edtValue)*1000000000;
                picograypersecond=(edtValue)*1000000000000.0000000000;
                femtograypersecond=(edtValue)*1000000000000000.0000000000;
                attograypersecond=(edtValue)*1000000000000000000.0000000000;
                radpersecond=(edtValue)*100;
                jouleperkilogrampersecond=(edtValue)*1;
                wattperkilogram=(edtValue)*1;
                sievertpersecond=(edtValue)*1;
                rempersecond=(edtValue)*100;

                break;
            case "Watt/kilogram - W/kg":

                graypersecond=(edtValue)*1;
                exagraypersecond=(edtValue)*1.E-18;
                petagraypersecond=(edtValue)*1.E-15;
                teragraypersecond=(edtValue)*1.E-12;
                gigagraypersecond=(edtValue)*1.E-9;
                megagraypersecond=(edtValue)*0.000001;
                kilograypersecond=(edtValue)*0.001;
                hectograypersecond=(edtValue)*0.01;
                dekagraypersecond=(edtValue)*0.1;
                decigraypersecond=(edtValue)*10;
                centigraypersecond=(edtValue)*100;
                milligraypersecond=(edtValue)*1000;
                micrograypersecond=(edtValue)*1000000;
                nanograypersecond=(edtValue)*1000000000;
                picograypersecond=(edtValue)*1000000000000.0000000000;
                femtograypersecond=(edtValue)*1000000000000000.0000000000;
                attograypersecond=(edtValue)*1000000000000000000.0000000000;
                radpersecond=(edtValue)*100;
                jouleperkilogrampersecond=(edtValue)*1;
                wattperkilogram=(edtValue)*1;
                sievertpersecond=(edtValue)*1;
                rempersecond=(edtValue)*100;

                break;

            case "Sievert/second - Sv/s":

                graypersecond=(edtValue)*1;
                exagraypersecond=(edtValue)*1.E-18;
                petagraypersecond=(edtValue)*1.E-15;
                teragraypersecond=(edtValue)*1.E-12;
                gigagraypersecond=(edtValue)*1.E-9;
                megagraypersecond=(edtValue)*0.000001;
                kilograypersecond=(edtValue)*0.001;
                hectograypersecond=(edtValue)*0.01;
                dekagraypersecond=(edtValue)*0.1;
                decigraypersecond=(edtValue)*10;
                centigraypersecond=(edtValue)*100;
                milligraypersecond=(edtValue)*1000;
                micrograypersecond=(edtValue)*1000000;
                nanograypersecond=(edtValue)*1000000000;
                picograypersecond=(edtValue)*1000000000000.0000000000;
                femtograypersecond=(edtValue)*1000000000000000.0000000000;
                attograypersecond=(edtValue)*1000000000000000000.0000000000;
                radpersecond=(edtValue)*100;
                jouleperkilogrampersecond=(edtValue)*1;
                wattperkilogram=(edtValue)*1;
                sievertpersecond=(edtValue)*1;
                rempersecond=(edtValue)*100;

                break;

            case "Rem/second - rem/s":

                graypersecond=(edtValue)*0.01;
                exagraypersecond=(edtValue)*1.E-20;
                petagraypersecond=(edtValue)*1.E-17;
                teragraypersecond=(edtValue)*1.E-14;
                gigagraypersecond=(edtValue)*1.E-11;
                megagraypersecond=(edtValue)*1.E-8;
                kilograypersecond=(edtValue)*0.00001;
                hectograypersecond=(edtValue)*0.0001;
                dekagraypersecond=(edtValue)*0.001;
                decigraypersecond=(edtValue)*0.1;
                centigraypersecond=(edtValue)*1;
                milligraypersecond=(edtValue)*10;
                micrograypersecond=(edtValue)*10000;
                nanograypersecond=(edtValue)*10000000;
                picograypersecond=(edtValue)*10000000000.0000000000;
                femtograypersecond=(edtValue)*10000000000000.0000000000;
                attograypersecond=(edtValue)*10000000000000000.0000000000;
                radpersecond=(edtValue)*1;
                jouleperkilogrampersecond=(edtValue)*0.01;
                wattperkilogram=(edtValue)*0.01;
                sievertpersecond=(edtValue)*0.01;
                rempersecond=(edtValue)*1;

                break;
            case "Default":
                break;

        }
        results.setGraypersecond(graypersecond);
        results.setExagraypersecond(exagraypersecond);
        results.setPetagraypersecond(petagraypersecond);
        results.setTeragraypersecond(teragraypersecond);
        results.setGigagraypersecond(gigagraypersecond);
        results.setMegagraypersecond(megagraypersecond);
        results.setKilograypersecond(kilograypersecond);
        results.setHectograypersecond(hectograypersecond);
        results.setDekagraypersecond(dekagraypersecond);
        results.setDecigraypersecond(decigraypersecond);
        results.setCentigraypersecond(centigraypersecond);
        results.setMilligraypersecond(milligraypersecond);
        results.setMicrograypersecond(micrograypersecond);
        results.setNanograypersecond(nanograypersecond);
        results.setPicograypersecond(picograypersecond);
        results.setFemtograypersecond(femtograypersecond);
        results.setAttograypersecond(attograypersecond);
        results.setRadpersecond(radpersecond);
        results.setJouleperkilogrampersecond(jouleperkilogrampersecond);
        results.setWattperkilogram(wattperkilogram);
        results.setSievertpersecond(sievertpersecond);
        results.setRempersecond(rempersecond);


        converterArray.add(results);
        return converterArray;
    }

   public class ConversionResults{
        private double graypersecond,exagraypersecond,petagraypersecond,teragraypersecond,gigagraypersecond,megagraypersecond,kilograypersecond,hectograypersecond,dekagraypersecond
                ,decigraypersecond,centigraypersecond,milligraypersecond,micrograypersecond,nanograypersecond,picograypersecond,femtograypersecond,attograypersecond,radpersecond,jouleperkilogrampersecond
                ,wattperkilogram,sievertpersecond,rempersecond;

        public double getGraypersecond() {
            return graypersecond;
        }

        public void setGraypersecond(double graypersecond) {
            this.graypersecond = graypersecond;
        }

        public double getExagraypersecond() {
            return exagraypersecond;
        }

        public void setExagraypersecond(double exagraypersecond) {
            this.exagraypersecond = exagraypersecond;
        }

        public double getPetagraypersecond() {
            return petagraypersecond;
        }

        public void setPetagraypersecond(double petagraypersecond) {
            this.petagraypersecond = petagraypersecond;
        }

        public double getTeragraypersecond() {
            return teragraypersecond;
        }

        public void setTeragraypersecond(double teragraypersecond) {
            this.teragraypersecond = teragraypersecond;
        }

        public double getGigagraypersecond() {
            return gigagraypersecond;
        }

        public void setGigagraypersecond(double gigagraypersecond) {
            this.gigagraypersecond = gigagraypersecond;
        }

        public double getMegagraypersecond() {
            return megagraypersecond;
        }

        public void setMegagraypersecond(double megagraypersecond) {
            this.megagraypersecond = megagraypersecond;
        }

        public double getKilograypersecond() {
            return kilograypersecond;
        }

        public void setKilograypersecond(double kilograypersecond) {
            this.kilograypersecond = kilograypersecond;
        }

        public double getHectograypersecond() {
            return hectograypersecond;
        }

        public void setHectograypersecond(double hectograypersecond) {
            this.hectograypersecond = hectograypersecond;
        }

        public double getDekagraypersecond() {
            return dekagraypersecond;
        }

        public void setDekagraypersecond(double dekagraypersecond) {
            this.dekagraypersecond = dekagraypersecond;
        }

        public double getDecigraypersecond() {
            return decigraypersecond;
        }

        public void setDecigraypersecond(double decigraypersecond) {
            this.decigraypersecond = decigraypersecond;
        }

        public double getCentigraypersecond() {
            return centigraypersecond;
        }

        public void setCentigraypersecond(double centigraypersecond) {
            this.centigraypersecond = centigraypersecond;
        }

        public double getMilligraypersecond() {
            return milligraypersecond;
        }

        public void setMilligraypersecond(double milligraypersecond) {
            this.milligraypersecond = milligraypersecond;
        }

        public double getMicrograypersecond() {
            return micrograypersecond;
        }

        public void setMicrograypersecond(double micrograypersecond) {
            this.micrograypersecond = micrograypersecond;
        }

        public double getNanograypersecond() {
            return nanograypersecond;
        }

        public void setNanograypersecond(double nanograypersecond) {
            this.nanograypersecond = nanograypersecond;
        }

        public double getPicograypersecond() {
            return picograypersecond;
        }

        public void setPicograypersecond(double picograypersecond) {
            this.picograypersecond = picograypersecond;
        }

        public double getFemtograypersecond() {
            return femtograypersecond;
        }

        public void setFemtograypersecond(double femtograypersecond) {
            this.femtograypersecond = femtograypersecond;
        }

        public double getAttograypersecond() {
            return attograypersecond;
        }

        public void setAttograypersecond(double attograypersecond) {
            this.attograypersecond = attograypersecond;
        }

        public double getRadpersecond() {
            return radpersecond;
        }

        public void setRadpersecond(double radpersecond) {
            this.radpersecond = radpersecond;
        }

        public double getJouleperkilogrampersecond() {
            return jouleperkilogrampersecond;
        }

        public void setJouleperkilogrampersecond(double jouleperkilogrampersecond) {
            this.jouleperkilogrampersecond = jouleperkilogrampersecond;
        }

        public double getWattperkilogram() {
            return wattperkilogram;
        }

        public void setWattperkilogram(double wattperkilogram) {
            this.wattperkilogram = wattperkilogram;
        }

        public double getSievertpersecond() {
            return sievertpersecond;
        }

        public void setSievertpersecond(double sievertpersecond) {
            this.sievertpersecond = sievertpersecond;
        }

        public double getRempersecond() {
            return rempersecond;
        }

        public void setRempersecond(double rempersecond) {
            this.rempersecond = rempersecond;
        }


    }

}
