package com.naren.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.naren.game.FlappyBot;

public class MenuState extends State {

    private Texture background, playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Texture("playBtn.png");

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        sb.draw(background, 0, 0, FlappyBot.WIDTH, FlappyBot.HEIGHT);
        sb.draw(playBtn, (FlappyBot.WIDTH/2) - (playBtn.getWidth()/2) , FlappyBot.HEIGHT/2);
        sb.end();

    }
}
