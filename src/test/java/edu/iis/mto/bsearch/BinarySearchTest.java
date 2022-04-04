package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void TestElementIsFoundInSequence() {
        int[] seq = { 10 };
        int key = 10;
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound() && seq[result.getPosition()] == key);
    }

    @Test
    void TestElementIsNotFoundInSequence() {
        int[] seq = { 10 };
        int key = 1;
        SearchResult result = BinarySearch.search(key, seq);
        assertFalse(result.isFound() && result.getPosition() == -1);
    }

    @Test
    void TestElementIsFoundInSequenceAtTheBeginning() {
        int[] seq = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int key = 1;
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound() && seq[result.getPosition()] == key);
    }

    @Test
    void TestElementIsFoundInEvenSequenceInTheMiddle() {
        int[] seq = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 6;
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound() && seq[result.getPosition()] == key);
    }

    @Test
    void TestElementIsFoundInOddSequenceInTheMiddle() {
        int[] seq = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 5;
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound() && seq[result.getPosition()] == key);
    }

    @Test
    void TestElementIsFoundInSequenceAtTheEnd() {
        int[] seq = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int key = 9;
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound() && seq[result.getPosition()] == key);
    }

    @Test
    void TestElementIsNotFoundInSequenceWithManyElements() {
        int[] seq = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int key = 10;
        SearchResult result = BinarySearch.search(key, seq);
        assertFalse(result.isFound() && result.getPosition() == -1);
    }

    @Test
    void TestFindElementInEmptySequence() {
        int[] seq = {};
        int key = 1;
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(key, seq));
    }

    @Test
    void TestFindElementInSequenceWithDuplicates() {
        int[] seq = { 1, 2, 3, 4, 5, 5, 5, 8, 9 };
        int key = 5;
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(key, seq));
    }

}
