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
import com.pedrosoares.jumper.elements.Cano;
import com.pedrosoares.jumper.elements.Canos;
import com.pedrosoares.jumper.elements.Passaro;
import com.pedrosoares.jumper.graphic.Tela;

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private final Tela tela;
    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private Canos canos;

    public Game(Context context) {
        super(context);
        this.tela = new Tela(context);
        setOnTouchListener(this);
        inicializaElementos();
    }

    private void inicializaElementos() {
       this.passaro = new Passaro(tela);
       this.canos = new Canos(tela);
       Bitmap back = BitmapFactory.decodeResource(getResources(),R.drawable.background);
       this.background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);

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
