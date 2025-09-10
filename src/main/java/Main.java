import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        // Vetor ÚNICO polimórfico: 10 Aviões + 10 Navios
        Transporte[] frota = new Transporte[20];

        // Primeiros 10: Aviões (construtor default + entrada protegida)
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Entrada de dados (Avião " + (i + 1) + ") ---");
            Aviao a = new Aviao(); // construtor vazio
            a.entrada();           // trata exceções de Scanner internamente
            frota[i] = a;
        }

        // Próximos 10: Navios (construtor default + entrada protegida)
        for (int i = 10; i < 20; i++) {
            System.out.println("\n--- Entrada de dados (Navio " + (i - 9) + ") ---");
            Navio n = new Navio(); // construtor vazio
            n.entrada();           // trata exceções de Scanner internamente
            frota[i] = n;
        }

        // Exibição
        System.out.println("\n================== DADOS DA FROTA ==================");
        for (Transporte t : frota) {
            t.imprimir();
            System.out.println();
        }

        // Exemplo de uso de reajuste (apenas para ilustrar)
        System.out.println("Aplicando reajuste de +5% no preço do primeiro item da frota...");
        frota[0].reajustarPreco(5.0);
        frota[0].imprimir();
    }
}
