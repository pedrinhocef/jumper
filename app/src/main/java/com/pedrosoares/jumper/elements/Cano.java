package com.pedrosoares.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.pedrosoares.jumper.graphic.Cores;
import com.pedrosoares.jumper.graphic.Tela;

public class Cano {

    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;
    private final int alturaDoCanoSuperior;
    private int alturaDoCanoInferior;
    private Tela tela;
    private int posicao;
    private final Paint VERDE = Cores.getCorDoCano();

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        this.posicao = posicao;
        alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        alturaDoCanoSuperior = TAMANHO_DO_CANO + valorAleatorio();
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoSuperiorNo(canvas);
        desenhaCanoInferiorNo(canvas);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas) {
        canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior,VERDE);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(),VERDE);
    }

    public void move() {
        this.posicao -= 1;
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return this.posicao - passaro.X < passaro.RAIO;
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {
        return passaro.getAltura() - passaro.RAIO < this.alturaDoCanoSuperior
                || passaro.getAltura() + passaro.RAIO > this.alturaDoCanoInferior;
    }
}
