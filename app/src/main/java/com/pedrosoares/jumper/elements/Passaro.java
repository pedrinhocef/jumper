package com.pedrosoares.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.pedrosoares.jumper.graphic.Cores;

public class Passaro {

    private static final int X = 100;
    private static final int RAIO = 50;
    private static final Paint VERMELHA = Cores.getCorDoPassaro();
    private int altura;

    public Passaro() {
        this.altura = 100;
    }

    public void desenhaNoCanvas(Canvas canvas) {
        canvas.drawCircle(X, altura, RAIO, VERMELHA);
    }

    public void cai() {
        this.altura += 5;
    }

    public void pula() {
        this.altura -= 150;
    }
}
