package com.agar.roomba.utils;

import com.agar.roomba.domain.model.Position;

import java.util.List;
import java.util.stream.Collectors;

public class PositionMapper {

    /** maps List<Integer> elements to Position objects
     *
     * @param patches List<List<Integer>> patches
     * @return List<Position>
     */
    public static List<Position> mapToPosition(List<List<Integer>> patches) {
        // map input patches to a list of Position elements
        // only first two values are considered
        return patches.stream().map(pair -> {
            Position p = new Position();
            p.setxCoordinate(pair.get(0));
            p.setyCoordinate(pair.get(1));
            return p;
        }).collect(Collectors.toList());
    }
}
