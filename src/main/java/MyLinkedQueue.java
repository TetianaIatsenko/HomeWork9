public class MyLinkedQueue<T> extends MyCollection implements MyQueue<T>{
    private class Element<T>{
        private T value;
        private Element<T> prev;
        public Element(T value, Element prev){
            this.value = value;
            this.prev = prev;
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

        @Override
        public String toString() {
            return "Element{" +
                    "value=" + value +
                    '}';
        }
    }
    private Element<T> lastElement;

    @Override
    public boolean add(T value) {
        if(lastElement == null){
            lastElement = new Element<T>(value, null);
        }else{
            Element<T> element = new Element<>(value, lastElement);
            lastElement = element;
        }
        size++;
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
        Element<T> element = lastElement;
        while (element.getPrev() != null){
            element = element.getPrev();
        }
        return element.getValue();
    }

    @Override
    public T poll() {
        if(lastElement == null)
            return null;
        T value;
        if(lastElement.getPrev() == null){
            value = lastElement.getValue();
            lastElement = null;
        }else {
            Element<T> element = lastElement;
            Element<T> nextElement = lastElement;
            while (element.getPrev() != null) {
                nextElement = element;
                element = element.getPrev();
            }
            nextElement.setPrev(null);
            value = element.getValue();
        }
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
            builder.insert(1, element.getValue() + ((element == lastElement)?"":", "));
            element = element.getPrev();
        }
        builder.append("]");
        return builder.toString();
    }
}
