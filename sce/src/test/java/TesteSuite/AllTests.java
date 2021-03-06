package TesteSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fatec.sce.TestaConexaoComDB;
import com.fatec.sce.UC01CadastrarLivro;
import com.fatec.sce.UC02ConsultarLivro;
import com.fatec.sce.UC05CadastrarUsuario;
import com.fatec.sce.UC06ConsultarUsuario;
import com.fatec.sce.UC09RegistrarEmprestimoDeLivro;
import com.fatec.sce.UC10ConsultarEmprestimo;

@RunWith(Suite.class)
@SuiteClasses({ 
	UC01CadastrarLivro.class, 
	UC02ConsultarLivro.class,
	UC05CadastrarUsuario.class, 
	UC06ConsultarUsuario.class,
	UC09RegistrarEmprestimoDeLivro.class,
	UC10ConsultarEmprestimo.class,
	TestaConexaoComDB.class, 
	})
public class AllTests {
}