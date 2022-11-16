package test.model.dao; 

import model.dao.DonoDAO;
import model.dao.ExercicioDAO;
import model.database.Database;
import model.database.DatabaseFactory;
import model.domain.Dono;
import model.domain.Exercicio;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.Connection;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/** 
* ExercicioDAO Tester. 
* 
* @author <Authors name> 
* @since <pre>nov. 15, 2022</pre> 
* @version 1.0 
*/ 
public class ExercicioDAOTest { 

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
    ExercicioDAO exercicio = new ExercicioDAO();

    exercicio.setConnection(conn);
    Connection newConn = exercicio.getConnection();
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
    ExercicioDAO exercicio = new ExercicioDAO();

    exercicio.setConnection(conn);
    Connection newConn = exercicio.getConnection();
    assertEquals(conn, newConn);
} 

/** 
* 
* Method: insert(Exercicio exercicio) 
* 
*/ 
@Test
public void testInsert() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    ExercicioDAO exercicio = new ExercicioDAO();

    Exercicio exercicioTeste = new Exercicio(133, "Nome Teste", 4, 12, 1);
    exercicio.setConnection(conn);
    boolean resposta = exercicio.insert(exercicioTeste);

    assertEquals(true, resposta);
} 

/** 
* 
* Method: update(Exercicio exercicio) 
* 
*/ 
@Test
public void testUpdate() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    ExercicioDAO exercicio = new ExercicioDAO();

    Exercicio exercicioTeste = new Exercicio(133, "Nome Teste Teste", 4, 12, 1);
    exercicio.setConnection(conn);
    boolean resposta = exercicio.update(exercicioTeste);

    assertEquals(true, resposta);
} 

/** 
* 
* Method: delete(Exercicio exercicio) 
* 
*/ 
@Test
public void testDelete() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    ExercicioDAO exercicio = new ExercicioDAO();

    Exercicio exercicioTeste = new Exercicio(133, "Nome Teste Teste", 4, 12, 1);
    exercicio.setConnection(conn);
    boolean resposta = exercicio.delete(exercicioTeste);

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
    ExercicioDAO exercicio = new ExercicioDAO();
    exercicio.setConnection(conn);
    List<Exercicio> resposta = exercicio.list();
    assertNotNull(resposta);
} 

/** 
* 
* Method: search(Exercicio exercicio) 
* 
*/ 
@Test
public void testSearch() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    ExercicioDAO exercicio = new ExercicioDAO();

    Exercicio exercicioTeste = new Exercicio(133, "Nome Teste Teste", 4, 12, 1);
    exercicio.setConnection(conn);
    Exercicio resposta = exercicio.search(exercicioTeste);

    assertNotNull(resposta);
} 


} 
