package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Contato;
import model.Endereco;
import model.Materia;
import model.Professor;
import model.Turma;
import util.Mensagem;
import util.Rotulo;
import util.Valida;

/**
 * Classe respons�vel por controlar o sistema de gerenciamento para cadastro de
 * alunos, turmas, mat�rias e professores
 * @author Renato Duarte Sampaio
 * @since 23/02/2021
 */
public class GerenciaEscola {

	// Declarando as listas para armazenar os conte�dos do sistema( ALUNOS,PROFESSORES,TURMAS e MATERIAS )
	private ArrayList<Aluno> alunos; // criando ArrayList para armazenar dados de alunos cadastrados.
	private ArrayList<Professor> professores;// criando ArrayList para armazenar dados de professores cadastrados.
	private ArrayList<Materia> materias;// criando ArrayList para armazenar dados de materias cadastradas.
	private ArrayList<Turma> turmas;// criando ArrayList para armazenar dados de Turmass cadastradas.
	
	// Construtor da classe GERENCIA ESCOLA
	public GerenciaEscola() { // criando o m�todo principal do programa
		alunos = new ArrayList<Aluno>(); // iniciando o cadastros nas ArrayListas.
		professores = new ArrayList<Professor>(); // iniciando o cadastros nas ArrayListas.
		materias = new ArrayList<Materia>();// iniciando o cadastros nas ArrayListas.
		turmas = new ArrayList<Turma>();// iniciando o cadastros nas ArrayListas.
		
		menuPrincipal(); // chamando o M�todo (MENU) para rodar na classe.
	}

