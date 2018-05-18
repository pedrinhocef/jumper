package com.pedrosoares.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.pedrosoares.jumper.R;
import com.pedrosoares.jumper.elements.Canos;
import com.pedrosoares.jumper.elements.GameOver;
import com.pedrosoares.jumper.elements.Passaro;
import com.pedrosoares.jumper.elements.Pontuacao;
import com.pedrosoares.jumper.graphic.Tela;

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private final Tela tela;
    private final Som som;
    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private Canos canos;
    private Pontuacao pontuacao;
    private Context context;

    public Game(Context context) {
        super(context);
        this.context = context;
        som = new Som(context);
        tela = new Tela(context);
        setOnTouchListener(this);
        inicializaElementos();
    }

    private void inicializaElementos() {
        this.pontuacao = new Pontuacao(som);
        passaro = new Passaro(tela, context, som);
        canos = new Canos(tela, pontuacao, context);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);

    }

    @Override
    public void run() {
        while (isRunning) {
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();

            //desenhando elementos do jogo
            canvas.drawBitmap(background, 0, 0, null);
            passaro.desenhaNoCanvas(canvas);
            passaro.cai();

            canos.desenhaNo(canvas);
            canos.move();

            pontuacao.desenhaNo(canvas);

            if(new VerificadorDeColisao(passaro, canos).temColisao()){
                new GameOver(tela).desenhaNo(canvas);
                som.play(Som.COLISAO);
                isRunning = false;
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicia() {
        this.isRunning = true;
    }

    public void pause() {
        this.isRunning = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        passaro.pula();
        return false;
    }
}
