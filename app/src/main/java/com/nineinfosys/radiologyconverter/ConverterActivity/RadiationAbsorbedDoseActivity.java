package com.nineinfosys.radiologyconverter.ConverterActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nineinfosys.radiologyconverter.ConverterActivityList.ConversionRadiationAbsorbedDoseListActivity;
import com.nineinfosys.radiologyconverter.Engin.RadiologyConverter;
import com.nineinfosys.radiologyconverter.R;
import com.nineinfosys.radiologyconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RadiationAbsorbedDoseActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {

    //declaration of designing tools
    private Spinner spinnerConvertFrom, spinnerConvertTo;
    private EditText editTextValue, editTextValueTo;
    private static final int REQUEST_CODE = 100;

    private FloatingActionButton buttonList, buttonShare, buttonMail, buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listRadiationFirsttempTo, listRadiationFirstfrom,listRadiationTo,listRadiationfrom;
    private String stringSpinnerFrom, stringSpinnerTo;
    private TextView textViewBasicUnit, textViewAllUnit,textViewConvert;
    double doubleEdittextvalue = 1.0;
    private int basicunit = 6;
    private int allunit = 23;
    DecimalFormat formatter = null;

    RadiologyConverter.ConversionResults item;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);


        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03a9f4")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Radiation Absorbed Dose");

        formatsetting();
        MobileAds.initialize(RadiationAbsorbedDoseActivity.this, getString(R.string.ads_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adViewUnitConverter);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //initalization of tools and variables
        spinnerConvertFrom = (Spinner) findViewById(R.id.spinnerConvertFrom);
        spinnerConvertTo = (Spinner) findViewById(R.id.spinnerConvertTo);
        textViewBasicUnit = (TextView) findViewById(R.id.textViewBasicUnit);
        textViewConvert=(TextView) findViewById(R.id.buttonUnitConverter);
        textViewAllUnit = (TextView) findViewById(R.id.textViewAllUnit);
        editTextValue = (EditText) findViewById(R.id.edittextFrom);
        editTextValueTo = (EditText) findViewById(R.id.edittextTo);
        buttonCopy = (FloatingActionButton) findViewById(R.id.button_copy);
        buttonList = (FloatingActionButton) findViewById(R.id.button_list_fullreport);
        buttonShare = (FloatingActionButton) findViewById(R.id.button_list_share);
        buttonMail = (FloatingActionButton) findViewById(R.id.button_list_mail);
        switchChangeType = (SwitchCompat) findViewById(R.id.switchButton);

        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorskyblue)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007ac1"));
        }


        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listRadiationFirstfrom = new ArrayList<String>();
        listRadiationFirsttempTo = new ArrayList<String>();

        //for first time running spinner
        listRadiationFirstfrom.add("Rad - rd");
        listRadiationFirstfrom.add("Millirad - mrd");
        listRadiationFirstfrom.add("Joule/kilogram - J/kg");
        listRadiationFirstfrom.add("Joule/gram - J/g");
        listRadiationFirstfrom.add("Joule/centigram - J/cg");
        listRadiationFirstfrom.add("Joule/milligram - J/mg");
        //for first time running spinner
        listRadiationFirsttempTo.add("Rad - rd");
        listRadiationFirsttempTo.add("Millirad - mrd");
        listRadiationFirsttempTo.add("Joule/kilogram - J/kg");
        listRadiationFirsttempTo.add("Joule/gram - J/g");
        listRadiationFirsttempTo.add("Joule/centigram - J/cg");
        listRadiationFirsttempTo.add("Joule/milligram - J/mg");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(RadiationAbsorbedDoseActivity.this, android.R.layout.simple_spinner_item, listRadiationFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(RadiationAbsorbedDoseActivity.this, android.R.layout.simple_spinner_item, listRadiationFirsttempTo);


        // Drop down layout style - list view with radio button
        Adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        AdapterTempTo.setDropDownViewResource(android.R.layout.simple_list_item_checked);

        // attaching data adapter to spinner
        spinnerConvertFrom.setAdapter(Adapter);
        spinnerConvertTo.setAdapter(AdapterTempTo);

        //switch converttype
        switchChangeType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                listRadiationfrom = new ArrayList<String>();
                listRadiationTo = new ArrayList<String>();
                String stringSwitchSate = String.valueOf(isChecked);
                String strBasic = "Basic";
                String strAdvance = "All";
                switch (stringSwitchSate) {

                    case "false":
                        Snackbar.make(buttonView, "You switched to " + strBasic + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listRadiationfrom.clear();
                        listRadiationTo.clear();

                        //for first time running spinner
                        listRadiationfrom.add("Rad - rd");
                        listRadiationfrom.add("Millirad - mrd");
                        listRadiationfrom.add("Joule/kilogram - J/kg");
                        listRadiationfrom.add("Joule/gram - J/g");
                        listRadiationfrom.add("Joule/centigram - J/cg");
                        listRadiationfrom.add("Joule/milligram - J/mg");

                        //for first time running spinner
                        listRadiationTo.add("Rad - rd");
                        listRadiationTo.add("Millirad - mrd");
                        listRadiationTo.add("Joule/kilogram - J/kg");
                        listRadiationTo.add("Joule/gram - J/g");
                        listRadiationTo.add("Joule/centigram - J/cg");
                        listRadiationTo.add("Joule/milligram - J/mg");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listRadiationfrom.clear();
                        listRadiationTo.clear();

                        //for first  running spinner
                        listRadiationfrom.add("Rad - rd");
                        listRadiationfrom.add("Millirad - mrd");
                        listRadiationfrom.add("Joule/kilogram - J/kg");
                        listRadiationfrom.add("Joule/gram - J/g");
                        listRadiationfrom.add("Joule/centigram - J/cg");
                        listRadiationfrom.add("Joule/milligram - J/mg");
                        listRadiationfrom.add("Gray - Gy");
                        listRadiationfrom.add("Exagray - EGy");
                        listRadiationfrom.add("Petagray - PGy");
                        listRadiationfrom.add("Teragray - TGy");
                        listRadiationfrom.add("Gigagray - GGy");
                        listRadiationfrom.add("Megagray - MGy");
                        listRadiationfrom.add("Kilogray - kGy");
                        listRadiationfrom.add("Hectogray - hGy");
                        listRadiationfrom.add("Dekagray - daGy");
                        listRadiationfrom.add("Decigray - dGy");

                        listRadiationfrom.add("Centigray - cGy");
                        listRadiationfrom.add("Milligray - mGy");

                        listRadiationfrom.add("Microgray - µGy");
                        listRadiationfrom.add("Nanogray - nGy");

                        listRadiationfrom.add("Picogray - pGy");
                        listRadiationfrom.add("Femtogray - fGy");

                        listRadiationfrom.add("Attogray - aGy");


                        //for second running spinner
                        listRadiationTo.add("Rad - rd");
                        listRadiationTo.add("Millirad - mrd");
                        listRadiationTo.add("Joule/kilogram - J/kg");
                        listRadiationTo.add("Joule/gram - J/g");
                        listRadiationTo.add("Joule/centigram - J/cg");
                        listRadiationTo.add("Joule/milligram - J/mg");
                        listRadiationTo.add("Gray - Gy");
                        listRadiationTo.add("Exagray - EGy");
                        listRadiationTo.add("Petagray - PGy");
                        listRadiationTo.add("Teragray - TGy");
                        listRadiationTo.add("Gigagray - GGy");
                        listRadiationTo.add("Megagray - MGy");
                        listRadiationTo.add("Kilogray - kGy");
                        listRadiationTo.add("Hectogray - hGy");
                        listRadiationTo.add("Dekagray - daGy");
                        listRadiationTo.add("Decigray - dGy");

                        listRadiationTo.add("Centigray - cGy");
                        listRadiationTo.add("Milligray - mGy");

                        listRadiationTo.add("Microgray - µGy");
                        listRadiationTo.add("Nanogray - nGy");

                        listRadiationTo.add("Picogray - pGy");
                        listRadiationTo.add("Femtogray - fGy");

                        listRadiationTo.add("Attogray - aGy");



                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(RadiationAbsorbedDoseActivity.this, android.R.layout.simple_spinner_item, listRadiationfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(RadiationAbsorbedDoseActivity.this, android.R.layout.simple_spinner_item, listRadiationTo);


                // Drop down layout style - list view with radio button
                Adapter2.setDropDownViewResource(android.R.layout.simple_list_item_checked);
                AdapterTempTo2.setDropDownViewResource(android.R.layout.simple_list_item_checked);

                // attaching data adapter to spinner
                spinnerConvertFrom.setAdapter(Adapter2);
                spinnerConvertTo.setAdapter(AdapterTempTo2);

            }
        });

        editTextValue.addTextChangedListener(this);
        buttonList.setOnClickListener(this);
        buttonShare.setOnClickListener(this);
        buttonMail.setOnClickListener(this);
        buttonCopy.setOnClickListener(this);
        textViewConvert.setOnClickListener(this);


        spinnerConvertFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (editTextValue.getText().toString().trim().equals("")) {
                    Snackbar.make(adapterView, "Provide Unit Value for Conversion", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                } else {
                    doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                    stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
                    stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();

                    calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerConvertTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (editTextValue.getText().toString().trim().equals("")) {
                    Snackbar.make(adapterView, "Provide Unit Value for Conversion", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                } else {
                    doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                    stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
                    stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();

                    calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void formatsetting() {
        //fetching value from sharedpreference
        SharedPreferences sharedPreferences = this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Fetching thepatient_mobile_Number value form sharedpreferences
        String FormattedString = sharedPreferences.getString(Settings.Format_Selected_SHARED_PREF, "Thousands separator");
        String DecimalplaceString = sharedPreferences.getString(Settings.Decimal_Place_Selected_SHARED_PREF, "2");
        Settings settings = new Settings(FormattedString, DecimalplaceString);
        formatter = settings.setting();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonUnitConverter:
                //switch spinner value
                int spinner1Index = spinnerConvertFrom.getSelectedItemPosition();
                spinnerConvertFrom.setSelection(spinnerConvertTo.getSelectedItemPosition());
                spinnerConvertTo.setSelection(spinner1Index );
                break;

            case R.id.button_list_fullreport:
                doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
                Intent i = new Intent(this,ConversionRadiationAbsorbedDoseListActivity.class);
                i.putExtra("stringSpinnerFrom", stringSpinnerFrom);
                i.putExtra("doubleEdittextvalue", doubleEdittextvalue);
                startActivity(i);
                break;

            case R.id.button_copy:
                String text = editTextValueTo.getText().toString().trim();
                android.content.ClipboardManager clipboardMgr = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied text", text);
                clipboardMgr.setPrimaryClip(clip);
                Snackbar.make(v, "Conversion Value Copied", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                break;

            case R.id.button_list_share:
                String textTo = editTextValueTo.getText().toString().trim();
                String textFrom = editTextValueTo.getText().toString().trim();
                String shareMessage = textFrom + " " + stringSpinnerFrom + ": " + textTo + " " + stringSpinnerTo;

                try {
                    Intent share = new Intent();
                    share.setAction("android.intent.action.SEND");
                    share.setType("text/plain");
                    share.putExtra("android.intent.extra.TEXT", shareMessage);
                    startActivity(Intent.createChooser(share, ""));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.button_list_mail:
                String textmailTo = editTextValueTo.getText().toString().trim();
                String textmailFrom = editTextValueTo.getText().toString().trim();
                String message = textmailTo + " " + stringSpinnerFrom + " :  " + textmailFrom + "  " + stringSpinnerTo;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{});
                email.putExtra(Intent.EXTRA_SUBJECT, "Conversion Details");
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Select Email Client"));
                break;

        }

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        try {

            doubleEdittextvalue = Double.parseDouble(editTextValue.getText().toString().trim());
            stringSpinnerFrom = spinnerConvertFrom.getSelectedItem().toString().trim();
            stringSpinnerTo = spinnerConvertTo.getSelectedItem().toString().trim();
            calcualteValue(stringSpinnerFrom, stringSpinnerTo, doubleEdittextvalue);

            //   Toast.makeText(this, "string12" + stringSpinnerFrom + "\n string13" + stringSpinnerTo + "string14" + doubleEdittextvalue, Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }


    }

    public void calcualteValue(String strSpinnerFromvalue1, String strSpinnerTovalue2, double doubleEdittextvalue1) {



        try {

            RadiologyConverter c = new RadiologyConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<RadiologyConverter.ConversionResults> results = c.calculateRadiationAbosirbedConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

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


                switch (strSpinnerFromvalue1) {
                    case "Rad - rd" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Millirad - mrd":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Joule/kilogram - J/kg" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Joule/gram - J/g":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Joule/centigram - J/cg":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Joule/milligram - J/mg" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gray - Gy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Exagray - EGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Petagray - PGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Teragray - TGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gigagray - GGy":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Megagray - MGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilogray - kGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Hectogray - hGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Dekagray - daGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Decigray - dGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Centigray - cGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Milligray - mGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Microgray - µGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Nanogray - nGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Picogray - pGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Femtogray - fGy":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Attogray - aGy":
                        conversion(strSpinnerTovalue2);
                        break;
                }
            }


        } catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }
    }

    private void conversion(String strSpinnerTovalue2) {

        switch (strSpinnerTovalue2) {

            case "Rad - rd" :
                editTextValueTo.setText(strRad);
                break;
            case "Millirad - mrd":
                editTextValueTo.setText(strMillirad);
                break;
            case "Joule/kilogram - J/kg" :
                editTextValueTo.setText(strJouleperkilogram);
                break;
            case "Joule/gram - J/g":
                editTextValueTo.setText(strJoulepergram);
                break;
            case "Joule/centigram - J/cg":
                editTextValueTo.setText(strJoulepercentigram);
                break;
            case "Joule/milligram - J/mg" :
                editTextValueTo.setText(strJoulepermilligram);
                break;
            case "Gray - Gy":
                editTextValueTo.setText(strGray);
                break;
            case "Exagray - EGy":
                editTextValueTo.setText(strExagray);
                break;
            case "Petagray - PGy":
                editTextValueTo.setText(strPetagray);
                break;
            case "Teragray - TGy":
                editTextValueTo.setText(strTeragray);
                break;
            case "Gigagray - GGy":
                editTextValueTo.setText(strGigagray);
                break;

            case "Megagray - MGy":
                editTextValueTo.setText(strMegagray);
                break;
            case "Kilogray - kGy":
                editTextValueTo.setText(strKilogray);
                break;
            case "Hectogray - hGy":
                editTextValueTo.setText(strHectogray);
                break;
            case "Dekagray - daGy":
                editTextValueTo.setText(strDekagray);
                break;
            case "Decigray - dGy":
                editTextValueTo.setText(strDecigray);
                break;
            case "Centigray - cGy":
                editTextValueTo.setText(strCentigray);
                break;
            case "Milligray - mGy":
                editTextValueTo.setText(strMilligray);
                break;
            case "Microgray - µGy":
                editTextValueTo.setText(strMicrogray);
                break;
            case "Nanogray - nGy":
                editTextValueTo.setText(strNanogray);
                break;
            case "Picogray - pGy":
                editTextValueTo.setText(strPicogray);
                break;
            case "Femtogray - fGy":
                editTextValueTo.setText(strFemtogray);
                break;
            case "Attogray - aGy":
                editTextValueTo.setText(strAttogray);
                break;

        }


    }


    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {

            this.finish();
        }

        return super.onOptionsItemSelected(item);
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