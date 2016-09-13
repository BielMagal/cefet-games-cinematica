package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author Flávio Coutinho <fegemo@gmail.com>
 */
public class Chegar extends Algoritmo {

    private static final char NOME = 'c';

    public Chegar(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }

    protected Chegar(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;

    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        output.velocidade = new Vector3 (this.alvo.getObjetivo());
        float distancia = output.velocidade.dst(agente.posicao);
        float velocidade = distancia*this.maxVelocidade/100;
        if(velocidade > this.maxVelocidade)
            velocidade = this.maxVelocidade;
        output.velocidade.sub(agente.posicao);
        output.velocidade = output.velocidade.nor().scl(velocidade);
        return output;
    }

}
