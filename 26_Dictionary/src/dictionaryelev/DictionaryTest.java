package dictionaryelev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DictionaryTest {
    Dictionary<String, Integer> dictionary;
    @BeforeEach
    public void setUp() {
        // dictionary = new DictionaryHashMap<>();
        dictionary = new DictionaryArrayList<>();
    }

    @Test
    public void test() {
        assertTrue(dictionary.isEmpty());
        assertEquals(0, dictionary.size());

        dictionary.put("hans", 8);
        dictionary.put("viggo", 3);

        assertFalse(dictionary.isEmpty());
        assertEquals(2, dictionary.size());

        assertEquals(8, dictionary.get("hans"));

        dictionary.put("bent", 7);
        dictionary.put("lene", 2);

        assertFalse(dictionary.isEmpty());
        assertEquals(4, dictionary.size());

        assertEquals(3, dictionary.remove("viggo"));

        assertEquals(3, dictionary.size());

        assertEquals(8, dictionary.put("hans", 9));
        assertEquals(9, dictionary.get("hans"));

    }
}
