public interface MyQueue <T>{
    public boolean add(T value);
    public void clear();
    public int size();
    public T peek();
    public T poll();
}
