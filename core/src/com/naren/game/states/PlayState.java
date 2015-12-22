package com.naren.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.naren.game.FlappyBot;

public class PlayState extends State {

    private Texture bot;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        bot = new Texture("bird.png");
        cam.setToOrtho(false, FlappyBot.WIDTH/2, FlappyBot.HEIGHT/2);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bot, 50, 50);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
