package br.unicamp.padroescriacionais.legacy.service;

import br.unicamp.padroescriacionais.legacy.domain.*;
import br.unicamp.padroescriacionais.legacy.factory.RelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;

import java.time.LocalDateTime;

public class RelatorioService {
    private final ConfiguracaoSistema configuracao = ConfiguracaoSistema.getInstancia();

    public Relatorio criarRelatorio(TipoRelatorio tipo) {
        return new Relatorio("Relatorio de " + tipo.name(), "Conteudo de " + tipo.name(), tipo, LocalDateTime.now());
    }

    public String gerarRelatorio(TipoRelatorio tipo, FormatoRelatorio formato) {
        if (configuracao.isDebugAtivo()) {
            System.out.println("[DEBUG] Gerando relatorio");
        }
        RelatorioGenerator generator = RelatorioGeneratorFactory.criar(formato);
        return generator.gerar(criarRelatorio(tipo));
    }
}
