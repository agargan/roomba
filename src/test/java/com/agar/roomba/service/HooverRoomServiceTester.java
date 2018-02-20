package com.agar.roomba.service;

import com.agar.roomba.domain.model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HooverRoomServiceTester {

    HooverRoomServiceImpl hooverRoomService;
    Position hooverPosOnPatch;
    Position hooverPosNotOnPatch;
    List<Position> patches;
    Set<Position> cleaned;

    @Before
    public void setUp() {
        hooverRoomService = new HooverRoomServiceImpl();
        hooverPosOnPatch = new Position(1,2);
        hooverPosNotOnPatch = new Position(2, 2);
        patches = new ArrayList<>();
        cleaned = new HashSet<>();
        patches.add(hooverPosOnPatch);
    }

    @Test
    public void test_checkPatchCleaned_MethodRemovesPatchCleanedIfHooverIsOnPatchPosition() {
        assertThat(patches.size(), is(1));

        hooverRoomService.checkPatchCleaned(patches, hooverPosOnPatch, cleaned);

        assertThat(patches.size(), is(0));
        assertThat(cleaned.size(), is(1));
        assertThat(cleaned.contains(hooverPosOnPatch), is(true));
    }

    @Test
    public void test_checkPatchCleaned_MethodDoesNotCleanPatchIfHooverIsNotOnPatchPosition() {
        assertThat(patches.size(), is(1));

        hooverRoomService.checkPatchCleaned(patches, hooverPosNotOnPatch, cleaned);

        assertThat(patches.size(), is(1));
        assertThat(cleaned.isEmpty(), is(true));
    }
}
