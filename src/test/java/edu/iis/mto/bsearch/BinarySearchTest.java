package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;


class BinarySearchTest {

    int [] array;
    int [] arrayNegatives;
    int n;

    @BeforeEach
    void setUp() throws Exception {
        Random rand = new Random();
        n = rand.nextInt(50);
        n+=10;
        array = new int[n];
        arrayNegatives = new int[n];
        for(int i =0;i<n;i++){
            array[i] = i;
            arrayNegatives[i] = -n+1+i;
        }
    }

    @Test
    void ElementIsInList() {
        int [] array = new int[1];
        array[0] = 1;
        SearchResult result = BinarySearch.search(1,array);
        assertEquals(true,result.isFound());
        assertEquals(0,result.getPosition());
    }

    @Test
    void ElementIsNotInList() {
        int [] array = new int[1];
        array[0] = 2;
        SearchResult result = BinarySearch.search(1,array);
        assertEquals(false,result.isFound());
        assertEquals(-1,result.getPosition());
    }

    @Test
    void ElementIsFirstElementInList() {
        SearchResult result = BinarySearch.search(0,array);
        assertEquals(true,result.isFound());
        assertEquals(0,result.getPosition());

        result = BinarySearch.search(-n+1,arrayNegatives);
        assertEquals(true,result.isFound());
        assertEquals(0,result.getPosition());
    }

    @Test
    void ElementIsLastElementInList() {
        SearchResult result = BinarySearch.search(n-1,array);
        assertEquals(true,result.isFound());
        assertEquals(n-1,result.getPosition());

        result = BinarySearch.search(0,arrayNegatives);
        assertEquals(true,result.isFound());
        assertEquals(n-1,result.getPosition());
    }

    @Test
    void ElementIsMiddleElementInList() {
        SearchResult result = BinarySearch.search(n/2,array);
        assertEquals(true,result.isFound());
        assertEquals(n/2,result.getPosition());

        result = BinarySearch.search(-n/2,arrayNegatives);
        assertEquals(true,result.isFound());
        assertEquals(n/2,result.getPosition());
    }

    @Test
    void ElementIsNotInListWithMultipleElements() {
        SearchResult result = BinarySearch.search(n,array);
        assertEquals(false,result.isFound());
        assertEquals(-1,result.getPosition());

        result = BinarySearch.search(-n,arrayNegatives);
        assertEquals(false,result.isFound());
        assertEquals(-1,result.getPosition());
    }

    @Test
    void ArrayIsEmpty() {
        int [] array = new int[0];
        assertThrows(IllegalArgumentException.class, ()-> {
            BinarySearch.search(1, array);
        });
    }

    @Test
    void ArrayIsNull() {
        assertThrows(NullPointerException.class, ()-> {
            BinarySearch.search(1, null);
        });
    }

    @Test
    void ArrayIsNotDistinct() {
        int [] array = new int[]{1,1};
        assertThrows(IllegalArgumentException.class, ()-> {
            BinarySearch.search(1, array);
        });
    }






}
