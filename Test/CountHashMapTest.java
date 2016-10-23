import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Acer on 18.10.2016.
 */
public class CountHashMapTest {

    @Test
    public void testConstructor() {
        Assert.assertTrue(null != new CountHashMap<String>());
    }

    @Test
    public void testCountProcess() throws Exception {
        CountHashMap<String> strings = new CountHashMap<>();
        strings.add("q");
        strings.add("e");
        strings.add("q");
        Assert.assertEquals(2, strings.getCount("q"));
        Assert.assertEquals(1, strings.getCount("e"));
    }

    @Test
    public void testGetCountForNotExistedElement() throws Exception {
        CountHashMap<String> strings = new CountHashMap<>();
        Assert.assertEquals(0, strings.getCount(""));
    }

    @Test
    public void testRemove() {
        CountHashMap<String> strings = new CountHashMap<>();
        strings.add("r");
        strings.add("r");
        strings.add("e");
        Assert.assertEquals(2, strings.remove("r"));
    }

    @Test
    public void testSize() {
        CountHashMap<String> strings = new CountHashMap<>();
        strings.add("1");
        strings.add("1");
        strings.add("q");
        strings.add("4");
        strings.add("4");
        strings.add("4");
        strings.remove("1");
        Assert.assertEquals(2, strings.size());
    }

    @Test
    public void testAddAll() {
        CountHashMap<String> strings1 = new CountHashMap<>();
        strings1.add("d");
        strings1.add("d");
        strings1.add("q");
        strings1.add("e");
        CountHashMap<String> strings2 = new CountHashMap<>();
        strings2.add("w");
        strings2.addAll(strings1);
        Assert.assertEquals(4, strings2.size());
        Assert.assertEquals(2, strings2.getCount("d"));
        Assert.assertEquals(1, strings2.getCount("e"));
    }

    @Test
    public void testMapToMap() {
        CountHashMap<String> strings = new CountHashMap<>();
        strings.add("t");
        strings.add("q");
        strings.add("q");
        HashMap<String, Integer> strings2 = new HashMap<>();
        strings2.put("t", 1);
        strings2.put("q", 2);
        Assert.assertEquals(strings2, strings.toMap());
    }

    @Test
    public void testVoidToMap() {
        CountHashMap<String> strings = new CountHashMap<>();
        strings.add("z");
        strings.add("z");
        strings.add("s");
        strings.add("x");
        Map<String, Integer> strings2 = new HashMap<>();
        strings2.put("z", 2);
        strings2.put("s", 1);
        strings2.put("x", 1);
        Map<String, Integer> destination = new HashMap<>();
        strings.toMap(destination);
        Assert.assertEquals(strings2, destination);
    }
}
