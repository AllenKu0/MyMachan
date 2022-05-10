package com.example.mymachan.utils.sharepreference;

import android.content.Context;

import javax.inject.Inject;

public class LoginPreferences extends PreferenceHelper implements LoginPreferencesProvider {

    private final String SP_FiLE_NAME = LoginPreferences.class.getName();
    private final String SP_ORG_ID = "SP_ORG_ID";
    private final String SP_PERSON_ID = "SP_PERSON_ID";
    private final String SP_PERSON_NAME = "SP_PERSON_NAME";
    private final String FACTORY_NUMBER="FACTORY_NUMBER";

    @Inject
    public LoginPreferences(Context context){
        super(context);
    }

    @Override
    public String getClassName(){
        return SP_PERSON_NAME;
    }


    @Override
    public void setOrgId(String orgId) {
        save(Type.String,SP_ORG_ID,orgId);
    }

    @Override
    public void setPersonId(String personId) {
        save(Type.String,SP_PERSON_ID,personId);
    }

    @Override
    public void setPersonName(String personName) {
        save(Type.String,SP_PERSON_NAME,personName);
    }

    @Override
    public void setFactoryNumber(String mNumber) {
        save(Type.String,FACTORY_NUMBER,mNumber);
    }

    @Override
    public String getOrgId() {
        return (String) get(Type.String,SP_ORG_ID);
    }

    @Override
    public String getPersonId() {
        return (String) get(Type.String,SP_PERSON_ID);
    }

    @Override
    public String getPersonName() {
        return (String) get(Type.String,SP_PERSON_NAME);
    }

    @Override
    public String getFactoryName() {
        return (String) get(Type.String,FACTORY_NUMBER);
    }

}
