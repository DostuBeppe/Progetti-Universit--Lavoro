package priorityQueue;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestJUnit {
    private PriorityQueue.IntegerComparator cmp= new PriorityQueue.IntegerComparator();
    private PriorityQueue<Integer, Integer> hq= new PriorityQueue<>(cmp);
    @Test
    public void testInit(){
        assertNull(null);
    }


    @Test
    public void testCreation(){

        assertNotNull(hq);
    }

    @Test
    public void testInsert(){

        hq.insert(5,15);
        hq.insert(7,8);
        hq.insert(1,2);
        assertEquals(hq.extract().toString(), "5 15");
        assertEquals(hq.extract().toString(), "7 8");
        assertEquals(hq.extract().toString(), "1 2");
        assertNull(hq.extract());

    }

    @Test
    public void testInsertControlPriority(){
        hq.insert(1,2);
        hq.insert(5,15);
        hq.insert(7,8);
        assertEquals(hq.extract().toString(), "5 15");
        assertEquals(hq.extract().toString(), "7 8");
        assertEquals(hq.extract().toString(), "1 2");
        assertNull(hq.extract());
    }

    @Test
    public void testPrint(){
        String prova="- 5 15 - - 7 8 - - 1 2 - ";
        hq.insert(1,2);
        hq.insert(5,15);
        hq.insert(7,8);
        assertEquals(hq.toString(),prova);
    }


}
