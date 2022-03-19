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
        SearchResult searchResult = BinarySearch.search(4, seq);
        assertTrue(searchResult.isFound());
        assertEquals(1, searchResult.getPosition());
    }

}
