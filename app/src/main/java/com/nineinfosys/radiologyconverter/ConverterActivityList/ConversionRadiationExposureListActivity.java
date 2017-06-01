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
import com.nineinfosys.radiologyconverter.Engin.RadiationExposureConverter;
import com.nineinfosys.radiologyconverter.R;
import com.nineinfosys.radiologyconverter.Supporter.ItemList;
import com.nineinfosys.radiologyconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionRadiationExposureListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    DecimalFormat formatter = null;

    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;


    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;

    private String  strCoulombperkilogram = null;
    private String  strMillicoulombperkilogram  = null;
    private String  strRoentgen  = null;
    private String  strTissueroentgen  = null;
    private String  strParker  = null;
    private String  strMicrocoulombpeperkilogram  = null;
    private String  strRep  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#db290d")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#a10000"));
        }


        MobileAds.initialize(ConversionRadiationExposureListActivity.this, getString(R.string.ads_app_id));
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
        switch(stringSpinnerFrom)
        {

            case "Coulomb/kilogram - C/kg" :
                textconversionFrom.setText("Coulomb/kilogram");
                textViewConversionShortform.setText("C/kg");
                break;

            case "Millicoulomb/kilogram - mC/kg":
                textconversionFrom.setText("Millicoulomb/kilogram");
                textViewConversionShortform.setText("mC/kg");

                break;
            case "Microcoulomb/kilogram - μC/kg":
                textconversionFrom.setText("Microcoulomb/kilogram");
                textViewConversionShortform.setText(" μC/kg");
                break;
            case "Roentgen - R":
                textconversionFrom.setText("Roentgen");
                textViewConversionShortform.setText("R");
                break;
            case  "Tissue roentgen - Tr":
                textconversionFrom.setText("Tissue roentgen");
                textViewConversionShortform.setText("Tr");
                break;

            case "Parker - parker":
                textconversionFrom.setText("Parker");
                textViewConversionShortform.setText("parker");
                break;
            case "Rep - rep":
                textconversionFrom.setText("Rep");
                textViewConversionShortform.setText("rep");
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
        RadiationExposureConverter c = new RadiationExposureConverter(strSpinnerFrom,(int)doubleEdittextvalue1);
        ArrayList<RadiationExposureConverter.ConversionResults> results = c.calculateRadiationExposureConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            RadiationExposureConverter.ConversionResults item = results.get(i);



             strCoulombperkilogram = String.valueOf(formatter.format(item.getCoulombperkilogram()));
               strMillicoulombperkilogram = String.valueOf(formatter.format(item.getMillicoulombperkilogram()));
              strRoentgen = String.valueOf(formatter.format(item.getRoentgen()));
              strTissueroentgen = String.valueOf(formatter.format(item.getTissueroentgen()));

             strParker = String.valueOf(formatter.format(item.getParker()));
             strMicrocoulombpeperkilogram = String.valueOf(formatter.format(item.getMicrocoulombperkilogram()));
             strRep = String.valueOf(formatter.format(item.getRep()));



            list.add(new ItemList("C/kg","Coulomb/kilogram ",strCoulombperkilogram,"C/kg"));
            list.add(new ItemList("mC/kg","Millicoulomb/kilogram",strMillicoulombperkilogram,"mC/kg"));
            list.add(new ItemList("μC/kg","Microcoulomb/kilogram",strMicrocoulombpeperkilogram,"μC/kg"));
            list.add(new ItemList("R","Roentgen",strRoentgen,"R"));
            list.add(new ItemList("Tr","Tissue roentgen",strTissueroentgen,"Tr"));
            list.add(new ItemList("parker","Parker",strParker,"parker"));

            list.add(new ItemList("rep","Rep",strRep,"rep"));
        }
        return list;

    }

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

}
