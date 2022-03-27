package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testSingleElementExistingInList() {
        int[] seq = {1};
        SearchResult searchResult = BinarySearch.search(seq[0], seq);
        assertTrue(searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    void testSingleElementNotExistingInList() {
        int[] seq = {1};
        SearchResult searchResult = BinarySearch.search(2, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void testMultipleElementFirst() {
        int[] seq = {1, 2, 3, 4, 5};
        SearchResult searchResult = BinarySearch.search(seq[0], seq);
        assertTrue(searchResult.isFound());
        assertEquals(0 ,searchResult.getPosition());
    }

    @Test
    void testMultipleElementLast() {
        int[] seq = {1, 2, 3, 4, 5};
        SearchResult searchResult = BinarySearch.search(seq[seq.length - 1], seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq.length - 1, searchResult.getPosition());
    }

    @Test
    void testMultipleElementMid() {
        int[] seq = {1, 2, 3, 4, 5};
        SearchResult searchResult = BinarySearch.search(seq[(seq.length - 1) / 2], seq);
        assertTrue(searchResult.isFound());
        assertEquals((seq.length - 1) / 2,searchResult.getPosition());
    }

    @Test
    void testMultipleElementNotExistingInList() {
        int[] seq = {1, 2, 3, 4, 5};
        SearchResult searchResult = BinarySearch.search(6, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void testEmptyList() {
        int[] seq = {};
        assertThrows(IllegalArgumentException.class, ()-> BinarySearch.search(6, seq));
    }

    @Test
    void testNotSortedList() {
        int[] seq = {1, 2, 4, 3};
        assertThrows(IllegalArgumentException.class, ()-> BinarySearch.search(4, seq));
    }

    @Test
    void testDuplicatedElementsInList() {
        int[] seq = {1, 2, 3, 3};
        assertThrows(IllegalArgumentException.class, ()-> BinarySearch.search(1, seq));
    }
}
