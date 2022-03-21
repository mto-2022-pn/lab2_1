package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {
    }
    @Test
    void SequenceIsEmpty(){
        int[] arr = new int[0];
        assertThrows(IllegalArgumentException.class, ()->{
            BinarySearch.search(1, arr);
        });
    }

    @Test
    void searchForValueInArray() {
        SearchResult sr = BinarySearch.search(1, new int[]{1});
        assertTrue(sr.isFound());
    }

    @Test
    void NotFoundInSequence() {
        SearchResult sr = BinarySearch.search(2, new int[]{1});
        assertTrue(!sr.isFound() && sr.getPosition() == -1);
    }

    @Test
    void FirstElementInSequence() {
        SearchResult sr = BinarySearch.search(2, new int[]{2, 4, 7, 8});
        assertTrue(sr.isFound() && sr.getPosition() == 1);
    }

    @Test
    void LastElementInSequence() {
        int[] arr = new int[]{2, 4, 7, 8};
        SearchResult sr = BinarySearch.search(8, arr);
        assertTrue(sr.isFound() && sr.getPosition() == arr.length);
    }

    @Test
    void MiddleElementInSequence() {
        int[] arr = new int[]{2, 4, 5, 7, 8};
        SearchResult sr = BinarySearch.search(5, arr);
        assertTrue(sr.isFound() && sr.getPosition()>0 && sr.getPosition() < arr.length);
    }
    @Test
    void NotFoundInLongSequence() {
        SearchResult sr = BinarySearch.search(2, new int[]{1,3,5,6,7,8,9});
        assertTrue(!sr.isFound() && sr.getPosition() == -1);
    }
}