/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.model.DefaultModel;
import br.com.etec.service.AbstractService;
import br.com.etec.util.Operacao;
import br.com.etec.util.view.NavigableInternalFrame;
import br.com.etec.view.CategoriaProfessorView;
import br.com.etec.view.action.AbstractAction;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

/**
 * Controller abstrato direcionado a gerenciar componentes JInternalFrame que
 * sejam instanciados dentro do MainController.
 *
 * Possui uma view interna, bastando criar outras views nos filhos
 * caso necessário
 *
 * @see br.com.etec.controller.AbstractController
 *
 * @author Diego Neri - #diegoneri
 */
@Controller
public abstract class PagingController<S extends AbstractService , F extends NavigableInternalFrame<M> , M extends DefaultModel> extends AbstractInternalController<S , F , M> {

    private Integer pageNumber;
    private Integer lastPageNumber;
    private Long maxResults;
    private Integer pageSize = 10;
    private List<M> page;
    private final Integer FIRST_PAGE = 1;
    private Operacao operacao = Operacao.NENHUM;
    //FIXME
    //1 - Adicionar método que receba todos os componentes de texto
    private List<JComponent> componentesList;

    protected abstract void clearFields();

    protected abstract void enableFields(final Boolean flag);

    protected abstract void setDefaultFocusedComponent();

    protected abstract JComponent getIdentityComponent();

    protected abstract M getNewModel();

    protected Operacao getOperacao(){
        return operacao;
    }

    @Deprecated
    public PagingController() {
    }

    @Deprecated
    public PagingController(MainController parent) {
        super(parent);
    }

    public PagingController(S service , F view) {
        super(service , view);
    }

    private String extrairTextoNavegacao() {
        String texto = "Página " + pageNumber + " de " + lastPageNumber
                + "\nTotal de " + maxResults + " registro(s)";
        return texto;
    }

    @Override
    protected final F getView() {
        return super.getView();
    }

    @Override
    protected void init() {
        super.init();

        registerNavigableActions();
        registerCRUDActions();
        maxResults = super.getService().count();
        super.getService().setMaxResults(pageSize);
        firstPage();
        postInitTableData();
        enableFields(false);
    }


