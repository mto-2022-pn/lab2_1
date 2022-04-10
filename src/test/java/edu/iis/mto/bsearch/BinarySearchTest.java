package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @BeforeEach void setUp() throws Exception {
    }

    @Test void testKeyPresentInSingleElementSeq() {
        int key = 5;
        int[] seq = {5};
        int expected_position = 0;
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(expected_position, result.getPosition());
    }

    @Test void testKeyNotPresentInSingleElementSeq() {
        int key = 5;
        int[] seq = {8};
        int expected_position = -1;
        SearchResult result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertEquals(expected_position, result.getPosition());
    }

    @Test void testKeyPresentFirstInMultipleElementsSeq() {
        int key = 5;
        int[] seq = {5, 9, 12};
        int expected_position = 0;
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(expected_position, result.getPosition());
    }

    @Test void testKeyPresentLastInMultipleElementsSeq() {
        int key = 12;
        int[] seq = {5, 9, 12};
        int expected_position = 2;
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(expected_position, result.getPosition());
    }

    @Test void testKeyPresentMiddleInMultipleElementsSeq() {
        int key = 9;
        int[] seq = {5, 9, 12};
        int expected_position = 1;
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(expected_position, result.getPosition());
    }

    @Test void testKeyNotPresentInMultipleElementsSeq() {
        int key = 10;
        int[] seq = {5, 9, 12};
        int expected_position = -1;
        SearchResult result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertEquals(expected_position, result.getPosition());
    }

}
