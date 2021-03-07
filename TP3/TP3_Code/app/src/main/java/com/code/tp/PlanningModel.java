package com.code.tp;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlanningModel extends ViewModel {

    public String AM1 = "08h-10H : Rencontre client Dupont";
    public String AM2 = "10h-12h : Travailler le dossier recrutement";
    public String PM1 = "14h-16h : Réunion équipe";
    public String PM2 = "16h-18h : Préparation dossier vente";


    public MutableLiveData<String> AM1LD = new MutableLiveData<String>();
    public MutableLiveData<String> AM2LD = new MutableLiveData<String>();
    public MutableLiveData<String> PM1LD = new MutableLiveData<String>();
    public MutableLiveData<String> PM2LD = new MutableLiveData<String>();


}
