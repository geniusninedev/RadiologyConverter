package com.nineinfosys.radiologyconverter.Engin;


        import java.util.ArrayList;


public class RadiationActivityConverter {


    private double becquerel ,terabecquerel ,gigabecquerel ,megabecquerel ,kilobecquerel ,millibecquerel  ,curie ,kilocurie ,millicurie ,microcurie ,nanocurie ,picocurie ,rutherford ,onepersecond,disintegrationspersecond,disintegrationsperminute;
    private double edtValue;
    private String conversionFrom;


    public RadiationActivityConverter(String conversionFrom, int edtValue) {
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
            case "Becquerel - Bq":

                becquerel=(edtValue)*1;
                terabecquerel=(edtValue)*1.E-12;
                gigabecquerel=(edtValue)*1.E-9;
                megabecquerel=(edtValue)*0.000001;
                kilobecquerel=(edtValue)*0.001;
                millibecquerel=(edtValue)*1000;
                curie=(edtValue)*2.702702702E-11;
                kilocurie=(edtValue)*2.702702702E-14;
                millicurie=(edtValue)*2.702702702E-8;
                microcurie=(edtValue)*0.000027027;
                nanocurie=(edtValue)*0.027027027;
                picocurie=(edtValue)*27.027027027;
                rutherford=(edtValue)*0.000001;
                onepersecond=(edtValue)*1;
                disintegrationspersecond=(edtValue)*1;
                disintegrationsperminute=(edtValue)*60;

                break;

            case "Terabecquerel - TBq":

                becquerel=(edtValue)*1000000000000.0;
                terabecquerel=(edtValue)*1;
                gigabecquerel=(edtValue)*1000;
                megabecquerel=(edtValue)*1000000;
                kilobecquerel=(edtValue)*1000000000;

                millibecquerel=(edtValue)*1000000000000000.0;
                curie=(edtValue)*27.027027027;
                kilocurie=(edtValue)*0.027027027;
                millicurie=(edtValue)*27027.027027;
                microcurie=(edtValue)*27027027.027;
                nanocurie=(edtValue)*27027027027.0;
                picocurie=(edtValue)*27027027027027.0;
                rutherford=(edtValue)*1000000;
                onepersecond=(edtValue)*1000000000000.0;
                disintegrationspersecond=(edtValue)*1000000000000.0;
                disintegrationsperminute=(edtValue)*60000000000000.0;

                break;

            case "Gigabecquerel - GBq":

                becquerel=(edtValue)*1000000000;
                terabecquerel=(edtValue)*0.001;
                gigabecquerel=(edtValue)*1;
                megabecquerel=(edtValue)*1000;
                kilobecquerel=(edtValue)*1000000;

                millibecquerel=(edtValue)*1000000000000.0;
                curie=(edtValue)*0.027027027;
                kilocurie=(edtValue)*0.000027027;
                millicurie=(edtValue)*27.027027027;
                microcurie=(edtValue)*27027.027027;
                nanocurie=(edtValue)*27027027.027;
                picocurie=(edtValue)*27027027027.0;
                rutherford=(edtValue)*1000;
                onepersecond=(edtValue)*1000000000.0;
                disintegrationspersecond=(edtValue)*1000000000.0;
                disintegrationsperminute=(edtValue)*60000000000.0;

                break;

            case "Megabecquerel - MBq":

                becquerel=(edtValue)*1000000;
                terabecquerel=(edtValue)*0.000001;
                gigabecquerel=(edtValue)*0.001;
                megabecquerel=(edtValue)*1;
                kilobecquerel=(edtValue)*1000;

                millibecquerel=(edtValue)*1000000000;
                curie=(edtValue)*0.000027027;
                kilocurie=(edtValue)*2.702702702E-8;
                millicurie=(edtValue)*0.027027027;
                microcurie=(edtValue)*27.027027027;
                nanocurie=(edtValue)*27027.027027;
                picocurie=(edtValue)*27027027.027;
                rutherford=(edtValue)*1;
                onepersecond=(edtValue)*1000000;
                disintegrationspersecond=(edtValue)*1000000;
                disintegrationsperminute=(edtValue)*60000000;

                break;


            case "Kilobecquerel - kBq":

                becquerel=(edtValue)*1000;
                terabecquerel=(edtValue)*1.E-9;
                gigabecquerel=(edtValue)*0.000001;
                megabecquerel=(edtValue)*0.001;
                kilobecquerel=(edtValue)*1;

                millibecquerel=(edtValue)*1000000;
                curie=(edtValue)*2.702702702E-8;
                kilocurie=(edtValue)*2.702702702E-11;
                millicurie=(edtValue)*0.000027027;
                microcurie=(edtValue)*0.027027027;
                nanocurie=(edtValue)*27.027027027;
                picocurie=(edtValue)*27027.027027;
                rutherford=(edtValue)*0.001;
                onepersecond=(edtValue)*1000;
                disintegrationspersecond=(edtValue)*1000;
                disintegrationsperminute=(edtValue)*60000;

                break;



            case "Millibecquerel - mBq":

                becquerel=(edtValue)*0.001;
                terabecquerel=(edtValue)*9.999999999E-16;
                gigabecquerel=(edtValue)*1.E-12;
                megabecquerel=(edtValue)*9.999999999E-10;
                kilobecquerel=(edtValue)*0.000001;

                millibecquerel=(edtValue)*1;
                curie=(edtValue)*2.702702702E-14;
                kilocurie=(edtValue)*2.702702702E-17;
                millicurie=(edtValue)*2.702702702E-11;
                microcurie=(edtValue)*2.702702702E-8;
                nanocurie=(edtValue)*0.000027027;
                picocurie=(edtValue)*0.027027027;
                rutherford=(edtValue)*9.999999999E-10;
                onepersecond=(edtValue)*0.001;
                disintegrationspersecond=(edtValue)*0.001;
                disintegrationsperminute=(edtValue)*0.06;

                break;



            case "Curie - Ci":

                becquerel=(edtValue)*37000000000.0;
                terabecquerel=(edtValue)*0.037;
                gigabecquerel=(edtValue)*37;
                megabecquerel=(edtValue)*37000;
                kilobecquerel=(edtValue)*37000000;

                millibecquerel=(edtValue)*37000000000000.0;
                curie=(edtValue)*1;
                kilocurie=(edtValue)*0.001;
                millicurie=(edtValue)*1000;
                microcurie=(edtValue)*1000000;
                nanocurie=(edtValue)*1000000000;
                picocurie=(edtValue)*1000000000000.0;
                rutherford=(edtValue)*37000;
                onepersecond=(edtValue)*37000000000.0;
                disintegrationspersecond=(edtValue)*37000000000.0;
                disintegrationsperminute=(edtValue)*2220000000000.0;

                break;



            case "Kilocurie - kCi":

                becquerel=(edtValue)*37000000000000.0;
                terabecquerel=(edtValue)*37;
                gigabecquerel=(edtValue)*37000;
                megabecquerel=(edtValue)*37000000;
                kilobecquerel=(edtValue)*37000000000.0;

                millibecquerel=(edtValue)*37000000000000040.0;
                curie=(edtValue)*1000;
                kilocurie=(edtValue)*1;
                millicurie=(edtValue)*1000000;
                microcurie=(edtValue)*1000000000;
                nanocurie=(edtValue)*1000000000000.0;
                picocurie=(edtValue)*1000000000000000.0;
                rutherford=(edtValue)*37000000;
                onepersecond=(edtValue)*37000000000000.0;
                disintegrationspersecond=(edtValue)*37000000000000.0;
                disintegrationsperminute=(edtValue)*2220000000000002.0;

                break;


            case "Millicurie - mCi":

                becquerel=(edtValue)*37000000;
                terabecquerel=(edtValue)*0.000037;
                gigabecquerel=(edtValue)*0.037;
                megabecquerel=(edtValue)*37;
                kilobecquerel=(edtValue)*37000;

                millibecquerel=(edtValue)*37000000000.0;
                curie=(edtValue)*0.001;
                kilocurie=(edtValue)*0.000001;
                millicurie=(edtValue)*1;
                microcurie=(edtValue)*1000;
                nanocurie=(edtValue)*1000000;
                picocurie=(edtValue)*1000000000;
                rutherford=(edtValue)*37;
                onepersecond=(edtValue)*37000000;
                disintegrationspersecond=(edtValue)*37000000;
                disintegrationsperminute=(edtValue)*2220000000.0;
                break;



            case "Microcurie - µCi":

                becquerel=(edtValue)*37000;
                terabecquerel=(edtValue)*3.7E-8;
                gigabecquerel=(edtValue)*0.000037;
                megabecquerel=(edtValue)*0.037;
                kilobecquerel=(edtValue)*37;

                millibecquerel=(edtValue)*37000000;
                curie=(edtValue)*0.000001;
                kilocurie=(edtValue)*9.999999999E-10;
                millicurie=(edtValue)*0.001;
                microcurie=(edtValue)*1;
                nanocurie=(edtValue)*1000;
                picocurie=(edtValue)*1000000;
                rutherford=(edtValue)*0.037;
                onepersecond=(edtValue)*37000;
                disintegrationspersecond=(edtValue)*37000;
                disintegrationsperminute=(edtValue)*2220000;

                break;


            case "Nanocurie - nCi":

                becquerel=(edtValue)*37;
                terabecquerel=(edtValue)*3.7E-11;
                gigabecquerel=(edtValue)*3.7E-8;
                megabecquerel=(edtValue)*0.000037;
                kilobecquerel=(edtValue)*0.037;

                millibecquerel=(edtValue)*37000;
                curie=(edtValue)*9.999999999E-10;
                kilocurie=(edtValue)*1.E-12;
                millicurie=(edtValue)*0.000001;
                microcurie=(edtValue)*0.001;
                nanocurie=(edtValue)*1;
                picocurie=(edtValue)*1000;
                rutherford=(edtValue)*0.000037;
                onepersecond=(edtValue)*37;
                disintegrationspersecond=(edtValue)*37;
                disintegrationsperminute=(edtValue)*2220;

                break;


            case "Picocurie - pCi":

                becquerel=(edtValue)*0.037;
                terabecquerel=(edtValue)*3.7E-14;
                gigabecquerel=(edtValue)*3.7E-11;
                megabecquerel=(edtValue)*3.7E-8;
                kilobecquerel=(edtValue)*0.000037;

                millibecquerel=(edtValue)*37;
                curie=(edtValue)*1.E-12;
                kilocurie=(edtValue)*1.E-15;
                millicurie=(edtValue)*1.E-9;
                microcurie=(edtValue)*0.000001;
                nanocurie=(edtValue)*0.001;
                picocurie=(edtValue)*1;
                rutherford=(edtValue)*3.7E-8;
                onepersecond=(edtValue)*0.037;
                disintegrationspersecond=(edtValue)*0.037;
                disintegrationsperminute=(edtValue)*2.22;

                break;


            case "Rutherford - R":

                becquerel=(edtValue)*1000000;
                terabecquerel=(edtValue)*0.000001;
                gigabecquerel=(edtValue)*0.001;
                megabecquerel=(edtValue)*1;
                kilobecquerel=(edtValue)*1000;

                millibecquerel=(edtValue)*1000000000;
                curie=(edtValue)*0.000027027;
                kilocurie=(edtValue)*2.702702702E-8;
                millicurie=(edtValue)*0.027027027;
                microcurie=(edtValue)*27.027027027;
                nanocurie=(edtValue)*27027.027027;
                picocurie=(edtValue)*27027027.027;
                rutherford=(edtValue)*1;
                onepersecond=(edtValue)*1000000;
                disintegrationspersecond=(edtValue)*1000000;
                disintegrationsperminute=(edtValue)*60000000;

                break;


            case "One/second - 1/s":

                becquerel=(edtValue)*1;
                terabecquerel=(edtValue)*1.E-12;
                gigabecquerel=(edtValue)*1.E-9;
                megabecquerel=(edtValue)*0.000001;
                kilobecquerel=(edtValue)*0.001;

                millibecquerel=(edtValue)*1000;
                curie=(edtValue)*2.702702702E-11;
                kilocurie=(edtValue)*2.702702702E-14;
                millicurie=(edtValue)*2.702702702E-8;
                microcurie=(edtValue)*0.000027027;
                nanocurie=(edtValue)*0.027027027;
                picocurie=(edtValue)*27.027027027;
                rutherford=(edtValue)*0.000001;
                onepersecond=(edtValue)*1;
                disintegrationspersecond=(edtValue)*1;
                disintegrationsperminute=(edtValue)*60;

                break;


            case "Disintegrations/second - dis/sec":

                becquerel=(edtValue)*1;
                terabecquerel=(edtValue)*1.E-12;
                gigabecquerel=(edtValue)*1.E-9;
                megabecquerel=(edtValue)*0.000001;
                kilobecquerel=(edtValue)*0.001;

                millibecquerel=(edtValue)*1000;
                curie=(edtValue)*2.702702702E-11;
                kilocurie=(edtValue)*2.702702702E-14;
                millicurie=(edtValue)*2.702702702E-8;
                microcurie=(edtValue)*0.000027027;
                nanocurie=(edtValue)*0.027027027;
                picocurie=(edtValue)*27.027027027;
                rutherford=(edtValue)*0.000001;
                onepersecond=(edtValue)*1;
                disintegrationspersecond=(edtValue)*1;
                disintegrationsperminute=(edtValue)*60;

                break;


            case "Disintegrations/minute - dis/min":

                becquerel=(edtValue)*0.0166666667;
                terabecquerel=(edtValue)*1.666666666E-14;
                gigabecquerel=(edtValue)*1.666666666E-11;
                megabecquerel=(edtValue)*1.666666666E-8;
                kilobecquerel=(edtValue)*0.0000166667;

                millibecquerel=(edtValue)*16.666666667;
                curie=(edtValue)*4.504504504E-13;
                kilocurie=(edtValue)*4.504504504E-16;
                millicurie=(edtValue)*4.504504504E-10;
                microcurie=(edtValue)*4.504504504E-7;
                nanocurie=(edtValue)*0.0004504505;
                picocurie=(edtValue)*0.4504504505;
                rutherford=(edtValue)*1.666666666E-8;
                onepersecond=(edtValue)*0.0166666667;
                disintegrationspersecond=(edtValue)*0.0166666667;
                disintegrationsperminute=(edtValue)*1;




        }