	// m�todo para criar um menu de op��es
	public void menuPrincipal() { // M�todo construtor do Menu de Op��es.
		
		//criando mensagem para apresenta��o do MENU ao usu�rio.
		String menu = "============ M E N U ============ \n\n" + "\n1 - MAIOR ELEMENTO" + "\n2 - MENOR ELEMENTO"
				+ "\n3 - ORDENAR LISTA CRESCENTE" + "\n4 - ORDENAR LISTA DECRESCENTE" + "\n5 - M�DIA DOS ELEMENTOS" + "\n6 - SOMA DO MAIOR E MENOR ELEMENTO"
				+ "\n7 - SOMA DOS ELEMENTOS IGUAS" + "\n8 - MEDIA DOS ELEMENTOS IGUAIS" + "\n9 - SAIR DO SISTEMA"+"\n\n INFORME A OP��O DESEJADA";

		while (true) { // enquanto
			try { // op��o escolhida pelo usuario for valida , deixar programa rodando.
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu)); // apresenta em tela as op��es e pega a op��o desejada 
				processamentoPrincipal(opcao); // com a op��o desejada dentro do processamento principal para rodar o M�todo incluso no menu 
			} catch (Exception e) {
				// Mensagem de erro: se escolher op��o invalida.
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.sistemaEscola, 0);
			}
		}

	}

	// M�todo para controlar o processamento do programa
	public void processamentoPrincipal(int opcao) {
		switch (opcao) {
		case 1: { // op��o 1 do menu
			cadastrarMateria(); // chama o M�todo de cadastro de Mat�ria para funcionalidade.
			break;// para o processamento
		}// fim da op��o 1

		case 2: {// op��o 2 do menu
			cadastrarProfessor();// chama o M�todo de cadastro de Professor para funcionalidade.
			break;// para o processamento
		}// fim da op��o 2

		case 3: {// op��o 3 do menu
			cadastrarAluno(); // chama o M�todo de cadastro de Aluno para funcionalidade.
			break;// para o processamento
		}// fim da op��o 3

		case 4: {// op��o 4 do menu
			cadastrarTurma();// chama o M�todo de cadastro de Turma para funcionalidade.
			break;// para o processamento
		}// fim da op��o 4

		case 5: {// op��o 5 do menu
			listarAlunos();// chama o M�todo de Listar Alunos para funcionalidade.
			break;// para o processamento
		}// fim da op��o 5

		case 6: {// op��o 6 do menu
			listarProfessores();// chama o M�todo de Listar Professores para funcionalidade.
			break;// para o processamento
		}// fim da op��o 6

		case 7: {// op��o 7 do menu
			listarTurmas();// chama o M�todo de Listar Turmas para funcionalidade.
			break;// para o processamento
		}// fim da op��o 7

		case 8: {// op��o 8 do menu
			consultarturma();// chama o M�todo de Consultar Turma para funcionalidade.
			break;// para o processamento
		}// fim da op��o 8

		case 9: {// op��o 9 do menu
			sair();// chama o M�todo de Sair do programa para funcionalidade.
			break;// para o processamento
		}// fim da op��o 9

		default: //se op��o n�o existir apresentar mensagem de ERRO.
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.sistemaEscola, 0);// mensagem de erro
			break;// para o processamento
		}// fim do swit
	} //fim do M�todo

	// M�todo para cadastrar mat�ria
	public void cadastrarMateria() {//m�to construtor
		materias.add(getMateria());//cadastro de materia
		JOptionPane.showMessageDialog(null, Mensagem.materiaCadastrada, Rotulo.cadastroMateria, 1); //mensagem de Sucesso

	}//fim do m�todo

	// m�todo para cadastrar professor
	public void cadastrarProfessor() { // M�todo Construtor
		if (materias.size() > 0) { // se tamanho de mat�ria maior que 0.
			professores.add(getProfessor()); // adicionar professores ao cdastro
			JOptionPane.showMessageDialog(null, Mensagem.professorCadastrado, Rotulo.cadastroProfessor, 1); //Mensagem de Sucesso
		} else {//se n�o
			JOptionPane.showMessageDialog(null, Mensagem.erroCadastroProfessor, Rotulo.cadastroProfessor, 2);// Mensagem de Advertencia
		}//fim do if , else.
		
	} // fim do M�todo.

	// m�todo para cadastrar aluno
	public void cadastrarAluno() { // m�todo construtor
		alunos.add(getAluno()); // adicinando alunos ao cadastro.
		JOptionPane.showMessageDialog(null, Mensagem.alunoCadastrado, Rotulo.cadastroAluno, 1); // mensagem de Sucesso
	}//fim do M�todo

	// m�todo para cadastrar turma
	public void cadastrarTurma() {//M�todo construtor

		if (professores.size() > 0 && alunos.size() > 0) { // se tiver professor j� cadastrado e alunos .
			turmas.add(getTurma()); //fazer cadastro de turmas.
			JOptionPane.showMessageDialog(null, Mensagem.turmaCadastrada, Rotulo.cadastroTurmas, 1);// Mensagem de Sucesso
		} else {// se n�o
			JOptionPane.showMessageDialog(null, Mensagem.erroCadastroTurma, Rotulo.cadastroTurmas, 2);// Mensagem de advertencia.
		}// fim do if , else.
	}//fim do M�todo

	// m�todo para retorar um objeto do tipo Turma
	private Turma getTurma() {// metodo construtor
		Turma turma = new Turma(); // nova turma 
		
		turma.setCodigo(getCodigoTurma()); //setando c�digo de turma 
		turma.setAno(getAno());// setando o Ano da turma
		turma.setProfessor(getProfessorTurma());// setando Professor a turma 
		turma.setMateria(getMateriaTurma()); //setando Materia a turma
		turma.setAlunos(getAlunosTurma());//setando alunos a turma
		
		return turma; // retornando Turma.
	}// fim do m�todo
	
	
	// m�todo para listar alunos
	public void listarAlunos() {//M�todo principal.
		String mensagem = "Alunos cadastrados\n"; // String Auxiliar para criar mensagens.
		boolean existe = false; // variavel auxiliar ( boolean ).
		
		for (Aluno aluno : alunos) { // varrendo alunos cadastrados
			existe = true; // se existir 1 ou Mais no cadastro a boolean � verdadeira.
			mensagem += "\nC�digo: " + aluno.getCodigo() + " - " + aluno.getNome(); // concatenando mensagem.
		}//fim do for
		
		if (existe) { //se verdadeira
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroAluno, 1); //ent�o apresentar em tela a lista de alunos
		} else {// se falsa
			JOptionPane.showMessageDialog(null, Mensagem.alunoVazio, Rotulo.cadastroAluno, 2); // mensagem de Advertencia.
		}//fim do if , else.
	}// fim do M�todo

	// M�todo para listar professores
	public void listarProfessores() {// M�todo Construtor

		String mensagem = "Professores cadastrados\n"; // String Auxiliar para mensagens.
		boolean existe = false; // variavel auxiliar ( boolean ).
		
		for (Professor professor : professores) {// varrendo professores cadastrados
			existe = true; // se existir cadastro , boolean � verdadeira.
			mensagem += "\nC�digo: " + professor.getCodigo() + " - " + professor.getNome();//concatenando mensagem.
		}// fim do for
		
		if (existe) { // se verdadeira
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroProfessor, 1); // apresentar em tela a lista de professores.
		} else { //se falsa
			JOptionPane.showMessageDialog(null, Mensagem.professorVazio, Rotulo.cadastroProfessor, 2);// mensagem de advertencia.
		}//fim do if , else.
	}//fim do m�todo

	// m�todo para listar turmas
	public void listarTurmas() {//M�todo construtor

		String mensagem = "Turmas cadastradas\n"; // variavel auxiliar para mensagem.
		boolean existe = false; // variavel auxiliar ( boolena )
		
		for (Turma turma : turmas) {
			existe = true;
			mensagem += "\nC�digo: " + turma.getCodigo() + " - " + turma.getAno() + " - " + turma.getMateria().getNome();
		}//fim do for.
		
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroTurmas, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.turmaVazio, Rotulo.cadastroTurmas, 2);
		}//fim do if, else.
	}//fim do m�todo

	// m�todo para consultar uma turma especifica
	public void consultarturma() { // m�todo construtor
		
		Turma turma = getConsultarTurma();
		String mensagem = "Detalhes da Turma\n";
		mensagem += "\nC�digo: "+ turma.getCodigo();
		mensagem += "\nAno: " + turma.getAno();;
		mensagem += "\nProfessor: " + turma.getProfessor().getNome();
		mensagem += "\nMateria : " + turma.getMateria().getNome();
		mensagem += "\nAlunos Matriculados: ";// mensagem concatenada.
		
		for (Aluno aluno : turma.getAlunos()) {
			mensagem += "\n C�digo: " + aluno.getCodigo() + " - " + aluno.getNome(); 
		}//fim do for.
		JOptionPane.showMessageDialog(null, mensagem, "Consulta de Turmas", 1);
	}//fim do m�todo

	// m�todo para sair do sistema
	public void sair() {// M�todo construtor
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Aten��o", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}//fim do if.
	}//fim do m�todo

	// m�todo para retornar os atributos (valores) do aluno
	public Aluno getAluno() {// M�todo construtor
		Aluno aluno = new Aluno();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		aluno.setCodigo(getCodigoAluno());
		aluno.setNome(getNomeAluno());
		aluno.setCpf(getCpfAluno());
		aluno.setRg(getRgAluno());

		endereco.setLogradouro(getLogradouro());
		endereco.setNome(getNomeLogradouro());
		endereco.setNumero(getNumero());
		endereco.setComplemento(getComplemento());
		endereco.setBairro(getBairro());
		endereco.setCidade(getCidade());
		endereco.setEstado(getEstado());
		endereco.setCep(getCep());

		contato.setCelular(getCelular());
		contato.setEmail(getEmail());

		aluno.setEndereco(endereco);
		aluno.setContato(contato);

		return aluno;
	}//fim do m�todo

	// m�todo para retornar os atributos (valores) do professor
	private Professor getProfessor() {// inicio do metodo
		Professor professor = new Professor();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();
		
		professor.setCodigo(getCodigoProfessor());
		professor.setNome(getNomeProfessor());
		professor.setCpf(getCpfProfessor());
		professor.setRg(getRgProfessor());
		
		endereco.setLogradouro(getLogradouro());
		endereco.setNome(getNomeLogradouro());
		endereco.setNumero(getNumero());
		endereco.setComplemento(getComplemento());
		endereco.setBairro(getBairro());
		endereco.setCidade(getCidade());
		endereco.setEstado(getEstado());
		endereco.setCep(getCep());
		
		contato.setCelular(getCelular());
		contato.setEmail(getEmail());
		
		professor.setEndereco(endereco);
		professor.setContato(contato);
		
		professor.setListaMateria(getMaterias());
		professor.setSalario(getSalario());
		return professor;
	}// fim do metodo

	// m�todo para retornar um objeto Materia
	private Materia getMateria() {//m�todo construtor
		Materia materia = new Materia();
		materia.setCodigo(getCodigoMateria());
		materia.setNome(getNomeMateria());
		
		return materia;
	}// fim do m�todo
	
	private int getCodigoMateria() { // M�todo construtor
		boolean execute = true;// variavel auxiliar booleana
		int codigo = 0;
		while (execute) {// inicio while
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroMateria, 0);
					execute = true;
				} else {
					execute = false;
				}//fim do If , else.
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroMateria, 0);
				execute = true;
			}//fim do try, catch.

		}//fim do While
		return codigo;
	}// fim do m�todo
	
	private String getNomeMateria() {//M�todo construtor
		boolean execute = true; //variavel auxiliar Booleana
		String nome = "";// variavel para armazenar Nome
		while (execute) { // inicio do while
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);
			if (Valida.isEmptyOrNull(nome)) {// inicio do if, else.
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroMateria, 0);
				execute = true;
			} else {
				execute = false;
			}//fim do if , else.
		}// fim do while
		return nome;
	}// fim do m�todo
	
	
	private int getCodigoAluno() {//m�todo principal
		boolean execute = true; //variavel auxiliar booleana.
		int codigo = 0;
		while (execute) {//inicio do while
			try {// inicio do try, catch
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {//inicio do if, else.
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroAluno, 0);
					execute = true;
				} else {
					execute = false;
				}//fim do if, else.
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroAluno, 0);
				execute = true;
			}//fim do try, cath.

		}//fim do while
		return codigo;
	}// fim do m�todo

	private String getNomeAluno() {//m�todo construtor
		boolean execute = true;// vriavel auxiliar booleana.
		String nome = "";
		while (execute) {//inicio while.
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);
			if (Valida.isEmptyOrNull(nome)) {// inicio if , else.
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}//fim do if, else.
		}// fim do while
		return nome;
	}// fim do m�todo

	private String getCpfAluno() {//m�todo construtor
		boolean execute = true;
		String cpf = "";
		while (execute) {//inicio while.
			cpf = JOptionPane.showInputDialog(Mensagem.informeCpf);
			if (Valida.isEmptyOrNull(cpf)) {// inicio if , else.
				JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}//fim if, else
		}//fim while
		return cpf;
	}// fim do m�todo

	private String getRgAluno() {
		boolean execute = true;
		String rg = "";
		while (execute) {
			rg = JOptionPane.showInputDialog(Mensagem.informeRg);
			if (Valida.isEmptyOrNull(rg)) {
				JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return rg;
	}// fim do m�todo

	private String getLogradouro() {
		boolean execute = true;
		String logradouro = "";
		while (execute) {
			logradouro = JOptionPane.showInputDialog(Mensagem.informeLogradouro);
			if (Valida.isEmptyOrNull(logradouro)) {
				JOptionPane.showMessageDialog(null, Mensagem.logradouroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return logradouro;
	}// fim do m�todo

	private String getNomeLogradouro() {
		boolean execute = true;
		String nomeLogradouro = "";
		while (execute) {
			nomeLogradouro = JOptionPane.showInputDialog(Mensagem.informeNomeLogradouro);
			if (Valida.isEmptyOrNull(nomeLogradouro)) {
				JOptionPane.showMessageDialog(null, Mensagem.logradouroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nomeLogradouro;
	}// fim do m�todo

	private int getNumero() {
		boolean execute = true;
		int numero = 0;
		while (execute) {
			try {
				numero = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(numero)) {
					JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Rotulo.cadastroEndereco, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Rotulo.cadastroEndereco, 0);
				execute = true;
			}

		}
		return numero;
	}// fim do m�todo

	private String getComplemento() {
		String complemento = "";
		complemento = JOptionPane.showInputDialog(Mensagem.informeComplemento);
		return complemento;
	}// fim do m�todo

	private String getBairro() {
		boolean execute = true;
		String bairro = "";
		while (execute) {
			bairro = JOptionPane.showInputDialog(Mensagem.informeBairro);
			if (Valida.isEmptyOrNull(bairro)) {
				JOptionPane.showMessageDialog(null, Mensagem.bairroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return bairro;
	}// fim do m�todo

	private String getCidade() {
		boolean execute = true;
		String cidade = "";
		while (execute) {
			cidade = JOptionPane.showInputDialog(Mensagem.informeCidade);
			if (Valida.isEmptyOrNull(cidade)) {
				JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cidade;
	}// fim do m�todo

	private String getEstado() {
		boolean execute = true;
		String estado = "";
		while (execute) {
			estado = JOptionPane.showInputDialog(Mensagem.informeEstado);
			if (Valida.isEmptyOrNull(estado)) {
				JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return estado;
	}// fim do m�todo

	private String getCep() {
		boolean execute = true;
		String cep = "";
		while (execute) {
			cep = JOptionPane.showInputDialog(Mensagem.informeCep);
			if (Valida.isEmptyOrNull(cep)) {
				JOptionPane.showMessageDialog(null, Mensagem.cepVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cep;
	}// fim do m�todo

	private String getCelular() {
		boolean execute = true;
		String celular = "";
		while (execute) {
			celular = JOptionPane.showInputDialog(Mensagem.informeCelular);
			if (Valida.isEmptyOrNull(celular)) {
				JOptionPane.showMessageDialog(null, Mensagem.celularVazio, Rotulo.cadastroContato, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return celular;
	}// fim do m�todo

	private String getEmail() {
		boolean execute = true;
		String email = "";
		while (execute) {
			email = JOptionPane.showInputDialog(Mensagem.informeEmail);
			if (Valida.isEmptyOrNull(email)) {
				JOptionPane.showMessageDialog(null, Mensagem.emailVazio, Rotulo.cadastroContato, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return email;
	}// fim do m�todo
	
	private int getCodigoProfessor() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroProfessor, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroProfessor, 0);
				execute = true;
			}

		}
		return codigo;
	}// fim do m�todo
	
	private String getNomeProfessor() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	}// fim do m�todo

	private String getCpfProfessor() {
		boolean execute = true;
		String cpf = "";
		while (execute) {
			cpf = JOptionPane.showInputDialog(Mensagem.informeCpf);
			if (Valida.isEmptyOrNull(cpf)) {
				JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cpf;
	}// fim do m�todo

	private String getRgProfessor() {
		boolean execute = true;
		String rg = "";
		while (execute) {
			rg = JOptionPane.showInputDialog(Mensagem.informeRg);
			if (Valida.isEmptyOrNull(rg)) {
				JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return rg;
	}// fim do m�todo
	
	private ArrayList<Materia> getMaterias(){
		ArrayList<Materia> materias = new ArrayList<Materia>();
		String mensagem = "Mat�rias Cadastradas\n";
		
		for (Materia materia : this.materias) {
			mensagem += "\nC�digo: " + materia.getCodigo() + " - " + materia.getNome(); 
		}
		
		boolean aux = true;
		mensagem += "\n" + Mensagem.informeCodigo;
		while (aux) {
			try {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				materias.add(this.materias.get(codigo - 1));
				
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outra mat�ria?", "Aten��o", JOptionPane.YES_OPTION,
						JOptionPane.CANCEL_OPTION);

				if (opcao == JOptionPane.YES_OPTION) {
					aux = true;
				} else {
					aux = false;
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroProfessor, 0);
			}
		}
		
		return materias;
	}
	
	private double getSalario() {
		boolean execute = true;
		double salario = 0;
		while (execute) {
			try {
				salario = Double.parseDouble(JOptionPane.showInputDialog(Mensagem.informeSalario));

				if (Valida.isDoubleZero(salario)) {
					JOptionPane.showMessageDialog(null, Mensagem.salarioVazio, Rotulo.cadastroProfessor, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.salarioInvalido, Rotulo.cadastroProfessor, 0);
				execute = true;
			}

		}
		return salario;
	}
	
	private int getCodigoTurma() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroTurmas, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurmas, 0);
				execute = true;
			}

		}
		return codigo;
	}// fim do m�todo
	
	private int getAno() {
		boolean execute = true;
		int ano = 0;
		while (execute) {
			try {
				ano = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeAno));

				if (Valida.isIntZero(ano)) {
					JOptionPane.showMessageDialog(null, Mensagem.anoVazio, Rotulo.cadastroTurmas, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.anoInvalido, Rotulo.cadastroTurmas, 0);
				execute = true;
			}

		}
		return ano;
	}// fim do m�todo
	
	private Professor getProfessorTurma(){
		Professor retorno = new Professor();
		
		String mensagem = "Professores Cadastrados\n";
		
		for (Professor professor: professores) {
			mensagem += "\nC�digo: " + professor.getCodigo() + " - " + professor.getNome(); 
		}
		
		mensagem += "\n" + Mensagem.informeCodigo;
			try {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				retorno = professores.get(codigo - 1);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroProfessor, 0);
			}
		
		return retorno;
	}
	
	private Materia getMateriaTurma(){
		Materia retorno = new Materia();
		String mensagem = "Mat�rias Cadastradas\n";
		
		for (Materia materia: materias) {
			mensagem += "\nC�digo: " + materia.getCodigo() + " - " + materia.getNome(); 
		}
		
		mensagem += "\n" + Mensagem.informeCodigo;
			try {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				retorno = materias.get(codigo - 1);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroMateria, 0);
			}
		
		return retorno;
	}
	
	private ArrayList<Aluno> getAlunosTurma(){
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		String mensagem = "Alunos Cadastrados\n";
		
		for (Aluno aluno : this.alunos) {
			mensagem += "\nC�digo: " + aluno.getCodigo() + " - " + aluno.getNome(); 
		}
		
		boolean aux = true;
		mensagem += "\n" + Mensagem.informeCodigo;
		while (aux) {
			try {
				int codigo;
				codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				alunos.add(this.alunos.get(codigo - 1));
				
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro aluno?", "Aten��o", JOptionPane.YES_OPTION,
						JOptionPane.CANCEL_OPTION);

				if (opcao == JOptionPane.YES_OPTION) {
					aux = true;
				} else {
					aux = false;
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurmas, 0);
			}
		}
		
		return alunos;
	}
	private Turma getConsultarTurma(){// inicio do m�todo Consultar Turma
		Turma retorno = new Turma(); //new turma
		String mensagem = "Mat�rias Cadastradas\n"; // String auxiliar para menagem
		
		for (Turma turma: turmas) { // for Reach para localizar em turmas a turma consultada.
			mensagem += "\nC�digo: " + turma.getCodigo() + " - " + turma.getAno() + " - " + turma.getMateria().getNome(); // concatenando mensagem apara apresentar ao usuario.
		} // fim do for
		
		mensagem += "\n" + Mensagem.informeCodigo; //concatenando a mensagem para solicitar o c�digo da turma 
			try {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem)); // solicitando o c�digo da turma
				retorno = turmas.get(codigo - 1);  // variavel auxiliar para retornar a posi��o da turma no indice a Lista
				
			} catch (Exception e) { // se n�o atender ao solicitado , mensagem de erro ( codigo invalido ).
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurmas, 0); // apresentando  mensagem de erro ao usuario
			}
		
		return retorno; // retornando a posi��o no m�todo
	}//fim do m�todo
	
}// fim da classe
