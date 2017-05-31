package com.nineinfosys.radiologyconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.nineinfosys.radiologyconverter.ConverterActivity.RadiationAbsorbedDoseActivity;
import com.nineinfosys.radiologyconverter.ConverterActivity.RadiationActivity;
import com.nineinfosys.radiologyconverter.ConverterActivity.RadiationConverterActivity;
import com.nineinfosys.radiologyconverter.ConverterActivity.RadiationExposureActivity;


public class SearchActivity extends AppCompatActivity implements TextWatcher {


    // List view
    private ListView lv;

    private String selectedItem;
    // Listview Adapter
    ArrayAdapter<String> adapter;

    // Search EditText
    EditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //customize toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Search By Unit");


        // Listview Data
        String listitem[] = {

                //radiology
                "Rad - rd",
                "Millirad - mrd",
                "Joule/kilogram - J/kg",
                "Joule/gram - J/g",
                "Joule/centigram - J/cg",
                "Joule/milligram - J/mg",
                "Gray - Gy",
                "Exagray - EGy",
                "Petagray - PGy",
                "Teragray - TGy",
                "Gigagray - GGy",
                "Megagray - MGy",
                "Kilogray - kGy",
                "Hectogray - hGy",
                "Dekagray - daGy",
                "Decigray - dGy",
                "Centigray - cGy",
                "Milligray - mGy",
                "Microgray - µGy",
                "Nanogray - nGy",
                "Picogray - pGy",
                "Femtogray - fGy",
                "Attogray - aGy",

                //radiation
                "Becquerel - Bq",
                "Terabecquerel - TBq",
                "Gigabecquerel - GBq",
                "Megabecquerel - MBq",
                "Kilobecquerel - kBq",
                "Millibecquerel - mBq",
                "Curie - Ci",
                "Kilocurie - kCi",
                "Millicurie - mCi",
                "Microcurie - µCi",
                "Nanocurie - nCi",
                "Picocurie - pCi",
                "Rutherford - R",
                "One/second - 1/s",
                "Disintegrations/second - dis/sec",
                "Disintegrations/minute - dis/min",

                //radiationconverteractivity
                "Gray/second - Gy/s",
                "Exagray/second - EGy/s",
                "Petagray/second - PGy/s",
                "Teragray/second - TGy/s",
                "Gigagray/second - GGy/s",
                "Megagray/second - MGy/s",
                "Kilogray/second - kGy/s",
                "Hectogray/second - hGy/s",
                "Dekagray/second - daGy/s",
                "Decigray/second - dGy/s",
                "Centigray/second - cGy/s",
                "Milligray/second - mGy/s",
                "Microgray/second - µGy/s",
                "Nanogray/second - nGy/s",
                "Picogray/second - pGy/s",
                "Femtogray/second - fGy/s",
                "Attogray/second - aGy/s",
                "Rad/second - rd/s",
                "Joule/kilogram/second - J/kg/s",
                "Watt/kilogram - W/kg",
                "Sievert/second - Sv/s",
                "Rem/second - rem/s",

                "Coulomb/kilogram - C/kg",
                "Millicoulomb/kilogram - mC/kg",
                "Microcoulomb/kilogram - μC/kg",
                "Roentgen - R",
                "Tissue roentgen - Tr",
                "Parker - parker",
                "Rep - rep"


        };

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, listitem);
        lv.setAdapter(adapter);

        /*Collections.sort(lv, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });*/

        inputSearch.addTextChangedListener(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterView, View view, int position, long id) {

                //Do some more stuff here and launch new activity
                selectedItem = (String) adapterView.getItemAtPosition(position);
                //  Toast.makeText(SearchActivity.this,"Position"+selectedItem,Toast.LENGTH_LONG).show();
                switch (selectedItem) {

                    //radiology
                    case "Rad - rd" : radionabosrved(); break;
                    case "Millirad - mrd" : radionabosrved(); break;
                    case "Joule/kilogram - J/kg" : radionabosrved(); break;
                    case "Joule/gram - J/g" : radionabosrved(); break;
                    case "Joule/centigram - J/cg" : radionabosrved(); break;
                    case "Joule/milligram - J/mg" : radionabosrved(); break;
                    case "Gray - Gy" : radionabosrved(); break;
                    case "Exagray - EGy" : radionabosrved(); break;
                    case "Petagray - PGy" : radionabosrved(); break;
                    case "Teragray - TGy" : radionabosrved(); break;
                    case "Gigagray - GGy" : radionabosrved(); break;
                    case "Megagray - MGy" : radionabosrved(); break;
                    case "Kilogray - kGy" : radionabosrved(); break;
                    case "Hectogray - hGy" : radionabosrved(); break;
                    case "Dekagray - daGy" : radionabosrved(); break;
                    case "Decigray - dGy" : radionabosrved(); break;

                    case "Centigray - cGy" : radionabosrved(); break;
                    case "Milligray - mGy" : radionabosrved(); break;

                    case "Microgray - µGy" : radionabosrved(); break;
                    case "Nanogray - nGy" : radionabosrved(); break;

                    case "Picogray - pGy" : radionabosrved(); break;
                    case "Femtogray - fGy" : radionabosrved(); break;

                    case "Attogray - aGy" : radionabosrved(); break;

                    //radiation
                    case "Becquerel - Bq" : radiation(); break;
                    case "Terabecquerel - TBq" : radiation(); break;
                    case "Gigabecquerel - GBq" : radiation(); break;
                    case "Megabecquerel - MBq" : radiation(); break;
                    case "Kilobecquerel - kBq" : radiation(); break;
                    case "Millibecquerel - mBq" : radiation(); break;
                    case "Curie - Ci" : radiation(); break;
                    case "Kilocurie - kCi" : radiation(); break;
                    case "Millicurie - mCi" : radiation(); break;
                    case "Microcurie - µCi" : radiation(); break;
                    case "Nanocurie - nCi" : radiation(); break;
                    case "Picocurie - pCi" : radiation(); break;
                    case "Rutherford - R" : radiation(); break;
                    case "One/second - 1/s" : radiation(); break;
                    case "Disintegrations/second - dis/sec" : radiation(); break;
                    case "Disintegrations/minute - dis/min" : radiation(); break;


                    case "Gray/second - Gy/s" : radiationativity(); break;
                    case "Exagray/second - EGy/s" : radiationativity(); break;
                    case "Petagray/second - PGy/s" : radiationativity(); break;
                    case "Teragray/second - TGy/s" : radiationativity(); break;
                    case "Gigagray/second - GGy/s" : radiationativity(); break;
                    case "Megagray/second - MGy/s" : radiationativity(); break;
                    case "Kilogray/second - kGy/s" : radiationativity(); break;
                    case "Hectogray/second - hGy/s" : radiationativity(); break;
                    case "Dekagray/second - daGy/s" : radiationativity(); break;
                    case "Decigray/second - dGy/s" : radiationativity(); break;
                    case "Centigray/second - cGy/s" : radiationativity(); break;
                    case "Milligray/second - mGy/s" : radiationativity(); break;
                    case "Microgray/second - µGy/s" : radiationativity(); break;
                    case "Nanogray/second - nGy/s" : radiationativity(); break;
                    case "Picogray/second - pGy/s" : radiationativity(); break;
                    case "Femtogray/second - fGy/s" : radiationativity(); break;
                    case "Attogray/second - aGy/s" : radiationativity(); break;
                    case "Rad/second - rd/s" : radiationativity(); break;
                    case "Joule/kilogram/second - J/kg/s" : radiationativity(); break;
                    case "Watt/kilogram - W/kg" : radiationativity(); break;
                    case "Sievert/second - Sv/s" : radiationativity(); break;
                    case "Rem/second - rem/s" : radiationativity(); break;

                    //radiation exposure
                    case "Coulomb/kilogram - C/kg" : radiationexposure(); break;
                    case "Millicoulomb/kilogram - mC/kg" : radiationexposure(); break;
                    case "Microcoulomb/kilogram - μC/kg" : radiationexposure(); break;
                    case "Roentgen - R" : radiationexposure(); break;
                    case "Tissue roentgen - Tr" : radiationexposure(); break;
                    case "Parker - parker" : radiationexposure(); break;
                    case "Rep - rep" : radiationexposure(); break;


                }
            }
        });
        }


    private void radiationexposure() {
        Intent i7=new Intent(SearchActivity.this,RadiationExposureActivity.class);
        startActivity(i7);
    }

    private void radiationativity() {
        Intent i7=new Intent(SearchActivity.this,RadiationConverterActivity.class);
        startActivity(i7);
    }

    private void radiation() {
        Intent i7=new Intent(SearchActivity.this,RadiationActivity.class);
        startActivity(i7);
    }

    private void radionabosrved() {
        Intent i7=new Intent(SearchActivity.this,RadiationAbsorbedDoseActivity.class);
        startActivity(i7);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        SearchActivity.this.adapter.getFilter().filter(s);
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



