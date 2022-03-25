package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    private static final int NOT_FOUND_ELEMENT = -1;

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void seqOneElementIsInSeq() {
        int key = 2;
        int[] seq = {2};

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqOneElementIsNotInSeq() {
        int key = 3;
        int[] seq = { key + 3};

        SearchResult result = BinarySearch.search(key, seq);

        assertFalse(result.isFound());
        assertEquals(NOT_FOUND_ELEMENT, result.getPosition());
    }

}
