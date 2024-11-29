package com.example.yennhu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class LoginFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button login;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        login = view.findViewById(R.id.login);

        // Set up login button click listener
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeFragment.class);
                startActivity(intent);
            }
        });

        // Initialize TabLayout with ViewPager (if using tabs)
        if (tabLayout != null && viewPager != null) {
            tabLayout.setupWithViewPager(viewPager);
        }

        return view;
    }
}
