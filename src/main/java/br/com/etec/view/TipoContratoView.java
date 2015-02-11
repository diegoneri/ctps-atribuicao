/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.view;

import br.com.etec.dao.TipoContratoDao;
import br.com.etec.model.DefaultModel;
import br.com.etec.model.TipoContrato;
import br.com.etec.util.Operacao;
import br.com.etec.util.view.NavigableInternalFrame;
import br.com.etec.util.view.Utils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.observablecollections.ObservableCollections;
import org.springframework.stereotype.Component;

/**
 *
 * @author dfelix3
 */
@Component
public class TipoContratoView extends NavigableInternalFrame<TipoContrato> {

    /**
     * Método construtor da classe PrincipalAtribuicaoView
     */
    private TipoContratoDao dao = new TipoContratoDao();
    private Integer PAGE = 1;
    private Integer TOTAL_RECORDS = dao.getCount();
    private Operacao operacao = Operacao.NENHUM;

    public TipoContratoView() {
    }

    @PostConstruct
    private void init(){
        initComponents();
    }

    @Override
    public JButton getBtnPrimeiro() {
        return this.btnPrimeiro;
    }

    @Override
    public JButton getBtnAnterior() {
        return this.btnAnterior;
    }

    @Override
    public JButton getBtnProximo() {
        return this.btnProximo;
    }

    @Override
    public JButton getBtnUltimo() {
        return this.btnUltimo;
    }

    @Override
    public JButton getBtnIncluir() {
        return this.btnIncluir;
    }

    @Override
    public JButton getBtnAlterar() {
        return this.btnAlterar;
    }

    @Override
    public JButton getBtnExcluir() {
        return this.btnExcluir;
    }

    @Override
    public JButton getBtnSalvar() {
        return this.btnSalvar;
    }

    @Override
    public JButton getBtnCancelar() {
        return this.btnCancelar;
    }

    @Override
    public JTable getTable() {
        return this.tbTipoContrato;
    }

    @Override
    public JTextArea getDadosNavegacao() {
        return this.lblRecordInfo;
    }

    @Override
    public TipoContrato getModel() {
        return this.tipoContratoBean;
    }

    @Override
    public void setModel(TipoContrato model) {
        this.tipoContratoBean = model;
    }

