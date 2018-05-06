package com.example.fadil.butterknifeglide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivityWithPicasso extends AppCompatActivity {

    @BindView(R.id.detail_picasso)
    ImageView picasso;
    @BindView(R.id.tv_ttl_picasso)
    TextView ttl;
    @BindView(R.id.tv_alamat_picasso)
    TextView alamat;
    @BindView(R.id.tv_nama_picasso)
    TextView nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_with_picasso);
        ButterKnife.bind(this);
        String nama1 = getIntent().getStringExtra("nama");
        String alamat1 = getIntent().getStringExtra("alamat");
        String ttl1 = getIntent().getStringExtra("ttl");

        //String url="http://1.bp.blogspot.com/-4RyfkbSlWeg/VqCsqHV_p0I/AAAAAAAAH44/UWqUeAGwzN8/s1600/Gambar%2BNaruto%2BTerbaru%2B2016%2B5.jpg";
        //Load Image GIF
        String url = "https://media.giphy.com/media/a7EUhsVF4qHQI/giphy.gif";

        Picasso.with(this).load(url)
                .resize(768,432)
                .into(picasso);
        set(ttl1,alamat1,nama1);

    }
    public void  set(String ttl1,String alamat1,String nama1){
        ttl.setText(ttl1);
        alamat.setText(alamat1);
        nama.setText(nama1);
    }
}
