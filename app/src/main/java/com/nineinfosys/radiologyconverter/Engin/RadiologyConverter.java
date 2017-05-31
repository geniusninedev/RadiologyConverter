package com.nineinfosys.radiologyconverter.Engin;



        import java.util.ArrayList;


public class RadiologyConverter {


    private double rad  ,millirad  ,jouleperkilogram ,joulepergram  ,joulepercentigram  ,joulepermilligram  ,gray  ,exagray  ,petagray  ,teragray  ,gigagray  ,megagray  ,kilogray  ,hectogray ,dekagray ,decigray ,centigray,milligray , microgray ,nanogray,picogray,femtogray ,attogray   ;
    private double edtValue;
    private String conversionFrom;


    public RadiologyConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateRadiationAbosirbedConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Rad - rd":

                rad=(edtValue)*1;
                millirad=(edtValue)*1000;
                jouleperkilogram=(edtValue)*0.01;
                joulepergram=(edtValue)*0.00001;
                joulepercentigram=(edtValue)*1.E-7;
                joulepermilligram=(edtValue)*1.E-8;
                gray=(edtValue)*0.01;
                exagray=(edtValue)*1.E-20;
                petagray=(edtValue)*1.E-17;
                teragray=(edtValue)*1.E-14;
                gigagray=(edtValue)*1.E-11;
                megagray=(edtValue)*1.E-8;
                kilogray=(edtValue)*0.00001;
                hectogray=(edtValue)*0.0001;
                dekagray=(edtValue)*0.001;
                decigray=(edtValue)*0.1;
                centigray=(edtValue)*1;
                milligray=(edtValue)*10;
                microgray=(edtValue)*10000;


                nanogray=(edtValue)*10000000;
                picogray =(edtValue)*10000000000.0;
                femtogray =(edtValue)*10000000000000.0;
                attogray =(edtValue)*10000000000000000.0;

                break;


            case  "Millirad - mrd":

                rad=(edtValue)*0.001;
                millirad=(edtValue)*1;
                jouleperkilogram=(edtValue)*0.00001;
                joulepergram=(edtValue)*1.E-8;
                joulepercentigram=(edtValue)*1.E-10;
                joulepermilligram=(edtValue)*1.E-11;
                gray=(edtValue)*0.00001;
                exagray=(edtValue)*1.E-23;
                petagray=(edtValue)*1.E-20;
                teragray=(edtValue)*1.E-17;
                gigagray=(edtValue)*1.E-17;
                megagray=(edtValue)*1.E-11;
                kilogray=(edtValue)*1.E-8;
                hectogray=(edtValue)*1.E-7;
                dekagray=(edtValue)*0.000001;
                decigray=(edtValue)*0.0001;
                centigray=(edtValue)*0.001;
                milligray=(edtValue)*0.01;
                microgray=(edtValue)*10;


                nanogray=(edtValue)*10000;
                picogray =(edtValue)*10000000.0;
                femtogray =(edtValue)*10000000000.0;
                attogray =(edtValue)*10000000000000.0;

                break;


            case  "Joule/kilogram - J/kg":

                rad=(edtValue)*100;
                millirad=(edtValue)*100000;
                jouleperkilogram=(edtValue)*1;
                joulepergram=(edtValue)*0.001;
                joulepercentigram=(edtValue)*0.00001;
                joulepermilligram=(edtValue)*0.000001;
                gray=(edtValue)*1;
                exagray=(edtValue)*1.E-18;
                petagray=(edtValue)*1.E-15;
                teragray=(edtValue)*1.E-12;
                gigagray=(edtValue)*1.E-9;
                megagray=(edtValue)*0.000001;
                kilogray=(edtValue)*0.001;
                hectogray=(edtValue)*0.01;
                dekagray=(edtValue)*0.1;
                decigray=(edtValue)*10;
                centigray=(edtValue)*100;
                milligray=(edtValue)*1000;
                microgray=(edtValue)*1000000;


                nanogray=(edtValue)*1000000000;
                picogray =(edtValue)*1000000000000.0;
                femtogray =(edtValue)*1000000000000000.0;
                attogray =(edtValue)*1000000000000000000.0;

                break;




            case "Joule/gram - J/g":

