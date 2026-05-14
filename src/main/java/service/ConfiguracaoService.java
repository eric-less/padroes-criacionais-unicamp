package br.unicamp.padroescriacionais.legacy.service;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;

public class ConfiguracaoService {
    private final ConfiguracaoSistema configuracao = ConfiguracaoSistema.getInstancia();

    public ConfiguracaoSistema getConfiguracao() {
        return configuracao;
    }

    public void exibirConfiguracao() {
        System.out.println("=== Configuracao do Sistema ===");
        System.out.println("Empresa    : " + configuracao.getNomeEmpresa());
    }
}
