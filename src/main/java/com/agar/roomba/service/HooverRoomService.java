package com.agar.roomba.service;

import com.agar.roomba.dto.model.UserDto;
import com.agar.roomba.domain.model.response.Response;
import com.agar.roomba.service.exception.InputException;

/**
 * @author Agar
 */
public interface HooverRoomService {

    /**
     *
     * @param input UserDto object unmarshalled from json payload
     *
     *      json payload example:
     *
     *              {
     *                  "roomSize": [5,5],
                        "coords": [1,2],
                        "patches": [
                                    [1,0],
                                    [2,2],
                                    [2,3]
                                    ],
                    "instructions": "NNESEESWNWW"
                    }
     * @return Response object containing marshalled json payload
     *
     *      json payload example:
     *
     *              {
                        "coords":[1,3],
                        "patches": 1
                    }
     */
    Response hoover(UserDto input) throws InputException;
}
