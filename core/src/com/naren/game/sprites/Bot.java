package com.naren.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Bot {

    private static final int GRAVITY = -15;

    private Vector3 position, velocity;
    private Texture bot;

    public Bot(int x, int y) {
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        bot = new Texture("bird.png");
    }

    public void update(float dt){

        if (position.y > 0){
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(dt);
        position.add(0, velocity.y, 0);
        velocity.scl(1/dt);

        if (position.y < 0){
            position.y = 0;

        }

    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBot() {
        return bot;
    }

    public void jump(){

        velocity.y = 250;

    }
}
