package br.unicamp.padroescriacionais.legacy.service;

import br.unicamp.padroescriacionais.legacy.domain.*;
import br.unicamp.padroescriacionais.legacy.factory.RelatorioGeneratorFactory;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;

public class ExportacaoService {
    private final ConfiguracaoSistema configuracao = ConfiguracaoSistema.getInstancia();

    public void exportar(Relatorio relatorio, FormatoRelatorio formato) {
        RelatorioGenerator generator = RelatorioGeneratorFactory.criar(formato);
        String conteudoFormatado = generator.gerar(relatorio);

        String nomeArquivo = relatorio.getTitulo().replace(" ", "_").toLowerCase() + "." + formato.name().toLowerCase();
        String caminhoCompleto = configuracao.getDiretorioExportacao() + "/" + nomeArquivo;

        System.out.println("[EXPORTACAO] Empresa  : " + configuracao.getNomeEmpresa());
        System.out.println("[EXPORTACAO] Ambiente : " + configuracao.getAmbiente());
        System.out.println("[EXPORTACAO] Arquivo  : " + caminhoCompleto);
        System.out.println(conteudoFormatado);
    }
}
