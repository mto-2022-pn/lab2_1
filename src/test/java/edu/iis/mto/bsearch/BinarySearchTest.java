package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void seqLengthIsZero_throwsException() {
        int key = 10;
        int[] seq = new int[0];

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            SearchResult result = BinarySearch.search(key, seq);
        });
        assertEquals("Sequence is empty", e.getMessage());
    }

    @Test
    void seqLengthIsOne_keyInSeq() {
        int key = 10;
        int[] seq = {key};

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqLengthIsOne_keyNotInSeq() {
        int key = 10;
        int[] seq = {key};

        SearchResult result = BinarySearch.search(key + 1, seq);

        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

    @Test
    void seqLengthGreaterThanOne_keyFirstInSeq() {
        int key = 10;
        int[] seq = {key, 20, 30};

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqLengthGreaterThanOne_keyLastInSeq() {
        int key = 30;
        int[] seq = {10, 20, key};

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(seq.length - 1, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqLengthGreaterThanOne_keyInMiddleOfSeq() {
        int key = 20;
        int[] seq = {10, key, 30};

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertNotEquals(seq.length - 1, result.getPosition());
        assertNotEquals(0, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqLengthGreaterThanOne_keyNotInSeq() {
        int key = 20;
        int[] seq = {10, 30, 40};

        SearchResult result = BinarySearch.search(key, seq);

        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

}
