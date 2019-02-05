package org.toy.til.effective.generic;

import java.util.*;

// item.29 Use Generic field as long as you can.
public class Stack {

    static class NoGenericCase {
        private static final int DEFAULT_INITIAL_CAPACITY = 16;
        private Object[] elements;
        private int size = 0;

        public NoGenericCase() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            Object result = elements[--size];
            elements[size] = null;
            return result;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }
    }

    static class GenericCase<E> {
        // private E[] elements;

        private static final int DEFAULT_INITIAL_CAPACITY = 16;
        // case 2
        private Object[] elements;
        private int size = 0;


        public GenericCase() {
            // this code can't complete compile.
            //elements = new E[DEFAULT_INITIAL_CAPACITY];

            // first case !!
            // This code complete compile. but IDE mark a `Unchecked` warning
            // In this case, type of elements is safe because elements don't return direct.
            // write `@SuppressWarnings("unchecked")` above method
            // elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];

            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(E e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public E pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            // case.2
            @SuppressWarnings("unchecked")
            E result = (E) elements[--size];
            elements[size] = null;
            return result;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }
    }

    static class Trouble<T> {
        public static void main(String[] args) {
            Trouble trouble = new Trouble();
            // 이건 조금 신박한데 ?
            /*for (String str : trouble.getStrs()) {
                System.out.println(str);
            }*/
        }

        public List<String> getStrs() {
            return Arrays.asList("str");
        }
    }

    static class NonGeneric {
        Collection<Number> myNumbers() {
            return null;
        }
    }

    abstract static class RawMembers<T> extends NonGeneric
            implements Collection<String> {

        static Collection<NonGeneric> cng =
                new ArrayList<NonGeneric>();

        public static void main(String[] args) {
            RawMembers rw = null;
            // OK
            Collection<Number> cn = rw.myNumbers();
            // Unchecked warning
            Iterator<String> is = rw.iterator();
            // OK, static member
            Collection<NonGeneric> cnn = rw.cng;

        }
    }
}
