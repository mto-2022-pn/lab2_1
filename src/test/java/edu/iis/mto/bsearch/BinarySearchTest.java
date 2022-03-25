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
    public void sequenceIsEmpty() {
        int[] arr = new int[0];
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.search(1, arr);
        });
        assertEquals("Sequence length cannot be zero", e.getMessage());
    }

    @Test
    public void sequenceIsNotSortedAsc() {
        int[] arr = new int[]{4, 2, 1, 5};
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            BinarySearch.search(1, arr);
        });
        assertEquals("Sequence must be sorted in ascending order", e.getMessage());
    }

    @Test
    public void sequenceHasDupes() {
        Random random = new Random();

        int[] arr = new int[]{1, 1, 3, 5};
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
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
    public void notFoundInSequence() {
        SearchResult sr = BinarySearch.search(2, new int[]{1});
        assertTrue(!sr.isFound() && sr.getPosition() == -1);
    }

    @Test
    public void FirstElementInSequence() {
        SearchResult sr = BinarySearch.search(2, new int[]{2, 4, 7, 8});
        assertTrue(sr.isFound() && sr.getPosition() == 1);
    }

    @Test
    public void lastElementInSequence() {
        int[] arr = new int[]{2, 4, 7, 8};
        SearchResult sr = BinarySearch.search(8, arr);
        assertTrue(sr.isFound() && sr.getPosition() == arr.length);
    }

    @Test
    public void middleElementInSequence() {
        int[] arr = new int[]{2, 4, 5, 7, 8};
        int centerPos = arr.length / 2;
        int centerKey = arr[centerPos];
        SearchResult sr = BinarySearch.search(centerKey, arr);
        assertTrue(sr.isFound());
        assertEquals(centerPos, sr.getPosition() - 1);
        assertTrue(centerKey == arr[centerPos]);
    }

    @Test
    public void twoMiddleElementsInSequence() {
        int[] arr = new int[]{2, 4, 5, 6, 7, 8};
        int centerPos = arr.length / 2;
        int centerKey = arr[centerPos];
        SearchResult sr = BinarySearch.search(centerKey, arr);
        assertTrue(sr.isFound());
        assertEquals(centerPos, sr.getPosition() - 1);
        assertTrue(centerKey == arr[centerPos]);
    }

    @Test
    public void notFoundInLongSequence() {
        SearchResult sr = BinarySearch.search(2, new int[]{1, 3, 5, 6, 7, 8, 9});
        assertTrue(!sr.isFound() && sr.getPosition() == -1);
    }
}