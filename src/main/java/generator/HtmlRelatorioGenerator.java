package br.unicamp.padroescriacionais.legacy.generator;

import br.unicamp.padroescriacionais.legacy.domain.Relatorio;

public class HtmlRelatorioGenerator implements RelatorioGenerator {
    public String gerar(Relatorio relatorio) {
        return "<html><body><h1>" + relatorio.getTitulo() + "</h1><p>" + relatorio.getConteudo() + "</p></body></html>";
    }
}
