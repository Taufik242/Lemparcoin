package taufik.ti18d5.lemparcoin;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Lemparcoin extends Activity implements View.OnClickListener {
    private Button buttonLempar;
    private Button buttonUlang;
    private Button buttonKeluar;
    private Random acak;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        acak = new Random();
        setContentView(R.layout.lemparcoin);

        buttonLempar = (Button)findViewById(R.id.button1);
        buttonUlang = (Button)findViewById(R.id.button2);
        buttonKeluar = (Button)findViewById(R.id.button3);

        buttonLempar.setOnClickListener(this);
        buttonUlang.setOnClickListener(this);
        buttonKeluar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == buttonLempar){
            Log.d("CLICK EVENT","Lempar Button diklik");
            TextView tv = (TextView)findViewById(R.id.textView1);
            ImageView iv = (ImageView) findViewById(R.id.imageView1);

            if (acak.nextDouble()<0.5) {
                tv.setText("kepala");
                iv.setImageResource(R.drawable.head);
            } else {
                tv.setText("cross");
                iv.setImageResource(R.drawable.tail);
            }
            buttonLempar.setVisibility(View.INVISIBLE);
            buttonUlang.setVisibility(View.VISIBLE);
            buttonKeluar.setVisibility(View.VISIBLE);
        } else if (view == buttonUlang) {
            TextView tv = (TextView)findViewById(R.id.textView1);
            ImageView iv = (ImageView)findViewById(R.id.imageView1);

            buttonLempar.setVisibility(View.VISIBLE);
            buttonUlang.setVisibility(View.INVISIBLE);
            buttonKeluar.setVisibility(View.INVISIBLE);
        }
        else if(view == buttonKeluar){
            this.finish();
        }



    }

}
