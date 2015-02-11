/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.view;

import br.com.etec.model.CategoriaProfessor;
import br.com.etec.util.view.NavigableInternalFrame;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.observablecollections.ObservableCollections;
import org.springframework.stereotype.Component;

/**
 *
 * @author dfelix3
 */
@Component
public class CategoriaProfessorView extends NavigableInternalFrame<CategoriaProfessor> {

    /**
     * Método construtor da classe PrincipalAtribuicaoView
     */
    public CategoriaProfessorView() {
    }

    @PostConstruct
    private void init() {
        initComponents();
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

        listCategorias = ObservableCollections.observableList(new ArrayList<CategoriaProfessor>());
        categoriaBean = new br.com.etec.model.CategoriaProfessor();
        panelPrincipal = new javax.swing.JPanel();
        paneltitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelTable = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        tbCategorias = new javax.swing.JTable();
        panelDados = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblRecordInfo = new javax.swing.JTextArea();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        panelNavegacao = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        painelAcoes = new javax.swing.JPanel();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setOpaque(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        panelPrincipal.setLayout(new javax.swing.BoxLayout(panelPrincipal, javax.swing.BoxLayout.PAGE_AXIS));

        paneltitulo.setPreferredSize(new java.awt.Dimension(1198, 40));
        paneltitulo.setLayout(new java.awt.GridBagLayout());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Categorias");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 30, 20);
        paneltitulo.add(lblTitulo, gridBagConstraints);

        panelPrincipal.add(paneltitulo);

        panelTable.setLayout(new java.awt.GridBagLayout());

        tbCategorias.setNextFocusableComponent(txtId);
        tbCategorias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listCategorias, tbCategorias);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigo}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        scrollTable.setViewportView(tbCategorias);
        tbCategorias.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbCategorias.getColumnModel().getColumn(0).setResizable(false);
        tbCategorias.getColumnModel().getColumn(1).setResizable(false);

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
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDados.add(jScrollPane2, gridBagConstraints);

