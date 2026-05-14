package br.unicamp.padroescriacionais.legacy;

import br.unicamp.padroescriacionais.legacy.domain.*;
import br.unicamp.padroescriacionais.legacy.service.RelatorioService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class RelatorioServiceTest {
    private RelatorioService service;

    @BeforeEach
    void setUp() { service = new RelatorioService(); }

    @Test
    void todosFormatosDevemProduzirConteudoValido() {
        for (FormatoRelatorio formato : FormatoRelatorio.values()) {
            assertFalse(service.gerarRelatorio(TipoRelatorio.VENDAS, formato).isBlank());
        }
    }

    @Test
    void deveGerarXml() {
        assertTrue(service.gerarRelatorio(TipoRelatorio.CLIENTES, FormatoRelatorio.XML).contains("<relatorio>"));
    }

    @Test
    void deveGerarHtml() {
        assertTrue(service.gerarRelatorio(TipoRelatorio.CLIENTES, FormatoRelatorio.HTML).contains("<html>"));
    }
}
