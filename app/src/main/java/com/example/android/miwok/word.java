package com.example.android.miwok;

public class word{

    private String mDefaultTranslation ;


    private String mMiwokTranslation ;

    public word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public String getmDefaultTranslation () {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation () {
        return mMiwokTranslation;
    }

}
