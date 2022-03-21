package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void keyElementIsInSequence() {
        int key = 5;
        int[] seq = { 1,3,4,5,6,8 };
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test
    void keyElementIsNotInSequence() {
        int key = 2;
        int[] seq = { 1,3,4,6,8 };
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
}
