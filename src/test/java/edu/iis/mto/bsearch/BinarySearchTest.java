package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void oneElementInSeq() {
        int element = 20;
        int[] seq = new int[1];
        seq[0] = element;

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertTrue(searchResult.isFound());
        assertEquals(1, searchResult.getPosition());
    }

    @Test
    void noElementInSeq() {
        int element = 20;
        int[] seq = new int[1];
        seq[0] = 1;

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void firstElementInSeq() {
        int element = 20;
        int[] seq = new int[]{20,5,623,46,853,415,23,1,78};

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertTrue(searchResult.isFound());
        assertEquals(1,searchResult.getPosition());
    }
}
