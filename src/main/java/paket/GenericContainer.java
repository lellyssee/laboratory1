package paket;
/**
 * Класс GenericContainer обеспечивает возможность хранения
 * произвольного количества объектов одного типа.
 * @param <T> тип объектов, которые будут храниться в контейнере.
 */
public class GenericContainer<T> {
    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /** Конструктор по умолчанию, инициализирует массив с заданной емкостью. */
    @SuppressWarnings("unchecked")
    public GenericContainer() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Добавляет элемент в контейнер.
     * @param item элемент, который нужно добавить.
     */
    public void add(T item) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = item;
    }

    /** Извлекает элемент по индексу. */
    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    /**
     * Удаляет элемент по индексу.
     * @param index индекс элемента, который необходимо удалить.
     */
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Удаляем ссылку для сборщика мусора.
    }

    /** Возвращает размер контейнера. */
    public int size() {
        return size;
    }

    /** Проверка индекса на допустимость. */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
    }

    /** Увеличивает размер массива при необходимости. */
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = elements.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }
}
