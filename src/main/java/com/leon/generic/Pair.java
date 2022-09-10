package com.leon.generic;

/**
 * @author Leon
 * @since 2021年09月08日 17:46
 **/
public class Pair<T> {
    T t;
    public void set(T t){
        this.t = t;
    }

    public T get(){
        return this.t;
    }
    
    public static void setPair(Pair<? super Number> d, Pair<? extends Number> s){
        Object o = "1";
        Number s1 = s.get();
        Object d1 = d.get();
        d.set(s.get());
        Integer i = 0;
    }

    public static void main(String[] args) {

        Pair<Integer> d1 = new Pair<>();
        setPair(null, d1);
    }
}
