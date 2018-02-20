package com.agar.roomba.dto.model;

import com.agar.roomba.domain.model.Position;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private List<Integer> roomSize;
    private List<Position> patches;
    private String instructions;

    private List<Integer> coords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(List<Integer> roomSize) {
        this.roomSize = roomSize;
    }

    public List<Position> getPatches() {
        return patches;
    }

    public void setPatches(List<Position> patches) {
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
}