                rad=(edtValue)*100000;
                millirad=(edtValue)*100000000;
                jouleperkilogram=(edtValue)*1000;
                joulepergram=(edtValue)*1;
                joulepercentigram=(edtValue)*0.01;
                joulepermilligram=(edtValue)*0.001;
                gray=(edtValue)*1000;
                exagray=(edtValue)*1.E-15;
                petagray=(edtValue)*1.E-12;
                teragray=(edtValue)*1.E-9;
                gigagray=(edtValue)*0.000001;
                megagray=(edtValue)*0.001;
                kilogray=(edtValue)*1;
                hectogray=(edtValue)*10;
                dekagray=(edtValue)*100;
                decigray=(edtValue)*10000;
                centigray=(edtValue)*100000;
                milligray=(edtValue)*1000000;
                microgray=(edtValue)*1000000000;


                nanogray=(edtValue)*1000000000000.0;
                picogray =(edtValue)*1000000000000000.0;
                femtogray =(edtValue)*1000000000000000100.0;
                attogray =(edtValue)*1.E+21;

                break;
            case "Joule/centigram - J/cg":

                rad=(edtValue)*10000000;
                millirad=(edtValue)*10000000000.0;
                jouleperkilogram=(edtValue)*100000;
                joulepergram=(edtValue)*100;
                joulepercentigram=(edtValue)*1;
                joulepermilligram=(edtValue)*0.1;
                gray=(edtValue)*100000;
                exagray=(edtValue)*1.E-13;
                petagray=(edtValue)*1.E-10;
                teragray=(edtValue)*1.E-7;
                gigagray=(edtValue)*0.0001;
                megagray=(edtValue)*0.1;
                kilogray=(edtValue)*100;
                hectogray=(edtValue)*1000;
                dekagray=(edtValue)*10000;
                decigray=(edtValue)*1000000;
                centigray=(edtValue)*10000000;
                milligray=(edtValue)*100000000;
                microgray=(edtValue)*100000000000.0;


                nanogray=(edtValue)*100000000000000.0;
                picogray =(edtValue)*100000000000000000.0;
                femtogray =(edtValue)*100000000000000020000.0;
                attogray =(edtValue)*1.E+23;

                break;


            case "Joule/milligram - J/mg" :

                rad=(edtValue)*100000000;
                millirad=(edtValue)*100000000000.0;
                jouleperkilogram=(edtValue)*1000000;
                joulepergram=(edtValue)*1000;
                joulepercentigram=(edtValue)*10;
                joulepermilligram=(edtValue)*1;
                gray=(edtValue)*1000000;
                exagray=(edtValue)*1.E-12;
                petagray=(edtValue)*1.E-9;
                teragray=(edtValue)*0.000001;
                gigagray=(edtValue)*0.001;
                megagray=(edtValue)*1;
                kilogray=(edtValue)*1000;
                hectogray=(edtValue)*10000;
                dekagray=(edtValue)*100000;
                decigray=(edtValue)*10000000;
                centigray=(edtValue)*100000000;
                milligray=(edtValue)*1000000000;
                microgray=(edtValue)*1000000000000.0;


                nanogray=(edtValue)*1000000000000000.0;
                picogray =(edtValue)*1000000000000000000.0;
                femtogray =(edtValue)*1.E+21;
                attogray =(edtValue)*1.E+24;

                break;

            case "Gray - Gy":

                rad=(edtValue)*100;
                millirad=(edtValue)*100000;
                jouleperkilogram=(edtValue)*1;
                joulepergram=(edtValue)*0.001;
                joulepercentigram=(edtValue)*0.00001;
                joulepermilligram=(edtValue)*0.000001;
                gray=(edtValue)*1;
                exagray=(edtValue)*1.E-18;
                petagray=(edtValue)*1.E-15;
                teragray=(edtValue)*1.E-12;
                gigagray=(edtValue)*1.E-9;
                megagray=(edtValue)*0.000001;
                kilogray=(edtValue)*0.001;
                hectogray=(edtValue)*0.01;
                dekagray=(edtValue)*0.1;
                decigray=(edtValue)*10;
                centigray=(edtValue)*100;
                milligray=(edtValue)*1000;
                microgray=(edtValue)*1000000;


                nanogray=(edtValue)*1000000000;
                picogray =(edtValue)*1000000000000.0;
                femtogray =(edtValue)*1000000000000000.0;
                attogray =(edtValue)*1000000000000000000.0;

