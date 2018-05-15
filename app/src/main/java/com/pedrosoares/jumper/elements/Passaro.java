package com.pedrosoares.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.pedrosoares.jumper.graphic.Cores;
import com.pedrosoares.jumper.graphic.Tela;

public class Passaro {

    public static final int X = 350;
    public static final int RAIO = 50;
    private static final Paint VERMELHA = Cores.getCorDoPassaro();
    private int altura;
    private Tela tela;

    public Passaro(Tela tela) {
        this.tela = tela;
        this.altura = 100;
    }

    public void desenhaNoCanvas(Canvas canvas) {
        canvas.drawCircle(X, altura, RAIO, VERMELHA);
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
            this.altura -= 150;
        }
    }

    public int getAltura() {
        return this.altura;
    }
}