        results. setBecquerel( becquerel);

        results. setTerabecquerel( terabecquerel);

        results. setGigabecquerel( gigabecquerel);

        results. setMegabecquerel( megabecquerel);

        results. setKilobecquerel( kilobecquerel) ;
        results. setMillibecquerel( millibecquerel);

        results. setCurie( curie) ;

        results. setKilocurie( kilocurie) ;

        results. setMillicurie( millicurie) ;


        results. setMicrocurie( microcurie) ;

        results. setNanocurie( nanocurie) ;

        results. setPicocurie( picocurie) ;

        results. setRutherford( rutherford);

        results. setOnepersecond( onepersecond) ;

        results. setDisintegrationspersecond( disintegrationspersecond);

        results. setDisintegrationsperminute( disintegrationsperminute) ;





        converterArray.add(results);
        return converterArray;

    }

    public class ConversionResults{

        private double becquerel ,terabecquerel ,gigabecquerel ,megabecquerel ,kilobecquerel ,millibecquerel  ,curie ,kilocurie ,millicurie ,microcurie ,nanocurie ,picocurie ,rutherford ,onepersecond,disintegrationspersecond,disintegrationsperminute;

        public double getBecquerel() {
            return becquerel;
        }

        public void setBecquerel(double becquerel) {
            this.becquerel = becquerel;
        }

        public double getTerabecquerel() {
            return terabecquerel;
        }

        public void setTerabecquerel(double terabecquerel) {
            this.terabecquerel = terabecquerel;
        }

        public double getGigabecquerel() {
            return gigabecquerel;
        }

        public void setGigabecquerel(double gigabecquerel) {
            this.gigabecquerel = gigabecquerel;
        }

        public double getMegabecquerel() {
            return megabecquerel;
        }

        public void setMegabecquerel(double megabecquerel) {
            this.megabecquerel = megabecquerel;
        }

        public double getKilobecquerel() {
            return kilobecquerel;
        }

        public void setKilobecquerel(double kilobecquerel) {
            this.kilobecquerel = kilobecquerel;
        }

        public double getMillibecquerel() {
            return millibecquerel;
        }

        public void setMillibecquerel(double millibecquerel) {
            this.millibecquerel = millibecquerel;
        }

        public double getCurie() {
            return curie;
        }

        public void setCurie(double curie) {
            this.curie = curie;
        }

        public double getKilocurie() {
            return kilocurie;
        }

        public void setKilocurie(double kilocurie) {
            this.kilocurie = kilocurie;
        }

        public double getMillicurie() {
            return millicurie;
        }

        public void setMillicurie(double millicurie) {
            this.millicurie = millicurie;
        }

        public double getMicrocurie() {
            return microcurie;
        }

        public void setMicrocurie(double microcurie) {
            this.microcurie = microcurie;
        }

        public double getNanocurie() {
            return nanocurie;
        }

        public void setNanocurie(double nanocurie) {
            this.nanocurie = nanocurie;
        }

        public double getPicocurie() {
            return picocurie;
        }

        public void setPicocurie(double picocurie) {
            this.picocurie = picocurie;
        }

        public double getRutherford() {
            return rutherford;
        }

        public void setRutherford(double rutherford) {
            this.rutherford = rutherford;
        }

        public double getOnepersecond() {
            return onepersecond;
        }

        public void setOnepersecond(double onepersecond) {
            this.onepersecond = onepersecond;
        }

        public double getDisintegrationspersecond() {
            return disintegrationspersecond;
        }

        public void setDisintegrationspersecond(double disintegrationspersecond) {
            this.disintegrationspersecond = disintegrationspersecond;
        }

        public double getDisintegrationsperminute() {
            return disintegrationsperminute;
        }

        public void setDisintegrationsperminute(double disintegrationsperminute) {
            this.disintegrationsperminute = disintegrationsperminute;
        }


    }

    /*public static void main(String[] args) {
        // TODO Auto-generated method stub
        RadiationActivity iA = new RadiationActivity("disintegrationsperminute",1);

        ArrayList<RadiationActivity.ConversionResults> results = iA.calculateRadiationConversion();
        int length = results.size();




        for(int i = 0; i <length; i++){

            RadiationActivity.ConversionResults item  =  results.get(i);
            System.out.println("\n becquerel - " +new DecimalFormat("##.################").format( item.getBecquerel())
                    +"\n terabecquerel- " +new DecimalFormat("##.################").format( item.getTerabecquerel())
                    +"\n gigabecquerel - " +new DecimalFormat("##.################").format( item.getGigabecquerel())+
                    "\n megabecquerel - " +new DecimalFormat("##.################").format( item.getMegabecquerel())+
                    "\n kilobecquerel - " +new DecimalFormat("##.################").format( item.getKilobecquerel())+
                    "\n millibecquerel- " +new DecimalFormat("##.################").format( item.getMillibecquerel())+
                    "\n curie- " +new DecimalFormat("##.################").format( item.getCurie())+
                    "\n kilocurie - " +new DecimalFormat("##.################").format( item.getKilocurie())+
                    "\n millicurie - " +new DecimalFormat("##.################").format( item.getMillicurie())+
                    "\n microcurie - " +new DecimalFormat("##.################").format( item.getMicrocurie())+
                    "\n nanocurie - " +new DecimalFormat("##.################").format( item.getNanocurie())+
                    "\n picocurie - " +new DecimalFormat("##.################").format( item.getPicocurie())+
                    "\n rutherford - " +new DecimalFormat("##.################").format( item.getRutherford())+
                    "\n onepersecond - " +new DecimalFormat("##.################").format( item.getOnepersecond())+
                    "\n disintegrationspersecond- " +new DecimalFormat("##.################").format( item.getDisintegrationspersecond())+
                    "\n disintegrationsperminute- " +new DecimalFormat("##.################").format( item.getDisintegrationsperminute())


            );



        }
    }
*/


}

