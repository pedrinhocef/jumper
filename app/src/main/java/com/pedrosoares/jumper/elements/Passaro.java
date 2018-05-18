package com.pedrosoares.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.pedrosoares.jumper.R;
import com.pedrosoares.jumper.engine.Som;
import com.pedrosoares.jumper.graphic.Cores;
import com.pedrosoares.jumper.graphic.Tela;

public class Passaro {

    public static final int X = 350;
    public static final int RAIO = 50;
    private static final Paint VERMELHA = Cores.getCorDoPassaro();
    private final Bitmap passaro;
    private int altura;
    private Tela tela;
    private Context context;
    private Som som;

    public Passaro(Tela tela, Context context, Som som) {
        this.tela = tela;
        this.som = som;
        this.context = context;
        this.altura = 100;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2 , false);
    }

    public void desenhaNoCanvas(Canvas canvas) {
//        canvas.drawCircle(X, altura, RAIO, VERMELHA);
        canvas.drawBitmap(passaro, X - RAIO, altura - RAIO , null);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();
        if (!chegouNoChao) {
            this.altura += 5;
        }
    }

    public void pula() {
        int bordaSuperior = altura - RAIO;
        if (bordaSuperior > 0) {
            som.play(Som.PULO);
            this.altura -= 150;
        }
    }

    public int getAltura() {
        return this.altura;
    }
}
