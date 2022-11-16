package test.model.dao; 

import model.dao.ClienteDAO;
import model.dao.DonoDAO;
import model.database.Database;
import model.database.DatabaseFactory;
import model.domain.Cliente;
import model.domain.Dono;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class DonoDAOTest { 

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
    DonoDAO dono = new DonoDAO();

    dono.setConnection(conn);
    Connection newConn = dono.getConnection();
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
    DonoDAO dono = new DonoDAO();

    dono.setConnection(conn);
    Connection newConn = dono.getConnection();
    assertEquals(conn, newConn);
} 

/** 
* 
* Method: insert(Dono dono) 
* 
*/ 
@Test
public void testInsert() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    DonoDAO dono = new DonoDAO();

    Dono donoTeste = new Dono(133, "Nome Teste", "Cpf Test", "Email Teste", "Telefone Test", "Endereco Test", "Cargo Teste", "Horario Teste", "Senha Teste");
    dono.setConnection(conn);
    boolean resposta = dono.insert(donoTeste);

    assertEquals(true, resposta);
} 

/** 
* 
* Method: update(Dono dono) 
* 
*/ 
@Test
public void testUpdate() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    DonoDAO dono = new DonoDAO();

    Dono donoTeste = new Dono(133, "Update Teste", "Cpf Test", "Email Teste", "Telefone Test", "Endereco Test", "Cargo Teste", "Horario Teste", "Senha Teste");
    dono.setConnection(conn);
    boolean resposta = dono.update(donoTeste);

    assertEquals(true, resposta);
} 

/** 
* 
* Method: delete(Dono dono) 
* 
*/ 
@Test
public void testDelete() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    DonoDAO dono = new DonoDAO();

    Dono donoTeste = new Dono(133, "Update Teste", "Cpf Test", "Email Teste", "Telefone Test", "Endereco Test", "Cargo Teste", "Horario Teste", "Senha Teste");
    dono.setConnection(conn);
    boolean resposta = dono.delete(donoTeste);

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
    DonoDAO dono = new DonoDAO();
    dono.setConnection(conn);
    List<Dono> resposta = dono.list();
    assertNotNull(resposta);
} 

/** 
* 
* Method: search(Dono dono) 
* 
*/ 
@Test
public void testSearch() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    DonoDAO dono = new DonoDAO();
    Dono donoTeste = new Dono(133, "Update Teste", "Cpf Test", "Email Teste", "Telefone Test", "Endereco Test", "Cargo Teste", "Horario Teste", "Senha Teste");
    dono.setConnection(conn);
    Dono resposta = dono.search(donoTeste);

    assertNotNull(resposta);
} 


} 