                break;


            case "Exagray - EGy":

                rad=(edtValue)*100000000000000000000.0;
                millirad=(edtValue)*1.E+23;
                jouleperkilogram=(edtValue)*1000000000000000000.0;
                joulepergram=(edtValue)*1000000000000000.0;
                joulepercentigram=(edtValue)*10000000000000.0;
                joulepermilligram=(edtValue)*1000000000000.0;
                gray=(edtValue)*1000000000000000000.0;
                exagray=(edtValue)*1;
                petagray=(edtValue)*1000;
                teragray=(edtValue)*1000000;
                gigagray=(edtValue)*1000000000;
                megagray=(edtValue)*1000000000000.0;
                kilogray=(edtValue)*1000000000000000.0;
                hectogray=(edtValue)*10000000000000000.0;
                dekagray=(edtValue)*100000000000000000.0;
                decigray=(edtValue)*10000000000000000000.0;
                centigray=(edtValue)*100000000000000000000.0;
                milligray=(edtValue)*1.E+21;
                microgray=(edtValue)*1.E+24;


                nanogray=(edtValue)*1.E+27;
                picogray =(edtValue)*1.E+30;
                femtogray =(edtValue)*1.E+33;
                attogray =(edtValue)*9.999999999E+35;

                break;

            case "Petagray - PGy":

                rad=(edtValue)*99999999999999980.0;
                millirad=(edtValue)*100000000000000000000.0;
                jouleperkilogram=(edtValue)*1000000000000000.0;
                joulepergram=(edtValue)*1000000000000.0;
                joulepercentigram=(edtValue)*10000000000.0;
                joulepermilligram=(edtValue)*1000000000;
                gray=(edtValue)*1000000000000000.0;
                exagray=(edtValue)*0.001;
                petagray=(edtValue)*1;
                teragray=(edtValue)*1000;
                gigagray=(edtValue)*1000000;
                megagray=(edtValue)*1000000000;
                kilogray=(edtValue)*1000000000000.0;
                hectogray=(edtValue)*10000000000000.0;
                dekagray=(edtValue)*100000000000000.0;
                decigray=(edtValue)*10000000000000000.0;
                centigray=(edtValue)*99999999999999980.0;
                milligray=(edtValue)*999999999999999900.0;
                microgray=(edtValue)*999999999999999900000.0;


                nanogray=(edtValue)*1.E+24;
                picogray =(edtValue)*9.999999999E+26;
                femtogray =(edtValue)*1.E+30;
                attogray =(edtValue)*1.E+33;

                break;

            case "Teragray - TGy":

                rad=(edtValue)*100000000000000.0;
                millirad=(edtValue)*100000000000000000.0;
                jouleperkilogram=(edtValue)*1000000000000.0;
                joulepergram=(edtValue)*1000000000;
                joulepercentigram=(edtValue)*10000000;
                joulepermilligram=(edtValue)*1000000;
                gray=(edtValue)*1000000000000.0;
                exagray=(edtValue)*0.000001;
                petagray=(edtValue)*0.001;
                teragray=(edtValue)*1;
                gigagray=(edtValue)*1000;
                megagray=(edtValue)*1000000;
                kilogray=(edtValue)*1000000000;
                hectogray=(edtValue)*10000000000.0;
                dekagray=(edtValue)*100000000000.0;
                decigray=(edtValue)*10000000000000.0;
                centigray=(edtValue)*100000000000000.0;
                milligray=(edtValue)*1000000000000000.0;
                microgray=(edtValue)*1000000000000000000.0;


                nanogray=(edtValue)*1.E+21;
                picogray =(edtValue)*1.E+24;
                femtogray =(edtValue)*1.E+27;
                attogray =(edtValue)*9.999999999E+29;

                break;

            case "Gigagray - GGy":

                rad=(edtValue)*100000000000.0;
                millirad=(edtValue)*100000000000000.0;
                jouleperkilogram=(edtValue)*1000000000;
                joulepergram=(edtValue)*1000000;
                joulepercentigram=(edtValue)*10000;
                joulepermilligram=(edtValue)*1000;
                gray=(edtValue)*1000000000;
                exagray=(edtValue)*1.E-9;
                petagray=(edtValue)*0.000001;
                teragray=(edtValue)*0.001;
                gigagray=(edtValue)*1;
                megagray=(edtValue)*1000;
                kilogray=(edtValue)*1000000;
                hectogray=(edtValue)*10000000;
                dekagray=(edtValue)*100000000;
                decigray=(edtValue)*10000000000.0;
                centigray=(edtValue)*100000000000.0;
                milligray=(edtValue)*1000000000000.0;
                microgray=(edtValue)*1000000000000000.0;


