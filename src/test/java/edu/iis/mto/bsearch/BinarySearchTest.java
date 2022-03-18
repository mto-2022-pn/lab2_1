package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    @DisplayName("Jest w sekwencji i dł = 1")
    void test1() {
        int key=11;
        int [] seq = {11};
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertTrue(searchResult.isFound());
        assertEquals(1,searchResult.getPosition());
    }

}
