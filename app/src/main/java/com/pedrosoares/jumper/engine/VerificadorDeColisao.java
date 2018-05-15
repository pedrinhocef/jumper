package com.pedrosoares.jumper.engine;

import com.pedrosoares.jumper.elements.Canos;
import com.pedrosoares.jumper.elements.Passaro;

class VerificadorDeColisao {

    private final Passaro passaro;
    private final Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }


    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }
}