                nanogray=(edtValue)*1000000000000000000.0;
                picogray =(edtValue)*1.E+21;
                femtogray =(edtValue)*1.E+24;
                attogray =(edtValue)*1.E+27;

                break;

            case "Megagray - MGy":

                rad=(edtValue)*100000000;
                millirad=(edtValue)*100000000000.0;
                jouleperkilogram=(edtValue)*1000000;
                joulepergram=(edtValue)*1000;
                joulepercentigram=(edtValue)*10;
                joulepermilligram=(edtValue)*1;
                gray=(edtValue)*1000000;
                exagray=(edtValue)*1.E-12;
                petagray=(edtValue)*1.E-9;
                teragray=(edtValue)*0.000001;
                gigagray=(edtValue)*0.001;
                megagray=(edtValue)*1;
                kilogray=(edtValue)*1000;
                hectogray=(edtValue)*10000;
                dekagray=(edtValue)*100000;
                decigray=(edtValue)*10000000;
                centigray=(edtValue)*100000000;
                milligray=(edtValue)*1000000000;
                microgray=(edtValue)*1000000000000.0;


                nanogray=(edtValue)*1000000000000000.0;
                picogray =(edtValue)*1000000000000000000.0;
                femtogray =(edtValue)*1.E+21;
                attogray =(edtValue)*1.E+24;

                break;

            case "Kilogray - kGy":

                rad=(edtValue)*100000;
                millirad=(edtValue)*100000000;
                jouleperkilogram=(edtValue)*1000;
                joulepergram=(edtValue)*1;
                joulepercentigram=(edtValue)*0.01;
                joulepermilligram=(edtValue)*0.001;
                gray=(edtValue)*1000;
                exagray=(edtValue)*1.E-15;
                petagray=(edtValue)*1.E-12;
                teragray=(edtValue)*1.E-9;
                gigagray=(edtValue)*0.000001;
                megagray=(edtValue)*0.001;
                kilogray=(edtValue)*1;
                hectogray=(edtValue)*10;
                dekagray=(edtValue)*100;
                decigray=(edtValue)*10000;
                centigray=(edtValue)*100000;
                milligray=(edtValue)*1000000;
                microgray=(edtValue)*1000000000;


                nanogray=(edtValue)*1000000000000.0;
                picogray =(edtValue)*1000000000000000.0;
                femtogray =(edtValue)*1000000000000000100.0;
                attogray =(edtValue)*1.E+21;

                break;

            case "Hectogray - hGy":

                rad=(edtValue)*10000;
                millirad=(edtValue)*10000000;
                jouleperkilogram=(edtValue)*100;
                joulepergram=(edtValue)*0.1;
                joulepercentigram=(edtValue)*0.001;
                joulepermilligram=(edtValue)*0.0001;
                gray=(edtValue)*100;
                exagray=(edtValue)*1.E-16;
                petagray=(edtValue)*1.E-13;
                teragray=(edtValue)*1.E-10;
                gigagray=(edtValue)*1.E-7;
                megagray=(edtValue)*0.0001;
                kilogray=(edtValue)*0.1;
                hectogray=(edtValue)*1;
                dekagray=(edtValue)*10;
                decigray=(edtValue)*1000;
                centigray=(edtValue)*10000;
                milligray=(edtValue)*100000;
                microgray=(edtValue)*100000000;


                nanogray=(edtValue)*100000000000.0;
                picogray =(edtValue)*100000000000000.0;
                femtogray =(edtValue)*100000000000000020.0;
                attogray =(edtValue)*100000000000000000000.0;

                break;

            case "Dekagray - daGy":

