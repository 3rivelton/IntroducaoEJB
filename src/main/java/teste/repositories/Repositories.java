package teste.repositories;

public interface Repositories <Classe, Key> {
	
	public void inserir(Classe classe) throws Exception;
	public void alterar(Classe classe) throws Exception;
	public Classe ler(Key key) throws Exception;
	public void deletar(Key key) throws Exception;
	public void limparLista() throws Exception;

}
