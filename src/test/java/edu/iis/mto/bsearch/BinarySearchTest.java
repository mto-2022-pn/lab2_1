package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void seqLengthIsOne_keyInSeq() {
        int key = 1;
        int[] seq = {key};

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqLengthIsOne_keyNotInSeq() {
        int key = 1;
        int[] seq = {key};

        SearchResult result = BinarySearch.search(key + 1, seq);

        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

}
