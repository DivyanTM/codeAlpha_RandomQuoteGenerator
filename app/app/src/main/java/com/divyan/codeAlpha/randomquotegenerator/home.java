package com.divyan.codeAlpha.randomquotegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class home extends AppCompatActivity {
    ImageView back;
    Button generate,share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        back=findViewById(R.id.back_icon);
        generate=findViewById(R.id.button_generate);
        share=findViewById(R.id.button_share);
        TextView tv=findViewById(R.id.quoteTextView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        RandomQuote rq=new RandomQuote();

        String quote=rq.getQuote(home.this,R.raw.quote);
        tv.setText(quote);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(rq.getQuote(home.this,R.raw.quote));
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share(tv.getText().toString());
            }


        });

    }
    private void share(String text){
        Intent shareIntent=new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,text);
        startActivity(Intent.createChooser(shareIntent,"Share quote"));
    }
}
