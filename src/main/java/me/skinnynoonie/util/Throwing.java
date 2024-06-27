package me.skinnynoonie.util;

public interface Throwing {

    interface Runnable {
        void run() throws Exception;
    }

    interface Supplier<T> {
        T get() throws Exception;
    }

    interface Consumer<T> {
        void accept(T input) throws Exception;
    }

    interface Function<I, O> {
        O apply(I input) throws Exception;
    }

    interface BiFunction<I1, I2, O> {
        O apply(I1 inputOne, I2 inputTwo) throws Exception;
    }

}
