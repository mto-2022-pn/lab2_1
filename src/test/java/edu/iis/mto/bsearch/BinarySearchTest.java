package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {
    int[] sequenceWithOneElement = new int[]{13};
    int[] sequenceWithMultipleElements = new int[]{13,15,17,22,43,78,112,234,666};
    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void keyIsInSequenceWithOneElement() {
        int key = 13;
        SearchResult searchResult = BinarySearch.search(key, sequenceWithOneElement);
        assertTrue(searchResult.isFound());
        assertEquals(key, sequenceWithOneElement[searchResult.getPosition()]);
    }
    @Test
    void noKeyInSequenceWithOneElement() {
        int key = 12;
        SearchResult searchResult = BinarySearch.search(key,sequenceWithOneElement);
        assertFalse(searchResult.isFound());
        assertEquals(-1,searchResult.getPosition());
    }
    @Test
    void keyIsFirstElementInSequenceWithMultipleElements(){
        int key = 13;
        SearchResult searchResult = BinarySearch.search(key,sequenceWithMultipleElements);
        assertTrue(searchResult.isFound());
        assertEquals(key,sequenceWithMultipleElements[0]);
    }
    @Test
    void keyIsLastElementInSequenceWithMultipleElements(){
        int key = 666;
        SearchResult searchResult = BinarySearch.search(key,sequenceWithMultipleElements);
        assertTrue(searchResult.isFound());
        assertEquals(key, sequenceWithMultipleElements[sequenceWithMultipleElements.length - 1]);
    }
}
