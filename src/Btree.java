import java.util.*;

public class Btree {
    private Bnode raiz;

    public Btree() {
        this.raiz = null;
    }

    public void add(int valor, char letra) {
        if (raiz == null) {
            raiz = new Bnode(valor, letra);
        } else {
            if (valor < raiz.x) {
                Bnode novaRaiz = new Bnode(raiz.x + valor, raiz.letra);
                novaRaiz.dir = raiz;
                novaRaiz.esq = new Bnode(valor, letra);
                raiz = novaRaiz;
            } else {
                Bnode novaRaiz = new Bnode(raiz.x + valor, raiz.letra);
                novaRaiz.esq = raiz;
                novaRaiz.dir = new Bnode(valor, letra);
                raiz = novaRaiz;
            }
        }
    }

    public void show() {
        if (raiz != null) {
            raiz.show();
        }
    }

    public void folhas() {
        if (raiz != null) {
            List<Bnode> folhas = new ArrayList<>();
            raiz.folhas("", folhas);
            for (Bnode folha : folhas) {
                System.out.println("Letra: " + folha.letra + ", Binário: " + folha.codigoBinario);
            }
        }
    }

    public void word(String input) {
        if (raiz != null) {
            List<Bnode> folhas = new ArrayList<>();
            raiz.folhas("", folhas);

            List<Character> letras = new ArrayList<>();
            List<String> codigosBinarios = new ArrayList<>();
            for (int i = 0; i < folhas.size(); i++) {
                Bnode folha = folhas.get(i);
                letras.add(folha.letra);
                codigosBinarios.add(folha.codigoBinario);
            }

            StringBuilder binarioString = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                int index = letras.indexOf(c);
                if (index != -1) {
                    binarioString.append(codigosBinarios.get(index));
                }
            }

            // Completar os bits para formar um múltiplo de 8
            int comprimento = binarioString.length();
            int completamento = (8 - comprimento % 8) % 8;
            for (int i = 0; i < completamento; i++) {
                binarioString.append("0");
            }

            System.out.println("String binária antes da conversão: " + binarioString.toString());

            // Converter binário em ASCII
            StringBuilder asciiString = new StringBuilder();
            for (int i = 0; i < binarioString.length(); i += 8) {
                String byteString = binarioString.substring(i, i + 8);
                int valorAscii = Integer.parseInt(byteString, 2);
                asciiString.append((char) valorAscii);
            }

            System.out.println("Texto convertido: " + asciiString.toString());
        }
    }
}
