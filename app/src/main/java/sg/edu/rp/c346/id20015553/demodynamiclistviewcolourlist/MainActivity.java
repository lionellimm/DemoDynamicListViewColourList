package sg.edu.rp.c346.id20015553.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etNumber;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etNumber = findViewById(R.id.editTextNumber);
        btnAdd = findViewById((R.id.buttonAddItem));
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);

        ArrayList<String> alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etElement.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "Please add a Colour!", Toast.LENGTH_SHORT).show();
                }
                else if(!etElement.getText().toString().equalsIgnoreCase("")){

                    int num = Integer.parseInt(etNumber.getText().toString());

                    if(num > alColours.size()){
                        Toast.makeText(MainActivity.this, "Too large of an index!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        alColours.add(num, etElement.getText().toString());

                        aaColour.notifyDataSetChanged();
                    }
                }
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, "Colour: " + colour, Toast.LENGTH_SHORT).show();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etNumber.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "Index Required!", Toast.LENGTH_SHORT).show();
                }

                else{
                    if(Integer.parseInt(etNumber.getText().toString()) > alColours.size()-1){
                        Toast.makeText(MainActivity.this, "Too large of an index!", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        alColours.remove(Integer.parseInt(etNumber.getText().toString()));
                        aaColour.notifyDataSetChanged();
                    }
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etNumber.getText().toString().equalsIgnoreCase("") || etElement.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, "Colour and Index Required!", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(Integer.parseInt(etNumber.getText().toString()) > alColours.size()-1){
                        Toast.makeText(MainActivity.this, "Too large of an index!", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        alColours.set(Integer.parseInt(etNumber.getText().toString()), etElement.getText().toString());
                        aaColour.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}