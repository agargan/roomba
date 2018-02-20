package com.agar.roomba.utils;

import com.agar.roomba.request.Request;

import java.util.List;

public class RequestPayloadValidator {

    /** main validator method, checks both x,y coordinates for parameters are given
     *  for roomSize, coords and patches
     *  checks size of each of the parameters is >= 2
     *  in case of patches, checks all array elements are of size >= 2
     *
     * @param toValidate Request object to validate
     * @return true if request passes validation
     */
    public static boolean validate(Request toValidate) {
        return toValidate != null && checkSize(toValidate.getRoomSize())
                && checkSize(toValidate.getCoords())
                && checkPatches(toValidate.getPatches());
    }

    private static boolean checkSize(List<Integer> toValidate) {
        return !toValidate.isEmpty()
                && toValidate.size() >= 2;
    }

    private static boolean checkPatches(List<List<Integer>> toValidate) {
        return !toValidate.isEmpty()
                && toValidate.stream().allMatch(e -> e.size() >= 2);
    }
}
