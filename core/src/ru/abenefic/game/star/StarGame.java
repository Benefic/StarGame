package ru.abenefic.game.star;

import com.badlogic.gdx.Game;

import ru.abenefic.game.star.screen.impl.MenuScreen;

public class StarGame extends Game {

    @Override
    public void create() {
        setScreen(new MenuScreen());
    }
}
