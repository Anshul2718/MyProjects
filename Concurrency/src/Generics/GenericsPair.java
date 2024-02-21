package Generics;

public class GenericsPair<E, F> {
    private E first;
    private F secound;

    public GenericsPair(E first, F secound){
        this.first = first;
        this.secound = secound;
    }

    public E getFirst() {
        return first;
    }

    public F getSecound() {
        return secound;
    }
}
