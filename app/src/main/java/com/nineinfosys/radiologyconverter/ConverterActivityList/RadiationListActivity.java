package com.nineinfosys.radiologyconverter.ConverterActivityList;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.radiologyconverter.Adapter.RecyclerViewConversionListAdapter;
import com.nineinfosys.radiologyconverter.Engin.RadiationActivityConverter;
import com.nineinfosys.radiologyconverter.R;
import com.nineinfosys.radiologyconverter.Supporter.ItemList;
import com.nineinfosys.radiologyconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RadiationListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strBecquerel = null;
    private String strTerabecquerel = null;
    private  String strGigabecquerel = null;
    private String strMegabecquerel = null;
    private String strkilobecquerel = null;
    private String strMillibecquerel = null;
    private String strCurie = null;
    private  String strKilocurie = null;
    private String strMillicurie = null;
    private String strMicrocurie = null;
    private String strNanocurie = null;
    private String strPicocurie = null;
    private String strRutherford = null;
    private String strOnepersecond = null;
    private String strDisintegrationspersecond = null;
    private String strDisintegrationsperminute = null;
    DecimalFormat formatter = null;

    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;


    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e65f21")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#a02a00"));
        }


        MobileAds.initialize(RadiationListActivity.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewUnitConverterList);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //format of decimal pint
        formatsetting();

        edittextConversionListvalue=(EditText)findViewById(R.id.edittextConversionListvalue) ;
        textconversionFrom=(TextView) findViewById(R.id.textViewConversionFrom) ;
        textViewConversionShortform=(TextView) findViewById(R.id.textViewConversionShortform) ;

        //get the value from temperture activity
        stringSpinnerFrom = getIntent().getExtras().getString("stringSpinnerFrom");
        doubleEdittextvalue= getIntent().getExtras().getDouble("doubleEdittextvalue");
        edittextConversionListvalue.setText(String.valueOf(doubleEdittextvalue));

        NamesAndShortform(stringSpinnerFrom);

        //   Toast.makeText(this,"string1 "+stringSpinnerFrom,Toast.LENGTH_LONG).show();
        rowListItem = getAllunitValue(stringSpinnerFrom,doubleEdittextvalue);

        //Initializing Views
        rView = (RecyclerView) findViewById(R.id.recyclerViewConverterList);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new GridLayoutManager(this, 1));


        //Initializing our superheroes list
        rcAdapter = new RecyclerViewConversionListAdapter(this,rowListItem);
        rView.setAdapter(rcAdapter);

        edittextConversionListvalue.addTextChangedListener(this);



    }

    private void NamesAndShortform(String stringSpinnerFrom) {
        switch (stringSpinnerFrom) {
            case "Becquerel - Bq":
                textconversionFrom.setText("Becquerel");
                textViewConversionShortform.setText("Bq");
                break;
            case "Terabecquerel - TBq":
                textconversionFrom.setText("Terabecquerel");
                textViewConversionShortform.setText("TBq");
                break;
            case "Gigabecquerel - GBq":
                textconversionFrom.setText("Gigabecquerel");
                textViewConversionShortform.setText("GBq");
                break;
            case "Megabecquerel - MBq":
                textconversionFrom.setText("Megabecquerel");
                textViewConversionShortform.setText("MBq");
                break;
            case "Kilobecquerel - kBq":
                textconversionFrom.setText("Kilobecquerel");
                textViewConversionShortform.setText("kBq");
                break;
            case "Millibecquerel - mBq":
                textconversionFrom.setText("Millibecquerel");
                textViewConversionShortform.setText("mBq");
                break;
            case "Curie - Ci" :
                textconversionFrom.setText("Curie");
                textViewConversionShortform.setText("Ci");
                break;
            case "Kilocurie - kCi":
                textconversionFrom.setText("Kilocurie");
                textViewConversionShortform.setText("kCi");
                break;
            case "Millicurie - mCi":
                textconversionFrom.setText("Millicurie");
                textViewConversionShortform.setText("mCi");
                break;
            case "Microcurie - µCi":
                textconversionFrom.setText("Microcurie");
                textViewConversionShortform.setText("µCi");
                break;
            case "Nanocurie - nCi":
                textconversionFrom.setText("Nanocurie");
                textViewConversionShortform.setText("nCi");
                break;
            case "Picocurie - pCi":
                textconversionFrom.setText("Picocurie");
                textViewConversionShortform.setText("pCi");
                break;
            case "Rutherford - R":
                textconversionFrom.setText("Rutherford");
                textViewConversionShortform.setText("R");
                break;
            case "One/second - 1/s":
                textconversionFrom.setText("One/second");
                textViewConversionShortform.setText("1/s");
                break;
            case "Disintegrations/second - dis/sec":
                textconversionFrom.setText("Disintegrations/second");
                textViewConversionShortform.setText("dis/sec");
                break;
            case "Disintegrations/minute - dis/min":
                textconversionFrom.setText("Disintegrations/minute");
                textViewConversionShortform.setText("dis/min");
                break;


        }
    }

    private void formatsetting() {
        //fetching value from sharedpreference
        SharedPreferences sharedPreferences =this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Fetching thepatient_mobile_Number value form sharedpreferences
        String  FormattedString = sharedPreferences.getString(Settings.Format_Selected_SHARED_PREF,"Thousands separator");
        String DecimalplaceString= sharedPreferences.getString(Settings.Decimal_Place_Selected_SHARED_PREF,"2");
        Settings settings=new Settings(FormattedString,DecimalplaceString);
        formatter= settings.setting();
    }

    private List<ItemList> getAllunitValue(String strSpinnerFrom,double doubleEdittextvalue1) {
        RadiationActivityConverter c = new RadiationActivityConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<RadiationActivityConverter.ConversionResults> results = c.calculateRadiationConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            RadiationActivityConverter.ConversionResults item = results.get(i);

            strBecquerel = String.valueOf(formatter.format(item.getBecquerel()));
            strTerabecquerel =String.valueOf(formatter.format(item.getTerabecquerel()));
            strGigabecquerel =String.valueOf(formatter.format(item.getGigabecquerel()));
            strMegabecquerel =String.valueOf(formatter.format(item.getMegabecquerel()));
            strkilobecquerel = String.valueOf(formatter.format(item.getKilobecquerel()));
            strMillibecquerel =String.valueOf(formatter.format(item.getMillibecquerel()));
            strCurie =String.valueOf(formatter.format(item.getCurie()));
            strKilocurie =String.valueOf(formatter.format(item.getKilocurie()));
            strMillicurie = String.valueOf(formatter.format(item.getMillicurie()));
            strMicrocurie = String.valueOf(formatter.format(item.getMicrocurie()));
            strNanocurie =String.valueOf(formatter.format(item.getNanocurie()));
            strPicocurie = String.valueOf(formatter.format(item.getPicocurie()));
            strRutherford = String.valueOf(formatter.format(item.getRutherford()));
            strOnepersecond =String.valueOf(formatter.format(item.getOnepersecond()));
            strDisintegrationspersecond =String.valueOf(formatter.format(item.getDisintegrationspersecond()));
            strDisintegrationsperminute = String.valueOf(formatter.format(item.getDisintegrationsperminute()));

            list.add(new ItemList("Bq","Becquerel ",strBecquerel,"Bq"));
            list.add(new ItemList("TBq","Terabecquerel ",strTerabecquerel,"TBq"));
            list.add(new ItemList("GBq","Gigabecquerel",strGigabecquerel,"GBq"));
            list.add(new ItemList("MBq","Megabecquerel",strMegabecquerel,"MBq"));
            list.add(new ItemList("kBq","Kilobecquerel",strkilobecquerel,"kBq"));
            list.add(new ItemList("mBq","Millibecquerel  ",strMillibecquerel,"mBq"));
            list.add(new ItemList("Ci","Curie",strCurie,"Ci"));
            list.add(new ItemList("kCi","Kilocurie",strKilocurie,"kCi"));

            list.add(new ItemList("mCi","Millicurie",strMillicurie,"mCi"));
            list.add(new ItemList("µCi","Microcurie",strMicrocurie,"µCi"));
            list.add(new ItemList("nCi","Nanocurie",strNanocurie," nCi"));
            list.add(new ItemList("pCi","Picocurie",strPicocurie,"pCi"));
            list.add(new ItemList("R","Rutherford",strRutherford,"R"));
            list.add(new ItemList("1/s","One/second",strOnepersecond,"1/s"));
            list.add(new ItemList("dis/sec","Disintegrations/second",strDisintegrationspersecond,"dis/sec"));
            list.add(new ItemList("dis/min","Disintegrations/minute",strDisintegrationsperminute,"dis/min"));


        }
        return list;

    }
   /* @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(ConversionTempListActivity.this, ConversionTempListActivity.class);
        i.putExtra("stringSpinnerFrom", stringSpinnerFrom);
        i.putExtra("doubleEdittextvalue", doubleEdittextvalue);
        startActivity(i);
        finish();

    }*/

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


        rowListItem.clear();
        try {

            double value = Double.parseDouble(edittextConversionListvalue.getText().toString().trim());

            rowListItem1 = getAllunitValue(stringSpinnerFrom,value);


            rcAdapter = new RecyclerViewConversionListAdapter(this,rowListItem1);
            rView.setAdapter(rcAdapter);

        }
        catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                this.finish();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