    /*
     * Adiciona listeners para os botões INCLUIR, ALTERAR, EXCLUIR, SALVAR e
     * CANCELAR
     */
    private void registerCRUDActions() {
        registerAction(getView().getBtnIncluir() , new AbstractAction() {
            @Override
            protected void action() {
                getView().getList().add(getNewModel());
            }

            @Override
            protected void posAction() {
                initFields(getView().getList().size() - 1 , Operacao.INCLUIR);
            }
        });
        registerAction(getView().getBtnAlterar() , new AbstractAction() {
            @Override
            protected void action() {
                initFields(getView().getTable().getSelectedRow() , Operacao.ALTERAR);
            }
        });
        registerAction(getView().getBtnExcluir() , new AbstractAction() {
            @Override
            protected void action() {
                int resposta =
                        JOptionPane.showConfirmDialog(getView() , "Deseja excluir o item selecionado?" , "Exclusão" , JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
                if (resposta == JOptionPane.YES_OPTION) {
                    getService().delete(getView().getModel());
                    getView().getList().remove(getView().getModel());
                }
            }

            @Override
            protected void posAction() {
                initFields(-1 , Operacao.NENHUM);
            }
        });
        registerAction(getView().getBtnSalvar() , new AbstractAction() {
            @Override
            protected void action() {
                switch (operacao) {
                    case INCLUIR:
                        getService().saveAndFlush(getView().getModel());
                        break;
                    case ALTERAR:
                        getService().save(getView().getModel());
                        break;
                    default:
                        throw new RuntimeException("Erro ao persistir dados: Não há operação definida");
                }
            }

            @Override
            protected void posAction() {
                initFields(-1 , Operacao.NENHUM);
            }
        });
        registerAction(getView().getBtnCancelar() , new AbstractAction() {
            @Override
            protected void action() {
                setPageList();
            }

            @Override
            protected void posAction() {
                initFields(-1 , Operacao.NENHUM);
            }
        });
    }

    /*
     * Adiciona listeners para os botões de navegação
     */
    private void registerNavigableActions() {
        registerAction(getView().getBtnPrimeiro() , new AbstractAction() {
            @Override
            protected void action() {
                firstPage();
            }
        });
        registerAction(getView().getBtnAnterior() , new AbstractAction() {
            @Override
            protected void action() {
                previousPage();
            }
        });
        registerAction(getView().getBtnProximo() , new AbstractAction() {
            @Override
            protected void action() {
                nextPage();
            }
        });
        registerAction(getView().getBtnUltimo() , new AbstractAction() {
            @Override
            protected void action() {
                lastPage();
            }
        });

    }

    private void initFields(int row , Operacao operacao) {
        this.operacao = operacao;
        if (operacao == Operacao.NENHUM) {
            //SALVAR, CANCELAR, EXCLUIR, ATUALIZAR
            int index = getView().getTable().getSelectedRow();
            getView().getTable().getSelectionModel().clearSelection();
            clearFields();
            if (index < 0) {
                index = 0;
            }
            this.getView().getTable().setRowSelectionInterval(index , index);
            this.maxResults = super.getService().count();
            this.setPageList();
            this.enableComponents(false);
        } else {
            //INCLUIR E ALTERAR
            getView().getTable().setRowSelectionInterval(row , row);
            getView().getTable().scrollRectToVisible(getView().getTable().getCellRect(row , 0 , true));
            this.enableComponents(true);
            this.setDefaultFocusedComponent();
        }
    }

    /**
     * Este método faz a pós inicialização da tabela de dados da view,
     * adicionando um listener de seleção à tabela, com a criação de uma classe
     * anônima a partir da interface
     * <code>ListSelectionListener</code>.
     * <p/>
     * Controla a funcionalidade de adição / exclusão do form
     */
    private void postInitTableData() {
        this.getView().getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (getView().getTable().getSelectedRow() != -1) {
                    getView().setModel(getView().getList().get(getView().getTable().getSelectedRow()));
                    getView().getBtnAlterar().setEnabled(Boolean.TRUE);
                    getView().getBtnExcluir().setEnabled(Boolean.TRUE);
                } else {
                    getView().setModel(null);
                    getView().getBtnAlterar().setEnabled(Boolean.FALSE);
                    getView().getBtnExcluir().setEnabled(Boolean.FALSE);
                }
            }
        });
    }

    /**
     * Permite que os botões sejam habilitados ou desabilitados conforme a
     * operação exercida sob a View.
     * <p/>
     * @param flag
     */
    private void habilitarBotoesNavegacao(boolean flag) {
        this.getView().getBtnPrimeiro().setEnabled(flag ? getPageNumber() > 1 : flag);
        this.getView().getBtnAnterior().setEnabled(flag ? getPageNumber() > 1 : flag);
        this.getView().getBtnProximo().setEnabled(flag ? getPageNumber() < getLastPageNumber() : flag);
        this.getView().getBtnUltimo().setEnabled(flag ? getPageNumber() < getLastPageNumber() : flag);
    }

    /**
     * Faz o controle de acesso aos botões do
     * <code>NavigableInternalFrame</code>
     * <warning>Deve haver a sobrescrita do mesmo para o controle dos
     * campos</warning>
     * <p/>
     * @param flag
     */
    private void enableComponents(final boolean flag) {
        this.enableFields(flag);

        this.getView().getTable().setEnabled(!flag);

        this.getView().getBtnIncluir().setEnabled(!flag);
        this.getView().getBtnAlterar().setEnabled(!flag);
        this.getView().getBtnExcluir().setEnabled(!flag);

        this.getView().getBtnSalvar().setEnabled(flag);
        this.getView().getBtnCancelar().setEnabled(flag);

        this.habilitarBotoesNavegacao(!flag);
    }

    private void setPageList() {
        this.page = super.getService().findAll(pageNumber);
        this.lastPageNumber = super.getService().getLastPage();

        this.getView().getList().clear();
        this.getView().getList().addAll(page);

        this.getView().getDadosNavegacao().setText(extrairTextoNavegacao());

        if (this.getView().getList().size() > 0) {
            this.getView().getTable().setRowSelectionInterval(0 , 0);
        }

        habilitarBotoesNavegacao(true);
    }

    private void firstPage() {
        this.pageNumber = FIRST_PAGE;
        this.setPageList();
    }

    private void previousPage() {
        if (--pageNumber < FIRST_PAGE) {
            pageNumber = FIRST_PAGE;
        }
        this.setPageList();
    }

    private void nextPage() {
        if (++pageNumber > lastPageNumber) {
            pageNumber = lastPageNumber;
        }
        this.setPageList();
    }

    private void lastPage() {
        this.pageNumber = lastPageNumber;
        this.setPageList();
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getLastPageNumber() {
        return lastPageNumber;
    }

    public Long getMaxResults() {
        return maxResults;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}
