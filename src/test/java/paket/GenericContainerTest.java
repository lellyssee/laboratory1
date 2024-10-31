package paket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenericContainerTest {

    @Test
    public void testAddAndGet() {
        GenericContainer<String> container = new GenericContainer<>();
        container.add("Hello");
        container.add("World");

        assertEquals("Hello", container.get(0));
        assertEquals("World", container.get(1));
    }

    @Test
    public void testRemove() {
        GenericContainer<String> container = new GenericContainer<>();
        container.add("One");
        container.add("Two");
        container.remove(0);

        assertEquals("Two", container.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(1));
    }

    @Test
    public void testSize() {
        GenericContainer<Integer> container = new GenericContainer<>();
        assertEquals(0, container.size());
        container.add(1);
        assertEquals(1, container.size());
        container.add(2);
        assertEquals(2, container.size());
        container.remove(1);
        assertEquals(1, container.size());
    }

    @Test
    public void testIndexOutOfBounds() {
        GenericContainer<String> container = new GenericContainer<>();
        container.add("Alpha");
        container.add("Beta");

        assertThrows(IndexOutOfBoundsException.class, () -> container.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(2));
    }
}
