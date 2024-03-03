package com.divyan.codeAlpha.randomquotegenerator;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class RandomQuote {
    public String getQuote(Context context,int fileName){
        try{
            ArrayList<String> lines=new ArrayList<>();
            InputStream inputStream=context.getResources().openRawResource(fileName);
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line= reader.readLine())!=null){
                lines.add(line);
            }
            reader.close();

            Random random=new Random();
            int randomIndex= random.nextInt(lines.size());
            return lines.get(randomIndex);
        }catch (IOException e){
            e.printStackTrace();
            return "DO OR DIE - MAHATHMA GHANDHI";
        }
    }
}
