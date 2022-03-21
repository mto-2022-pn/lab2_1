package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void testSingleElemPresentInList() {
        int[] seq = {1};
        SearchResult result = BinarySearch.search(seq[0], seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 0);
    }

    @Test
    void TestSingleElemNotPresent() {
        int[] seq = {2};
        SearchResult result = BinarySearch.search(1, seq);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }

    @Test
    void TestMultiElemFirst() {
        int[] seq = {2, 4, 5, 7};
        SearchResult result = BinarySearch.search(seq[0], seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 0);
    }

    @Test
    void TestMultiElemLast() {
        int[] seq = {2, 4, 5, 7};
        var lastIdx = seq.length - 1;
        SearchResult result = BinarySearch.search(seq[lastIdx], seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), lastIdx);
    }

    @Test
    void TestMultiElemMiddle() {
        int[] seq = {2, 3, 4, 6, 8};
        var idx = (seq.length - 1) / 2;
        SearchResult result = BinarySearch.search(seq[idx], seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), idx);
    }

    @Test
    void TestMultiElemNotPresent() {
        int[] seq = {2, 3, 4, 6};
        SearchResult result = BinarySearch.search(12, seq);
        assertFalse(result.isFound());
        assertEquals(result.getPosition(), -1);
    }

    @Test
    void TestEmptySeq() {
        int[] seq = {};
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(12, seq));
    }
}
