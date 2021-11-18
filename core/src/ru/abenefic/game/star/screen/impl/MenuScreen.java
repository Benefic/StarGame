package ru.abenefic.game.star.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.abenefic.game.star.screen.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 touch;
    private Vector2 velocity;
    private Vector2 pos;
    private float speed = 0.02f;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        touch = new Vector2();
        pos = new Vector2();
        velocity = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        if (pos.dst(touch) <= 0.1) {
            pos.set(touch);
        } else {
            pos.add(velocity);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        velocity = touch.cpy().sub(pos).scl(speed);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
