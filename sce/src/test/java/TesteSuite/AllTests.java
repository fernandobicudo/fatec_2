package TesteSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fatec.sce.TestaConexaoComDB;
import com.fatec.sce.UC01CadastrarLivro;
import com.fatec.sce.UC05CadastrarUsuario;

@RunWith(Suite.class)
@SuiteClasses({ UC01CadastrarLivro.class, UC05CadastrarUsuario.class, TestaConexaoComDB.class })
public class AllTests {
}