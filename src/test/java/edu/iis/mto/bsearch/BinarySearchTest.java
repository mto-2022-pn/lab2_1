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
        int element = 5;
        int[] seq = new int[]{5, 78, 46, 45, 78, 23, 1, 21};

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertTrue(searchResult.isFound());
        assertEquals(1, searchResult.getPosition());
    }

    @Test
    void lastElementInSeq() {
        int element = 78;
        int[] seq = new int[]{8, 56, 23, 34, 51, 48, 23, 78};

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq.length, searchResult.getPosition());
    }

    @Test
    void middleElementInSeq() {
        int element = 51;
        int[] seq = new int[]{8, 56, 23, 34, 51, 48, 23, 78, 56};

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertTrue(searchResult.isFound());
        assertEquals(5, searchResult.getPosition());
    }

    @Test
    void noElementInMultipleSeq() {
        int element = 25896;
        int[] seq = new int[]{8, 56, 23, 34, 51, 48, 23, 78, 56};

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }
}
