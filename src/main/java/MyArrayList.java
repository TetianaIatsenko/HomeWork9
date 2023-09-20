import java.util.Arrays;

public class MyArrayList<T> implements MyList<T>{
    private static int DEFAULT_LENGTH = 10;
    private Object[] array;
    private int pointer = 0;

    public MyArrayList(){
        this(DEFAULT_LENGTH);
    }
    public MyArrayList(int length){
        this.array = new Object[length];
    }

    @Override
    public boolean add(T value) {
        if(pointer == array.length)
            resize(array.length + DEFAULT_LENGTH);
        array[pointer] = value;
        pointer ++;
        return true;
    }

    private void resize(int length){
        Object[] newArray = new Object[length];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    @Override
    public boolean remove(int index) {
        if(index >= pointer)
            throw new ArrayIndexOutOfBoundsException(getExceptionString(index, pointer));
        for(int i = index; i < pointer; i++){
            array[i] = array[i + 1];
        }
        pointer--;
        if(pointer < array.length - DEFAULT_LENGTH){
            resize(array.length - DEFAULT_LENGTH);
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Object[DEFAULT_LENGTH];
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public T get(int index) {
        if(index >= pointer)
            throw new ArrayIndexOutOfBoundsException(getExceptionString(index, pointer));
        return (T)array[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, pointer));
    }
}
