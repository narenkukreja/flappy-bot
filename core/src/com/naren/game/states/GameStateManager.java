package com.naren.game.states;

import java.util.Stack;

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager() {
        states = new Stack<State>();
    }

    public void push(State state){

        states.push(state);

    }

    public void pop(){

        states.pop();

    }
}
