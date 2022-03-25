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
        int[] seq = {key};

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

    @Test
    void seqManyElementsKeyIsFirst() {
        int key = 4;
        int[] seq = {key, 5, 7, 12};

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqManyElementsKeyIsLast() {
        int key = 15;
        int[] seq = {1, 5, 8, 13, key};

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(seq.length - 1, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqManyElementsKeyIsMiddle() {
        int key = 13;
        int[] seq = {4, 7, key, 15, 18};

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(seq.length/2, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }
}
