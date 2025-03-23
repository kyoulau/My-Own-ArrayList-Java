import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LauraArrayList<String> listaNomes = new LauraArrayList<>();

        listaNomes.add("Laura");
        listaNomes.add("Gustavo");
        listaNomes.add("Brigitte");
        listaNomes.add("Maria");

        System.out.println("Lista de nomes: " + listaNomes.toString());

        listaNomes.remove("Gustavo");
        System.out.println("Lista após remover elemento Gustavo: " + listaNomes.toString());

        listaNomes.remove(2);
        System.out.println("Lista após remover o elemento no índice 2:"+ listaNomes.toString());
    }
}