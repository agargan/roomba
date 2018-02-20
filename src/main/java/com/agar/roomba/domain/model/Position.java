package com.agar.roomba.domain.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;

/**
 * Class to denote a set of x,y coordinates
 */
public class Position {

    private int xCoordinate;
    private int yCoordinate;

    public Position() {}

    public Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public String toString() {
        return this.xCoordinate + ", " + this.yCoordinate;
    }

    /**
     *
     * @return List<Integer> containing x and y coordinates
     */
    @JsonValue
    public List<Integer> getCoords() {
        return Arrays.asList(this.xCoordinate, this.yCoordinate);
    }

    /**
     *
     * @param p Position object containing x and y coordinates
     * @return comparison of two sets of coordinates
     */
    public boolean equals(Position p) {
        return this.xCoordinate == p.xCoordinate
                && this.yCoordinate == p.yCoordinate;
    }
}
