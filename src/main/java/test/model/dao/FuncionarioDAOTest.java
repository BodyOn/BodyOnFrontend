package test.model.dao;

import model.dao.FuncionarioDAO;
import model.database.Database;
import model.database.DatabaseFactory;
import model.domain.Funcionario;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.Connection;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/** 
* FuncionarioDAO Tester. 
* 
* @author <Authors name> 
* @since <pre>nov. 15, 2022</pre> 
* @version 1.0 
*/ 
public class FuncionarioDAOTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getConnection() 
* 
*/ 
@Test
public void testGetConnection() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    FuncionarioDAO funcionario = new FuncionarioDAO();

    funcionario.setConnection(conn);
    Connection newConn = funcionario.getConnection();
    assertEquals(conn, newConn);
} 

/** 
* 
* Method: setConnection(Connection connection) 
* 
*/ 
@Test
public void testSetConnection() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    FuncionarioDAO funcionario = new FuncionarioDAO();

    funcionario.setConnection(conn);
    Connection newConn = funcionario.getConnection();
    assertEquals(conn, newConn);
} 

/** 
* 
* Method: insert(Funcionario funcionario) 
* 
*/ 
@Test
public void testInsert() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    FuncionarioDAO funcionario = new FuncionarioDAO();
    funcionario.setConnection(conn);

    Funcionario funcionarioTeste = new Funcionario(133, "Nome Teste", "Cpf Teste", "Email Teste", "Telefone Teste", "Endereco Teste", "Cargo Teste", "Horario Teste");
    boolean resposta = funcionario.insert(funcionarioTeste);

    assertEquals(true, resposta);
} 

/** 
* 
* Method: update(Funcionario funcionario) 
* 
*/ 
@Test
public void testUpdate() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    FuncionarioDAO funcionario = new FuncionarioDAO();
    funcionario.setConnection(conn);

    Funcionario funcionarioTeste = new Funcionario(133, "Nome Teste Teste", "Cpf Teste", "Email Teste", "Telefone Teste", "Endereco Teste", "Cargo Teste", "Horario Teste");
    boolean resposta = funcionario.update(funcionarioTeste);

    assertEquals(true, resposta);
} 

/** 
* 
* Method: delete(Funcionario funcionario) 
* 
*/ 
@Test
public void testDelete() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    FuncionarioDAO funcionario = new FuncionarioDAO();
    funcionario.setConnection(conn);

    Funcionario funcionarioTeste = new Funcionario(133, "Nome Teste Teste", "Cpf Teste", "Email Teste", "Telefone Teste", "Endereco Teste", "Cargo Teste", "Horario Teste");
    boolean resposta = funcionario.delete(funcionarioTeste);

    assertEquals(true, resposta);
} 

/** 
* 
* Method: list() 
* 
*/ 
@Test
public void testList() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    FuncionarioDAO funcionario = new FuncionarioDAO();
    funcionario.setConnection(conn);
    List<Funcionario> resposta = funcionario.list();
    assertNotNull(resposta);
} 

/** 
* 
* Method: search(Funcionario funcionario) 
* 
*/ 
@Test
public void testSearch() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    FuncionarioDAO funcionario = new FuncionarioDAO();
    funcionario.setConnection(conn);

    Funcionario funcionarioTeste = new Funcionario(133, "Nome Teste Teste", "Cpf Teste", "Email Teste", "Telefone Teste", "Endereco Teste", "Cargo Teste", "Horario Teste");
    Funcionario resposta = funcionario.search(funcionarioTeste);

    assertNotNull(resposta);
} 


} 
