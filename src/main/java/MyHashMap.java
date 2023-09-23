public class MyHashMap<K, V> extends MyCollection implements MyMap<K, V>{
    private static int ARRAY_LENGTH = 20;
    private Element<K, V>[] array;

    private class Element<K, V>{
        int hashCode;
        K key;
        V value;
        Element<K, V> nextElement;

        public Element(K key, V value) {
            this.hashCode = getHashCode(key);
            this.key = key;
            this.value = value;
            this.nextElement = null;
        }

        public void setNextElement(Element<K, V> nextElement) {
            this.nextElement = nextElement;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getHashCode() {
            return hashCode;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Element<K, V> getNextElement() {
            return nextElement;
        }

        public static Integer getHashCode(Object key){
            if(key == null)
                return 0;
            return key.hashCode();
        }
    }

    public MyHashMap(){
        array = new Element[ARRAY_LENGTH];
        size = 0;
    }
    @Override
    public boolean put(K key, V value) {
        Element<K, V> element = new Element<>(key, value);
        int index = getIndex(element.getHashCode());
        Element<K,V> elementInArray = array[index];
        if(elementInArray == null){
            array[index] = element;
            size++;
            return true;
        }
        while (elementInArray != null){
            if(isKeyEquals(element.getKey(), elementInArray.getKey())) {
                elementInArray.setValue(element.getValue());
                return false;
            }
            if(elementInArray.getNextElement() == null){
                elementInArray.setNextElement(element);
                size++;
                return true;
            }
            elementInArray = elementInArray.getNextElement();
        }
        return false;
    }

    private boolean isKeyEquals(K key1, K key2){
        return Element.getHashCode(key1).equals(Element.getHashCode(key2));
    }

    private int getIndex(int hashCode){
        return hashCode & (ARRAY_LENGTH-1);
    }

    @Override
    public V remove(K key) {
        int index = getIndex(Element.getHashCode(key));
        Element<K, V> element = array[index];
        Element<K, V> prevElement = null;
        while (element != null){

            if(isKeyEquals(element.getKey(), key)){
                if(prevElement == null){
                    array[index] = element.getNextElement();
                }else {
                    prevElement.setNextElement(element.getNextElement());
                }
                size--;
                return element.getValue();
            }
            prevElement = element;
            element = element.getNextElement();
        }
        return null;
    }

    @Override
    public void clear() {
        this.array = new Element[ARRAY_LENGTH];
        this.size = 0;
    }

    @Override
    public V get(K key) {
        int index = getIndex(Element.getHashCode(key));
        Element<K, V> element = array[index];
        while (element != null){
            if(isKeyEquals(element.getKey(), key)){
                return element.getValue();
            }
            element = element.getNextElement();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Element<K, V> element :
                array) {
            while (element != null){
                builder.append(element.getKey() + " = " + element.getValue());
                builder.append("; ");
                element = element.getNextElement();
            }
        }
        if(builder.length() > 2)
            builder.replace(builder.length()-2, builder.length(), "");
        builder.append("]");
        return builder.toString();
    }
}
