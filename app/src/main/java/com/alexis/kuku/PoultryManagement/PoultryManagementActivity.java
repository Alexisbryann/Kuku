package com.alexis.kuku.PoultryManagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.alexis.kuku.BadHabits.BadHabitsActivity;
import com.alexis.kuku.BestPractice.BestPracticeActivity;
import com.alexis.kuku.Brooding.BroodingActivity;
import com.alexis.kuku.HousingAndEquipment.HousingAndEquipmentActivity;
import com.alexis.kuku.PoultryHealthManagement.PoultryHealthManagementActivity;
import com.alexis.kuku.R;
import com.google.android.material.navigation.NavigationView;

public class PoultryManagementActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poultry_management);

    }
}