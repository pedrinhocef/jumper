package com.pedrosoares.jumper.elements;

import android.graphics.Canvas;

import com.pedrosoares.jumper.graphic.Tela;

import java.util.ArrayList;
import java.util.List;

public class Canos {

    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 250;
    private final List<Cano> canos = new ArrayList<>();

    public Canos(Tela tela) {
        int posicaoInicial = 500;

        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial));
        }

    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano : canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {
        for (Cano cano : canos) {
            cano.move();
        }
    }

}
