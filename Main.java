

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



  public class Main {
      public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          Connection conn = null;

          String url = System.getenv("URL"); 
          String user = System.getenv("USERNAME"); 
          String password = System.getenv("PASSWORD");

          try {
              conn = DriverManager.getConnection(url, user, password);
              if (conn != null) {
                  System.out.println("Conexão bem-sucedida!");
              } else {
                  System.out.println("Falha ao estabelecer conexão.");
              }
          } catch (SQLException e) {
              System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
              return; 
          }

          int opcaozinha = 0;
          List<Departamentos> departamentos = new ArrayList<>();
          List<Funcionario> funcionarios = new ArrayList<>();

          do {
              int id = 0;
              String nome = "";
              String cargo = "";
              String departamento = "";
              int horasTrabalhadas = 0;
              String estilocontrato = ""; 

              System.out.println("Bem-vindo ao Sistema de Cabaço de Cainho e companhia");
              System.out.println("Escolha:");
              System.out.println("1- Inserir funcionários");
              System.out.println("2- Inserir departamentos");
              System.out.println("3- Buscar Funcionário (ID)");
              System.out.println("4- Buscar Departamento (Nome)");
              System.out.println("5- Listar Todos os Funcionários por departamento");
              System.out.println("6- Listar Todos os Funcionários");
              System.out.println("7- Listar Todos os Departamentos");
              System.out.println("8- Excluir um funcionário de departamento");
              System.out.println("9- Incluir funcionário em um departamento");
              System.out.println("10- Excluir um departamento");
              System.out.println("0- Sair");

              try {
                  opcaozinha = input.nextInt();
                  input.nextLine(); 

                  switch (opcaozinha) {
                      case 1:
                          System.out.println("Vamos inserir um novo funcionário:");
                          System.out.print("ID: ");
                          id = input.nextInt();
                          input.nextLine(); 

                          System.out.print("Nome: ");
                          nome = input.nextLine().toLowerCase();


                          System.out.print("Qual cargo do " + nome + "? ");
                          cargo = input.nextLine().toLowerCase();


                          System.out.print("Qual a departamento do " + nome + "? ");
                          departamento = input.nextLine().toLowerCase();

                          System.out.println("Qual o estilo de contrato do " + nome + "? ");
                          estilocontrato = input.nextLine().toLowerCase();


                          if (estilocontrato.equals("freelancer")) {
                              System.out.print("Quantidade de Projetos: ");
                              int qtdProjetos = input.nextInt();
                              System.out.print("Salário por Projeto: ");
                              double salarioProjeto = input.nextDouble();

                              double salario = qtdProjetos * salarioProjeto; 
                              Funcionario freelancer = new Freelancer(nome, cargo, id, qtdProjetos, salarioProjeto);
                              funcionarios.add(freelancer);

                              String sql = "INSERT INTO Funcionario (id, nome, cargo, departamento, estilocontrato, salario) VALUES (?, ?, ?, ?, ?, ?)";

                              try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                                  pstmt.setInt(1, id);
                                  pstmt.setString(2, nome);
                                  pstmt.setString(3, cargo);
                                  pstmt.setString(4, departamento);
                                  pstmt.setString(5, estilocontrato);
                                  pstmt.setDouble(6, salario); 

                                  int affectedRows = pstmt.executeUpdate();
                                  if (affectedRows > 0) {
                                      System.out.println("Funcionário inserido com sucesso!");
                                  } else {
                                      System.out.println("Falha ao inserir o funcionário.");
                                  }
                              } catch (SQLException e) {
                                  System.out.println("Erro ao inserir funcionário: " + e.getMessage());
                              }
                            
      //Agora começa a parte de calcular do horista!
                          } else if (estilocontrato.equals("horista")) {

                              System.out.println("Quantidade de horas normais trabalhadas: ");
                              int horasTrabalhadaszinhas = input.nextInt();

                              System.out.println("Taxa por hora: ");
                              int taxaporHora = input.nextInt();
                            
                              System.out.print("Quantidade de horas extras trabalhadas: ");
                              int horasextras = input.nextInt();

                              System.out.print("Bonus por hora extra: ");
                              double taxaPorHoraextra = input.nextDouble();


                              double taxaExtraReal = (taxaporHora + taxaPorHoraextra);
                              double salario = (horasTrabalhadaszinhas * taxaporHora) + (horasextras * taxaExtraReal); 
                              Funcionario horista = new Horista(nome, cargo, id, horasextras, taxaporHora);
                              funcionarios.add(horista);

                              String sql = "INSERT INTO Funcionario (id, nome, cargo, departamento, estilocontrato, salario) VALUES (?, ?, ?, ?, ?, ?)";

                              try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                                  pstmt.setInt(1, id);
                                  pstmt.setString(2, nome);
                                  pstmt.setString(3, cargo);
                                  pstmt.setString(4, departamento);
                                  pstmt.setString(5, estilocontrato);
                                  pstmt.setDouble(6, salario); 

                                  int affectedRows = pstmt.executeUpdate();
                                  if (affectedRows > 0) {
                                      System.out.println("Funcionário inserido com sucesso!");
                                  } else {
                                      System.out.println("Falha ao inserir o funcionário.");
                                  }
                              } catch (SQLException e) {
                                  System.out.println("Erro ao inserir funcionário: " + e.getMessage());
                              }



                            

                          } else if(estilocontrato.equals("temporario")){
                              
                              System.out.print("Quantidade de horas trabalhadas: ");
                              int horasTrab = input.nextInt();

                              System.out.print("Taxa por hora: ");
                              double taxaPorHora = input.nextDouble();

                              double salario = horasTrab * taxaPorHora; 
                              Funcionario temporariozinho = new Temporario (nome, cargo, id, horasTrab, taxaPorHora);
                              funcionarios.add(temporariozinho);

                              String sql = "INSERT INTO Funcionario (id, nome, cargo, departamento, estilocontrato, salario) VALUES (?, ?, ?, ?, ?, ?)";

                              try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                                  pstmt.setInt(1, id);
                                  pstmt.setString(2, nome);
                                  pstmt.setString(3, cargo);
                                  pstmt.setString(4, departamento);
                                  pstmt.setString(5, estilocontrato);
                                  pstmt.setDouble(6, salario); 

                                  int affectedRows = pstmt.executeUpdate();
                                  if (affectedRows > 0) {
                                      System.out.println("Funcionário inserido com sucesso!");
                                  } else {
                                      System.out.println("Falha ao inserir o funcionário.");
                                  }
                              } catch (SQLException e) {
                                  System.out.println("Erro ao inserir funcionário: " + e.getMessage());
                              }
                              
                          } else if(estilocontrato.equals("permanente")){

                                System.out.print("Digite o salário do funcionário:");
                                double salario = input.nextDouble();

                                Funcionario permanente = new Permanente (nome, cargo, id);
                                funcionarios.add(permanente);

                                String sql = "INSERT INTO Funcionario (id, nome, cargo, departamento, estilocontrato, salario) VALUES (?, ?, ?, ?, ?, ?)";

                                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                                    pstmt.setInt(1, id);
                                    pstmt.setString(2, nome);
                                    pstmt.setString(3, cargo);
                                    pstmt.setString(4, departamento);
                                    pstmt.setString(5, estilocontrato);
                                    pstmt.setDouble(6, salario); 

                                    int affectedRows = pstmt.executeUpdate();
                                    if (affectedRows > 0) {
                                        System.out.println("Funcionário inserido com sucesso!");
                                    } else {
                                        System.out.println("Falha ao inserir o funcionário.");
                                    }
                                } catch (SQLException e) {
                                    System.out.println("Erro ao inserir funcionário: " + e.getMessage());
                                }
                          }
                          break;

                      case 2:
                      System.out.println("Vamos inserir um novo departamento:");
                      System.out.print("Nome do Departamento: ");
                      String nomeDepartamento = input.nextLine().toLowerCase();

                      try {
                          String sql = "INSERT INTO departamentozinhos (nome_departamentozinho) VALUES (?)";
                          PreparedStatement pstmt = conn.prepareStatement(sql);
                          pstmt.setString(1, nomeDepartamento);

                          int affectedRows = pstmt.executeUpdate();
                          if (affectedRows > 0) {
                              System.out.println("Departamento inserido com sucesso!");
                          } else {
                              System.out.println("Falha ao inserir o departamento.");
                          }

                          pstmt.close();
                      } catch (SQLException e) {
                          System.out.println("Erro ao inserir departamento: " + e.getMessage());
                      }

                          break;

                      case 3:
                          System.out.print("Digite o ID do funcionário: ");
                          
                          int idBuscarFuncionario = input.nextInt();
                          String sqlBuscarFuncionarioPorId = "SELECT * FROM Funcionario WHERE id = ?";
                          
                          try (PreparedStatement pstmt = conn.prepareStatement(sqlBuscarFuncionarioPorId)) {
                              pstmt.setInt(1, idBuscarFuncionario);
                              
                              try (ResultSet rs = pstmt.executeQuery()) {
                                  if (rs.next()) {
                                      String nomeBusca = rs.getString("nome");
                                      String cargoBusca = rs.getString("cargo");
                                      String departamentoBusca = rs.getString("departamento");
                                      double salarioBusca = rs.getDouble("salario");
                                      int id_funcionario = rs.getInt("id");
                                      String tipoContrato = rs.getString("estilocontrato");
                                      System.out.println("ID: " + id_funcionario);
                                      System.out.println("Nome: " + nomeBusca);
                                      System.out.println("Cargo: " + cargoBusca);
                                      System.out.println("Departamento: " + departamentoBusca);
                                      System.out.println("Salário: " + salarioBusca);
                                      System.out.println("Tipo de Contrato: " + tipoContrato);
                                  } else {
                                      System.out.println("Funcionário não encontrado.");
                                  }
                              } catch (SQLException e) {
                                  System.out.println("Erro ao buscar funcionário por ID: " + e.getMessage());
                              }
                          } catch (SQLException e) {
                              System.out.println("Erro ao preparar a consulta do funcionário por ID: " + e.getMessage());
                          }
                            break;

                      case 4:
                          System.out.print("Digite o nome do departamento: ");
                          String nomeDeptoBusca = input.nextLine().toLowerCase();

                          String sqlBuscaDepartamento = 
                              "SELECT nome_departamento, STRING_AGG(lista_funcionarios, ', ') AS funcionarios " +
                              "FROM departamento " +
                              "WHERE nome_departamento = ? " +
                              "GROUP BY nome_departamento";

                          try (PreparedStatement pstmt = conn.prepareStatement(sqlBuscaDepartamento)) {
                              pstmt.setString(1, nomeDeptoBusca);

                              try (ResultSet rs = pstmt.executeQuery()) {
                                  boolean departamentoEncontrado = false;
                                  while (rs.next()) {
                                      String nomeDepto = rs.getString("nome_departamento");
                                      String funcionariosNoDepartamento = rs.getString("funcionarios");

                                      System.out.println("Departamento " + nomeDepto + " possui os funcionários: " + funcionariosNoDepartamento);
                                      departamentoEncontrado = true;
                                  }
                                  if (!departamentoEncontrado) {
                                      System.out.println("Departamento não encontrado.");
                                  }
                              } catch (SQLException e) {
                                  System.out.println("Erro ao buscar funcionários do departamento: " + e.getMessage());
                              }
                          } catch (SQLException e) {
                              System.out.println("Erro ao preparar a consulta do departamento: " + e.getMessage());
                          }
                          break;

                          
                      case 5:
                          try{
                            System.out.print("Digite o nome do departamento a ser buscado: ");
                            String departamentoBusca = input.nextLine().toLowerCase();
                              if(!(departamentoBusca instanceof String)){
                                  throw new IllegalArgumentException("O nome do departamento deve ser uma string");
                              }
                            String sqlBuscarFuncionariosPorDepartamento =  "SELECT nome, cargo FROM Funcionario WHERE departamento = ? ";

                              try(PreparedStatement pstmt = conn.prepareStatement(sqlBuscarFuncionariosPorDepartamento)){
                                  pstmt.setString(1, departamentoBusca);

                                  try(ResultSet rs = pstmt.executeQuery()){
                                      while(rs.next()) {
                                          String nomeFuncionario = rs.getString("nome");

                                          System.out.println("Nome: " + nomeFuncionario);
                                    }   
                                }catch (SQLException e){
                                      System.out.println("Erro ao buscar funcionários por departamento: " + e.getMessage());
                                }
                            } catch (SQLException e){
                                  System.out.println("Erro ao buscar funcionários por departamento: " + e.getMessage());
                            }
                          } catch(IllegalArgumentException e){
                              System.out.println("Erro: " + e.getMessage());
                          }
                          break;

                          
                      case 6:
                          try {
                              String sqlListarFuncionarios = "SELECT id, nome FROM Funcionario";
                              try (PreparedStatement pstmtListarFuncionarios = conn.prepareStatement(sqlListarFuncionarios);
                                   ResultSet rsFuncionarios = pstmtListarFuncionarios.executeQuery()) {
                                  System.out.println("=== Lista de Todos os Funcionários ===");
                                  while (rsFuncionarios.next()) {
                                      int idFuncionario = rsFuncionarios.getInt("id");
                                      String nomeFuncionario = rsFuncionarios.getString("nome");
                                      System.out.println("ID: " + idFuncionario + ", Nome: " + nomeFuncionario);
                                  }
                              }
                          } catch (SQLException e) {
                              System.out.println("Erro ao listar funcionários: " + e.getMessage());
                          }
                          
                          break;

                          
                      case 7:
                         try {
                           String sql = "SELECT nome_departamentozinho FROM departamentozinhos";
                           PreparedStatement pstmt = conn.prepareStatement(sql);
                           ResultSet rs = pstmt.executeQuery();

                           System.out.println("=== Lista de Departamentos ===");
                           while (rs.next()) {
                               String nomeDepartamentozinho = rs.getString("nome_departamentozinho");
                               System.out.println(nomeDepartamentozinho);
                           }

                           rs.close();
                           pstmt.close();
                         } catch (SQLException e) {
                           System.out.println("Erro ao buscar departamentos: " + e.getMessage());
                         }
                          break;

                          
                      case 8:
                          System.out.print("Digite o nome do funcionário: ");
                          String nomeFuncRemover = input.nextLine().toLowerCase();

                          System.out.print("Digite o departamento a ser removido: ");
                          String departamentoRemover = input.nextLine().toLowerCase();
                          
                          String sqlTirarDepartamento = "UPDATE Funcionario SET departamento = NULL WHERE nome = ? AND departamento = ?";

                          try (PreparedStatement pstmt = conn.prepareStatement(sqlTirarDepartamento)) {
                              pstmt.setString(1, nomeFuncRemover);
                              pstmt.setString(2, departamentoRemover);
                              int linhasAfetadas = pstmt.executeUpdate();

                              if (linhasAfetadas > 0) {
                                  System.out.println("Departamento " + departamentoRemover + " removido do funcionário " + nomeFuncRemover + " com sucesso.");
                              } else {
                                  System.out.println("O funcionário " + nomeFuncRemover + " não está associado ao departamento " + departamentoRemover);
                              }
                          } catch (SQLException e) {
                              System.out.println("Erro ao remover departamento do funcionário: " + e.getMessage());
                          }
                          break;

                          
                      case 9:
                          System.out.println("Incluir funcionário em um departamento:");
                          System.out.print("Digite o nome do departamento: ");
                          String nomeDepartamento2 = input.nextLine().toLowerCase();

                          // Verificar se o departamento já existe na tabela departamentozinhos
                          boolean departamentoExiste = false;
                          try {
                              String sqlVerificarDepartamento = "SELECT nome_departamentozinho FROM departamentozinhos WHERE nome_departamentozinho = ?";
                              PreparedStatement pstmtVerificarDepartamento = conn.prepareStatement(sqlVerificarDepartamento);
                              pstmtVerificarDepartamento.setString(1, nomeDepartamento2);
                              ResultSet rsDepartamento = pstmtVerificarDepartamento.executeQuery();

                              if (rsDepartamento.next()) {
                                  departamentoExiste = true;
                              }

                              rsDepartamento.close();
                              pstmtVerificarDepartamento.close();
                          } catch (SQLException e) {
                              System.out.println("Erro ao verificar departamento: " + e.getMessage());
                          }

                          if (departamentoExiste) {
                              // Se o departamento existe, inserir o funcionário na tabela departamentos
                              try {
                                  System.out.print("Nome do Funcionário: ");
                                  String nomeFuncionario = input.nextLine().toLowerCase();
                                  // Aqui você coletaria os outros dados do funcionário

                                  String sqlInserirFuncionario = "INSERT INTO departamento (nome_departamento, lista_funcionarios) VALUES (?, ?)";
                                  PreparedStatement pstmtInserirFuncionario = conn.prepareStatement(sqlInserirFuncionario);
                                  pstmtInserirFuncionario.setString(1, nomeDepartamento2);
                                  pstmtInserirFuncionario.setString(2, nomeFuncionario);
                                  // Aqui você atribuiria os valores para os outros campos do funcionário

                                  int affectedRows = pstmtInserirFuncionario.executeUpdate();
                                  if (affectedRows > 0) {
                                      System.out.println("Funcionário inserido no departamento com sucesso!");
                                  } else {
                                      System.out.println("Falha ao inserir o funcionário no departamento.");
                                  }

                                  pstmtInserirFuncionario.close();
                              } catch (SQLException e) {
                                  System.out.println("Erro ao inserir funcionário no departamento: " + e.getMessage());
                              }
                          } else {
                              System.out.println("O departamento não existe.");
                          }
                          break;


                          
                      case 10:
                          System.out.print("Digite o nome do departamento a ser excluído: ");
                          String nomeDeptoExcluir = input.nextLine().toLowerCase();

                          try {
                              conn.setAutoCommit(false);

                              // Excluir funcionários ligados ao departamento
                              String sqlExcluirFuncionarios = 
                                  "DELETE FROM departamento WHERE nome_departamento = ?";
                              try (PreparedStatement pstmtExcluirFuncionarios = conn.prepareStatement(sqlExcluirFuncionarios)) {
                                  pstmtExcluirFuncionarios.setString(1, nomeDeptoExcluir);
                                  pstmtExcluirFuncionarios.executeUpdate();
                              }

                              // Excluir o departamento da tabela departamentozinhos
                              String sqlExcluirDepartamento = 
                                  "DELETE FROM departamentozinhos WHERE nome_departamentozinho = ?";
                              try (PreparedStatement pstmtExcluirDepartamento = conn.prepareStatement(sqlExcluirDepartamento)) {
                                  pstmtExcluirDepartamento.setString(1, nomeDeptoExcluir);
                                  int affectedRows = pstmtExcluirDepartamento.executeUpdate();
                                  if (affectedRows > 0) {
                                      System.out.println("Departamento excluído com sucesso!");
                                  } else {
                                      System.out.println("Falha ao excluir o departamento.");
                                  }
                              }

                              conn.commit();
                          } catch (SQLException e) {
                              try {
                                  conn.rollback();
                              } catch (SQLException rollbackEx) {
                                  System.out.println("Erro ao executar rollback: " + rollbackEx.getMessage());
                              }
                              System.out.println("Erro ao excluir departamento: " + e.getMessage());
                          } finally {
                              try {
                                  conn.setAutoCommit(true);
                              } catch (SQLException e) {
                                  System.out.println("Erro ao definir auto-commit: " + e.getMessage());
                              }
                          }
                          break;

                          
                      case 0:                      
                          System.out.println("Saindo do programa...");
                          break;
                      default:
                          System.out.println("Opção inválida, tente novamente.");
                  }
              } catch (InputMismatchException e) {
                  System.out.println("Por favor, insira somente um número válido.");
                  input.next();
              }
          } while (opcaozinha != 0);

          try {
              if (conn != null && !conn.isClosed()) {
                  conn.close();
              }
          } catch (SQLException e) {
              System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
          }
      }
  }    