                rad=(edtValue)*1000;
                millirad=(edtValue)*1000000;
                jouleperkilogram=(edtValue)*10;
                joulepergram=(edtValue)*0.01;
                joulepercentigram=(edtValue)*0.0001;
                joulepermilligram=(edtValue)*0.00001;
                gray=(edtValue)*10;
                exagray=(edtValue)*1.E-17;
                petagray=(edtValue)*1.E-14;
                teragray=(edtValue)*1.E-11;
                gigagray=(edtValue)*1.E-8;
                megagray=(edtValue)*0.00001;
                kilogray=(edtValue)*0.01;
                hectogray=(edtValue)*0.1;
                dekagray=(edtValue)*1;
                decigray=(edtValue)*100;
                centigray=(edtValue)*1000;
                milligray=(edtValue)*10000;
                microgray=(edtValue)*10000000;


                nanogray=(edtValue)*10000000000.0;
                picogray =(edtValue)*10000000000000.0;
                femtogray =(edtValue)*10000000000000000.0;
                attogray =(edtValue)*10000000000000000000.0;

                break;

            case "Decigray - dGy":

                rad=(edtValue)*10;
                millirad=(edtValue)*10000;
                jouleperkilogram=(edtValue)*0.1;
                joulepergram=(edtValue)*0.0001;
                joulepercentigram=(edtValue)*0.000001;
                joulepermilligram=(edtValue)*1.E-7;
                gray=(edtValue)*0.1;
                exagray=(edtValue)*1.E-19;
                petagray=(edtValue)*1.E-16;
                teragray=(edtValue)*1.E-13;
                gigagray=(edtValue)*1.E-10;
                megagray=(edtValue)*1.E-7;
                kilogray=(edtValue)*0.0001;
                hectogray=(edtValue)*0.001;
                dekagray=(edtValue)*0.01;
                decigray=(edtValue)*1;
                centigray=(edtValue)*10;
                milligray=(edtValue)*100;
                microgray=(edtValue)*100000;


                nanogray=(edtValue)*100000000;
                picogray =(edtValue)*100000000000.0;
                femtogray =(edtValue)*100000000000.0;
                attogray =(edtValue)*100000000000000000.0;

                break;

            case "Centigray - cGy":

                rad=(edtValue)*1;
                millirad=(edtValue)*1000;
                jouleperkilogram=(edtValue)*0.01;
                joulepergram=(edtValue)*0.00001;
                joulepercentigram=(edtValue)*1.E-7;
                joulepermilligram=(edtValue)*1.E-8;
                gray=(edtValue)*0.01;
                exagray=(edtValue)*1.E-20;
                petagray=(edtValue)*1.E-17;
                teragray=(edtValue)*1.E-14;
                gigagray=(edtValue)*1.E-11;
                megagray=(edtValue)*1.E-8;
                kilogray=(edtValue)*0.00001;
                hectogray=(edtValue)*0.0001;
                dekagray=(edtValue)*0.001;
                decigray=(edtValue)*0.1;
                centigray=(edtValue)*1;
                milligray=(edtValue)*10;
                microgray=(edtValue)*10000;


                nanogray=(edtValue)*10000000;
                picogray =(edtValue)*10000000000.0;
                femtogray =(edtValue)*10000000000000.0;
                attogray =(edtValue)*10000000000000000.0;

                break;

            case "Milligray - mGy":

                rad=(edtValue)*0.1;
                millirad=(edtValue)*100;
                jouleperkilogram=(edtValue)*0.001;
                joulepergram=(edtValue)*0.000001;
                joulepercentigram=(edtValue)*1.E-8;
                joulepermilligram=(edtValue)*1.E-9;
                gray=(edtValue)*0.001;
                exagray=(edtValue)*1.E-21;
                petagray=(edtValue)*1.E-18;
                teragray=(edtValue)*1.E-15;
                gigagray=(edtValue)*1.E-12;
                megagray=(edtValue)*1.E-9;
                kilogray=(edtValue)*0.000001;
                hectogray=(edtValue)*0.00001;
                dekagray=(edtValue)*0.0001;
                decigray=(edtValue)*0.01;
                centigray=(edtValue)*0.1;
                milligray=(edtValue)*1;
                microgray=(edtValue)*1000;


                nanogray=(edtValue)*1000000;
                picogray =(edtValue)*1000000000;
                femtogray =(edtValue)*1000000000000.0;
                attogray =(edtValue)*1000000000000000.0;

                break;

            case "Microgray - µGy":

