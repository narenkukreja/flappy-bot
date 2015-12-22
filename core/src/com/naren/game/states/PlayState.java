package com.naren.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.naren.game.FlappyBot;
import com.naren.game.sprites.Bot;

public class PlayState extends State {

    private Bot bot;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        bot = new Bot(50,300);
        cam.setToOrtho(false, FlappyBot.WIDTH/2, FlappyBot.HEIGHT/2);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        bot.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bot.getBot(), bot.getPosition().x, bot.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
