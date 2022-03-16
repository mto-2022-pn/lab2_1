package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {
    int[] sequenceWithOneElement = new int[]{13};

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void keyIsInSequenceWithOneElement() {
        int key = 13;
        SearchResult searchResult = BinarySearch.search(key, sequenceWithOneElement);
        assertTrue(searchResult.isFound());
        assertEquals(key, sequenceWithOneElement[searchResult.getPosition()]);
    }
    @Test
    void noKeyInSequenceWithOneElement() {
        int key=12;
        SearchResult searchResult = BinarySearch.search(key,sequenceWithOneElement);
        assertFalse(searchResult.isFound());
        assertEquals(-1,searchResult.getPosition());
    }

}
