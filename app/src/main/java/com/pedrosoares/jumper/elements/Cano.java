package com.pedrosoares.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.pedrosoares.jumper.graphic.Cores;
import com.pedrosoares.jumper.graphic.Tela;

public class Cano {

    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;
    private int alturaDoCanoInferior;
    private Tela tela;
    private int posicao;
    private final Paint VERDE = Cores.getCorDoCano();

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO;
    }

    public void desenhaNoCanvas(Canvas canvas) {
        desenhaCanoInferiorNo(canvas);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(),VERDE);
    }

    public void move() {
        this.posicao -= 1;
    }
}
