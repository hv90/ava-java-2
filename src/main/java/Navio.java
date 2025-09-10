import java.util.Locale;
import java.util.Scanner;

public class Navio extends Transporte {
    protected String nome;
    protected int numeroTripulantes;
    protected String dataLancamento;

    // Construtor 1: default
    public Navio() { super(); }

    // Construtor 2: nome
    public Navio(String nome) {
        super();
        setNome(nome);
    }

    // Construtor 3: nome + tripulantes
    public Navio(String nome, int numeroTripulantes) {
        super();
        setNome(nome);
        setNumeroTripulantes(numeroTripulantes);
    }

    // Construtor 4: nome + tripulantes + passageiros (comum)
    public Navio(String nome, int numeroTripulantes, int numeroPassageiros) {
        super(0, numeroPassageiros, 0.0);
        setNome(nome);
        setNumeroTripulantes(numeroTripulantes);
    }

    // Construtor 5: completo
    public Navio(String nome, int numeroTripulantes, int numeroPassageiros, double preco, String dataLancamento) {
        super(0, numeroPassageiros, preco);
        setNome(nome);
        setNumeroTripulantes(numeroTripulantes);
        setDataLancamento(dataLancamento);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Nome inválido.");
        this.nome = nome.trim();
    }

    public int getNumeroTripulantes() { return numeroTripulantes; }
    public void setNumeroTripulantes(int numeroTripulantes) {
        if (numeroTripulantes < 0) throw new IllegalArgumentException("Tripulantes negativo.");
        this.numeroTripulantes = numeroTripulantes;
    }

    public String getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(String dataLancamento) {
        if (dataLancamento == null || dataLancamento.trim().isEmpty())
            throw new IllegalArgumentException("Data de lançamento inválida.");
        this.dataLancamento = dataLancamento.trim();
    }

    // Leitura dos campos próprios + comuns
    @Override
    public void entrada() {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        setNome(readNonEmpty(sc, "Nome (texto): "));
        setDataLancamento(readNonEmpty(sc, "Data de lançamento (texto): "));
        setNumeroTripulantes(readInt(sc, "Número de tripulantes (inteiro): "));
        super.entrada();
    }

    public double passageirosPorTripulantes() {
        if (numeroTripulantes == 0) {
            // pode-se lançar exceção ou retornar 0/Double.POSITIVE_INFINITY; aqui, retornamos 0 por segurança
            return 0.0;
        }
        return (double) numeroPassageiros / (double) numeroTripulantes;
    }

    @Override
    public void imprimir() {
        System.out.println("=== NAVIO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Data de lançamento: " + dataLancamento);
        System.out.println("Número de tripulantes: " + numeroTripulantes);
        super.imprimir();
        System.out.printf(Locale.US, "Passageiros / Tripulante: %.2f%n", passageirosPorTripulantes());
    }
}
