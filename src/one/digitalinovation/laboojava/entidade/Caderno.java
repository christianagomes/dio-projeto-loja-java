package one.digitalinovation.laboojava.entidade;

import one.digitalinovation.laboojava.entidade.constantes.Materias;

/**
 * Classe que representa um caderno, qual é uma especialização de um produto da loja.
 * @author thiago leite
 */

public class Caderno extends Produto {

    /**
     * Quantidade de matérias que o caderno pode ter.
     */
    private Materias tipo;

    public Materias getTipo() {

        return tipo;
    }

    public void setTipo(Materias tipo) {

        this.tipo = tipo;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public double calcularFrete() {

        return (getPreco() * getQuantidade()) + tipo.getFator();
    }

    @Override
    public String toString() {
        return "Caderno{" +
                " tipo=" + tipo + '\'' +
                ", codigo='" + getCodigo() + '\'' +
                ", preço='" + getPreco() + '\'' +
                '}';
    }
}