        lblId.setText("Código:");
        lblId.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 3, 5);
        panelDados.add(lblId, gridBagConstraints);

        txtId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtId.setNextFocusableComponent(txtNome);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tbCategorias, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigo}"), txtId, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 10, 5);
        panelDados.add(txtId, gridBagConstraints);

        lblNome.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 10, 5);
        panelDados.add(lblNome, gridBagConstraints);

        txtNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNome.setNextFocusableComponent(btnIncluir);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tbCategorias, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), txtNome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 3, 5);
        panelDados.add(txtNome, gridBagConstraints);

        panelNavegacao.setPreferredSize(new java.awt.Dimension(300, 50));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 2, 5);
        flowLayout1.setAlignOnBaseline(true);
        panelNavegacao.setLayout(flowLayout1);

        btnPrimeiro.setText("|<<");
        btnPrimeiro.setToolTipText("Primeiro Registro");
        btnPrimeiro.setNextFocusableComponent(btnAnterior);
        btnPrimeiro.setPreferredSize(new java.awt.Dimension(55, 25));
        panelNavegacao.add(btnPrimeiro);

        btnAnterior.setText("<");
        btnAnterior.setToolTipText("Registro Anterior");
        btnAnterior.setMaximumSize(new java.awt.Dimension(53, 23));
        btnAnterior.setMinimumSize(new java.awt.Dimension(53, 23));
        btnAnterior.setNextFocusableComponent(btnProximo);
        btnAnterior.setPreferredSize(new java.awt.Dimension(55, 25));
        panelNavegacao.add(btnAnterior);

        btnProximo.setText(">");
        btnProximo.setToolTipText("Próximo Registro");
        btnProximo.setMaximumSize(new java.awt.Dimension(53, 23));
        btnProximo.setMinimumSize(new java.awt.Dimension(53, 23));
        btnProximo.setNextFocusableComponent(btnUltimo);
        btnProximo.setPreferredSize(new java.awt.Dimension(55, 25));
        panelNavegacao.add(btnProximo);

        btnUltimo.setText(">>|");
        btnUltimo.setToolTipText("Último Registro");
        btnUltimo.setNextFocusableComponent(tbCategorias);
        btnUltimo.setPreferredSize(new java.awt.Dimension(55, 25));
        panelNavegacao.add(btnUltimo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 70;
        panelDados.add(panelNavegacao, gridBagConstraints);

        painelAcoes.setMaximumSize(new java.awt.Dimension(300, 35));
        painelAcoes.setMinimumSize(new java.awt.Dimension(300, 35));
        painelAcoes.setPreferredSize(new java.awt.Dimension(300, 35));

        btnIncluir.setText("Incluir");
        btnIncluir.setActionCommand("incluir");
        btnIncluir.setNextFocusableComponent(btnAlterar);
        btnIncluir.setPreferredSize(new java.awt.Dimension(75, 25));
        painelAcoes.add(btnIncluir);

        btnAlterar.setText("Alterar");
        btnAlterar.setActionCommand("ListarCargoView.alterar");
        btnAlterar.setNextFocusableComponent(btnExcluir);
        btnAlterar.setPreferredSize(new java.awt.Dimension(75, 25));
        painelAcoes.add(btnAlterar);

        btnExcluir.setText("Excluir");
        btnExcluir.setActionCommand("ListarCargoView.excluir");
        btnExcluir.setNextFocusableComponent(btnSalvar);
        btnExcluir.setPreferredSize(new java.awt.Dimension(75, 25));
        painelAcoes.add(btnExcluir);

        btnSalvar.setText("Salvar");
        btnSalvar.setActionCommand("ListarCargoView.salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.setNextFocusableComponent(btnCancelar);
        btnSalvar.setPreferredSize(new java.awt.Dimension(75, 25));
        painelAcoes.add(btnSalvar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setActionCommand("ListarCargoView.cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setNextFocusableComponent(btnPrimeiro);
        btnCancelar.setPreferredSize(new java.awt.Dimension(75, 25));
        painelAcoes.add(btnCancelar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 30;
        panelDados.add(painelAcoes, gridBagConstraints);

        panelPrincipal.add(panelDados);

        getContentPane().add(panelPrincipal);

        bindingGroup.bind();

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-384)/2, (screenSize.height-576)/2, 384, 576);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoriaProfessorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CategoriaProfessorView().setVisible(true);
            }
        });
    }
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
    private br.com.etec.model.CategoriaProfessor categoriaBean;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextArea lblRecordInfo;
    private javax.swing.JLabel lblTitulo;
    private java.util.List<CategoriaProfessor> listCategorias;
    private javax.swing.JPanel painelAcoes;
    private javax.swing.JPanel panelDados;
    private javax.swing.JPanel panelNavegacao;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTable;
    private javax.swing.JPanel paneltitulo;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable tbCategorias;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public JButton getBtnAlterar() {
        return btnAlterar;
    }

    @Override
    public JButton getBtnAnterior() {
        return btnAnterior;
    }

    @Override
    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    @Override
    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    @Override
    public JButton getBtnIncluir() {
        return btnIncluir;
    }

    @Override
    public JButton getBtnPrimeiro() {
        return btnPrimeiro;
    }

    @Override
    public JButton getBtnProximo() {
        return btnProximo;
    }

    @Override
    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    @Override
    public JButton getBtnUltimo() {
        return btnUltimo;
    }

    @Override
    public JTextArea getDadosNavegacao() {
        return lblRecordInfo;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    @Override
    public JTable getTable() {
        return tbCategorias;
    }

    @Override
    public CategoriaProfessor getModel() {
       return categoriaBean;
    }

    @Override
    public void setModel(CategoriaProfessor categoriaProfessor ){
        this.categoriaBean = categoriaProfessor;
    }

    @Override
    public List<CategoriaProfessor> getList() {
        return this.listCategorias;
    }
}
