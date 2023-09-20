public interface MyList<T>{
    public boolean add(T value);

    public boolean remove(int index);
    public void clear();
    public int size();
    public T get(int index);

    public default String getExceptionString(int index, int size){
        return "Index = " + index + " is out of bounds. Array length = " + size;
    }

}
