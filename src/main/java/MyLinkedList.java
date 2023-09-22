public class MyLinkedList<T> extends MyKollection implements MyList<T>{
    private class Element<T>{
        private T value;
        private Element<T> prev;
        private Element<T> next;

        public Element(Element prev, Element next, T value){
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
        public Element(Element prev, T value){
            this(prev, null, value);
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Element<T> getPrev() {
            return prev;
        }

        public void setPrev(Element<T> prev) {
            this.prev = prev;
        }

        public Element<T> getNext() {
            return next;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "value=" + value +
                    '}';
        }
    }

    private Element<T> firstElement;
    private Element<T> lastElement;

    @Override
    public boolean add(T value) {
        Element<T> element;
        if(firstElement == null){
             element = new Element<>(null, value);
             firstElement = element;
             lastElement = element;
        }else {
            element = new Element<>(lastElement, value);
            lastElement.setNext(element);
            lastElement = element;
        }
        element.setValue(value);
        size++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if(index >= size)
            throw new IndexOutOfBoundsException(getExceptionString(index, size));
        Element<T> element = firstElement;
        size--;
        for(int i = 1; i <= index; i ++){
            element = element.getNext();
        }
        Element<T> prev = element.getPrev();
        Element<T> next = element.getNext();
        if(prev == null && next == null){
            firstElement = null;
            lastElement = null;
            return true;
        }
        if(prev == null){
            firstElement = next;
        }else {
            prev.setNext(next);
        }
        if(next == null){
            lastElement = prev;
        }else {
            next.setPrev(prev);
        }
        return true;
    }

    @Override
    public void clear() {
        lastElement = null;
        firstElement = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if(index >= size)
            throw new IndexOutOfBoundsException(getExceptionString(index, size));
        Element<T> element = firstElement;
        for(int i = 1; i <= index; i++){
            element = element.getNext();
        }
        return element.getValue();
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Element<T> element = firstElement;
        builder.append("[");

        for (int i = 0; i < size; i++){
            builder.append(element.getValue());
            if(element.getNext() != null)
                builder.append(" ,");
            element = element.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

}
