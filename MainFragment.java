package com.example.luke.myproject;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luke.myproject.models.User;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by TheAppExperts on 10/10/2016.
 */

public class MainFragment extends Fragment {

    private Realm realm;

    public MainFragment(){}

    public  static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment= new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        return v;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
                    public void  execute(Realm realm){
                User u = realm.createObject(User.class);
                u.set_name("Luke");
                u.setNationalNumber("JJJJJJJJ");
                u.setPassword("Hello");
                u.setRePassword("Hello");
                u.setNation("England");
            }
    });
        RealmResults<User> users = realm.where(User.class).findAll();
        for(User u : users){
            Log.d("Realm", u.getNationalNumber());
        }
    }

    @Override
    public  void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
