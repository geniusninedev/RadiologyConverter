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


import com.nineinfosys.radiologyconverter.ConverterActivityList.ConversionRadiationExposureListActivity;
import com.nineinfosys.radiologyconverter.Engin.RadiationExposureConverter;
import com.nineinfosys.radiologyconverter.R;
import com.nineinfosys.radiologyconverter.Supporter.Settings;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RadiationExposureActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher  {

    //declaration of designing tools
    private Spinner spinnerConvertFrom,spinnerConvertTo;
    private EditText editTextValue,editTextValueTo;
    private FloatingActionButton buttonList,buttonShare,buttonMail,buttonCopy;
    private SwitchCompat switchChangeType;
    List<String> listRadiationFirstfrom,listFirstRadiationTo,listRadiationfrom,listRadiationTo;
    private String stringSpinnerFrom,stringSpinnerTo;
    private TextView textViewBasicUnit,textViewAllUnit,textViewConvert;
    double doubleEdittextvalue=1.0;
    private int basicunit=3;
    private int allunit=7;
    private static final int REQUEST_CODE = 100;
    DecimalFormat formatter = null;

    RadiationExposureConverter.ConversionResults item;
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
        setContentView(R.layout.layout_converter);

        //customize toolbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#db290d")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Radiation Exposure");


        formatsetting();


        //keyboard hidden first time
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //initalization of tools and variables
        spinnerConvertFrom=(Spinner)findViewById(R.id.spinnerConvertFrom);
        spinnerConvertTo=(Spinner)findViewById(R.id.spinnerConvertTo);
        textViewBasicUnit=(TextView)findViewById(R.id.textViewBasicUnit);
        textViewAllUnit=(TextView)findViewById(R.id.textViewAllUnit);
        editTextValue=(EditText)findViewById(R.id.edittextFrom);
        editTextValueTo=(EditText)findViewById(R.id.edittextTo);
        textViewConvert=(TextView) findViewById(R.id.buttonUnitConverter);
        buttonCopy=(FloatingActionButton)findViewById(R.id.button_copy);
        buttonList=(FloatingActionButton) findViewById(R.id.button_list_fullreport);
        buttonShare=(FloatingActionButton)findViewById(R.id.button_list_share);
        buttonMail=(FloatingActionButton)findViewById(R.id.button_list_mail);
        switchChangeType=(SwitchCompat)findViewById(R.id.switchButton);


        //setting button color dynamically
        buttonCopy.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedorange)));
        buttonList.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedorange)));
        buttonShare.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedorange)));
        buttonMail.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedorange)));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textViewConvert.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedorange)));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#a10000"));
        }

        DrawableCompat.setTintList(DrawableCompat.wrap(switchChangeType.getThumbDrawable()),ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorRedorange)));
        textViewBasicUnit.setText(String.valueOf("Basic Units("+basicunit+")"));
        textViewAllUnit.setText(String.valueOf("All Units("+allunit+")"));


        //adding value to spinner
        listRadiationFirstfrom = new ArrayList<String>();
        listFirstRadiationTo = new ArrayList<String>();

        //for first time running spinner
        listRadiationFirstfrom.add("Coulomb/kilogram - C/kg");
        listRadiationFirstfrom.add("Millicoulomb/kilogram - mC/kg");
        listRadiationFirstfrom.add("Microcoulomb/kilogram - μC/kg");


        listFirstRadiationTo.add("Coulomb/kilogram - C/kg");
        listFirstRadiationTo.add("Millicoulomb/kilogram - mC/kg");
        listFirstRadiationTo.add("Microcoulomb/kilogram - μC/kg");


        // Creating adapter for spinner
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(RadiationExposureActivity.this,android.R.layout.simple_spinner_item, listRadiationFirstfrom);
        ArrayAdapter<String> AdapterTempTo = new ArrayAdapter<String>(RadiationExposureActivity.this,android.R.layout.simple_spinner_item, listFirstRadiationTo);


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
                String stringSwitchSate=String.valueOf(isChecked);
                String strBasic="Basic";
                String strAdvance="All";
                switch(stringSwitchSate)
                {

                    case "false":
                        Snackbar.make(buttonView, "You switched to "+strBasic+" Units", Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                        listRadiationfrom.clear();
                        listRadiationTo.clear();
                        listRadiationfrom.add("Coulomb/kilogram - C/kg");
                        listRadiationfrom.add("Millicoulomb/kilogram - mC/kg");
                        listRadiationfrom.add("Microcoulomb/kilogram - μC/kg");


                        //2 spinner
                        listRadiationTo.add("Coulomb/kilogram - C/kg");
                        listRadiationTo.add("Millicoulomb/kilogram - mC/kg");
                        listRadiationTo.add("Microcoulomb/kilogram - μC/kg");


                        break;

                    case "true":
                        Snackbar.make(buttonView, "You switched to "+strAdvance+" Units", Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                        listRadiationfrom.clear();
                        listRadiationTo.clear();
                        listRadiationfrom.add("Coulomb/kilogram - C/kg");
                        listRadiationfrom.add("Millicoulomb/kilogram - mC/kg");
                        listRadiationfrom.add("Microcoulomb/kilogram - μC/kg");
                        listRadiationfrom.add("Roentgen - R");
                        listRadiationfrom.add("Tissue roentgen - Tr");
                        listRadiationfrom.add("Parker - parker");
                        listRadiationfrom.add("Rep - rep");

                        //2 spinner
                        listRadiationTo.add("Coulomb/kilogram - C/kg");
                        listRadiationTo.add("Millicoulomb/kilogram - mC/kg");
                        listRadiationTo.add("Microcoulomb/kilogram - μC/kg");
                        listRadiationTo.add("Roentgen - R");

                        listRadiationTo.add("Tissue roentgen - Tr");
                        listRadiationTo.add("Parker - parker");
                        listRadiationTo.add("Rep - rep");


                        break;
                }
                // Creating adapter for spinner
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(RadiationExposureActivity.this,android.R.layout.simple_spinner_item, listRadiationfrom);
                ArrayAdapter<String> AdapterTempTo2 = new ArrayAdapter<String>(RadiationExposureActivity.this,android.R.layout.simple_spinner_item, listRadiationTo);


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

                if(editTextValue.getText().toString().trim().equals(""))
                {
                    Snackbar.make(adapterView, "Provide Unit Value for Conversion", Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                }
                else
                {
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

                if(editTextValue.getText().toString().trim().equals(""))
                {
                    Snackbar.make(adapterView, "Provide Unit Value for Conversion", Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                }
                else {
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
        SharedPreferences sharedPreferences =this.getSharedPreferences(Settings.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        //Fetching thepatient_mobile_Number value form sharedpreferences
        String  FormattedString = sharedPreferences.getString(Settings.Format_Selected_SHARED_PREF,"Thousands separator");
        String DecimalplaceString= sharedPreferences.getString(Settings.Decimal_Place_Selected_SHARED_PREF,"2");
        Settings settings=new Settings(FormattedString,DecimalplaceString);
        formatter= settings.setting();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonUnitConverter:
                //switch spinner value
                int spinner1Index = spinnerConvertFrom.getSelectedItemPosition();
                spinnerConvertFrom.setSelection(spinnerConvertTo.getSelectedItemPosition());
                spinnerConvertTo.setSelection(spinner1Index );
                break;

            case R.id.button_list_fullreport:
                doubleEdittextvalue= Double.parseDouble(editTextValue.getText().toString().trim());
                Intent i=new Intent(this,ConversionRadiationExposureListActivity.class);
                i.putExtra("stringSpinnerFrom", stringSpinnerFrom);
                i.putExtra("doubleEdittextvalue", doubleEdittextvalue);
                startActivity(i);
                break;

            case R.id.button_copy:
                String text= editTextValueTo.getText().toString().trim();
                android.content.ClipboardManager clipboardMgr = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied text", text);
                clipboardMgr.setPrimaryClip(clip);
                Snackbar.make(v, "Conversion Value Copied", Snackbar.LENGTH_LONG).setAction("ACTION",null).show();
                break;

            case R.id.button_list_share:
                String textTo= editTextValueTo.getText().toString().trim();
                String textFrom= editTextValueTo.getText().toString().trim();

                String shareMessage=textFrom+" "+stringSpinnerFrom+": "+textTo+" "+stringSpinnerTo;

                try {
                    Intent share = new Intent();
                    share.setAction("android.intent.action.SEND");
                    share.setType("text/plain");
                    share.putExtra("android.intent.extra.TEXT",shareMessage);
                    startActivity(Intent.createChooser(share, ""));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.button_list_mail:
                String textmailTo= editTextValueTo.getText().toString().trim();
                String textmailFrom= editTextValueTo.getText().toString().trim();
                String message= textmailTo+" "+stringSpinnerFrom+" :  "+textmailFrom+"  "+stringSpinnerTo;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ });
                email.putExtra(Intent.EXTRA_SUBJECT, "Conversion Details");
                email.putExtra(Intent.EXTRA_TEXT,message );
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
            calcualteValue(stringSpinnerFrom,stringSpinnerTo,doubleEdittextvalue);

            //   Toast.makeText(this, "string12" + stringSpinnerFrom + "\n string13" + stringSpinnerTo + "string14" + doubleEdittextvalue, Toast.LENGTH_LONG).show();
        }
        catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }


    }
    public void calcualteValue(String strSpinnerFromvalue1,String strSpinnerTovalue2,double doubleEdittextvalue1)
    {


        try {

            RadiationExposureConverter c = new RadiationExposureConverter(strSpinnerFromvalue1, (int) doubleEdittextvalue1);
            ArrayList<RadiationExposureConverter.ConversionResults> results = c.calculateRadiationExposureConversion();
            int length = results.size();
            for (int i = 0; i < length; i++) {
                item = results.get(i);

                strCoulombperkilogram = String.valueOf(formatter.format(item.getCoulombperkilogram()));
                strMillicoulombperkilogram = String.valueOf(formatter.format(item.getMillicoulombperkilogram()));
                strRoentgen = String.valueOf(formatter.format(item.getRoentgen()));
                strTissueroentgen = String.valueOf(formatter.format(item.getTissueroentgen()));

                strParker = String.valueOf(formatter.format(item.getParker()));
                strMicrocoulombpeperkilogram = String.valueOf(formatter.format(item.getMicrocoulombperkilogram()));
                strRep = String.valueOf(formatter.format(item.getRep()));




                switch(strSpinnerFromvalue1) {
                    case "Coulomb/kilogram - C/kg" :
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Millicoulomb/kilogram - mC/kg":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Microcoulomb/kilogram - μC/kg":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Roentgen - R":
                        conversion(strSpinnerTovalue2);
                        break;

                    case "Tissue roentgen - Tr":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Parker - parker":
                        conversion(strSpinnerTovalue2);
                        break;
                    case "Rep - rep":
                        conversion(strSpinnerTovalue2);
                        break;


                }


            }


        }
        catch (NumberFormatException e) {
            doubleEdittextvalue = 0;

        }

    }

    private void conversion(String strSpinnerTovalue2) {
        switch (strSpinnerTovalue2) {

            case "Coulomb/kilogram - C/kg" :
                editTextValueTo.setText(strCoulombperkilogram);
                break;
            case "Millicoulomb/kilogram - mC/kg":
                editTextValueTo.setText(strMillicoulombperkilogram);
                break;
            case "Microcoulomb/kilogram - μC/kg":
                editTextValueTo.setText(strRoentgen);
                break;
            case "Roentgen - R":
                editTextValueTo.setText(strTissueroentgen);
                break;

            case "Tissue roentgen - Tr":
                editTextValueTo.setText(strParker);
                break;
            case "Parker - parker":
                editTextValueTo.setText(strMicrocoulombpeperkilogram);
                break;
            case "Rep - rep":
                editTextValueTo.setText(strRep);
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