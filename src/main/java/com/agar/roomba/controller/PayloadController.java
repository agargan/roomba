package com.agar.roomba.controller;

import com.agar.roomba.dto.model.UserDto;
import com.agar.roomba.domain.model.response.Response;
import com.agar.roomba.request.Request;
import com.agar.roomba.service.HooverRoomService;
import com.agar.roomba.service.HooverRoomServiceImpl;
import com.agar.roomba.service.exception.InputException;
import com.agar.roomba.utils.PositionMapper;
import com.agar.roomba.utils.RequestPayloadValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/** Main REST controller class to handle /roomba POST request
 *
 */
@RestController
public class PayloadController {

    private static final Logger logger = LoggerFactory.getLogger(HooverRoomServiceImpl.class);

    HooverRoomService service;

    public PayloadController(HooverRoomService service) {
        this.service = service;
    }

    @PostMapping(value = "/roomba", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getPayload(@RequestBody Request request) {
        // validate request object
        if (RequestPayloadValidator.validate(request)) {
            UserDto input = new UserDto();
            input.setCoords(request.getCoords());
            input.setInstructions(request.getInstructions());
            input.setPatches(PositionMapper.mapToPosition(request.getPatches()));
            input.setRoomSize(request.getRoomSize());
            try {
                return service.hoover(input);
            } catch(InputException e) {
                return Response
                        .fail()
                        .setErrors(e.getMessage());
            }
        } else {
            // request is invalid, wrong parameters present
            logger.error("Expected 2 values for coordinates, got {}", request);
            return Response
                    .fail()
                    .setErrors("Expected 2 values for coordinates, got "+request);
        }
    }
}
