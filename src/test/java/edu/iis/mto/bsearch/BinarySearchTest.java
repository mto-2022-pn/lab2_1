package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
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
        assertEquals(result.getPosition(), 0);
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
        assertEquals(result.getPosition(), 0);
    }

    @Test
    void keyIsLastInSeqSeqLenIsGreaterThanOne() {
        int key = 78;
        int[] seq = {3, 5, 45, 55, 78};
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), seq.length-1);
    }

    @Test
    void keyIsInSeqSeqLenIsGreaterThanOne() {
        int key = 45;
        int[] seq = {3, 5, 45, 55, 78};
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 2);
    }

    @Test
    void keyIsNotInSeqSeqLenIsGreaterThanOne() {
        int key = 100;
        int[] seq = {3, 5, 45, 55, 78};
        SearchResult result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }

    @Test
    void seqLenIsZero() {
        int key = 3;
        int[] seq = {};
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->{
            SearchResult result = BinarySearch.search(key, seq);
        });
    }

    @Test
    void seqNotSorted() {
        int key = 5;
        int[] seq = {4, 6, 1, 0};
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->{
            SearchResult result = BinarySearch.search(key, seq);
        });
    }

    @Test
    void seqHaveDuplicates() {
        int key = 6;
        int[] seq = {1, 3, 3, 6};
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->{
            SearchResult result = BinarySearch.search(key, seq);
        });
    }

    @Test
    void keyIsCloseToSeqCenter() {
        int key = 45;
        int[] seq = {1, 4, 6, 23, 45, 47, 49, 56, 69, 100, 123};
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 4);
    }

    @Test
    void seqOfIntsWithoutGaps() {
        int key = 10;
        int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 9);
    }

    @Test
    void seqOfIntsWithGaps() {
        int key = 56;
        int[] seq = {1, 2, 3, 56, 58, 59, 127, 128, 129, 1003, 1004};
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 3);
    }
}
