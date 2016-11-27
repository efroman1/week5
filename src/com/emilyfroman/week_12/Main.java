package com.emilyfroman.week_12;

/**
 * Created by Emily on 11/25/2016.
 */
import java.util.ArrayList;
import java.util.List;

class QueueEmptyException extends Exception {}
class QueueFullExecption extends Exception {}

class Queue<E> {
    private List<E> elements;
    private int index = 0;
    private int size;

    Queue(int size) {
        elements = new ArrayList<>();
        this.size = size;
    }

    public void enqueue(E element) throws QueueFullExecption{
        if (elements.size() >= size) {
            throw new QueueFullExecption();
        }
        elements.add(element);

    }

    public E dequeue() throws QueueEmptyException{
        if (elements.size() == 0) {
            throw new QueueEmptyException();
        }
        return elements.remove(0);
    }

}

public class Main {
    public static void main(String[] args) {
        Queue<String> strings = new Queue<>(2);
        try {
            strings.enqueue("First String");
            strings.enqueue("Second String");
            //strings.enqueue("Third String");
            System.out.println(strings.dequeue() );
            System.out.println(strings.dequeue() );
            //System.out.println(strings.dequeue() );
        }
        catch (QueueEmptyException | QueueFullExecption e) {
            e.printStackTrace();
        }
    }
}
