package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void searchForExistingElem_singleItemSequence() {
        int[] seq = new int[1];
        seq[0] = 4;
        SearchResult searchResult = BinarySearch.search(seq[0], seq);
        assertTrue(searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    void notExistingElem_singleItemSequence() {
        int[] seq = new int[1];
        seq[0] = 4;
        SearchResult searchResult = BinarySearch.search(8, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void searchForExistingElem_atFirstPosition_multipleItemSequence() {
        int[] seq = new int[]{1,4,6,8,12,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(seq[0], seq);
        assertTrue(searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    void searchForExistingElem_atLastPosition_multipleItemSequence() {
        int[] seq = new int[]{1,4,6,8,12,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(seq[seq.length-1], seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq.length-1, searchResult.getPosition());
    }

    @Test
    void searchForExistingElem_atMiddlePosition_multipleItemSequence() {
        int[] seq = new int[]{1,4,6,8,12,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(seq[(seq.length)/2], seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq.length/2, searchResult.getPosition());
    }
}
