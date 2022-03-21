package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    SearchResult result;
    private final int[] input = {0, 1, 2, 3, 4, 5};
    @BeforeEach
    void setUp() throws Exception {
        
    }

    @Test
    void test() {
        fail("Not yet implemented");
    }
    
    @Test
    void test_01()
    {
        int key = 0;
        int[] seq = {0}; 
        result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertTrue(seq[result.getPosition()] == key);
 
    }

    @Test
    void test_02()
    {
        int key = 0;
        int[] seq = {1}; 
        result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertTrue(result.getPosition() == -1);
    }

    @Test
    void test_03()
    {
        int key = 0;
        int[] seq = {0, 1, 2, 3, 4, 5}; 
        result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertTrue(seq[result.getPosition()] == key);
    }

    @Test
    void test_04()
    {
        int key = 5;
        int[] seq = {0, 1, 2, 3, 4, 5};
        result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertTrue(seq[result.getPosition()] == key);
    }

    @Test
    void test_05()
    {
        int key = 3;
        int[] seq = {0, 1, 2, 3, 4, 5};
        result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertTrue(seq[result.getPosition()] == key);
    }

    @Test
    void test_06()
    {
        int key = 7;
        int[] seq = {0, 1, 2, 3, 4, 5};
        result = BinarySearch.search(key, seq);
        assertFalse(result.isFound());
        assertTrue(result.getPosition() == -1);
    }
}
