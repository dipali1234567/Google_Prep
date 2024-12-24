public class linkedlist {

    

    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        head.next = second;
        second.next = third;

        System.out.println(head.data);
    }
}


    
