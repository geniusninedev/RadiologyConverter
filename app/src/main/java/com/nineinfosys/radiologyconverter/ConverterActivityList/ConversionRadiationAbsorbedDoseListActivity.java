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
import com.nineinfosys.radiologyconverter.Engin.RadiologyConverter;
import com.nineinfosys.radiologyconverter.R;
import com.nineinfosys.radiologyconverter.Supporter.ItemList;
import com.nineinfosys.radiologyconverter.Supporter.Settings;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionRadiationAbsorbedDoseListActivity extends AppCompatActivity implements TextWatcher {

    List<ItemList> list = new ArrayList<ItemList>();
    private  String stringSpinnerFrom;
    private double doubleEdittextvalue;
    private EditText edittextConversionListvalue;
    private TextView textconversionFrom,textViewConversionShortform;
    View ChildView ;
    private String strRad = null;
    private String strMillirad = null;
    private  String strJouleperkilogram = null;
    private String strJoulepergram = null;
    private String strJoulepercentigram = null;
    private String strJoulepermilligram = null;
    private String strGray = null;
    private  String strExagray = null;
    private String strPetagray = null;
    private String strTeragray = null;
    private String strGigagray = null;
    private String strMegagray = null;
    private String strKilogray = null;
    private String strHectogray = null;
    private String strDekagray = null;
    private String strDecigray = null;
    private String strCentigray = null;
    private String strMilligray = null;
    private String strMicrogray = null;
    private String strNanogray = null;
    private String strPicogray = null;
    private String strFemtogray = null;
    private String strAttogray = null;
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

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03a9f4")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Conversion Report");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007ac1"));
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
            case "Rad - rd":
                textconversionFrom.setText("Rad");
                textViewConversionShortform.setText("rd");
                break;
            case "Millirad - mrd":
                textconversionFrom.setText("Millirad");
                textViewConversionShortform.setText("mrd");
                break;
            case "Joule/kilogram - J/kg":
                textconversionFrom.setText("Joule/kilogram");
                textViewConversionShortform.setText("J/kg");
                break;
            case "Joule/gram - J/g":
                textconversionFrom.setText("Joule/gram");
                textViewConversionShortform.setText("J/g");
                break;
            case  "Joule/centigram - J/cg":
                textconversionFrom.setText("Joule/centigram");
                textViewConversionShortform.setText("J/cg");
                break;
            case "Joule/milligram - J/mg":
                textconversionFrom.setText("Joule/milligram");
                textViewConversionShortform.setText("J/mg");
                break;
            case "Gray - Gy":
                textconversionFrom.setText("Gray");
                textViewConversionShortform.setText("Gy");
                break;
            case "Exagray - EGy":
                textconversionFrom.setText("Exagray");
                textViewConversionShortform.setText("EGy");
                break;
            case "Petagray - PGy":
                textconversionFrom.setText("Petagray");
                textViewConversionShortform.setText("PGy");
                break;
            case "Teragray - TGy":
                textconversionFrom.setText("Teragray");
                textViewConversionShortform.setText("TGy");
                break;
            case "Gigagray - GGy":
                textconversionFrom.setText("Gigagray");
                textViewConversionShortform.setText("GGy");
                break;
            case "Megagray - MGy":
                textconversionFrom.setText("Megagray");
                textViewConversionShortform.setText("MGy");
                break;
            case "Kilogray - kGy":
                textconversionFrom.setText("Kilogray");
                textViewConversionShortform.setText("kGy");
                break;
            case "Hectogray - hGy":
                textconversionFrom.setText("Hectogray");
                textViewConversionShortform.setText("hGy");
                break;
            case "Dekagray - daGy":
                textconversionFrom.setText("Dekagray");
                textViewConversionShortform.setText("daGy");
                break;
            case "Decigray - dGy":
                textconversionFrom.setText("Decigray");
                textViewConversionShortform.setText("dGy");
                break;
            case "Centigray - cGy":
                textconversionFrom.setText("Centigray");
                textViewConversionShortform.setText("cGy");
                break;
            case "Milligray - mGy":
                textconversionFrom.setText("Milligray");
                textViewConversionShortform.setText("mGy");
                break;
            case "Microgray - µGy":
                textconversionFrom.setText("Microgray");
                textViewConversionShortform.setText("µGy");
                break;
            case "Nanogray - nGy":
                textconversionFrom.setText("Nanogray");
                textViewConversionShortform.setText("nGy");
                break;
            case "Picogray - pGy":
                textconversionFrom.setText("Picogray");
                textViewConversionShortform.setText("pGy");
                break;
            case "Femtogray - fGy":
                textconversionFrom.setText("Femtogray");
                textViewConversionShortform.setText("fGy");
                break;
            case "Attogray - aGy":
                textconversionFrom.setText("Attogray");
                textViewConversionShortform.setText("aGy");
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
        RadiologyConverter c = new RadiologyConverter(strSpinnerFrom, (int) doubleEdittextvalue1);
        ArrayList<RadiologyConverter.ConversionResults> results = c.calculateRadiationAbosirbedConversion();
        int length = results.size();
        for (int i = 0; i < length; i++) {
            RadiologyConverter.ConversionResults item = results.get(i);

            strRad = String.valueOf(formatter.format(item.getRad()));
            strMillirad =String.valueOf(formatter.format(item.getMillirad()));
            strJouleperkilogram =String.valueOf(formatter.format(item.getJouleperkilogram()));
            strJoulepergram =String.valueOf(formatter.format(item.getJoulepergram()));
            strJoulepercentigram = String.valueOf(formatter.format(item.getJoulepercentigram()));
            strJoulepermilligram =String.valueOf(formatter.format(item.getJoulepermilligram()));
            strGray =String.valueOf(formatter.format(item.getGray()));
            strExagray =String.valueOf(formatter.format(item.getExagray()));
            strPetagray = String.valueOf(formatter.format(item.getPetagray()));
            strTeragray = String.valueOf(formatter.format(item.getTeragray()));
            strGigagray =String.valueOf(formatter.format(item.getGigagray()));
            strMegagray = String.valueOf(formatter.format(item.getMegagray()));
            strKilogray = String.valueOf(formatter.format(item.getKilogray()));
            strHectogray =String.valueOf(formatter.format(item.getHectogray()));
            strDekagray =String.valueOf(formatter.format(item.getDekagray()));
            strDecigray = String.valueOf(formatter.format(item.getDecigray()));
            strCentigray =String.valueOf(formatter.format(item.getCentigray()));
            strMilligray = String.valueOf(formatter.format(item.getMilligray()));
            strMicrogray =String.valueOf(formatter.format(item.getMicrogray()));
            strNanogray = String.valueOf(formatter.format(item.getNanogray()));
            strPicogray =String.valueOf(formatter.format(item.getPicogray()));
            strFemtogray = String.valueOf(formatter.format(item.getFemtogray()));
            strAttogray = String.valueOf(formatter.format(item.getAttogray()));


            list.add(new ItemList("rd","Rad ",strRad,"rd"));
            list.add(new ItemList("mrd","Millirad ",strMillirad,"mrd"));
            list.add(new ItemList("J/kg","Joule/kilogram",strJouleperkilogram,"J/kg"));
            list.add(new ItemList("J/g","Joule/gram",strJoulepergram,"J/g"));
            list.add(new ItemList("J/cg","Joule/centigram",strJoulepercentigram,"J/cg"));
            list.add(new ItemList("J/mg","Joule/milligram  ",strJoulepermilligram,"J/mg"));
            list.add(new ItemList("Gy","Gray",strGray,"Gy"));
            list.add(new ItemList("EGy","Exagray",strExagray,"EGy"));

            list.add(new ItemList("PGy","Petagray",strPetagray,"PGy"));
            list.add(new ItemList("TGy","Teragray",strTeragray,"TGy"));
            list.add(new ItemList("GGy","Gigagray",strGigagray,"GGy"));
            list.add(new ItemList("MGy","Megagray",strMegagray,"MGy"));
            list.add(new ItemList("kGy","Kilogray",strKilogray,"kGy"));
            list.add(new ItemList("hGy","Hectogray",strHectogray,"hGy"));
            list.add(new ItemList("daGy","Dekagray",strDekagray,"daGy"));
            list.add(new ItemList("dGy","Decigray",strDecigray,"dGy"));
            list.add(new ItemList("cGy","Centigray",strCentigray,"cGy"));
            list.add(new ItemList("mGy","Milligray",strMilligray,"mGy"));
            list.add(new ItemList("µGy","Microgray",strMicrogray," µGy"));
            list.add(new ItemList("nGy","Nanogray",strNanogray,"nGy"));
            list.add(new ItemList("pGy","Picogray",strPicogray,"pGy"));
            list.add(new ItemList("fGy","Femtogray",strFemtogray,"fGy"));
            list.add(new ItemList("aGy","Attogray",strAttogray,"aGy"));


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
