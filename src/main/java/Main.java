public class Main {
    public static void main(String [] args){
        MyArrayList<String> list2 = new MyArrayList<>();
        System.out.println("Size " + list2.size());
        list2.add("20");
        System.out.println(list2);
        System.out.println("get " + list2.get(0));
        list2.remove(0);
        list2.add("21");
        list2.add("22");
        list2.add("23");
        list2.add("24");
        System.out.println(list2);
        list2.remove(0);
        System.out.println(list2);
        list2.remove(2);
        System.out.println(list2);
        System.out.println("Size " + list2.size());
        System.out.println("get " + list2.get(1));



        MyLinkedList<String> list = new MyLinkedList<>();
        System.out.println("Size " + list.size());
        list.add("20");
        System.out.println(list);
        System.out.println("get " + list.get(0));
        list.remove(0);
        System.out.println(list);
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("25");
        list.add("26");

        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println("Size " + list.size());
        System.out.println("get " + list.get(3));
        list.remove(3);
        System.out.println(list);

    }
}
