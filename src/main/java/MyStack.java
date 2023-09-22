public interface MyStack<T> {
    public void push(T value);
    public boolean remove(int index);
    public void clear();
    public int size();
    public T peek();
    public T pop();
}
