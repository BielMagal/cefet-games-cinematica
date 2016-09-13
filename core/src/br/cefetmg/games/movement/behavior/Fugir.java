package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author Flávio Coutinho <fegemo@gmail.com>
 */
public class Fugir extends Algoritmo {

    private static final char NOME = 'f';

    public Fugir(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }

    protected Fugir(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;

    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        output.velocidade = new Vector3 (agente.posicao);
        output.velocidade.sub(this.alvo.getObjetivo());
        output.velocidade = output.velocidade.nor().scl(this.maxVelocidade);
        
        // Calcula a direção para onde o agente deve ir
        // Input: a posicao do objetivo (this.alvo) e deste agente
        // ..
        // ..
        // ..
        // ..
        // Output: vetor velocidade (apontando na direção encontrada) 
        //         limitado pela maxVelocidade (tangencial)
        // PS: não é necessário definir a rotação
        return output;
    }

}