                rad=(edtValue)*0.0001;
                millirad=(edtValue)*0.1;
                jouleperkilogram=(edtValue)*0.000001;
                joulepergram=(edtValue)*1.E-9;
                joulepercentigram=(edtValue)*1.E-11;
                joulepermilligram=(edtValue)*1.E-12;
                gray=(edtValue)*0.000001;
                exagray=(edtValue)*1.E-24;
                petagray=(edtValue)*1.E-21;
                teragray=(edtValue)*1.E-18;
                gigagray=(edtValue)*1.E-15;
                megagray=(edtValue)*1.E-12;
                kilogray=(edtValue)*1.E-9;
                hectogray=(edtValue)*1.E-8;
                dekagray=(edtValue)*1.E-7;
                decigray=(edtValue)*0.00001;
                centigray=(edtValue)*0.0001;
                milligray=(edtValue)*0.001;
                microgray=(edtValue)*1;


                nanogray=(edtValue)*1000;
                picogray =(edtValue)*1000000;
                femtogray =(edtValue)*1000000000;
                attogray =(edtValue)*1000000000000.0;

                break;

            case "Nanogray - nGy":

                rad=(edtValue)*1.E-7;
                millirad=(edtValue)*0.0001;
                jouleperkilogram=(edtValue)*1.E-9;
                joulepergram=(edtValue)*1.E-12;
                joulepercentigram=(edtValue)*1.E-14;
                joulepermilligram=(edtValue)*1.E-15;
                gray=(edtValue)*1.E-9;
                exagray=(edtValue)*1.E-27;
                petagray=(edtValue)*1.E-24;
                teragray=(edtValue)*1.E-21;
                gigagray=(edtValue)*1.E-18;
                megagray=(edtValue)*1.E-15;
                kilogray=(edtValue)*1.E-12;
                hectogray=(edtValue)*1.E-11;
                dekagray=(edtValue)*1.E-10;
                decigray=(edtValue)*1.E-8;
                centigray=(edtValue)*1.E-7;
                milligray=(edtValue)*0.000001;
                microgray=(edtValue)*0.001;


                nanogray=(edtValue)*1;
                picogray =(edtValue)*1000;
                femtogray =(edtValue)*1000000;
                attogray =(edtValue)*1000000000;

                break;

            case "Picogray - pGy":

                rad=(edtValue)*1.E-10;
                millirad=(edtValue)*1.E-7;
                jouleperkilogram=(edtValue)*1.E-12;
                joulepergram=(edtValue)*1.E-15;
                joulepercentigram=(edtValue)*1.E-17;
                joulepermilligram=(edtValue)*1.E-18;
                gray=(edtValue)*1.E-12;
                exagray=(edtValue)*1.E-30;
                petagray=(edtValue)*1.E-27;
                teragray=(edtValue)*1.E-24;
                gigagray=(edtValue)*1.E-21;
                megagray=(edtValue)*1.E-18;
                kilogray=(edtValue)*1.E-15;
                hectogray=(edtValue)*1.E-14;
                dekagray=(edtValue)*1.E-13;
                decigray=(edtValue)*1.E-11;
                centigray=(edtValue)*1.E-10;
                milligray=(edtValue)*1.E-9;
                microgray=(edtValue)*0.000001;


                nanogray=(edtValue)*0.001;
                picogray =(edtValue)*1;
                femtogray =(edtValue)*1000;
                attogray =(edtValue)*1000000;

                break;

            case "Femtogray - fGy":

                rad=(edtValue)*9.999999999E-14;
                millirad=(edtValue)*9.999999999E-11;
                jouleperkilogram=(edtValue)*9.999999999E-16;
                joulepergram=(edtValue)*9.999999999E-19;
                joulepercentigram=(edtValue)*1.E-20;
                joulepermilligram=(edtValue)*1.E-21;
                gray=(edtValue)*9.999999999E-16;
                exagray=(edtValue)*9.999999999E-34;
                petagray=(edtValue)*9.999999999E-31;
                teragray=(edtValue)*9.999999999E-28;
                gigagray=(edtValue)*1.E-24;
                megagray=(edtValue)*1.E-21;
                kilogray=(edtValue)*9.999999999E-19;
                hectogray=(edtValue)*9.999999999E-18;
                dekagray=(edtValue)*9.999999999E-17;
                decigray=(edtValue)*9.999999999E-15;
                centigray=(edtValue)*9.999999999E-14;
                milligray=(edtValue)*1.E-12;
                microgray=(edtValue)*9.999999999E-10;


