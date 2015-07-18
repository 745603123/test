package com.example.system.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class JsonTools {
   
    public static String createJsonString(Object value) {
        Gson gson = new Gson();
        String string = gson.toJson(value);
        return string;
    }
    

    
}