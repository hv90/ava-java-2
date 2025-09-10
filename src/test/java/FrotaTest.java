import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FrotaTest {

    // private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    // private final PrintStream originalOut = System.out;

    // @BeforeEach
    // void setUpStreams() {
    //     System.setOut(new PrintStream(outContent));
    // }

    // @AfterEach
    // void restoreStreams() {
    //     System.setOut(originalOut);
    // }

    @Test
    void testFrotaCompleta() {
        System.out.println(">>> Iniciando teste de frota completa...");

        // Dados: 10 aviões + 10 navios
        Object[][] dados = {
            {"PT-ABC", 5000, 180, 120000000.0, "2024-01-10"},
            {"PT-DEF", 7000, 220, 150000000.0, "2025-03-20"},
            {"PT-GHI", 6000, 200, 140000000.0, "2024-12-05"},
            {"PT-JKL", 8000, 250, 160000000.0, "2023-07-15"},
            {"PT-MNO", 7500, 230, 155000000.0, "2024-09-22"},
            {"PT-PQR", 7200, 210, 152000000.0, "2023-11-11"},
            {"PT-STU", 6500, 190, 145000000.0, "2025-06-06"},
            {"PT-VWX", 9000, 280, 170000000.0, "2025-01-30"},
            {"PT-YZA", 8800, 270, 168000000.0, "2024-08-18"},
            {"PT-BCD", 7700, 240, 157000000.0, "2023-10-25"},

            {"Titanic II", 100000, 3000, 900, 200000000.0, "2018-05-01"},
            {"Queen Mary", 120000, 3500, 1000, 250000000.0, "2019-07-12"},
            {"Costa Luminosa", 110000, 3200, 950, 230000000.0, "2020-02-22"},
            {"MSC Fantasia", 130000, 4000, 1100, 280000000.0, "2021-09-14"},
            {"Harmony", 150000, 5000, 1500, 350000000.0, "2022-01-01"},
            {"Norwegian Joy", 125000, 3600, 1050, 260000000.0, "2019-11-19"},
            {"Aida Nova", 135000, 4200, 1150, 290000000.0, "2020-03-03"},
            {"Oasis", 140000, 4800, 1400, 330000000.0, "2021-04-17"},
            {"Symphony", 145000, 4900, 1450, 340000000.0, "2022-12-25"},
            {"Celebrity Edge", 115000, 3100, 920, 220000000.0, "2018-06-09"}
        };

        Transporte[] frota = new Transporte[20];

        // Primeiros 10 são Aviões
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Criando Avião " + (i+1) + " ---");
            Aviao a = new Aviao();
            a.setPrefixo((String) dados[i][0]);
            a.setCapacidadeTanque((Integer) dados[i][1]);
            a.setNumeroPassageiros((Integer) dados[i][2]);
            a.setPreco((Double) dados[i][3]);
            a.setDataRevisao((String) dados[i][4]);
            frota[i] = a;

            System.out.println("Definido: " + a);

            // Testa getters
            assertEquals(dados[i][0], a.getPrefixo());
            assertEquals(dados[i][1], a.getCapacidadeTanque());
            assertEquals(dados[i][2], a.getNumeroPassageiros());
            assertEquals(dados[i][3], a.getPreco());
            assertEquals(dados[i][4], a.getDataRevisao());
            System.out.println("Getters validados com sucesso.");

            // Testa reajuste de preço
            double precoAntigo = a.getPreco();
            a.reajustarPreco(10); // +10%
            assertEquals(precoAntigo * 1.1, a.getPreco(), 0.0001);
            System.out.println("Reajuste de preço validado. Novo preço: " + a.getPreco());
        }

        // Próximos 10 são Navios
        for (int i = 10; i < 20; i++) {
            System.out.println("\n--- Criando Navio " + (i-9) + " ---");
            Navio n = new Navio();
            n.setNome((String) dados[i][0]);
            n.setCapacidadeTanque((Integer) dados[i][1]);
            n.setNumeroPassageiros((Integer) dados[i][2]);
            n.setNumeroTripulantes((Integer) dados[i][3]);
            n.setPreco((Double) dados[i][4]);
            n.setDataLancamento((String) dados[i][5]);
            frota[i] = n;

            System.out.println("Definido: " + n);

            // Testa getters
            assertEquals(dados[i][0], n.getNome());
            assertEquals(dados[i][1], n.getCapacidadeTanque());
            assertEquals(dados[i][2], n.getNumeroPassageiros());
            assertEquals(dados[i][3], n.getNumeroTripulantes());
            assertEquals(dados[i][4], n.getPreco());
            assertEquals(dados[i][5], n.getDataLancamento());
            System.out.println("Getters validados com sucesso.");

            // Testa divisão passageiros/tripulantes
            double esperado = (double) n.getNumeroPassageiros() / n.getNumeroTripulantes();
            assertEquals(esperado, n.passageirosPorTripulantes(), 0.0001);
            System.out.println("Razão passageiros/tripulantes validada: " + esperado);
        }

        // Testa imprimir (captura stdout)
        // outContent.reset();
        frota[0].imprimir();
        // String saida = outContent.toString();
        // assertTrue(saida.contains("Prefixo"));
        // System.out.println("\nImpressão testada com sucesso. Saída capturada: " + saida.trim());

        System.out.println("\n>>> Todos os testes passaram com sucesso! <<<");
    }
}
