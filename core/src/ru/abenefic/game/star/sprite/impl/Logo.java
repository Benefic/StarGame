package ru.abenefic.game.star.sprite.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.abenefic.game.star.math.Rect;
import ru.abenefic.game.star.sprite.Sprite;

public class Logo extends Sprite {

    private final float V_LEN = 0.01f;
    private final Vector2 destination = new Vector2();

    private Vector2 velocity;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight() * 0.15f);
        pos.set(worldBounds.pos);
        destination.set(pos);
    }

    public void setPosition(Vector2 touch) {
        destination.set(touch);
        velocity = touch.cpy().sub(pos);
        velocity.setLength(V_LEN);
    }

    public void move() {
        if (pos.dst(destination) <= V_LEN) {
            pos.set(destination);
        } else {
            pos.add(velocity);
        }
    }
}
