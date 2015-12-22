package com.naren.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.naren.game.FlappyBot;
import com.naren.game.sprites.Bot;
import com.naren.game.sprites.Tube;

public class PlayState extends State {

    private Bot bot;
    private Texture bg;
    private Tube tube;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        bot = new Bot(50,300);
        cam.setToOrtho(false, FlappyBot.WIDTH/2, FlappyBot.HEIGHT/2);
        bg = new Texture("bg.png");
        tube = new Tube(100);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            bot.jump();
        }

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
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(bot.getBot(), bot.getPosition().x, bot.getPosition().y);
        sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
        sb.draw(tube.getBottomTube(), tube.getPosBottomTube().x, tube.getPosBottomTube().y);

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