    @Override
    public List<TipoContrato> getList() {
        return this.listTipoContrato;
    }
    /**
     * Este método é invocado pelo construtor e seu objetivo é inicializar o
     * form. WARNING: Não modifique este código. O seu conteúdo é
     * automaticamente regerado pelo editor visual do formulário.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listTipoContrato = ObservableCollections.observableList(new TipoContratoDao().listAll());
        tipoContratoBean = new br.com.etec.model.TipoContrato();
        panelPrincipal = new javax.swing.JPanel();
        paneltitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelTable = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        tbTipoContrato = new javax.swing.JTable();
        tbTipoContrato.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (tbTipoContrato.getSelectedRow() != -1) {
                    tipoContratoBean = listTipoContrato.get(tbTipoContrato.getSelectedRow());
                    btnAlterar.setEnabled(Boolean.TRUE);
                    btnExcluir.setEnabled(Boolean.TRUE);
                } else {
                    tipoContratoBean = null;
                    btnAlterar.setEnabled(Boolean.FALSE);
                    btnExcluir.setEnabled(Boolean.FALSE);
                }
            }
        });
        panelDados = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblRecordInfo = new javax.swing.JTextArea();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        btnIncluir = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        panelPrincipal.setLayout(new javax.swing.BoxLayout(panelPrincipal, javax.swing.BoxLayout.PAGE_AXIS));

        paneltitulo.setPreferredSize(new java.awt.Dimension(1198, 40));
        paneltitulo.setLayout(new java.awt.GridBagLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Tipos de Contrato");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 30, 20);
        paneltitulo.add(lblTitulo, gridBagConstraints);

        panelPrincipal.add(paneltitulo);

        panelTable.setLayout(new java.awt.GridBagLayout());

        tbTipoContrato.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listTipoContrato, tbTipoContrato);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollTable.setViewportView(tbTipoContrato);
        tbTipoContrato.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbTipoContrato.getColumnModel().getColumn(0).setResizable(false);
        tbTipoContrato.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbTipoContrato.getColumnModel().getColumn(1).setResizable(false);
        tbTipoContrato.getColumnModel().getColumn(1).setPreferredWidth(250);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 160;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelTable.add(scrollTable, gridBagConstraints);

        panelPrincipal.add(panelTable);

        panelDados.setLayout(new java.awt.GridBagLayout());

        btnPrimeiro.setText("|<<");
        btnPrimeiro.setToolTipText("Primeiro Registro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 38, 0, 0);
        panelDados.add(btnPrimeiro, gridBagConstraints);

        btnAnterior.setText("<");
        btnAnterior.setToolTipText("Registro Anterior");
        btnAnterior.setMaximumSize(new java.awt.Dimension(53, 23));
        btnAnterior.setMinimumSize(new java.awt.Dimension(53, 23));
        btnAnterior.setPreferredSize(new java.awt.Dimension(53, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        panelDados.add(btnAnterior, gridBagConstraints);

        btnProximo.setText(">");
        btnProximo.setToolTipText("Próximo Registro");
        btnProximo.setMaximumSize(new java.awt.Dimension(53, 23));
        btnProximo.setMinimumSize(new java.awt.Dimension(53, 23));
        btnProximo.setPreferredSize(new java.awt.Dimension(53, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        panelDados.add(btnProximo, gridBagConstraints);

        btnUltimo.setText(">>|");
        btnUltimo.setToolTipText("Último Registro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 32;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 65;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        panelDados.add(btnUltimo, gridBagConstraints);

        lblRecordInfo.setEditable(false);
        lblRecordInfo.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        lblRecordInfo.setColumns(20);
        lblRecordInfo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblRecordInfo.setLineWrap(true);
        lblRecordInfo.setRows(2);
        lblRecordInfo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblRecordInfo.setEnabled(false);
        jScrollPane2.setViewportView(lblRecordInfo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 98;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 311;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 10);
        panelDados.add(jScrollPane2, gridBagConstraints);

        lblId.setText("Id:");
        lblId.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 77, 0, 0);
        panelDados.add(lblId, gridBagConstraints);

        txtId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtId.setEnabled(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tbTipoContrato, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.id}"), txtId, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 55;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 178;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 4, 0, 0);
        panelDados.add(txtId, gridBagConstraints);

        lblNome.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 60, 0, 0);
        panelDados.add(lblNome, gridBagConstraints);

        btnAlterar.setText("Alterar");
        btnAlterar.setActionCommand("ListarCargoView.alterar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 10, 0, 0);
        panelDados.add(btnAlterar, gridBagConstraints);

        btnSalvar.setText("Salvar");
        btnSalvar.setActionCommand("ListarCargoView.salvar");
        btnSalvar.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 88, 0, 0);
        panelDados.add(btnSalvar, gridBagConstraints);

        btnCancelar.setText("Cancelar");
        btnCancelar.setActionCommand("ListarCargoView.cancelar");
        btnCancelar.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        panelDados.add(btnCancelar, gridBagConstraints);

        txtNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tbTipoContrato, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), txtNome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 97;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 243;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 4, 0, 10);
        panelDados.add(txtNome, gridBagConstraints);

        btnIncluir.setText("Incluir");
        btnIncluir.setActionCommand("incluir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 38, 0, 0);
        panelDados.add(btnIncluir, gridBagConstraints);

        btnExcluir.setText("Excluir");
        btnExcluir.setActionCommand("ListarCargoView.excluir");
        btnExcluir.setPreferredSize(new java.awt.Dimension(65, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 64;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 10, 0, 0);
        panelDados.add(btnExcluir, gridBagConstraints);

        panelPrincipal.add(panelDados);

        getContentPane().add(panelPrincipal);

        bindingGroup.bind();

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-495)/2, (screenSize.height-576)/2, 495, 576);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextArea lblRecordInfo;
    private javax.swing.JLabel lblTitulo;
    private java.util.List<TipoContrato> listTipoContrato;
    private javax.swing.JPanel panelDados;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTable;
    private javax.swing.JPanel paneltitulo;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable tbTipoContrato;
    private br.com.etec.model.TipoContrato tipoContratoBean;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void clearFields() {
        this.txtId.setText("");
        this.txtNome.setText("");
    }

    private void enableFields(boolean flag) {
        this.txtNome.setEnabled(flag);

        if (flag) {
            this.txtNome.requestFocus();
        }

        this.tbTipoContrato.setEnabled(!flag);

        this.btnIncluir.setEnabled(!flag);
        this.btnAlterar.setEnabled(!flag);
        this.btnExcluir.setEnabled(!flag);

        this.btnSalvar.setEnabled(flag);
        this.btnCancelar.setEnabled(flag);

        this.validarBotoesNavegacao(!flag);
    }
}
