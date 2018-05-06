package com.example.fadil.butterknifeglide;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Dashboard extends AppCompatActivity {

    @BindView(R.id.iv_gambar_glide)
    ImageView glide;
    @BindView(R.id.iv_gambar_picasso)
    ImageView picasso;
    @BindView(R.id.tv_ttl_1)
    TextView ttl1;
    @BindView(R.id.tv_alamat_1)
    TextView alamat1;
    @BindView(R.id.tv_nama_1)
    TextView nama1;
    @BindView(R.id.tv_ttl_2)
    TextView ttl2;
    @BindView(R.id.tv_alamat_2)
    TextView alamat2;
    @BindView(R.id.tv_nama_2)
    TextView nama2;

    String mNama1 ="Muhamad Farid Padilah";
    String mAlamat1 ="Kuningan";
    String mTtl1 ="28 Februari 1996";

    String mNama2 ="Fadil";
    String mAlamat2 ="Cirebon";
    String mTtl2 ="28 Februari 1997";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        set();

        //Load Image JPG
        String url="http://1.bp.blogspot.com/-4RyfkbSlWeg/VqCsqHV_p0I/AAAAAAAAH44/UWqUeAGwzN8/s1600/Gambar%2BNaruto%2BTerbaru%2B2016%2B5.jpg";

        //Load Image GIF
        //String url = "https://media.giphy.com/media/a7EUhsVF4qHQI/giphy.gif";

        Glide.with(this).load(url)
                .thumbnail(0.5f)
                .error(R.drawable.foto)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL).
                into(glide); //ini dari image View Glide

        /*Picasso.with(this).load(url)
                .into(picasso);*/ //dari image view picasso

        /* Pixel Glide : 768x432 Px
        Pixel Picasso : 1920x1080 Px
        Ukuran Dari Library Picasso 118kb,Glide 430kb*/

        //Agar Sama Dengan Pixel Glide
        Picasso.with(this).load(url)
                .resize(768,432)
                .into(picasso);

    }

    @OnClick(R.id.btn_tampil_glide)
    public void tekan_glide(View view) {
        Intent i = new Intent(Dashboard.this,DetailActivityWithGlide.class);
        glide.buildDrawingCache();
        Bitmap image= glide.getDrawingCache();
        i.putExtra("ttl",mTtl1);
        i.putExtra("nama",mNama1);
        i.putExtra("alamat",mAlamat1);
        startActivity(i);
    }

    @OnClick(R.id.btn_tampil_picasso)
    public void tekan_picasso(View view) {
        Intent i = new Intent(Dashboard.this,DetailActivityWithPicasso.class);
        picasso.buildDrawingCache();
        Bitmap image= picasso.getDrawingCache();
        i.putExtra("ttl",mTtl2);
        i.putExtra("nama",mNama2);
        i.putExtra("alamat",mAlamat2);
        startActivity(i);
    }

    public void set(){
        nama1.setText(mNama1);
        nama2.setText(mNama2);
        ttl1.setText(mTtl1);
        ttl2.setText(mTtl2);
        alamat1.setText(mAlamat1);
        alamat2.setText(mAlamat2);
    }
}
