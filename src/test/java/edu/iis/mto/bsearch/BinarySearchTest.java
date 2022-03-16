package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void keyIsInSequenceWithOneElement() {
        int[] sequenceWithOneElement = new int[]{13};
        int key = 13;
        SearchResult searchResult = BinarySearch.search(key, sequenceWithOneElement);
        assertTrue(searchResult.isFound());
        assertEquals(key, sequenceWithOneElement[searchResult.getPosition()]);
    }

}
