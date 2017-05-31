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


import com.nineinfosys.radiologyconverter.Adapter.RecyclerViewConversionListAdapter;
import com.nineinfosys.radiologyconverter.Engin.RadiationConverter;
import com.nineinfosys.radiologyconverter.R;
import com.nineinfosys.radiologyconverter.Supporter.ItemList;
import com.nineinfosys.radiologyconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RadiationConverterListAcivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strGraypersecond  = null;
    private  String strExagraypersecond  = null;
    private String strPetagraypersecond  = null;
    private String strTeragraypersecond  = null;
    private String strGigagraypersecond  = null;
    private String strMegagraypersecond  = null;
    private String strKilograypersecond  = null;
    private String strHectograypersecond  = null;
    private String strDekagraypersecond  = null;
    private String strDecigraypersecond  = null;
    private String strCentigraypersecond  = null;
    private String strMilligraypersecond  = null;
    private String strMicrograypersecond  = null;
    private String strNanograypersecond  = null;
    private String strPicograypersecond  = null;
    private String strFemtograypersecond  = null;
    private String strAttograypersecond  = null;
    private String strRadpersecond  = null;
    private String strJouleperkilogrampersecond  = null;
    private String strWattperkilogram  = null;
    private String strSievertpersecond  = null;
    private String strRempersecond  = null;

    DecimalFormat formatter = null;
    private RecyclerView rView;
    RecyclerViewConversionListAdapter rcAdapter;
    List<ItemList> rowListItem,rowListItem1;

    private static final int REQUEST_CODE = 100;
    private File imageFile;
    private Bitmap bitmap;
    private PrintHelper printhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_list);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2eaf46")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007e17"));
        }


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
            case "Gray/second - Gy/s":
                textconversionFrom.setText("Gray/second");
                textViewConversionShortform.setText("Gy/s");
                break;
            case "Exagray/second - EGy/s":
                textconversionFrom.setText("Exagray/second");
                textViewConversionShortform.setText("EGy/s");
                break;
            case "Petagray/second - PGy/s":
                textconversionFrom.setText("Petagray/second");
                textViewConversionShortform.setText("PGy/s");
                break;
            case "Teragray/second - TGy/s":
                textconversionFrom.setText("Teragray/second");
                textViewConversionShortform.setText("TGy/s");
                break;
            case "Gigagray/second - GGy/s":
                textconversionFrom.setText("Gigagray/second");
                textViewConversionShortform.setText("GGy/s");
                break;
            case "Megagray/second - MGy/s":
                textconversionFrom.setText("Megagray/second");
                textViewConversionShortform.setText("MGy/s");
                break;
            case "Kilogray/second - kGy/s":
                textconversionFrom.setText("Kilogray/second");
                textViewConversionShortform.setText("kGy/s");
                break;
            case "Hectogray/second  - hGy/s":
                textconversionFrom.setText("Hectogray/second");
                textViewConversionShortform.setText("hGy/s");
                break;
            case "Dekagray/second - daGy/s":
                textconversionFrom.setText("Dekagray/second");
                textViewConversionShortform.setText("daGy/s");
                break;
            case "Decigray/second - dGy/s":
                textconversionFrom.setText("Decigray/second");
                textViewConversionShortform.setText("dGy/s");
                break;
            case "Centigray/second - cGy/s":
                textconversionFrom.setText("Centigray/second");
                textViewConversionShortform.setText("cGy/s");
                break;
            case "Milligray - mGy/s":
                textconversionFrom.setText("Milligray/second");
                textViewConversionShortform.setText("mGy/s");
                break;
            case "Microgray - µGy/s":
                textconversionFrom.setText("Microgray/second");
                textViewConversionShortform.setText("µGy/s");
                break;
            case "Nanogray/second - nGy/s":
                textconversionFrom.setText("Nanogray/second");
                textViewConversionShortform.setText("nGy/s");
                break;
            case "Picogray/second - pGy/s":
                textconversionFrom.setText("Picogray/second");
                textViewConversionShortform.setText("pGy/s");
                break;
            case "Femtogray/second - fGy/s":
                textconversionFrom.setText("Femtogray/second");
                textViewConversionShortform.setText("fGy/s");
                break;
            case "Attogray/second - aGy/s":
                textconversionFrom.setText("Attogray/second");
                textViewConversionShortform.setText("aGy/s");
                break;

            case "Rad/second - rd/s":
                textconversionFrom.setText("Rad/second");
                textViewConversionShortform.setText("rd/s");
                break;
            case "Joule/kilogram/second - J/kg/s":
                textconversionFrom.setText("Joule/kilogram/second");
                textViewConversionShortform.setText("J/kg/s");
                break;
            case "Watt/kilogram - W/kg":
                textconversionFrom.setText("Watt/kilogram");
                textViewConversionShortform.setText("W/kg");
                break;
            case "Sievert/second - Sv/s":
                textconversionFrom.setText("Sievert/second");
                textViewConversionShortform.setText("Sv/s");
                break;
            case "Rem/second - rem/s":
                textconversionFrom.setText("Rem/second");
                textViewConversionShortform.setText("rem/s");
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
        RadiationConverter c = new RadiationConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<RadiationConverter.ConversionResults> results = c.calculateRadiationConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            RadiationConverter.ConversionResults item = results.get(i);

            strGraypersecond = String.valueOf(formatter.format(item.getGraypersecond()));
            strExagraypersecond =String.valueOf(formatter.format(item.getExagraypersecond()));
            strPetagraypersecond =String.valueOf(formatter.format(item.getPetagraypersecond()));
            strTeragraypersecond =String.valueOf(formatter.format(item.getTeragraypersecond()));
            strGigagraypersecond = String.valueOf(formatter.format(item.getGigagraypersecond()));
            strMegagraypersecond =String.valueOf(formatter.format(item.getMegagraypersecond()));
            strKilograypersecond =String.valueOf(formatter.format(item.getKilograypersecond()));
            strHectograypersecond =String.valueOf(formatter.format(item.getHectograypersecond()));
            strDekagraypersecond = String.valueOf(formatter.format(item.getDekagraypersecond()));
            strDecigraypersecond = String.valueOf(formatter.format(item.getDecigraypersecond()));
            strCentigraypersecond =String.valueOf(formatter.format(item.getCentigraypersecond()));
            strMilligraypersecond = String.valueOf(formatter.format(item.getMilligraypersecond()));
            strMicrograypersecond = String.valueOf(formatter.format(item.getMicrograypersecond()));
            strNanograypersecond =String.valueOf(formatter.format(item.getNanograypersecond()));
            strPicograypersecond =String.valueOf(formatter.format(item.getPicograypersecond()));
            strFemtograypersecond = String.valueOf(formatter.format(item.getFemtograypersecond()));
            strAttograypersecond =String.valueOf(formatter.format(item.getAttograypersecond()));
            strRadpersecond = String.valueOf(formatter.format(item.getRadpersecond()));
            strJouleperkilogrampersecond =String.valueOf(formatter.format(item.getJouleperkilogrampersecond()));
            strWattperkilogram = String.valueOf(formatter.format(item.getWattperkilogram()));
            strSievertpersecond =String.valueOf(formatter.format(item.getSievertpersecond()));
            strRempersecond = String.valueOf(formatter.format(item.getRempersecond()));



            list.add(new ItemList("Gy/s","Gray/second",strGraypersecond,"Gy/s"));
            list.add(new ItemList("EGy/s","Exagray/second",strExagraypersecond,"EGy/s"));
            list.add(new ItemList("PGy/s","Petagray/second",strPetagraypersecond,"PGy/s"));
            list.add(new ItemList("TGy/s","Teragray/second",strTeragraypersecond,"TGy/s"));
            list.add(new ItemList("GGy/s","Gigagray/second",strGigagraypersecond,"GGy/s"));
            list.add(new ItemList("MGy/s","Megagray/second",strMegagraypersecond,"MGy/s"));
            list.add(new ItemList("kGy/s","Kilogray/second",strKilograypersecond,"kGy/s"));
            list.add(new ItemList("hGy/s","Hectogray/second",strHectograypersecond,"hGy/s"));
            list.add(new ItemList("daGy/s","Dekagray/second",strDekagraypersecond,"daGy/s"));
            list.add(new ItemList("dGy/s","Decigray/second",strDecigraypersecond,"dGy/s"));
            list.add(new ItemList("cGy/s","Centigray/second",strCentigraypersecond,"cGy/s"));
            list.add(new ItemList("mGy/s","Milligray/second",strMilligraypersecond,"mGy/s"));
            list.add(new ItemList("µGy/s","Microgray/second",strMicrograypersecond,"µGy/s"));
            list.add(new ItemList("nGy/s","Nanogray/second",strNanograypersecond,"nGy/s"));
            list.add(new ItemList("pGy/s","Picogray/second",strPicograypersecond,"pGy/s"));
            list.add(new ItemList("fGy/s","Femtogray/second",strFemtograypersecond,"fGy/s"));
            list.add(new ItemList("aGy/s","Attogray/second",strAttograypersecond,"aGy/s"));

            list.add(new ItemList("rd/s","Rad/second ",strRadpersecond,"rd/s"));
            list.add(new ItemList("J/kg/s","Joule/kilogram/second",strJouleperkilogrampersecond,"J/kg/s"));
            list.add(new ItemList("W/kg","Watt/kilogram",strWattperkilogram,"W/kg"));
            list.add(new ItemList("Sv/s","Sievert/second",strSievertpersecond,"Sv/s"));
            list.add(new ItemList("rem/s","Rem/second",strRempersecond,"rem/s"));


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
