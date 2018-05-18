package com.pedrosoares.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.pedrosoares.jumper.engine.Som;
import com.pedrosoares.jumper.graphic.Cores;

public class Pontuacao {

    private static final Paint BRANCO = Cores.getCorDaPontuacao();
    private final Som som;
    private int pontos = 0;

    public Pontuacao(Som som) {
        this.som = som;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos),100 ,100 , BRANCO);
    }

    public void aumenta() {
        som.play(Som.PONTUACAO);
        this.pontos ++;
    }
}
