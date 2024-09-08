import java.rmi.UnexpectedException;
import java.util.LinkedList;


/**
 * Soru: Bir Linked List içinde
 * bir düğümü silen bir fonksiyon yaz.
 * <p>
 * Verilen düğüm,
 * silinmek istenen düğümdür
 * ve bu düğümün kendisi hariç
 * tüm verileri bilinir.
 * Linked List'in başından
 * veya sonundan bir düğüm
 * silinmesi gerekmez;
 * sadece arada
 * bir düğüm verilir.
 * <p>
 * İpucu: Düğümün datasını
 * bir sonraki düğümün datası
 * ile değiştirip,
 * bir sonraki düğümü silebilirsin.
 */


public class Linked_List_delete {


    Node head;

    public void add(int data) {

        Node newNodee = new Node(data);

        if (head == null) {
            head = newNodee;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNodee;
        }

    }

    // Düğüm silme metodu
    public void delete(int data) {
        // Eğer liste boşsa
        if (head == null) {
            System.out.println("Liste boş, silinecek bir şey yok.");
            return;
        }

        // Eğer silinecek düğüm baştaysa
        if (head.data == data) {
            head = head.next;  // Head'i bir sonrakine kaydır
            return;
        }

        Node current = head;
        Node previous = null;

        // Silinecek düğümü bulana kadar gez
        while (current != null && current.data != data) {
            previous = current;  // Bir önceki düğümü sakla
            current = current.next;  // Sonraki düğüme geç
        }

        // Eğer düğüm bulunamazsa
        if (current == null) {
            System.out.println("Veri bulunamadı: " + data);
            return;
        }

        // Ortadaki bir düğümse
        if (current.next != null) {
            previous.next = current.next;  // Bir önceki düğüm, silinen düğümün sonrasına işaret eder
        } else {
            previous.next = null;  // Son düğümse, bir önceki düğümün bağlantısını kes
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Linked_List_delete list = new Linked_List_delete();


        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);

        System.out.println("Başlangıç listesi:");
        list.printList();

        // Bir elemanı silin
        list.delete(30);

        // Güncellenmiş listeyi yazdır
        System.out.println("Güncellenmiş liste:");
        list.printList();


    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}