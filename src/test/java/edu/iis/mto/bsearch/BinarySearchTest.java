package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void keyElementIsInSequence() {
        int key = 5;
        int[] seq = { 1, 3, 4, 5, 6, 8 };
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test
    void keyElementIsNotInSequence() {
        int key = 2;
        int[] seq = { 1, 3, 4, 6, 8 };
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void keyElementsIsFirstElementInInSequence() {
        int key = 11;
        int[] seq = { 11, 22, 33, 123, 452 };
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test
    void keyElementsIsLastElementInInSequence() {
        int key = 4235;
        int[] seq = { 45, 157, 645, 1544, 2598, 4235 };
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test
    void keyElementsIsMiddleElementInInSequence() {
        int key = 89;
        int[] seq = { 1, 45, 89, 123, 222 };
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test
    void keyElementsIsNotInSequence() {
        int key = 1546;
        int[] seq = { 87, 154, 458, 684, 987, 1564, 2654 };
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void testExpectedIllegalArgumentException_EmptySeq(){
        int key = 1546;
        int[] seq = {};
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            BinarySearch.search(key, seq);
        });
    }

    @Test
    void testExpectedIllegalArgumentException_SeqNotSorted(){
        int key = 1546;
        int[] seq = {45,98784,4,17,87};
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            BinarySearch.search(key, seq);
        });
    }

    @Test
    void testExpectedIllegalArgumentException_SeqWithDuplicats(){
        int key = 1546;
        int[] seq = {4,87,154,154,987};
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            BinarySearch.search(key, seq);
        });
    }
}
