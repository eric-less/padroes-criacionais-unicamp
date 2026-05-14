package br.unicamp.padroescriacionais.legacy;

import br.unicamp.padroescriacionais.legacy.domain.*;
import br.unicamp.padroescriacionais.legacy.service.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ExportacaoServiceTest {
    @Test
    void todosFormatosDevemSerExportadosSemErro() {
        ExportacaoService exportacaoService = new ExportacaoService();
        RelatorioService relatorioService = new RelatorioService();

        for (FormatoRelatorio formato : FormatoRelatorio.values()) {
            Relatorio relatorio = relatorioService.criarRelatorio(TipoRelatorio.VENDAS);
            assertDoesNotThrow(() -> exportacaoService.exportar(relatorio, formato));
        }
    }
}
