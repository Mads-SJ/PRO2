package dictionaryelev;

import opg1.Bil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DictionarTest {
    Dictionary<Integer, String> dictionary;
    Dictionary<Bil, Integer> bilDictionary;
   

    @BeforeEach
    public void setUp() throws Exception {
        // dictionary = new DictionaryHashMap<>();
        dictionary = new DictionaryLinked<>();
        bilDictionary = new DictionaryLinked<>();
        
    }
    
    @Test
    public void test() {
        assertTrue(dictionary.isEmpty());
        assertEquals(0, dictionary.size());

        dictionary.put(8, "hans");
        dictionary.put(3, "viggo");
        
        assertFalse(dictionary.isEmpty());
        assertEquals(2, dictionary.size());

        assertEquals("hans", dictionary.get(8));

        dictionary.put(7, "bent");
        dictionary.put(2, "lene");
        
        assertFalse(dictionary.isEmpty());
        assertEquals(4, dictionary.size());
        
        assertEquals("viggo", dictionary.remove(3));

        assertEquals(3, dictionary.size());
        
        assertEquals("hans", dictionary.put(8, "Ida"));
        assertEquals("Ida", dictionary.get(8));

    }

    @Test
    public void testBil() {
        assertTrue(dictionary.isEmpty());
        assertEquals(0, dictionary.size());
        Bil b1 = new Bil("AB12345", "Ford", "Focus", "Rød");
        assertNull(bilDictionary.put(b1, 1));

        Bil b2 = new Bil("CD67891", "Ford", "Focus", "Rød");
        assertNull(bilDictionary.put(b2, 2));

        assertEquals(1, bilDictionary.get(b1));
        assertEquals(2, bilDictionary.get(b2));
        assertEquals(2, bilDictionary.size());

        assertEquals(1, bilDictionary.put(b1, 3));

        Bil b3 = new Bil("AB12345", "Audi", "A4", "Sort");


    }

    
    
}
