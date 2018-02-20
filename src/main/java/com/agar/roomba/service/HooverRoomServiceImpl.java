package com.agar.roomba.service;

import com.agar.roomba.domain.model.Position;
import com.agar.roomba.dto.model.UserDto;
import com.agar.roomba.domain.model.response.Response;
import com.agar.roomba.service.exception.InputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 *  implementation of HooverRoomService interface
 */
public class HooverRoomServiceImpl implements HooverRoomService {

    private static final Logger logger = LoggerFactory.getLogger(HooverRoomServiceImpl.class);
    private int patchesCleanedCounter;
    /**
     *
     * @param input UserDto object
     * @return Response object containing coords for hoover position,
     * number of patches cleaned
     */
    @Override
    public Response hoover(UserDto input) throws InputException {
        // init variables
        patchesCleanedCounter = 0;
        Set<Position> cleanedPatches = new HashSet<>();

        Position currentHooverPos = new Position(input.getCoords().get(0), input.getCoords().get(1));

        // validate room size is bigger than initial hoover position
        if (input.getRoomSize().get(0) >= currentHooverPos.getCoords().get(0)
                && input.getRoomSize().get(1) >= currentHooverPos.getCoords().get(1)) {
            char[] dirChar = input.getInstructions().toUpperCase().toCharArray();

            List<Position> patchesPosList = input.getPatches();
            logger.info("original patches: {}", patchesPosList);

            for (char c : dirChar) {
                checkPatchCleaned(patchesPosList, currentHooverPos, cleanedPatches);
                // switch statement to iterate through driving instructions
                switch (c) {
                    case 'N':
                        if (input.getRoomSize().get(1) > currentHooverPos.getyCoordinate())
                            currentHooverPos.setyCoordinate(currentHooverPos.getyCoordinate() + 1);
                        break;
                    case 'S':
                        if (currentHooverPos.getyCoordinate() > 0)
                            currentHooverPos.setyCoordinate(currentHooverPos.getyCoordinate() - 1);
                        break;
                    case 'W':
                        if (currentHooverPos.getxCoordinate() > 0)
                            currentHooverPos.setxCoordinate(currentHooverPos.getxCoordinate() - 1);
                        break;
                    case 'E':
                        if (input.getRoomSize().get(0) > currentHooverPos.getxCoordinate())
                            currentHooverPos.setxCoordinate(currentHooverPos.getxCoordinate() + 1);
                        break;
                    default:
                        break;
                }
            }
            checkPatchCleaned(patchesPosList, currentHooverPos, cleanedPatches);
        } else {
            throw new InputException("room size too small");
        }
        // build and return Response object containing final hoover position
        // and number of patches cleaned
        return Response.ok()
                .setCoords(currentHooverPos)
                .setPatches(patchesCleanedCounter);
    }

    /**
     * method to check if currentHooverPos is equal to patch to be cleaned
     * and if so, patch is added to cleanedPatches and removed from patchesPosList
     * via iterator
     */
    protected void checkPatchCleaned(List<Position> patchesPosList, Position currentHooverPos,
                                     Set<Position> cleanedPatches) {
        Iterator<Position> it = patchesPosList.listIterator();
        while (it.hasNext()) {
            Position nextPatch = it.next();
            if (currentHooverPos.equals(nextPatch)
                    && cleanedPatches.stream().noneMatch(e -> e.equals(nextPatch))) {
                cleanedPatches.add(nextPatch);
                patchesCleanedCounter += 1;
                it.remove();
                logger.info("patch cleaned up: {}", nextPatch);
            }
        }
    }
}
