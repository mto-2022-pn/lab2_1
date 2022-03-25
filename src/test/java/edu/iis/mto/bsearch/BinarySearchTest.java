package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Random;


class BinarySearchTest {

    @BeforeEach
    public void setUp() throws Exception {
    }
    @Test
    public void SequenceIsEmpty(){
        int[] arr = new int[0];
        IllegalArgumentException e= assertThrows(IllegalArgumentException.class, ()->{
            BinarySearch.search(1, arr);
        });
        assertEquals("Sequence length cannot be zero", e.getMessage());
    }

    @Test
    public void SequenceIsNotSortedAsc(){
        int[] arr = new int[]{4,2,1,5};
        IllegalArgumentException e= assertThrows(IllegalArgumentException.class, ()->{
            BinarySearch.search(1, arr);
        });
        assertEquals("Sequence must be sorted in ascending order", e.getMessage());
    }

    @Test
    public void SequenceHasDupes(){
        Random random = new Random();

        int[] arr = new int[]{1,1,3,5};
        IllegalArgumentException e= assertThrows(IllegalArgumentException.class, ()->{
            BinarySearch.search(1, arr);
        });
        assertEquals("Sequence cannot have duplicates", e.getMessage());
    }


    @Test
    public void searchForValueInArray() {
        SearchResult sr = BinarySearch.search(1, new int[]{1});
        assertTrue(sr.isFound());
    }

    @Test
    public void NotFoundInSequence() {
        SearchResult sr = BinarySearch.search(2, new int[]{1});
        assertTrue(!sr.isFound() && sr.getPosition() == -1);
    }

    @Test
    public void FirstElementInSequence() {
        SearchResult sr = BinarySearch.search(2, new int[]{2, 4, 7, 8});
        assertTrue(sr.isFound() && sr.getPosition() == 1);
    }

    @Test
    public void LastElementInSequence() {
        int[] arr = new int[]{2, 4, 7, 8};
        SearchResult sr = BinarySearch.search(8, arr);
        assertTrue(sr.isFound() && sr.getPosition() == arr.length);
    }

    @Test
    public void MiddleElementInSequence() {
        int[] arr = new int[]{2, 4, 5, 7, 8};
        SearchResult sr = BinarySearch.search(5, arr);
        assertTrue(sr.isFound() && sr.getPosition()>0 && sr.getPosition() < arr.length);
    }
    @Test
    public void NotFoundInLongSequence() {
        SearchResult sr = BinarySearch.search(2, new int[]{1,3,5,6,7,8,9});
        assertTrue(!sr.isFound() && sr.getPosition() == -1);
    }
}