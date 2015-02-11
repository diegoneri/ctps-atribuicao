/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.view;

import br.com.etec.model.DefaultModel;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 * Esta view guarda os métodos padrão de uma view navegável
 * @author Diego Neri - #diegoneri
 */
public interface INavigableView<M extends DefaultModel> extends IView{
    JButton getBtnPrimeiro();
    JButton getBtnAnterior();
    JButton getBtnProximo();
    JButton getBtnUltimo();

    JButton getBtnIncluir();
    JButton getBtnAlterar();
    JButton getBtnExcluir();
    JButton getBtnSalvar();
    JButton getBtnCancelar();

    JTable getTable();

    JTextArea getDadosNavegacao();

    M getModel();
    void setModel(M model);
    List<M> getList();

}
