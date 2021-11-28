package ru.abenefic.game.star.screen.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.abenefic.game.star.math.Rect;
import ru.abenefic.game.star.screen.BaseScreen;
import ru.abenefic.game.star.sprite.impl.Background;
import ru.abenefic.game.star.sprite.impl.Logo;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture bg;

    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        bg = new Texture("textures/background.jpg");
        background = new Background(bg);
        logo = new Logo(img);
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
        logo.draw(batch);
        batch.end();
        logo.move();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        bg.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.setPosition(touch);
        return super.touchDown(touch, pointer, button);
    }
}
