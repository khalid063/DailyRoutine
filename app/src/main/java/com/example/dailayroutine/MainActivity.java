package com.example.dailayroutine;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailayroutine.databinding.ActivityMainBinding;
import com.example.dailayroutine.fragment.HomeFragment;
import com.example.dailayroutine.fragment.ScheduleEight;
import com.example.dailayroutine.fragment.ScheduleEleven;
import com.example.dailayroutine.fragment.ScheduleFive;
import com.example.dailayroutine.fragment.ScheduleFour;
import com.example.dailayroutine.fragment.ScheduleNine;
import com.example.dailayroutine.fragment.ScheduleOne;
import com.example.dailayroutine.fragment.ScheduleSix;
import com.example.dailayroutine.fragment.ScheduleTen;
import com.example.dailayroutine.fragment.ScheduleThree;
import com.example.dailayroutine.fragment.ScheduleTwelve;
import com.example.dailayroutine.fragment.ScheduleTwo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    //private Toolbar toolbar;
    private TextView textView_toolbar_title;
    ImageView ivMenuIco;
    DrawerLayout drawerLayout;

    // for Drawar Navigation menu out side onCreat (outSide of OnCreat)
    ImageView ivDrawarButtton;
    //DrawerLayout drawerLayout;
    ListView lvDrawer;
    private String[] countryNames;
    DrawerAdapter drawerAdapter;

    private int[] flags = {R.drawable.ic_schedule,
            R.drawable.ic_schedule,
            R.drawable.ic_schedule,
            R.drawable.ic_schedule,
            R.drawable.ic_schedule,
            R.drawable.ic_schedule,
            R.drawable.ic_schedule,
            R.drawable.ic_schedule,
            R.drawable.ic_schedule,
            R.drawable.ic_schedule,
            R.drawable.ic_schedule,
            R.drawable.ic_schedule
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //--------------------------------------- Find view by Id -------------------------------//
        textView_toolbar_title = findViewById(R.id.tv_toolbar_text);
        textView_toolbar_title.setText("Daily Routine");

        // code for showing fragment in mainActivity.xml
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

        ivMenuIco = findViewById(R.id.ivMenuIco);
        drawerLayout = findViewById (R.id.drawar_layout);

        ivDrawarButtton = findViewById(R.id.ivMenuIco);
        drawerLayout = findViewById(R.id.drawar_layout);
        lvDrawer = findViewById(R.id.lvDrawer);


        // get menu item from string-array (from strings.xml)
        countryNames = getResources().getStringArray(R.array.menu_item);

        // call DrawerAdapter constractor (used by BaseAdapter)
        drawerAdapter = new DrawerAdapter(MainActivity.this, countryNames, flags);
        lvDrawer.setAdapter(drawerAdapter);  // set the view which we get from DrawerAdapter

        // Listener set into Navigation Drawer menu
        lvDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawer(GravityCompat.START);
                String value = countryNames[position];
                Toast.makeText(MainActivity.this, "Clicked"+value, Toast.LENGTH_SHORT).show();
                Log.d("position","view : "+position);

                int v = position;
                switch (v){
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleOne()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleTwo()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleThree()).commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleFour()).commit();
                        break;
                    case 4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleFive()).commit();
                        break;
                    case 5:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleSix()).commit();
                        break;
                    case 6:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleEleven()).commit();
                        break;
                    case 7:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleEight()).commit();
                        break;
                    case 8:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleNine()).commit();
                        break;
                    case 9:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleTen()).commit();
                        break;
                    case 10:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleEleven()).commit();
                        break;
                    case 11:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleTwelve()).commit();
                        break;

                    default:
                        String text = "No value found";
                }

//                if (position == 0){
//                    // code for showing fragment in mainActivity.xml
//                    Toast.makeText(MainActivity.this, " Clicked", Toast.LENGTH_LONG).show();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleOne()).commit();
//                    //lvDrawer.setSelector( R.color.sp_bg);
//                }
//                else if (position == 1){
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleTwo()).commit();
//                    //lvDrawer.setSelector( R.color.sp_bg);
//                }
//                else if (position == 2){
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleThree()).commit();
//                }
//                else if (position == 3){
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ScheduleFour()).commit();
//                }
            }
        });

        //---------------------------------------------- Set OnClick Listener ------------------------------//
        ivMenuIco.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        // For drawar navigation menu outside onCreat
        if (v.getId() == R.id.ivMenuIco){
            drawerLayout.openDrawer(GravityCompat.START);

        }
    }

    // OnBackPressed call
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }

}