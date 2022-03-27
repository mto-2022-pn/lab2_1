package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void oneElementInSeq() {
        int element = 20;
        int[] seq = new int[1];
        seq[0] = element;

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertTrue(searchResult.isFound());
        assertEquals(1, searchResult.getPosition());
    }

    @Test
    void noElementInSeq() {
        int element = 20;
        int[] seq = new int[1];
        seq[0] = 1;

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void firstElementInSeq() {
        int element = 1;
        int[] seq = new int[]{1, 5, 21, 23, 45, 46, 78, 461};

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertTrue(searchResult.isFound());
        assertEquals(1, searchResult.getPosition());
    }

    @Test
    void lastElementInSeq() {
        int element = 78;
        int[] seq = new int[]{8, 23, 23, 34, 48, 51, 56, 78};

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq.length, searchResult.getPosition());
    }

    @Test
    void middleElementInSeq() {
        int element = 48;
        int[] seq = new int[]{8, 23, 23, 34, 48, 51, 56, 56, 78};

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertTrue(searchResult.isFound());
        assertEquals(5, searchResult.getPosition());
    }

    @Test
    void noElementInMultipleSeq() {
        int element = 25896;
        int[] seq = new int[]{8, 23, 23, 34, 48, 51, 56, 56, 78};

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    void emptySeq() {
        int element = 123;
        int[] seq = new int[]{};

        assertThrows(IllegalArgumentException.class, () -> {
            SearchResult searchResult = BinarySearch.search(element, seq);
        });
    }

    @Test
    void nullSeq() {
        int element = 123;
        int[] seq = null;

        assertThrows(NullPointerException.class, () -> {
            SearchResult searchResult = BinarySearch.search(element, seq);
        });
    }

    @Test
    void middleElementInEvenSeq() {
        int element = 17;
        int[] seq = new int[]{14, 17, 52, 89};

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertTrue(searchResult.isFound());
        assertEquals(2, searchResult.getPosition());
    }

    @Test
    void middleElementInEvenSeqv2() {
        int element = 52;
        int[] seq = new int[]{14, 17, 52, 89};

        SearchResult searchResult = BinarySearch.search(element, seq);
        assertTrue(searchResult.isFound());
        assertEquals(3, searchResult.getPosition());
    }

    @Test
    void notSortedSeq(){
        int element = 51;
        int[] seq = new int[]{984,51,5165,56,51,513,17};
        assertThrows(IllegalArgumentException.class, () -> {
            SearchResult searchResult = BinarySearch.search(element, seq);
        });

    }
}
