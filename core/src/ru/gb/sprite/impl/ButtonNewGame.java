package ru.gb.sprite.impl;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.gb.math.Rect;
import ru.gb.sprite.BaseButton;
import ru.gb.sprite.ClickListener;

public class ButtonNewGame extends BaseButton {

    private static final float HEIGHT = 0.05f;

    private final ClickListener onClickListener;

    public ButtonNewGame(TextureAtlas atlas, ClickListener onClickListener) {
        super(atlas.findRegion("button_new_game"));
        this.onClickListener = onClickListener;
    }


    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + worldBounds.getHalfHeight() / 2);
    }

    @Override
    public void action() {
        onClickListener.onClick();
    }
}
