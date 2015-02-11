/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.util.view;

import br.com.etec.model.DefaultModel;
import br.com.etec.view.INavigableView;
import javax.swing.JInternalFrame;

/**
 *
 * @author Diego Neri - #diegoneri
 */
public abstract class NavigableInternalFrame<M extends DefaultModel> extends JInternalFrame implements INavigableView<M> {

}
