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

import com.nineinfosys.radiologyconverter.ConverterActivityList.RadiationListActivity;
import com.nineinfosys.radiologyconverter.Engin.RadiationActivityConverter;
import com.nineinfosys.radiologyconverter.R;
import com.nineinfosys.radiologyconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RadiationActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {

    //declaration of designing tools
    private Spinner spinnerConvertFrom, spinnerConvertTo;
    private EditText editTextValue, editTextValueTo;

    private FloatingActionButton buttonList, buttonShare, buttonMail, buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listRadiationFirsttempTo, listRadiationFirstfrom,listRadiationTo,listRadiationfrom;
    private String stringSpinnerFrom, stringSpinnerTo;
    private TextView textViewBasicUnit, textViewAllUnit,textViewConvert;
    double doubleEdittextvalue = 1.0;
    private int basicunit = 6;
    private int allunit = 16;
    DecimalFormat formatter = null;
    private static final int REQUEST_CODE = 100;

    RadiationActivityConverter.ConversionResults item;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_converter);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e65f21")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Radiation");

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

        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedishyellow)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedishyellow)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedishyellow)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedishyellow)));
        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedishyellow)));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedishyellow)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#a02a00"));
        }


        textViewBasicUnit.setText(String.valueOf("Basic Units(" + basicunit + ")"));
        textViewAllUnit.setText(String.valueOf("All Units(" + allunit + ")"));


        //adding value to spinner
        listRadiationFirstfrom = new ArrayList<String>();
        listRadiationFirsttempTo = new ArrayList<String>();

        //for first time running spinner
        listRadiationFirstfrom.add("Becquerel - Bq" );
        listRadiationFirstfrom.add("Terabecquerel - TBq");
        listRadiationFirstfrom.add("Gigabecquerel - GBq");
        listRadiationFirstfrom.add("Megabecquerel - MBq");
        listRadiationFirstfrom.add("Kilobecquerel - kBq");
        listRadiationFirstfrom.add("Millibecquerel - mBq");

        //for first time running spinner
        listRadiationFirsttempTo.add("Becquerel - Bq" );
        listRadiationFirsttempTo.add("Terabecquerel - TBq");
        listRadiationFirsttempTo.add("Gigabecquerel - GBq");
        listRadiationFirsttempTo.add("Megabecquerel - MBq");
        listRadiationFirsttempTo.add("Kilobecquerel - kBq");
        listRadiationFirsttempTo.add("Millibecquerel - mBq");

        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(RadiationActivity.this, android.R.layout.simple_spinner_item, listRadiationFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(RadiationActivity.this, android.R.layout.simple_spinner_item, listRadiationFirsttempTo);


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
                        listRadiationfrom.add("Becquerel - Bq" );
                        listRadiationfrom.add("Terabecquerel - TBq");
                        listRadiationfrom.add("Gigabecquerel - GBq");
                        listRadiationfrom.add("Megabecquerel - MBq");
                        listRadiationfrom.add("Kilobecquerel - kBq");
                        listRadiationfrom.add("Millibecquerel - mBq");

                        //for first time running spinner
                        listRadiationTo.add("Becquerel - Bq" );
                        listRadiationTo.add("Terabecquerel - TBq");
                        listRadiationTo.add("Gigabecquerel - GBq");
                        listRadiationTo.add("Megabecquerel - MBq");
                        listRadiationTo.add("Kilobecquerel - kBq");
                        listRadiationTo.add("Millibecquerel - mBq");
                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to " + strAdvance + " Units", Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
                        listRadiationfrom.clear();
                        listRadiationTo.clear();

                        //for first  running spinner
                        listRadiationfrom.add("Becquerel - Bq" );
                        listRadiationfrom.add("Terabecquerel - TBq");
                        listRadiationfrom.add("Gigabecquerel - GBq");
                        listRadiationfrom.add("Megabecquerel - MBq");
                        listRadiationfrom.add("Kilobecquerel - kBq");
                        listRadiationfrom.add("Millibecquerel - mBq");
                        listRadiationfrom.add("Curie - Ci");
                        listRadiationfrom.add("Kilocurie - kCi");
                        listRadiationfrom.add("Millicurie - mCi");
                        listRadiationfrom.add("Microcurie - µCi");
                        listRadiationfrom.add("Nanocurie - nCi");
                        listRadiationfrom.add("Picocurie - pCi");
                        listRadiationfrom.add("Rutherford - R");
                        listRadiationfrom.add("One/second - 1/s");
                        listRadiationfrom.add("Disintegrations/second - dis/sec");
                        listRadiationfrom.add("Disintegrations/minute - dis/min");




                        //for second running spinner
                        listRadiationTo.add("Becquerel - Bq" );
                        listRadiationTo.add("Terabecquerel - TBq");
                        listRadiationTo.add("Gigabecquerel - GBq");
                        listRadiationTo.add("Megabecquerel - MBq");
                        listRadiationTo.add("Kilobecquerel - kBq");
                        listRadiationTo.add("Millibecquerel - mBq");
                        listRadiationTo.add("Curie - Ci");
                        listRadiationTo.add("Kilocurie - kCi");
                        listRadiationTo.add("Millicurie - mCi");
                        listRadiationTo.add("Microcurie - µCi");
                        listRadiationTo.add("Nanocurie - nCi");
                        listRadiationTo.add("Picocurie - pCi");
                        listRadiationTo.add("Rutherford - R");
                        listRadiationTo.add("One/second - 1/s");
                        listRadiationTo.add("Disintegrations/second - dis/sec");
                        listRadiationTo.add("Disintegrations/minute - dis/min");


                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(RadiationActivity.this, android.R.layout.simple_spinner_item, listRadiationfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(RadiationActivity.this, android.R.layout.simple_spinner_item, listRadiationTo);


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
                Intent i = new Intent(this,RadiationListActivity.class);
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

           RadiationActivityConverter c = new RadiationActivityConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<RadiationActivityConverter.ConversionResults> results = c.calculateRadiationConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

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




                switch (strSpinnerFromvalue1) {
                    case "Becquerel - Bq" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Terabecquerel - TBq":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Gigabecquerel - GBq":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Megabecquerel - MBq":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilobecquerel - kBq":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Millibecquerel - mBq":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Curie - Ci":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Kilocurie - kCi":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Millicurie - mCi":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Microcurie - µCi":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Nanocurie - nCi":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Picocurie - pCi":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Rutherford - R":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "One/second - 1/s":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Disintegrations/second - dis/sec":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Disintegrations/minute - dis/min":
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
            case "Becquerel - Bq" :
                editTextValueTo.setText(strBecquerel);
                break;
            case "Terabecquerel - TBq":
                editTextValueTo.setText(strTerabecquerel);
                break;

            case "Gigabecquerel - GBq":
                editTextValueTo.setText(strGigabecquerel);
                break;
            case "Megabecquerel - MBq":
                editTextValueTo.setText(strMegabecquerel);
                break;
            case "Kilobecquerel - kBq":
                editTextValueTo.setText(strkilobecquerel);
                break;
            case "Millibecquerel - mBq":
                editTextValueTo.setText(strMillibecquerel);
                break;
            case "Curie - Ci":
                editTextValueTo.setText(strCurie);
                break;
            case "Kilocurie - kCi":
                editTextValueTo.setText(strKilocurie);
                break;
            case "Millicurie - mCi":
                editTextValueTo.setText(strMillicurie);
                break;
            case "Microcurie - µCi":
                editTextValueTo.setText(strMicrocurie);
                break;

            case "Nanocurie - nCi":
                editTextValueTo.setText(strNanocurie);
                break;
            case "Picocurie - pCi":
                editTextValueTo.setText(strPicocurie);
                break;
            case "Rutherford - R":
                editTextValueTo.setText(strRutherford);
                break;
            case "One/second - 1/s":
                editTextValueTo.setText(strOnepersecond);
                break;
            case "Disintegrations/second - dis/sec":
                editTextValueTo.setText(strDisintegrationspersecond);
                break;
            case "Disintegrations/minute - dis/min":
                editTextValueTo.setText(strDisintegrationsperminute);
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