package akashsarkar188.jellybottomnav;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.Navigation.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.TransitionManager;

public class MainActivity extends AppCompatActivity {

    LinearLayout homeOptionLayout, itemsOptionLayout, profileOptionLayout, settingsOptionLayout, bottomOptionsLayout;
    TextView homeTextView, itemsTextView, profileTextView, settingsTextView;
    NavController navController;
    int currentFrag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        onClickListeners();
    }

    private void onClickListeners() {
        homeOptionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(bottomOptionsLayout);
                homeTextView.setVisibility(View.VISIBLE);
                itemsTextView.setVisibility(View.GONE);
                profileTextView.setVisibility(View.GONE);
                settingsTextView.setVisibility(View.GONE);

                switch (currentFrag){
                    case 0:
                        // same frag, you can refresh if you like
                        break;
                    case 1:
                        // navigate to items from home
                        navController.navigate(R.id.action_itemsFragment_to_homeFragment);
                        break;
                    case 2:
                        // navigate to profile from home
                        navController.navigate(R.id.action_profileFragment_to_homeFragment);
                        break;
                    case 3:
                        // navigate to settings from home
                        navController.navigate(R.id.action_settingsFragment_to_homeFragment);
                        break;
                }

                currentFrag = 0;
            }
        });

        itemsOptionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(bottomOptionsLayout);
                homeTextView.setVisibility(View.GONE);
                itemsTextView.setVisibility(View.VISIBLE);
                profileTextView.setVisibility(View.GONE);
                settingsTextView.setVisibility(View.GONE);

                switch (currentFrag){
                    case 0:
                        navController.navigate(R.id.action_homeFragment_to_itemsFragment);
                        break;
                    case 1:
                        // same frag, you can refresh if you like
                        break;
                    case 2:
                        navController.navigate(R.id.action_profileFragment_to_itemsFragment);
                        break;
                    case 3:
                        navController.navigate(R.id.action_settingsFragment_to_itemsFragment);
                        break;
                }
                currentFrag = 1;
            }
        });

        profileOptionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(bottomOptionsLayout);
                homeTextView.setVisibility(View.GONE);
                itemsTextView.setVisibility(View.GONE);
                profileTextView.setVisibility(View.VISIBLE);
                settingsTextView.setVisibility(View.GONE);

                switch (currentFrag){
                    case 0:
                        navController.navigate(R.id.action_homeFragment_to_profileFragment);
                        break;
                    case 1:
                        navController.navigate(R.id.action_itemsFragment_to_profileFragment);
                        break;
                    case 2:
                        // same frag, you can refresh if you like
                        break;
                    case 3:
                        navController.navigate(R.id.action_settingsFragment_to_profileFragment);
                        break;
                }
                currentFrag = 2;
            }
        });

        settingsOptionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(bottomOptionsLayout);
                homeTextView.setVisibility(View.GONE);
                itemsTextView.setVisibility(View.GONE);
                profileTextView.setVisibility(View.GONE);
                settingsTextView.setVisibility(View.VISIBLE);

                switch (currentFrag){
                    case 0:
                        navController.navigate(R.id.action_homeFragment_to_settingsFragment);
                        break;
                    case 1:
                        navController.navigate(R.id.action_itemsFragment_to_settingsFragment);
                        break;
                    case 2:
                        navController.navigate(R.id.action_profileFragment_to_settingsFragment);
                        break;
                    case 3:
                        // same frag, you can refresh if you like
                        break;
                }
                currentFrag = 3;
            }
        });
    }

    private void initView() {

        homeOptionLayout = findViewById(R.id.homeOptionLayout);
        itemsOptionLayout = findViewById(R.id.itemsOptionLayout);
        profileOptionLayout = findViewById(R.id.profileOptionLayout);
        settingsOptionLayout = findViewById(R.id.settingsOptionLayout);

        bottomOptionsLayout = findViewById(R.id.bottomOptionsLayout);

        homeTextView = findViewById(R.id.homeTextView);
        itemsTextView = findViewById(R.id.itemsTextView);
        profileTextView = findViewById(R.id.profileTextView);
        settingsTextView = findViewById(R.id.settingsTextView);

        navController = Navigation.findNavController(MainActivity.this, R.id.fragmentPlaceHolder_Main);

    }
}