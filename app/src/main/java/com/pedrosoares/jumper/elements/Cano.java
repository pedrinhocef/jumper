package com.pedrosoares.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.pedrosoares.jumper.R;
import com.pedrosoares.jumper.graphic.Cores;
import com.pedrosoares.jumper.graphic.Tela;

public class Cano {

    private static final int TAMANHO_DO_CANO = 450;
    private static final int LARGURA_DO_CANO = 120;
    private final int alturaDoCanoSuperior;
    private final Bitmap canoInferior;
    private final Bitmap canoSuperior;
    private int alturaDoCanoInferior;
    private Context context;
    private Tela tela;
    private int posicao;
    private final Paint VERDE = Cores.getCorDoCano();

    public Cano(Tela tela, int posicao, Context context) {
        this.tela = tela;
        this.posicao = posicao;
        alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        this.context = context;
        alturaDoCanoSuperior = TAMANHO_DO_CANO + valorAleatorio();
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        this.canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, this.alturaDoCanoInferior, false);
        this.canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, this.alturaDoCanoSuperior, false);
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 250);
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoSuperiorNo(canvas);
        desenhaCanoInferiorNo(canvas);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas) {
//        canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior,VERDE);
        canvas.drawBitmap(canoSuperior, posicao,0 , null);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
//        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(),VERDE);
        canvas.drawBitmap(canoInferior, posicao, alturaDoCanoInferior, null);
    }

    public void move() {
        this.posicao -= 2;
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
