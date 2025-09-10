import java.util.Locale;
import java.util.Scanner;

public class Aviao extends Transporte {
    protected String prefixo;
    protected String dataRevisao;

    // Construtor default
    public Aviao() { super(); }

    // Construtor completo (inclui comuns + próprios)
    public Aviao(String prefixo, String dataRevisao, int capacidadeTanque, int numeroPassageiros, double preco) {
        super(capacidadeTanque, numeroPassageiros, preco);
        setPrefixo(prefixo);
        setDataRevisao(dataRevisao);
    }

    public String getPrefixo() { return prefixo; }
    public void setPrefixo(String prefixo) {
        if (prefixo == null || prefixo.trim().isEmpty())
            throw new IllegalArgumentException("Prefixo inválido.");
        this.prefixo = prefixo.trim();
    }

    public String getDataRevisao() { return dataRevisao; }
    public void setDataRevisao(String dataRevisao) {
        if (dataRevisao == null || dataRevisao.trim().isEmpty())
            throw new IllegalArgumentException("Data de revisão inválida.");
        this.dataRevisao = dataRevisao.trim();
    }

    // Lê próprios + comuns (da super)
    @Override
    public void entrada() {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        setPrefixo(readNonEmpty(sc, "Prefixo (texto): "));
        setDataRevisao(readNonEmpty(sc, "Data da revisão (texto): "));
        super.entrada();
    }

    @Override
    public void imprimir() {
        System.out.println("=== AVIÃO ===");
        System.out.println("Prefixo: " + prefixo);
        System.out.println("Data de revisão: " + dataRevisao);
        super.imprimir();
    }
}
