import java.util.*;

public class Bnode {
    int x;
    char letra;
    Bnode esq;
    Bnode dir;
    String codigoBinario;

    public Bnode(int valor, char letra) {
        this.x = valor;
        this.letra = letra;
        this.esq = this.dir = null;
    }

    public void show() {
        System.out.println(x);
        if (dir != null) dir.show();
        if (esq != null) esq.show();
    }

    public void folhas(String codigoBinario, List<Bnode> folhas) {
        if (esq == null && dir == null) {
            this.codigoBinario = codigoBinario;
            folhas.add(this);
        }

        if (dir != null) dir.folhas(codigoBinario + "1", folhas);
        if (esq != null) esq.folhas(codigoBinario + "0", folhas);
    }
}
