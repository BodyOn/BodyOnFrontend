package test.model.dao; 

import model.dao.ClienteDAO;
import model.database.Database;
import model.database.DatabaseFactory;
import model.domain.Cliente;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static junit.framework.TestCase.*;

public class ClienteDAOTest { 

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
    ClienteDAO cliente = new ClienteDAO();

    cliente.setConnection(conn);
    Connection newConn = cliente.getConnection();
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
    ClienteDAO cliente = new ClienteDAO();

    cliente.setConnection(conn);
    Connection newConn = cliente.getConnection();
    assertEquals(conn, newConn);
} 

/** 
* 
* Method: insert(Cliente cliente) 
* 
*/ 
@Test
public void testInsert() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    ClienteDAO cliente = new ClienteDAO();
    Cliente clienteTeste = new Cliente(133, "Teste", "Rua Teste", "Telefone Teste", "Email Teste", "Cpf Teste", 100.6, 1.7, "Horario Teste", 1, new Date(23-3-2002), false);
    cliente.setConnection(conn);
    boolean resposta = cliente.insert(clienteTeste);

    assertEquals(true, resposta);
} 

/** 
* 
* Method: update(Cliente cliente) 
* 
*/ 
@Test
public void testUpdate() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    ClienteDAO cliente = new ClienteDAO();
    Cliente clienteTeste = new Cliente(133, "Teste Teste", "Rua Teste", "Telefone Teste", "Email Teste", "Cpf Teste", 100.6, 1.7, "Horario Teste", 1, new Date(23-3-2002), false);
    cliente.setConnection(conn);
    boolean resposta = cliente.update(clienteTeste);

    assertEquals(true, resposta);
}

/**
*
* Method: delete(Cliente cliente)
*
*/
@Test
public void testDelete() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    ClienteDAO cliente = new ClienteDAO();
    Cliente clienteTeste = new Cliente(133, "Teste Teste", "Rua Teste", "Telefone Teste", "Email Teste", "Cpf Teste", 100.6, 1.7, "Horario Teste", 1, new Date(23-3-2002), false);
    cliente.setConnection(conn);
    boolean resposta = cliente.delete(clienteTeste);

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
    ClienteDAO cliente = new ClienteDAO();
    cliente.setConnection(conn);
    List<Cliente> resposta = cliente.list();
    assertNotNull(resposta);
} 

/** 
* 
* Method: search(Cliente cliente) 
* 
*/ 
@Test
public void testSearch() throws Exception {
    Database db = DatabaseFactory.getDatabase("postgresql");
    Connection conn = db.connect();
    ClienteDAO cliente = new ClienteDAO();
    Cliente clienteTeste = new Cliente(133, "Teste Teste", "Rua Teste", "Telefone Teste", "Email Teste", "Cpf Teste", 100.6, 1.7, "Horario Teste", 1, new Date(23-3-2002), false);
    cliente.setConnection(conn);
    Cliente resposta = cliente.search(clienteTeste);
    assertNotNull(resposta);
}


} 
