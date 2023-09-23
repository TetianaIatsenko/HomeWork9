import java.util.Arrays;

public class MyArrayList<T> extends MyCollection implements MyList<T>{
    private static int DEFAULT_LENGTH = 10;
    private Object[] array;

    public MyArrayList(){
        this(DEFAULT_LENGTH);
    }
    public MyArrayList(int length){
        this.array = new Object[length];
    }

    @Override
    public boolean add(T value) {
        if(size == array.length)
            resize(array.length + DEFAULT_LENGTH);
        array[size] = value;
        size++;
        return true;
    }

    private void resize(int length){
        Object[] newArray = new Object[length];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public boolean remove(int index) {
        if(index >= size)
            throw new ArrayIndexOutOfBoundsException(getExceptionString(index, size));
        for(int i = index; i < size; i++){
            array[i] = array[i + 1];
        }
        size--;
        if(size < array.length - DEFAULT_LENGTH){
            resize(array.length - DEFAULT_LENGTH);
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Object[DEFAULT_LENGTH];
    }

    @Override
    public T get(int index) {
        if(index >= size)
            throw new ArrayIndexOutOfBoundsException(getExceptionString(index, size));
        return (T)array[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}
