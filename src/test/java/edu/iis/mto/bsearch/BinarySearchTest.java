package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}
    @Test
    void TestIfSequenceIsEmpty() {
        int[] sequence = new int[0];
        int key = 1;
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(key, sequence));
    }
    @Test
    void TestOneElementInSequenceIsPresent() {
        int[] sequence = { 1 };
        int key = 1;
        SearchResult result = BinarySearch.search(key, sequence);
        assertTrue(result.isFound() && sequence[result.getPosition()] == key);
    }

    @Test
    void TestOneElementInSequenceIsAbsent() {
        int[] sequence = { 2 };
        int key = 3;
        SearchResult result = BinarySearch.search(key, sequence);
        assertFalse(result.isFound() && result.getPosition() == -1);
    }

    @Test
    void TestManyElementsInSequenceIsPresentAtTheBeginning() {
        int[] sequence = { 2, 3, 4 };
        int key = 2;
        SearchResult result = BinarySearch.search(key, sequence);
        assertTrue(result.isFound() && sequence[result.getPosition()] == key);
    }

    @Test
    void TestManyElementsInSequenceIsPresentAtTheMiddle() {
        int[] sequence = { 6, 13, 34, 51 };
        int key = 13;
        SearchResult result = BinarySearch.search(key, sequence);
        assertTrue(result.isFound() && sequence[result.getPosition()] == key);
    }

    @Test
    void TestManyElementsInSequenceIsPresentAtTheEnd() {
        int[] sequence = { 2, 3, 5, 8, 13, 21, 34 };
        int key = 34;
        SearchResult result = BinarySearch.search(key, sequence);
        assertTrue(result.isFound() && sequence[result.getPosition()] == key);
    }

    @Test
    void TestManyElementsInSequenceIsAbsent() {
        int[] sequence = { -1, 2, 3, 5, 8, 13 };
        int key = -13;
        SearchResult result = BinarySearch.search(key, sequence);
        assertFalse(result.isFound() && result.getPosition() == -1);
    }
    @Test
    void TestIfSequenceIsSorted() {
        int[] sequence = { -1, 2, -3, 5, -8, 13 };
        int key = 1;
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(key, sequence));
    }
    @Test
    void TestIfSequenceContainsDuplicates() {
        int[] sequence = { 2, 3, 3, 5, 7, 13 };
        int key = 1;
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(key, sequence));
    }
    @Test
    void TestManyElementsInEvenSequenceIsPresentAtTheDirectlyMiddle() {
        int[] sequence = { -17, -13, -8, -3, -2, -1 };
        int key = -8;
        SearchResult result = BinarySearch.search(key, sequence);
        assertTrue(result.isFound() && sequence[result.getPosition()] == key);
    }
    @Test
    void TestManyElementsInOddSequenceIsPresentAtTheDirectlyMiddle() {
        int[] sequence = { -19, -14, -1, 3, 12 };
        int key = -1;
        SearchResult result = BinarySearch.search(key, sequence);
        assertTrue(result.isFound() && sequence[result.getPosition()] == key);
    }
}
