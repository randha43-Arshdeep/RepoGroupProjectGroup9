/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author bipan
 */
public class Card {
    private Color color;
    private Value value;

    public Card(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }

    public boolean isPlayable(Card topCard) {
        return this.color == topCard.color || this.value == topCard.value || this.color == Color.WILD;
    }

    @Override
    public String toString() {
        return color + ":" + value;
    }
    public enum Color {
        RED, YELLOW, GREEN, BLUE, WILD;
    }

    public enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
        DRAW_TWO, REVERSE, SKIP,
        COLOR ,DRAW_FOUR;
    }

    }