                nanogray=(edtValue)*0.000001;
                picogray =(edtValue)*0.001;
                femtogray =(edtValue)*1;
                attogray =(edtValue)*1000;

                break;

            case "Attogray - aGy":

                rad=(edtValue)*1.E-16;
                millirad=(edtValue)*1.E-13;
                jouleperkilogram=(edtValue)*1.E-18;
                joulepergram=(edtValue)*1.E-21;
                joulepercentigram=(edtValue)*1.E-23;
                joulepermilligram=(edtValue)*1.E-24;
                gray=(edtValue)*1.E-18;
                exagray=(edtValue)*1.E-36;
                petagray=(edtValue)*1.E-33;
                teragray=(edtValue)*1.E-30;
                gigagray=(edtValue)*1.E-27;
                megagray=(edtValue)*1.E-24;
                kilogray=(edtValue)*1.E-21;
                hectogray=(edtValue)*1.E-20;
                dekagray=(edtValue)*1.E-19;
                decigray=(edtValue)*1.E-17;
                centigray=(edtValue)*1.E-16;
                milligray=(edtValue)*1.E-15;
                microgray=(edtValue)*1.E-12;


                nanogray=(edtValue)*1.E-9;
                picogray =(edtValue)*0.000001;
                femtogray =(edtValue)*0.001;
                attogray =(edtValue)*1;

        }


        results. setRad( rad);

        results. setMillirad( millirad) ;
        results. setJouleperkilogram( jouleperkilogram);

        results. setJoulepergram( joulepergram) ;

        results. setJoulepercentigram( joulepercentigram);
        results. setJoulepermilligram( joulepermilligram);

        results. setGray( gray);
        results. setExagray( exagray);
        results. setPetagray( petagray) ;

        results. setTeragray( teragray);

        results. setGigagray( gigagray) ;

        results. setMegagray( megagray);

        results. setKilogray( kilogray);

        results. setHectogray( hectogray);
        results. setDekagray( dekagray) ;

        results. setDecigray( decigray) ;
        results. setCentigray( centigray);

        results. setMilligray( milligray) ;
        results. setMicrogray( microgray);
        results. setNanogray( nanogray) ;

        results. setPicogray( picogray);

        results. setFemtogray( femtogray);

        results. setAttogray( attogray);

        converterArray.add(results);
        return converterArray;


    }
    public class ConversionResults{

        private double rad  ,millirad  ,jouleperkilogram ,joulepergram  ,joulepercentigram  ,joulepermilligram  ,gray  ,exagray  ,petagray  ,teragray  ,gigagray  ,megagray  ,kilogray  ,hectogray ,dekagray ,decigray ,centigray,milligray , microgray ,nanogray,picogray,femtogray ,attogray   ;

        public double getRad() {
            return rad;
        }

        public void setRad(double rad) {
            this.rad = rad;
        }

        public double getMillirad() {
            return millirad;
        }

        public void setMillirad(double millirad) {
            this.millirad = millirad;
        }

        public double getJouleperkilogram() {
            return jouleperkilogram;
        }

        public void setJouleperkilogram(double jouleperkilogram) {
            this.jouleperkilogram = jouleperkilogram;
        }

        public double getJoulepergram() {
            return joulepergram;
        }

        public void setJoulepergram(double joulepergram) {
            this.joulepergram = joulepergram;
        }

        public double getJoulepercentigram() {
            return joulepercentigram;
        }

        public void setJoulepercentigram(double joulepercentigram) {
            this.joulepercentigram = joulepercentigram;
        }

        public double getJoulepermilligram() {
            return joulepermilligram;
        }

        public void setJoulepermilligram(double joulepermilligram) {
            this.joulepermilligram = joulepermilligram;
        }

        public double getGray() {
            return gray;
        }

        public void setGray(double gray) {
            this.gray = gray;
        }

        public double getExagray() {
            return exagray;
        }

        public void setExagray(double exagray) {
            this.exagray = exagray;
        }

        public double getPetagray() {
            return petagray;
        }

        public void setPetagray(double petagray) {
            this.petagray = petagray;
        }

        public double getTeragray() {
            return teragray;
        }

        public void setTeragray(double teragray) {
            this.teragray = teragray;
        }

        public double getGigagray() {
            return gigagray;
        }

        public void setGigagray(double gigagray) {
            this.gigagray = gigagray;
        }

        public double getMegagray() {
            return megagray;
        }

        public void setMegagray(double megagray) {
            this.megagray = megagray;
        }

        public double getKilogray() {
            return kilogray;
        }

        public void setKilogray(double kilogray) {
            this.kilogray = kilogray;
        }

        public double getHectogray() {
            return hectogray;
        }

        public void setHectogray(double hectogray) {
            this.hectogray = hectogray;
        }

        public double getDekagray() {
            return dekagray;
        }

        public void setDekagray(double dekagray) {
            this.dekagray = dekagray;
        }

        public double getDecigray() {
            return decigray;
        }

        public void setDecigray(double decigray) {
            this.decigray = decigray;
        }

        public double getCentigray() {
            return centigray;
        }

        public void setCentigray(double centigray) {
            this.centigray = centigray;
        }

        public double getMilligray() {
            return milligray;
        }

        public void setMilligray(double milligray) {
            this.milligray = milligray;
        }

        public double getMicrogray() {
            return microgray;
        }

        public void setMicrogray(double microgray) {
            this.microgray = microgray;
        }

        public double getNanogray() {
            return nanogray;
        }

        public void setNanogray(double nanogray) {
            this.nanogray = nanogray;
        }

        public double getPicogray() {
            return picogray;
        }

        public void setPicogray(double picogray) {
            this.picogray = picogray;
        }

        public double getFemtogray() {
            return femtogray;
        }

        public void setFemtogray(double femtogray) {
            this.femtogray = femtogray;
        }

        public double getAttogray() {
            return attogray;
        }

        public void setAttogray(double attogray) {
            this.attogray = attogray;
        }


    }


   /* public static void main(String[] args) {
        // TODO Auto-generated method stub
        RadiatoinAbsobedDose iA = new RadiatoinAbsobedDose("exagray",1);

        ArrayList<RadiatoinAbsobedDose.ConversionResults> results = iA.calculateRadiationAbosirbedConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            RadiatoinAbsobedDose.ConversionResults item  =  results.get(i);
            System.out.println("\n rad  - " +new DecimalFormat("##.################").format( item.getRad ())
                    +"\n millirad - " +new DecimalFormat("##.################").format( item.getMillirad ())
                    +"\n jouleperkilogram - " +new DecimalFormat("##.################").format( item.getJouleperkilogram())+
                    "\n joulepergram - " +new DecimalFormat("##.################").format( item.getJoulepergram())+
                    "\n joulepercentigram - " +new DecimalFormat("##.################").format( item.getJoulepercentigram())+
                    "\n joulepermilligram- " +new DecimalFormat("##.################").format( item.getJoulepermilligram())+
                    "\n gray- " +new DecimalFormat("##.################").format( item.getGray())+
                    "\n exagray - " +new DecimalFormat("##.################").format( item.getExagray())+
                    "\n petagray - " +new DecimalFormat("##.################").format( item.getPetagray())+
                    "\n teragray - " +new DecimalFormat("##.################").format( item.getTeragray())+
                    "\n gigagray - " +new DecimalFormat("##.################").format( item.getGigagray())+
                    "\n megagray - " +new DecimalFormat("##.################").format( item.getMegagray())+
                    "\n kilogray - " +new DecimalFormat("##.################").format( item.getKilogray())+
                    "\n hectogray - " +new DecimalFormat("##.################").format( item.getHectogray())+
                    "\n dekagray- " +new DecimalFormat("##.################").format( item.getDekagray())+
                    "\n decigray- " +new DecimalFormat("##.################").format( item.getDecigray())+


                    "\n centigray - " +new DecimalFormat("##.################").format( item.getCentigray())+
                    "\n microgray - " +new DecimalFormat("##.################").format( item.getMicrogray())+
                    "\n milligray - " +new DecimalFormat("##.################").format( item.getMilligray())+
                    "\n nanogray- " +new DecimalFormat("##.################").format( item.getNanogray())+
                    "\n picogray- " +new DecimalFormat("##.################").format( item.getPicogray())+

                    "\n femtogray - " +new DecimalFormat("##.################").format( item.getFemtogray())+
                    "\n attogray - " +new DecimalFormat("##.################").format( item.getAttogray())


            );



        }
    }
*/

}