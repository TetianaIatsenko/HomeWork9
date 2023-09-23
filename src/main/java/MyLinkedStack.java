public class MyLinkedStack<T> extends MyCollection implements MyStack<T>{
    private class Element<T>{
        private T value;
        private Element<T> prev;

        public Element(T value, Element prev){
            this.prev = prev;
            this.value = value;
        }
        public Element(T value){
            this(value, null);
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
    }
    private Element<T> lastElement;

    @Override
    public void push(T value) {
        if(lastElement == null){
            lastElement = new Element<>(value);
        }else{
            lastElement = new Element<>(value, lastElement);
        }
        size++;
    }

    @Override
    public boolean remove(int index) {
        if(index >= size)
            throw new IndexOutOfBoundsException("Steak have size = " + size + " , index is " + index);
        if(lastElement.getPrev() == null){
            lastElement = null;
        }else {
            Element<T> element = lastElement;
            Element<T> prev = lastElement.getPrev();
            Element<T> next = null;
            for (int i = 1; i <= index; i++) {
                next = element;
                element = prev;
                prev = element.getPrev();
            }
            next.setPrev(prev);

        }

        size--;
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        lastElement = null;
    }

    @Override
    public T peek() {
        if(lastElement == null)
            return null;
        return lastElement.getValue();
    }

    @Override
    public T pop() {
        if(lastElement == null)
            return null;
        T value = lastElement.getValue();
        lastElement = lastElement.getPrev();
        size--;
        return value;
    }
    @Override
    public String toString() {
        if(lastElement == null)
            return "[]";
        Element<T> element = lastElement;
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (element != null){
            builder.append(element.getValue());
            if(element.getPrev() != null){
                builder.append(", ");
            }
            element = element.getPrev();
        }
        builder.append("]");
        return builder.toString();
    }

}
