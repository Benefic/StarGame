package ru.abenefic.game.star.screen.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.abenefic.game.star.math.Rect;
import ru.abenefic.game.star.screen.BaseScreen;
import ru.abenefic.game.star.sprite.impl.Background;
import ru.abenefic.game.star.sprite.impl.Logo;

public class MenuScreen extends BaseScreen {

    private final float V_LEN = 0.01f;

    private Texture img;
    private Texture bg;
    private Vector2 pos;

    private Vector2 velocity;

    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        bg = new Texture("textures/background.jpg");
        pos = new Vector2();
        background = new Background(bg);
        logo = new Logo(img);
        velocity = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        logo.pos.set(pos);
        logo.draw(batch);
        batch.end();
        Vector2 touch = getTouch();
        if (pos.dst(touch) <= V_LEN) {
            pos.set(touch);
        } else {
            pos.add(velocity);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        bg.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        velocity.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return super.touchDown(touch, pointer, button);
    }
}
