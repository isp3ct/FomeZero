//CRIADOR: JOÃO VICTOR DOS SANTOS COSTA

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DAO {

    private Conexao conexao;

    public DAO() {
        this.conexao = new Conexao(); // Certifique-se de que Conexao tenha um construtor padrão ou ajuste conforme necessário
    }

    public void realizarSelectProdutos() {
        try (Connection connection = conexao.conectar()) {
            String sql = "SELECT * FROM PRODUTOS";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int idProduto = resultSet.getInt("IDPRODUTOS");
                    String descricao = resultSet.getString("DESCRICAO");

                    System.out.println("[" + idProduto + "] " + descricao);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexão ou na execução da query: " + e.getMessage());
        }
    }

    public void inserirDoacao(int idUsuario, int alimento, int qtd) {
        try (Connection connection = conexao.conectar()) {
            String sqlInsert = "INSERT INTO DOACAO (IDUSUARIO, IDPRODUTOS, QTD, STATUS) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sqlInsert)) {
                statement.setInt(1, idUsuario);
                statement.setInt(2, alimento);
                statement.setInt(3, qtd);
                statement.setInt(4, 1);
    
                int linhasAfetadas = statement.executeUpdate();
    
                if (linhasAfetadas > 0) {
                    System.out.println("Doação inserida com sucesso!");
                } else {
                    System.out.println("Falha ao inserir a doação.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexão ou na execução da query: " + e.getMessage());
        }
    }

    public int inserirDadosUsuario(String nome, Date dataNascimento, String email, String cpf, int idTipoUsuario) {
        try (Connection connection = conexao.conectar()) {
            String sql = "INSERT INTO USUARIO (IDTIPOUSUARIO, NOME, EMAIL, DATANASCIMENTO, CPF, STATUS) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, idTipoUsuario);
                statement.setString(2, nome);
                statement.setString(3, email);
                java.sql.Date dataNascimentoSql = new java.sql.Date(dataNascimento.getTime());
                statement.setDate(4, dataNascimentoSql);
                statement.setString(5, cpf);
                statement.setInt(6, 1);
    
                int linhasAfetadas = statement.executeUpdate();
    
                if (linhasAfetadas > 0) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int usuarioId = generatedKeys.getInt(1);
                        return usuarioId;
                    } else {
                        System.out.println("Falha ao obter o ID do usuário.");
                        return -1; // Retorna um valor padrão em caso de falha
                    }
                } else {
                    System.out.println("Falha ao inserir o usuário.");
                    return -1; // Retorna um valor padrão em caso de falha
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexão ou na execução da query: " + e.getMessage());
            return -1; // Retorna um valor padrão em caso de exceção
        }
    }

    public Map<String, Integer> selectLogin(String email, String cpf) {
        Map<String, Integer> usuario = new HashMap<>();

        try (Connection connection = conexao.conectar()) {
            String sql = "SELECT * FROM USUARIO WHERE EMAIL = ? AND CPF = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, cpf);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int usuarioId = resultSet.getInt("IDUSUARIO");
                    int tipoUsuarioId = resultSet.getInt("IDTIPOUSUARIO");
                    
                    usuario.put("usuarioId", usuarioId);
                    usuario.put("tipoUsuarioId", tipoUsuarioId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na conexão ou na execução da query: " + e.getMessage());
        }

        return usuario;
    }     
}
