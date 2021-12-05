package ru.gb.sprite.impl;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.gb.math.Rect;
import ru.gb.sprite.Sprite;

public class Ship extends Sprite {

    private static final float HEIGHT = 0.2f;
    private static final float MARGIN = 0.02f;
    private static final float V_LEN = 0.03f;
    private static final int KEY_LEFT = 21;
    private static final int KEY_RIGHT = 22;

    private final Vector2 touch;
    private final Vector2 v;
    private float keySpeed = 0;
    private int pointer;
    private Rect worldBounds;

    public Ship(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship").split(195, 287)[0][0]);
        touch = new Vector2();
        v = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(HEIGHT);
        this.pos.set(0, worldBounds.getBottom() + getHalfHeight() + MARGIN);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (keySpeed != 0f) {
            pos.x += keySpeed;
        } else {
            if (pos.dst(touch) > V_LEN) {
                pos.add(v);
            } else {
                pos.set(touch);
            }
        }
        checkBounds();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.pointer = pointer;
        setPosition(touch);
        return super.touchDown(touch, pointer, button);
    }

    private void setPosition(Vector2 touch) {
        Vector2 linearTouch = touch.cpy().set(touch.x, pos.y);
        this.touch.set(linearTouch);
        v.set(linearTouch.sub(pos).setLength(V_LEN));
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        super.touchDragged(touch, pointer);
        if (pointer == this.pointer) {
            setPosition(touch);
        }
        return false;
    }

    public void keyDown(int keycode) {
        if (keycode == KEY_LEFT) {
            keySpeed = V_LEN * -1.0f;
        } else if (keycode == KEY_RIGHT) {
            keySpeed = V_LEN;
        } else {
            keySpeed = 0.0f;
        }
    }

    public void keyUp(int keycode) {
        keySpeed = 0.0f;
        touch.set(pos);
    }

    private void checkBounds() {
        if (getRight() > worldBounds.getRight()) {
            pos.set(worldBounds.getRight() - getHalfWidth(), pos.y);
            System.out.println("fix right");
        }
        if (getLeft() < worldBounds.getLeft()) {
            pos.set(worldBounds.getLeft() + getHalfWidth(), pos.y);
            System.out.println("fix left");
        }
    }
}
