package com.agar.roomba.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to represent a json Request payload
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    private List<Integer> roomSize;
    private List<List<Integer>> patches;
    private String instructions;
    private List<Integer> coords;

    public List<Integer> getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(List<Integer> roomSize) {
        this.roomSize = roomSize;
    }

    public List<List<Integer>> getPatches() {
        return patches;
    }

    public void setPatches(List<List<Integer>> patches) {
        this.patches = patches;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<Integer> getCoords() {
        return coords;
    }

    public void setCoords(List<Integer> coords) {
        this.coords = coords;
    }

    @Override
    public String toString() {
        return "roomSize: " + roomSize + ", patches: "
                + patches.stream().map(Object::toString).collect(Collectors.joining(","))
                + ", coords: " + coords + ", instructions: " + instructions;
    }
}
