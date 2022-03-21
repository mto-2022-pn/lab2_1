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
        SearchResult searchResult = BinarySearch.search(seq[0], seq);
        assertTrue(searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    void notExistingElem_singleItemSequence() {
        int[] seq = new int[1];
        seq[0] = 4;
        SearchResult searchResult = BinarySearch.search(8, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void searchForExistingElem_atFirstPosition_multipleItemSequence() {
        int[] seq = new int[]{1,4,6,8,12,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(seq[0], seq);
        assertTrue(searchResult.isFound());
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    void searchForExistingElem_atLastPosition_multipleItemSequence() {
        int[] seq = new int[]{1,4,6,8,12,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(seq[seq.length-1], seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq.length-1, searchResult.getPosition());
    }

    @Test
    void searchForExistingElem_atMiddlePosition_multipleItemSequence() {
        int[] seq = new int[]{1,4,6,8,12,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(seq[(seq.length)/2], seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq.length/2, searchResult.getPosition());
    }

    @Test
    void notExistingElem_multipleItemSequence() {
        int[] seq = new int[]{1,4,6,8,12,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(17, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void noSequence() {
        assertThrows(NullPointerException.class, ()-> {
            SearchResult searchResult = BinarySearch.search(17, null);
        });
    }

    @Test
    void itemSequence_notSorted() {
        int[] seq = new int[]{1,41,2,8,26,14,8,34,65};
        assertThrows(IllegalArgumentException.class, ()-> {
            SearchResult searchResult = BinarySearch.search(1, seq);
        });
    }

    @Test
    void itemSequence_itemsRepeats() {
        int[] seq = new int[]{1,4,8,8,12,14,23,34,65};
        assertThrows(IllegalArgumentException.class, ()-> {
            SearchResult searchResult = BinarySearch.search(1, seq);
        });
    }

    @Test
    void searchForExistingElem_beforeMiddlePosition_multipleItemSequence_evenQuantity() {
        int[] seq = new int[]{1,4,6,8,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(seq[(seq.length)/2 - 1], seq);
        assertTrue(searchResult.isFound());
        assertEquals((seq.length)/2 - 1, searchResult.getPosition());
    }

    @Test
    void searchForExistingElem_atMiddlePosition_multipleItemSequence_evenQuantity() {
        int[] seq = new int[]{1,4,6,8,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(seq[(seq.length)/2], seq);
        assertTrue(searchResult.isFound());
        assertEquals((seq.length)/2, searchResult.getPosition());
    }

    @Test
    void searchForExistingElem_afterMiddlePosition_multipleItemSequence_evenQuantity() {
        int[] seq = new int[]{1,4,6,8,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(seq[(seq.length)/2 + 1], seq);
        assertTrue(searchResult.isFound());
        assertEquals((seq.length)/2 + 1, searchResult.getPosition());
    }

    @Test
    void searchForExistingElem_beforeMiddlePosition_multipleItemSequence_notEvenQuantity() {
        int[] seq = new int[]{1,4,6,8,11,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(seq[(seq.length)/2 - 1], seq);
        assertTrue(searchResult.isFound());
        assertEquals((seq.length)/2 - 1, searchResult.getPosition());
    }

    @Test
    void searchForExistingElem_atMiddlePosition_multipleItemSequence_notEvenQuantity() {
        int[] seq = new int[]{1,4,6,8,11,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(seq[(seq.length)/2], seq);
        assertTrue(searchResult.isFound());
        assertEquals((seq.length)/2, searchResult.getPosition());
    }

    @Test
    void searchForExistingElem_afterMiddlePosition_multipleItemSequence_notEvenQuantity() {
        int[] seq = new int[]{1,4,6,8,11,14,18,34,65};
        SearchResult searchResult = BinarySearch.search(seq[(seq.length)/2 + 1], seq);
        assertTrue(searchResult.isFound());
        assertEquals((seq.length)/2 + 1, searchResult.getPosition());
    }


}
