package ru.abenefic.game.star.sprite.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.abenefic.game.star.math.Rect;
import ru.abenefic.game.star.sprite.Sprite;

public class Logo extends Sprite {

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight() * 0.15f);
        this.setPos(worldBounds.pos);
    }
}
