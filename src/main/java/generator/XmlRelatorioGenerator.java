package br.unicamp.padroescriacionais.legacy.generator;

import br.unicamp.padroescriacionais.legacy.domain.Relatorio;

public class XmlRelatorioGenerator implements RelatorioGenerator {
    public String gerar(Relatorio relatorio) {
        return "<relatorio><titulo>" + relatorio.getTitulo() + "</titulo><tipo>" + relatorio.getTipo() + "</tipo><conteudo>" + relatorio.getConteudo() + "</conteudo></relatorio>";
    }
}
