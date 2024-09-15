import java.util.*;

public class Main {
    static class LetraFrequencia {
        char letra;
        int frequencia;

        LetraFrequencia(char letra, int frequencia) {
            this.letra = letra;
            this.frequencia = frequencia;
        }
    }

    public static void main(String[] args) {
        List<LetraFrequencia> frequencias = new ArrayList<>();
        Btree crip = new Btree();
        String palavra = "abracadabra";
        int count[] = new int[255];

        for (int i = 0; i < palavra.length(); i++) {
            char c = palavra.charAt(i);
            count[c - 'a']++;
        }

        System.out.println("Frequência das letras:");
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                char letra = (char) (i + 'a');
                frequencias.add(new LetraFrequencia(letra, count[i]));
                System.out.println(letra + ": " + count[i]);
            }
        }

        // Ordenar pela frequência
        for (int i = 0; i < frequencias.size(); i++) {
            for (int j = i + 1; j < frequencias.size(); j++) {
                if (frequencias.get(j).frequencia < frequencias.get(i).frequencia) {
                    LetraFrequencia temp = frequencias.get(i);
                    frequencias.set(i, frequencias.get(j));
                    frequencias.set(j, temp);
                }
            }
        }

        for (int i = 0; i < frequencias.size(); i++) {
            LetraFrequencia lf = frequencias.get(i);
            crip.add(lf.frequencia, lf.letra);
        }

        System.out.println("\nÁrvore:");
        crip.show();

        System.out.println("\nFolhas:");
        crip.folhas();

        System.out.println("\nConversão de texto:");
        crip.word(palavra);
    }
}
