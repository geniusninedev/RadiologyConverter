package com.nineinfosys.radiologyconverter.Engin;

import java.util.ArrayList;


public class RadiationExposureConverter {


    private double  coulombperkilogram  , millicoulombperkilogram  , microcoulombperkilogram ,roentgen  ,tissueroentgen ,parker   ,rep ;
    private double edtValue;
    private String conversionFrom;


    public RadiationExposureConverter(String conversionFrom, int edtValue) {
        // TODO Auto-generated constructor stub
        this.conversionFrom = conversionFrom;
        this.edtValue = edtValue;
    }

    public ArrayList<ConversionResults> calculateRadiationExposureConversion()
    {

        ArrayList<ConversionResults> converterArray = new ArrayList<ConversionResults>();

        ConversionResults results= new ConversionResults();

        switch(conversionFrom)
        {
            case "Coulomb/kilogram - C/kg":

                coulombperkilogram=(edtValue)*1;
                millicoulombperkilogram=(edtValue)*1000;
                microcoulombperkilogram=(edtValue)*1000000;
                roentgen=(edtValue)*3875.9689922;
                tissueroentgen=(edtValue)*3875.9689922;
                parker=(edtValue)*3875.9689922;
                rep=(edtValue)*3875.9689922;


                break;

            case "Millicoulomb/kilogram - mC/kg":

                coulombperkilogram=(edtValue)*0.001;
                millicoulombperkilogram=(edtValue)*1;
                microcoulombperkilogram=(edtValue)*1000;
                roentgen=(edtValue)*3.8759689922;
                tissueroentgen=(edtValue)*3.8759689922;
                parker=(edtValue)*3.8759689922;
                rep=(edtValue)*3.8759689922;


                break;

            case "Microcoulomb/kilogram - μC/kg":

                coulombperkilogram=(edtValue)*0.000001;
                millicoulombperkilogram=(edtValue)*0.001;
                microcoulombperkilogram=(edtValue)*1;
                roentgen=(edtValue)*0.003875969;
                tissueroentgen=(edtValue)*0.003875969;
                parker=(edtValue)*0.003875969;
                rep=(edtValue)*0.003875969;


                break;


            case "Roentgen - R":

                coulombperkilogram=(edtValue)*0.000258;
                millicoulombperkilogram=(edtValue)*0.258;
                microcoulombperkilogram=(edtValue)*258;
                roentgen=(edtValue)*1;
                tissueroentgen=(edtValue)*1;
                parker=(edtValue)*1;
                rep=(edtValue)*1;


                break;

            case "Tissue roentgen - Tr":

                coulombperkilogram=(edtValue)*0.000258;
                millicoulombperkilogram=(edtValue)*0.258;
                microcoulombperkilogram=(edtValue)*258;
                roentgen=(edtValue)*1;
                tissueroentgen=(edtValue)*1;
                parker=(edtValue)*1;
                rep=(edtValue)*1;


                break;

            case "Parker - parker":


                coulombperkilogram=(edtValue)*0.000258;
                millicoulombperkilogram=(edtValue)*0.258;
                microcoulombperkilogram=(edtValue)*258;
                roentgen=(edtValue)*1;
                tissueroentgen=(edtValue)*1;
                parker=(edtValue)*1;
                rep=(edtValue)*1;



                break;


            case "Rep - rep":

                coulombperkilogram=(edtValue)*0.000258;
                millicoulombperkilogram=(edtValue)*0.258;
                microcoulombperkilogram=(edtValue)*258;
                roentgen=(edtValue)*1;
                tissueroentgen=(edtValue)*1;
                parker=(edtValue)*1;
                rep=(edtValue)*1;




        }


        results. setCoulombperkilogram( coulombperkilogram);
        results. setMillicoulombperkilogram( millicoulombperkilogram);

        results. setMicrocoulombperkilogram( microcoulombperkilogram) ;


        results. setRoentgen( roentgen) ;

        results. setTissueroentgen( tissueroentgen) ;

        results. setParker( parker) ;

        results. setRep( rep);




        converterArray.add(results);
        return converterArray;
    }

    public class ConversionResults{

        private double  coulombperkilogram  , millicoulombperkilogram  , microcoulombperkilogram ,roentgen  ,tissueroentgen ,parker   ,rep ;

        public double getCoulombperkilogram() {
            return coulombperkilogram;
        }

        public void setCoulombperkilogram(double coulombperkilogram) {
            this.coulombperkilogram = coulombperkilogram;
        }

        public double getMillicoulombperkilogram() {
            return millicoulombperkilogram;
        }

        public void setMillicoulombperkilogram(double millicoulombperkilogram) {
            this.millicoulombperkilogram = millicoulombperkilogram;
        }

        public double getMicrocoulombperkilogram() {
            return microcoulombperkilogram;
        }

        public void setMicrocoulombperkilogram(double microcoulombperkilogram) {
            this.microcoulombperkilogram = microcoulombperkilogram;
        }

        public double getRoentgen() {
            return roentgen;
        }

        public void setRoentgen(double roentgen) {
            this.roentgen = roentgen;
        }

        public double getTissueroentgen() {
            return tissueroentgen;
        }

        public void setTissueroentgen(double tissueroentgen) {
            this.tissueroentgen = tissueroentgen;
        }

        public double getParker() {
            return parker;
        }

        public void setParker(double parker) {
            this.parker = parker;
        }

        public double getRep() {
            return rep;
        }

        public void setRep(double rep) {
            this.rep = rep;
        }


    }

   /* public static void main(String[] args) {
        // TODO Auto-generated method stub
        RadiationExposure iA = new RadiationExposure("coulombperkilogram",1);

        ArrayList<RadiationExposure.ConversionResults> results = iA.calculateRadiationExposureConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            RadiationExposure.ConversionResults item  =  results.get(i);

            System.out.println("\n coulombperkilogram - " +new DecimalFormat("##.################").format( item.getCoulombperkilogram())
                    +"\n millicoulombperkilogram- " +new DecimalFormat("##.################").format( item.getMillicoulombperkilogram())
                    +"\n microcoulombperkilogram - " +new DecimalFormat("##.################").format( item.getMicrocoulombperkilogram())+
                    "\n roentgen - " +new DecimalFormat("##.################").format( item.getRoentgen())+
                    "\n tissueroentgen - " +new DecimalFormat("##.################").format( item.getTissueroentgen())+
                    "\n parker- " +new DecimalFormat("##.################").format( item.getParker())+
                    "\n rep- " +new DecimalFormat("##.################").format( item.getRep())


            );



        }
    }

*/

}

