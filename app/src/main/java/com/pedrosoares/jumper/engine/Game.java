package com.pedrosoares.jumper.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.pedrosoares.jumper.elements.Passaro;

public class Game extends SurfaceView implements Runnable {

    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;

    public Game(Context context) {
        super(context);
        inicializaElementos();
    }

    private void inicializaElementos() {
       this.passaro = new Passaro();
    }

    @Override
    public void run() {
        while (isRunning) {
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();

            //desenhando elementos do jogo

            passaro.desenhaNoCanvas(canvas);
            passaro.cai();

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicia() {
        this.isRunning = true;
    }

    public void pause() {
        this.isRunning = false;
    }
}
