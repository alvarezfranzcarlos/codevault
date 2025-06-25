import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DiffArrayLinked {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        arrayList.add("A");
        linkedList.add("A");

        System.out.println(arrayList.get(0)); // Acceso rápido
        System.out.println(linkedList.get(0)); // Acceso lento
    }

}
