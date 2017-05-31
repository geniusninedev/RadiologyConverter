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


import com.nineinfosys.radiologyconverter.ConverterActivityList.RadiationConverterListAcivity;
import com.nineinfosys.radiologyconverter.Engin.RadiationConverter;
import com.nineinfosys.radiologyconverter.R;
import com.nineinfosys.radiologyconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RadiationConverterActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {

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
    private int allunit = 22;
    DecimalFormat formatter = null;

    RadiationConverter.ConversionResults item;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2eaf46")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Radiation-Activity");

        formatsetting();

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

        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorGreenish)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#007e17"));
        }


        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listRadiationFirstfrom = new ArrayList<String>();
        listRadiationFirsttempTo = new ArrayList<String>();

        //for first time running spinner
        listRadiationFirstfrom.add("Gray/second - Gy/s");
        listRadiationFirstfrom.add("Exagray/second - EGy/s");
        listRadiationFirstfrom.add("Petagray/second - PGy/s");
        listRadiationFirstfrom.add("Teragray/second - TGy/s");
        listRadiationFirstfrom.add("Gigagray/second - GGy/s");
        listRadiationFirstfrom.add("Megagray/second - MGy/s");
        //for first time running spinner
        listRadiationFirsttempTo.add("Gray/second - Gy/s");
        listRadiationFirsttempTo.add("Exagray/second - EGy/s");
        listRadiationFirsttempTo.add("Petagray/second - PGy/s");
        listRadiationFirsttempTo.add("Teragray/second - TGy/s");
        listRadiationFirsttempTo.add("Gigagray/second - GGy/s");
        listRadiationFirsttempTo.add("Megagray/second - MGy/s");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(RadiationConverterActivity.this, android.R.layout.simple_spinner_item, listRadiationFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(RadiationConverterActivity.this, android.R.layout.simple_spinner_item, listRadiationFirsttempTo);


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
                        listRadiationfrom.add("Gray/second - Gy/s");
                        listRadiationfrom.add("Exagray/second - EGy/s");
                        listRadiationfrom.add("Petagray/second - PGy/s");
                        listRadiationfrom.add("Teragray/second - TGy/s");
                        listRadiationfrom.add("Gigagray/second - GGy/s");
                        listRadiationfrom.add("Megagray/second - MGy/s");

                        //for first time running spinner
                        listRadiationTo.add("Gray/second - Gy/s");
                        listRadiationTo.add("Exagray/second - EGy/s");
                        listRadiationTo.add("Petagray/second - PGy/s");
                        listRadiationTo.add("Teragray/second - TGy/s");
                        listRadiationTo.add("Gigagray/second - GGy/s");
                        listRadiationTo.add("Megagray/second - MGy/s");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listRadiationfrom.clear();
                        listRadiationTo.clear();

                        //for first  running spinner
                        listRadiationfrom.add("Gray/second - Gy/s");
                        listRadiationfrom.add("Exagray/second - EGy/s");
                        listRadiationfrom.add("Petagray/second - PGy/s");
                        listRadiationfrom.add("Teragray/second - TGy/s");
                        listRadiationfrom.add("Gigagray/second - GGy/s");
                        listRadiationfrom.add("Megagray/second - MGy/s");
                        listRadiationfrom.add("Kilogray/second - kGy/s");
                        listRadiationfrom.add("Hectogray/second - hGy/s");
                        listRadiationfrom.add("Dekagray/second - daGy/s");
                        listRadiationfrom.add("Decigray/second - dGy/s");
                        listRadiationfrom.add("Centigray/second - cGy/s");
                        listRadiationfrom.add("Milligray/second - mGy/s");
                        listRadiationfrom.add("Microgray/second - µGy/s");
                        listRadiationfrom.add("Nanogray/second - nGy/s");
                        listRadiationfrom.add("Picogray/second - pGy/s");
                        listRadiationfrom.add("Femtogray/second - fGy/s");
                        listRadiationfrom.add("Attogray/second - aGy/s");
                        listRadiationfrom.add("Rad/second - rd/s");
                        listRadiationfrom.add("Joule/kilogram/second - J/kg/s");
                        listRadiationfrom.add("Watt/kilogram - W/kg");
                        listRadiationfrom.add("Sievert/second - Sv/s");
                        listRadiationfrom.add("Rem/second - rem/s");

                        //for second running spinner
                        listRadiationTo.add("Gray/second - Gy/s");
                        listRadiationTo.add("Exagray/second - EGy/s");
                        listRadiationTo.add("Petagray/second - PGy/s");
                        listRadiationTo.add("Teragray/second - TGy/s");
                        listRadiationTo.add("Gigagray/second - GGy/s");
                        listRadiationTo.add("Megagray/second - MGy/s");
                        listRadiationTo.add("Kilogray/second - kGy/s");
                        listRadiationTo.add("Hectogray/second - hGy/s");
                        listRadiationTo.add("Dekagray/second - daGy/s");
                        listRadiationTo.add("Decigray/second - dGy/s");
                        listRadiationTo.add("Centigray/second - cGy/s");
                        listRadiationTo.add("Milligray/second - mGy/s");
                        listRadiationTo.add("Microgray/second - µGy/s");
                        listRadiationTo.add("Nanogray/second - nGy/s");
                        listRadiationTo.add("Picogray/second - pGy/s");
                        listRadiationTo.add("Femtogray/second - fGy/s");
                        listRadiationTo.add("Attogray/second - aGy/s");
                        listRadiationTo.add("Rad/second - rd/s");
                        listRadiationTo.add("Joule/kilogram/second - J/kg/s");
                        listRadiationTo.add("Watt/kilogram - W/kg");
                        listRadiationTo.add("Sievert/second - Sv/s");
                        listRadiationTo.add("Rem/second - rem/s");



                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(RadiationConverterActivity.this, android.R.layout.simple_spinner_item, listRadiationfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(RadiationConverterActivity.this, android.R.layout.simple_spinner_item, listRadiationTo);


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
                Intent i = new Intent(this,RadiationConverterListAcivity.class);
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

            RadiationConverter c = new RadiationConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<RadiationConverter.ConversionResults> results = c.calculateRadiationConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

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
           ;


                switch (strSpinnerFromvalue1) {
                    case "Gray/second - Gy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Exagray/second - EGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Petagray/second - PGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Teragray/second - TGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Gigagray/second - GGy/s":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Megagray/second - MGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilogray/second - kGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Hectogray/second - hGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Dekagray/second - daGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Decigray/second - dGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Centigray/second - cGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Milligray/second - mGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Microgray/second - µGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Nanogray/second - nGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Picogray/second - pGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Femtogray/second - fGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Attogray/second - aGy/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Rad/second - rd/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Joule/kilogram/second - J/kg/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Watt/kilogram - W/kg":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Sievert/second - Sv/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Rem/second - rem/s":
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

            case "Gray/second - Gy/s":
                editTextValueTo.setText(strGraypersecond);
                break;
            case "Exagray/second - EGy/s":
                editTextValueTo.setText(strExagraypersecond);
                break;
            case "Petagray/second - PGy/s":
                editTextValueTo.setText(strPetagraypersecond);
                break;
            case "Teragray/second - TGy/s":
                editTextValueTo.setText(strTeragraypersecond);
                break;
            case "Gigagray/second - GGy/s":
                editTextValueTo.setText(strGigagraypersecond);
                break;

            case "Megagray/second - MGy/s":
                editTextValueTo.setText(strMegagraypersecond);
                break;
            case "Kilogray/second - kGy/s":
                editTextValueTo.setText(strKilograypersecond);
                break;
            case "Hectogray/second - hGy/s":
                editTextValueTo.setText(strHectograypersecond);
                break;
            case "Dekagray/second - daGy/s":
                editTextValueTo.setText(strDekagraypersecond);
                break;
            case "Decigray/second - dGy/s":
                editTextValueTo.setText(strDecigraypersecond);
                break;
            case "Centigray/second - cGy/s":
                editTextValueTo.setText(strCentigraypersecond);
                break;
            case "Milligray/second - mGy/s":
                editTextValueTo.setText(strMilligraypersecond);
                break;
            case "Microgray/second - µGy/s":
                editTextValueTo.setText(strMicrograypersecond);
                break;
            case "Nanogray/second - nGy/s":
                editTextValueTo.setText(strNanograypersecond);
                break;
            case "Picogray/second - pGy/s":
                editTextValueTo.setText(strPicograypersecond);
                break;
            case "Femtogray/second - fGy/s":
                editTextValueTo.setText(strFemtograypersecond);
                break;
            case "Attogray/second - aGy/s":
                editTextValueTo.setText(strAttograypersecond);
                break;
            case "Rad/second - rd/s":
                editTextValueTo.setText(strRadpersecond);
                break;
            case "Joule/kilogram/second - J/kg/s":
                editTextValueTo.setText(strJouleperkilogrampersecond);
                break;
            case "Watt/kilogram - W/kg":
                editTextValueTo.setText(strWattperkilogram);
                break;
            case "Sievert/second - Sv/s":
                editTextValueTo.setText(strSievertpersecond);
                break;
            case "Rem/second - rem/s":
                editTextValueTo.setText(strRempersecond);
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