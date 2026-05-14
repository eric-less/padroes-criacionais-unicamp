package br.unicamp.padroescriacionais.legacy;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;
import br.unicamp.padroescriacionais.legacy.service.ConfiguracaoService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ConfiguracaoSistemaTest {

    @BeforeEach
    void reset() { ConfiguracaoSistema.reset(); }

    @Test
    void deveRetornarMesmaInstanciaSingleton() {
        ConfiguracaoSistema c1 = ConfiguracaoSistema.getInstancia();
        ConfiguracaoSistema c2 = ConfiguracaoSistema.getInstancia();
        assertSame(c1, c2);
    }

    @Test
    void alteracaoDeveSerCompartilhada() {
        ConfiguracaoSistema c1 = ConfiguracaoSistema.getInstancia();
        ConfiguracaoSistema c2 = ConfiguracaoSistema.getInstancia();
        c1.setAmbiente("PROD");
        assertEquals("PROD", c2.getAmbiente());
    }

    @Test
    void configuracaoServiceDeveRetornarConfiguracaoNaoNula() {
        ConfiguracaoService service = new ConfiguracaoService();
        assertNotNull(service.getConfiguracao());
    }
}
