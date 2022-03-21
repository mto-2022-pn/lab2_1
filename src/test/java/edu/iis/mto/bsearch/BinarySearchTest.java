package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void keyIsInSeqSeqLenIsOne() {
        int key = 4;
        int[] seq = {4};
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 1);
    }

    @Test
    void keyIsNotInSeqSeqLenIsOne() {
        int key = 7;
        int[] seq = {4};
        SearchResult result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }

    @Test
    void keyIsFirstInSeqSeqLenIsGreaterThanOne() {
        int key = 3;
        int[] seq = {3, 5, 45, 55, 78};
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 1);
    }

    @Test
    void keyIsLastInSeqSeqLenIsGreaterThanOne() {
        int key = 78;
        int[] seq = {3, 5, 45, 55, 78};
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), seq.length);
    }

    @Test
    void keyIsInSeqSeqLenIsGreaterThanOne() {
        int key = 45;
        int[] seq = {3, 5, 45, 55, 78};
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 3);
    }

    @Test
    void keyIsNotInSeqSeqLenIsGreaterThanOne() {
        int key = 100;
        int[] seq = {3, 5, 45, 55, 78};
        SearchResult result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }
}
