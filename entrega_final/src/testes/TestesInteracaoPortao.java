package testes;

import classes.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class TestesInteracaoPortao {
    
    @Test
    public void testInteragirPortao1() {
        Garagem garagem = new Garagem(false, 10, 3);
        garagem.abrir_Portao();
        assertEquals(true, garagem.isEstado());
    }

    @Test
    public void testInteragirPortao2() {
        Garagem garagem = new Garagem(true, 60, 13);
        garagem.fechar_Portao();
        assertEquals(false, garagem.isEstado());
    }

    @Test
    public void testInteragirPortao3() {
        Garagem garagem = new Garagem(true, 40, 22);
        garagem.fechar_Portao();
        assertNotEquals(true, garagem.isEstado());
    }
}
