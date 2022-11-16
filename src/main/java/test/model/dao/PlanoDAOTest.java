package test.model.dao;

import model.dao.PlanoDAO;
import model.database.Database;
import model.database.DatabaseFactory;
import model.domain.Plano;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.Connection;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/** 
* PlanoDAO Tester. 
* 
* @author <Authors name> 
* @since <pre>nov. 15, 2022</pre> 
* @version 1.0 
*/ 
public class PlanoDAOTest { 

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
    PlanoDAO plano = new PlanoDAO();
    plano.setConnection(conn);

    Connection newConn = plano.getConnection();
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
    PlanoDAO plano = new PlanoDAO();
    plano.setConnection(conn);

    Connection newConn = plano.getConnection();
    assertEquals(conn, newConn);
} 

/** 
* 
* Method: insert(Plano plano) 
* 
*/ 
@Test
public void testInsert() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    PlanoDAO plano = new PlanoDAO();
    plano.setConnection(conn);

    Plano planoTeste = new Plano(133, "Nome Teste", "Descricao Teste", 23.5);
    boolean resposta = plano.insert(planoTeste);

    assertEquals(true, resposta);
} 

/** 
* 
* Method: update(Plano plano) 
* 
*/ 
@Test
public void testUpdate() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    PlanoDAO plano = new PlanoDAO();
    plano.setConnection(conn);

    Plano planoTeste = new Plano(133, "Nome Teste Teste", "Descricao Teste", 23.5);
    boolean resposta = plano.update(planoTeste);

    assertEquals(true, resposta);
} 

/** 
* 
* Method: delete(Plano plano) 
* 
*/ 
@Test
public void testDelete() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    PlanoDAO plano = new PlanoDAO();
    plano.setConnection(conn);

    Plano planoTeste = new Plano(133, "Nome Teste", "Descricao Teste", 23.5);
    boolean resposta = plano.delete(planoTeste);

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
    PlanoDAO plano = new PlanoDAO();
    plano.setConnection(conn);

    List<Plano> resposta = plano.list();
    assertNotNull(resposta);
} 

/** 
* 
* Method: search(Plano plano) 
* 
*/ 
@Test
public void testSearch() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    PlanoDAO plano = new PlanoDAO();
    plano.setConnection(conn);

    Plano planoTeste = new Plano(133, "Nome Teste", "Descricao Teste", 23.5);
    Plano resposta = plano.search(planoTeste);

    assertNotNull(resposta);
} 


} 
