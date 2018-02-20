package com.agar.roomba.testbuilders;

import com.agar.roomba.domain.model.Position;
import com.agar.roomba.dto.model.UserDto;

import java.util.Collections;
import java.util.List;

/** Request builder helper class
 *
 */
public class RequestPayloadBuilder {

    private UserDto request;

    public RequestPayloadBuilder() {
        request = new UserDto();
    }

    public RequestPayloadBuilder roomSize(List<Integer> roomSize) {
        request.setRoomSize(roomSize);
        return this;
    }

    public RequestPayloadBuilder coords(List<Integer> coords) {
        request.setCoords(coords);
        return this;
    }

    public RequestPayloadBuilder patches(List<Position> patches) {
        request.setPatches(patches);
        return this;
    }

    public RequestPayloadBuilder instructions(String instructions) {
        request.setInstructions(instructions);
        return this;
    }

    public UserDto build() {
        return request;
    }
}
