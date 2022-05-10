package com.example.mymachan.utils.sharepreference;

public interface LoginPreferencesProvider {
    void setOrgId(String orgId);

    void setPersonId(String personId);

    void setPersonName(String personName);

    void setFactoryNumber(String mNumber);

    String getOrgId();

    String getPersonId();

    String getPersonName();

    String getFactoryName();

}
