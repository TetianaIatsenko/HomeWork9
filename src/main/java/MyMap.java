public interface MyMap<K, V> {
    public boolean put(K key, V value);
    public V remove(K key);
    public void clear();
    public int size();
    public V get(K key);
}
