package ru.abenefic.game.star.screen.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.abenefic.game.star.math.Rect;
import ru.abenefic.game.star.screen.BaseScreen;
import ru.abenefic.game.star.sprite.impl.Background;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture bg;
    private Vector2 pos;

    private Background background;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        bg = new Texture("textures/background.jpg");
        pos = new Vector2();
        background = new Background(bg);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        bg.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        pos.set(touch);
        return super.touchDown(touch, pointer, button);
    }
}
