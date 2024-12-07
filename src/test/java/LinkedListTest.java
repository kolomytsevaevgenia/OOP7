import L7.LinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LinkedListTest {

    private LinkedList<Integer> createIntegerList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        return list;
    }

    private LinkedList<String> createStringList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("world");
        list.add("!");
        return list;
    }

    @Test
    @DisplayName("добавить Integer элементы")
    void addIntegerTest() {
        LinkedList<Integer> list = createIntegerList();
        assertEquals(4, list.getHead().getValue());
        assertEquals(6, list.getTail().getValue());
        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("удалить последний Integer элемент")
    void deleteIntegerTest() {
        LinkedList<Integer> list = createIntegerList();
        list.delete();
        assertEquals(2, list.size());
        assertEquals(5, list.getTail().getValue());

        list.delete(); // Удаляем 5
        list.delete(); // Удаляем 4
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("удалить определенное Integer значение")
    void deleteValueIntegerTest() {
        LinkedList<Integer> list = createIntegerList();
        list.delete(5);

        assertEquals(2, list.size());
        assertThrows(NoSuchElementException.class,
                () -> list.delete(5));
    }

    @Test
    @DisplayName("найти Integer значение")
    void findByValueIntegerTest() {
        LinkedList<Integer> list = createIntegerList();
        assertEquals(5, list.findByValue(5).getValue());

        assertThrows(NoSuchElementException.class,
                () -> list.findByValue(7));
    }

    @Test
    @DisplayName("добавить String элементы")
    void addStringTest() {
        LinkedList<String> list = createStringList();
        assertEquals("Hello", list.getHead().getValue());
        assertEquals("!", list.getTail().getValue());
        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("удалить последний String элемент")
    void deleteStringTest() {
        LinkedList<String> list = createStringList();
        list.delete();

        assertEquals(2, list.size());
        assertEquals("world", list.getTail().getValue());

        list.delete();
        list.delete();
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("удалить определенное String значение")
    void deleteValueStringTest() {
        LinkedList<String> list = createStringList();
        list.delete("world");

        assertEquals(2, list.size());
        assertThrows(NoSuchElementException.class,
                () -> list.delete("world"));
    }

    @Test
    @DisplayName("найти String значение")
    void findByValueStringTest() {
        LinkedList<String> list = createStringList();
        assertEquals("world", list.findByValue("world").getValue());

        assertThrows(NoSuchElementException.class,
                () -> list.findByValue("!!"));
    }
}

