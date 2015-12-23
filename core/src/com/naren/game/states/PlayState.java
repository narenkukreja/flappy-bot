package com.naren.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.naren.game.FlappyBot;
import com.naren.game.sprites.Bot;
import com.naren.game.sprites.Tube;

public class PlayState extends State {

    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;

    private Bot bot;
    private Texture bg;

    private com.badlogic.gdx.utils.Array<Tube> tubes;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        bot = new Bot(50,300);
        cam.setToOrtho(false, FlappyBot.WIDTH/2, FlappyBot.HEIGHT/2);
        bg = new Texture("bg.png");

        tubes = new com.badlogic.gdx.utils.Array<Tube>();

        for (int i = 0; i <= TUBE_COUNT; i++) {
            tubes.add(new Tube(i * (TUBE_SPACING) + Tube.TUBE_WIDTH));
        }
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
        cam.position.x = bot.getPosition().x + 80;

        for (Tube tube : tubes) {

            if (cam.position.x - (cam.viewportWidth/2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()){

                tube.reposition(tube.getPosTopTube().x + (Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT);

            }

            if (tube.collides(bot.getBounds())){

                gsm.set(new PlayState(gsm));

            }

        }

        cam.update();


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(bot.getBot(), bot.getPosition().x, bot.getPosition().y);

        for(Tube tube : tubes) {
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(), tube.getPosBottomTube().x, tube.getPosBottomTube().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {

        bg.dispose();
        bot.dispose();
        for (Tube tube: tubes){
            tube.dispose();
        }

    }
}
