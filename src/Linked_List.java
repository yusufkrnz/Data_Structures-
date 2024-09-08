/**  ilk soru node larla ilgili bilgiler mevcut*/
   class nNode {

    /*  NODE ların yapıları
     *
     *                              ------> DATA
     * 2 temel parça dan oluşur ---|
     *                              ------>pointer----(BAĞLANTI)
     *                                 --BİR SONRAKİ NODE UN ADRSİNİ TUTAR---
     *  */
    int data;
    /**
     * --- TÜRÜ Node olan değişkenin ismi next---
     */
   Node next;

    nNode(int data) {
        this.data = data;
        this.next = null; // başlangıçta başka düğüm yok diye null
    }

}


public class Linked_List {
    Node head;//ilk düğümü işaret eder

    /**
     * Node un varlığını sınadık
     * Şayet yoksa
     * oluşturduk ve atadık
     */

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }


    public int findMiddle() {

        if (head == null) {
            return -1;//Liste boşşsa
        }

        /**  Floyd's Tortoise and Hare Algorithm  */

        /*Bu mekanizma,
         "Floyd's Tortoise and Hare Algorithm"
          olarak da bilinir
          ve slow göstericisinin
          neden tam ortadaki düğümü
          işaret ettiğini
          */


        Node slow = head;
        Node fast = head;


        while (fast != null && fast.next != null) {
            // slow tek tek deniyor
            slow = slow.next;
            // fast 2 2 arıyor
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        Linked_List list=new Linked_List();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println("orta elaman : " + list.findMiddle());

    }


}

