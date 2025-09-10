import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Transporte {
    protected int capacidadeTanque;
    protected int numeroPassageiros;
    protected double preco;

    // Construtor default
    public Transporte() {}

    // Construtor completo (comuns)
    public Transporte(int capacidadeTanque, int numeroPassageiros, double preco) {
        setCapacidadeTanque(capacidadeTanque);
        setNumeroPassageiros(numeroPassageiros);
        setPreco(preco);
    }

    // Getters/Setters com validação simples
    public int getCapacidadeTanque() { return capacidadeTanque; }
    public void setCapacidadeTanque(int capacidadeTanque) {
        if (capacidadeTanque < 0) throw new IllegalArgumentException("Capacidade do tanque negativa.");
        this.capacidadeTanque = capacidadeTanque;
    }

    public int getNumeroPassageiros() { return numeroPassageiros; }
    public void setNumeroPassageiros(int numeroPassageiros) {
        if (numeroPassageiros < 0) throw new IllegalArgumentException("Número de passageiros negativo.");
        this.numeroPassageiros = numeroPassageiros;
    }

    public double getPreco() { return preco; }
    public void setPreco(double preco) {
        if (preco < 0) throw new IllegalArgumentException("Preço negativo.");
        this.preco = preco;
    }

    // Reajuste de preço (Aviao herda este comportamento)
    public void reajustarPreco(double percentual) {
        // percentual em % (ex.: 10.0 aumenta 10%)
        this.preco = this.preco * (1.0 + percentual / 100.0);
    }

    // -------- Entrada protegida por exceções --------
    protected static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int v = sc.nextInt();
                sc.nextLine(); // consome newline
                return v;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um inteiro.");
                sc.nextLine();
            }
        }
    }

    protected static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double v = sc.nextDouble();
                sc.nextLine();
                return v;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número (use vírgula ou ponto).");
                sc.nextLine();
            }
        }
    }

    protected static String readNonEmpty(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Texto vazio não é válido.");
        }
    }

    // Entrada dos campos COMUNS
    public void entrada() {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        setCapacidadeTanque(readInt(sc, "Capacidade do tanque (inteiro): "));
        setNumeroPassageiros(readInt(sc, "Número de passageiros (inteiro): "));
        setPreco(readDouble(sc, "Preço (real): "));
    }

    // Impressão dos campos COMUNS
    public void imprimir() {
        System.out.println("Capacidade do tanque: " + capacidadeTanque);
        System.out.println("Número de passageiros: " + numeroPassageiros);
        System.out.printf(Locale.US, "Preço: %.2f%n", preco);
    }
}
