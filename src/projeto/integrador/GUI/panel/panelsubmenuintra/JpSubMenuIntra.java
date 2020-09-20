
package projeto.integrador.GUI.panel.panelsubmenuintra;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import projeto.integrador.CarregaIMG;
import projeto.integrador.DAO.PostDAO;
import static projeto.integrador.animation.TAnimation.jSlidingPanel1;
import projeto.integrador.util.JSlidingPanel;

import sparkuniverse.table.tablemodel.TableModel;
import sparkuniverse.table.tablerendererbrwexp.TableRendererBrwExp;
import sparkuniverse.table.tablesorteruniverse.TableSorterUniv;



/**
 *
 * @author Rafael Dal Prá
 * Data: 27/04/2015
 */
public class JpSubMenuIntra extends javax.swing.JPanel {

    private static JTable jTabble = new JTable();// Tabela com os unitizadores ja cadastrados
    
    private JFrame frame = new JFrame();
    
    public JpSubMenuIntra() {
        
        initComponents();
        
        /* Objeto que carrega as imagens da tela*/
        CarregaIMG charge = new CarregaIMG();
        
        Image ImgBorder = charge.loadImage("image/lateral.png");
        Icon iCantos = new ImageIcon(ImgBorder);
        
    
        
        Image imgVoltar = charge.loadImage("image/voltar.png");
        Icon iVoltar = new ImageIcon(imgVoltar);
        
//        Image imgBtRfid = charge.loadImage("image/botao_rfid.png");
//        Icon iRfid = new ImageIcon(imgBtRfid);
        
//        Image imgBtRfidCorr = charge.loadImage("image/corredor.png");
//        Icon iRfidCorr = new ImageIcon(imgBtRfidCorr);
        

        
        JButton jBVoltar = new JButton();
        jBVoltar.setBounds(0,20,100, 70);
        jBVoltar.setHorizontalAlignment(SwingConstants.CENTER);
        jBVoltar.setContentAreaFilled(false);
        jBVoltar.setBorderPainted(false);
        jBVoltar.setIcon(iVoltar);
        jBVoltar.addActionListener((ActionEvent evet) -> {
          
            jSlidingPanel1.setDirectionMove(JSlidingPanel.MOVE_RIGHT);
            jSlidingPanel1.previous(0);  
        });
        
         /* Inicializa a tabela*/
        jTabble = new JTable(new TableSorterUniv(new TableModel(new Object[][]{{"", "", ""}},
                new Object[]{"Autor", "Mensagem"},
                new int[]{0, 1, 2}) {

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }
                }));

        jTabble.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// Redimensionavel dentro do ScrollPane
        jTabble.setRowHeight(40);//Tamanho linhas jtTabela1.
        jTabble.setShowGrid(true);//Linhas que separam as colunas, e linhas.
        jTabble.setFont(new Font("SansSerif", Font.BOLD, 22));// Fonte padrão da tabela
        
        ((TableSorterUniv) jTabble.getModel()).setTableHeader(jTabble.getTableHeader());
        TableColumnModel tcm = jTabble.getColumnModel();

        int ncols = jTabble.getColumnCount();// Número de linhas da tabela

        int[] iSizeCols = new int[]{100, 1440};//Tamanho das colunas na tabela

        TableRendererBrwExp tr = new TableRendererBrwExp();

        for (int c = 0; c < ncols; c++) {
            TableColumn tc = tcm.getColumn(c);
            tc.setCellRenderer(tr);
            if (c < iSizeCols.length) {
                jTabble.getColumnModel().getColumn(c).setPreferredWidth(iSizeCols[c]);
            }
        }
        
        jTPSubMenuIntra.setTitleAt(0, "Mensagens");
    
        jLBWest.add(jBVoltar);
        
        jLabel1.setIcon(iCantos);
        jLBWest.setIcon(iCantos);
        
        jScrollPane1.getViewport().add(jTabble, null);//ScrollPane adiciona a tabela
        jScrollPane1.getHorizontalScrollBar().setPreferredSize(new Dimension(Integer.SIZE, 15));//Tamanho Horizontal ScrollPane
        jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(15, Integer.SIZE));//Tamanho Vertical ScrollPane

        fillTable();
    }

    
   public static void fillTable() {


//        Object[][] obj ={{"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},{"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},{"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"},
//        {"Sistema", "É que daqui de um poco, não adianta, olha só, é o seguinte"}
//        
//        
//        };

        PostDAO postDAO = new PostDAO();
        Object [][] obj = postDAO.getPostData();
       
        TableSorterUniv ts = (TableSorterUniv) jTabble.getModel();
        TableModel tm = (TableModel) ts.getTableModel();

        if (tm.getRowCount() > 0) {
            tm.delAllRow();
        }
        tm.fireTableDataChanged();

        for (Object[] obj1 : obj) {
            tm.addRow(obj1);
        }
        tm.fireTableDataChanged();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTPSubMenuIntra = new javax.swing.JTabbedPane();
        jPSubMenuIntra = new javax.swing.JPanel();
        jLBWest = new javax.swing.JLabel();
        jPContainer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(197, 197, 197));

        jTPSubMenuIntra.setBackground(new java.awt.Color(197, 197, 197));

        jPSubMenuIntra.setBackground(new java.awt.Color(197, 197, 197));

        jPContainer.setBackground(new java.awt.Color(197, 197, 197));

        javax.swing.GroupLayout jPContainerLayout = new javax.swing.GroupLayout(jPContainer);
        jPContainer.setLayout(jPContainerLayout);
        jPContainerLayout.setHorizontalGroup(
            jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
        );
        jPContainerLayout.setVerticalGroup(
            jPContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContainerLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 294, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPSubMenuIntraLayout = new javax.swing.GroupLayout(jPSubMenuIntra);
        jPSubMenuIntra.setLayout(jPSubMenuIntraLayout);
        jPSubMenuIntraLayout.setHorizontalGroup(
            jPSubMenuIntraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSubMenuIntraLayout.createSequentialGroup()
                .addComponent(jLBWest, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPSubMenuIntraLayout.setVerticalGroup(
            jPSubMenuIntraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLBWest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPSubMenuIntraLayout.createSequentialGroup()
                .addComponent(jPContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTPSubMenuIntra.addTab("tab1", jPSubMenuIntra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPSubMenuIntra)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPSubMenuIntra, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLBWest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPContainer;
    private javax.swing.JPanel jPSubMenuIntra;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTabbedPane jTPSubMenuIntra;
    // End of variables declaration//GEN-END:variables
}
