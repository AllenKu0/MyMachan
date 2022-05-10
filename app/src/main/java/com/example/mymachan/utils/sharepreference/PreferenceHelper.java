package com.example.mymachan.utils.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.Type;
import java.security.Key;
import java.util.HashSet;
import java.util.Set;

public abstract class PreferenceHelper {
    private Context context;

    public PreferenceHelper(Context context){this.context = context;}

    public abstract String getClassName();

    public Context getContext(){return context;}

    public void save(Type type,String key,Object value) {
        SharedPreferences store = context.getSharedPreferences(getClassName(),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = store.edit();
        if(type == Type.String){
            editor.putString(key,(String) value);
        }else if(type == Type.FLOAT){
            editor.putFloat(key,(Float) value);
        }else if(type == Type.INT){
            editor.putInt(key,(Integer) value);
        }else if(type == Type.LONG){
            editor.putLong(key,(Long) value);
        }else if(type == Type.BOOLEAN){
            editor.putBoolean(key,(Boolean) value);
        }else if(type == Type.STRING_SET){
            editor.putStringSet(key,(HashSet<String>) value);
        }else{
            throw new RuntimeException("Must use base type(String, Float, Double, Integer, Long), type from input is " + type.getClass().getName() + ".");
        }
        editor.commit();
    }

    public Object get(Type type, String key){
        SharedPreferences store = context.getSharedPreferences(getClassName(),Context.MODE_PRIVATE);
        if(type == Type.String){
            return store.getString(key,"");
        }else if(type == Type.FLOAT){
            return  store.getFloat(key,0);
        }else if(type == Type.INT){
            return store.getInt(key,0);
        }else if(type == Type.LONG){
            return store.getLong(key,0);
        }else if(type == Type.BOOLEAN){
            return store.getBoolean(key,false);
        }else if(type == Type.STRING_SET){
            return store.getStringSet(key,new HashSet<>());
        }else{
            throw new RuntimeException("Must use base type(String, Float, Double, Integer, Long), type from input is " + type.getClass().getName() + ".");
        }
    }

    public static class Type{
        public static final Type String = new Type();
        public static final Type FLOAT = new Type();
        public static final Type DOUBLE = new Type();
        public static final Type INT = new Type();
        public static final Type LONG = new Type();
        public static final Type BOOLEAN = new Type();
        public static final Type STRING_SET = new Type();
    }
}

