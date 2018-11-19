/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project16;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author proxc
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        RenderChart();
        home.setVisible(true);
        panel_relatorio.setVisible(false);
        pnl_conexao.setVisible(false);
        pnl_chart.setVisible(true);
    }

    //cria uma conexao com o arduino
    Arduino conn = new Arduino();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        pnl_home = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnl_sidebar = new javax.swing.JPanel();
        btn_conectar = new javax.swing.JLabel();
        btn_home = new javax.swing.JLabel();
        btn_monitorar_consumo = new javax.swing.JLabel();
        btn_resto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnl_chart = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        StatusConexao = new javax.swing.JLabel();
        panel_relatorio = new javax.swing.JPanel();
        pnl_conexao = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBLedOn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Jbl_FeebackCon = new javax.swing.JLabel();
        JBLedOff = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);

        home.setBackground(new java.awt.Color(255, 255, 255));
        home.setLayout(new javax.swing.BoxLayout(home, javax.swing.BoxLayout.LINE_AXIS));

        pnl_home.setMaximumSize(new java.awt.Dimension(32760, 32767));
        pnl_home.setPreferredSize(new java.awt.Dimension(784, 39));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Bem vindo ao Controlador da sua casa");
        jLabel8.setPreferredSize(new java.awt.Dimension(180, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Para acessar os recursos clique em uma das opções ao lado");
        jLabel12.setPreferredSize(new java.awt.Dimension(180, 40));

        javax.swing.GroupLayout pnl_homeLayout = new javax.swing.GroupLayout(pnl_home);
        pnl_home.setLayout(pnl_homeLayout);
        pnl_homeLayout.setHorizontalGroup(
            pnl_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_homeLayout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
            .addGroup(pnl_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_homeLayout.createSequentialGroup()
                    .addGap(222, 222, 222)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(227, Short.MAX_VALUE)))
        );
        pnl_homeLayout.setVerticalGroup(
            pnl_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_homeLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
            .addGroup(pnl_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_homeLayout.createSequentialGroup()
                    .addGap(201, 201, 201)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(155, Short.MAX_VALUE)))
        );

        home.add(pnl_home);

        pnl_sidebar.setBackground(new java.awt.Color(34, 41, 50));
        pnl_sidebar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnl_sidebarMouseDragged(evt);
            }
        });
        pnl_sidebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_sidebarMousePressed(evt);
            }
        });

        btn_conectar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_conectar.setForeground(new java.awt.Color(166, 166, 166));
        btn_conectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project16/Icons/plus_18px_1.png"))); // NOI18N
        btn_conectar.setText("Conectar");
        btn_conectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_conectarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_conectarMousePressed(evt);
            }
        });

        btn_home.setBackground(new java.awt.Color(48, 201, 235));
        btn_home.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_home.setForeground(new java.awt.Color(48, 201, 235));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project16/Icons/home_18px.png"))); // NOI18N
        btn_home.setText("Inicio");
        btn_home.setToolTipText("");
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_homeMousePressed(evt);
            }
        });

        btn_monitorar_consumo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_monitorar_consumo.setForeground(new java.awt.Color(166, 166, 166));
        btn_monitorar_consumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project16/Icons/clock_18px.png"))); // NOI18N
        btn_monitorar_consumo.setText("Monitorar Consumo");
        btn_monitorar_consumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_monitorar_consumoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_monitorar_consumoMousePressed(evt);
            }
        });

        btn_resto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_resto.setForeground(new java.awt.Color(166, 166, 166));
        btn_resto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project16/Icons/search_18px_2.png"))); // NOI18N
        btn_resto.setText("Ajustes Grafico");
        btn_resto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_restoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_restoMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(22, 27, 33));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("São Judas 2018");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(21, 21, 21))
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project16/Nova Pasta/if__house_snowglobe_1679641 (1).png"))); // NOI18N

        javax.swing.GroupLayout pnl_sidebarLayout = new javax.swing.GroupLayout(pnl_sidebar);
        pnl_sidebar.setLayout(pnl_sidebarLayout);
        pnl_sidebarLayout.setHorizontalGroup(
            pnl_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_sidebarLayout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addGroup(pnl_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_monitorar_consumo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_conectar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_resto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        pnl_sidebarLayout.setVerticalGroup(
            pnl_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_sidebarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_monitorar_consumo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_conectar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_resto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_chart.setBackground(new java.awt.Color(54, 63, 73));
        pnl_chart.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnl_chartMouseDragged(evt);
            }
        });
        pnl_chart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_chartMousePressed(evt);
            }
        });
        pnl_chart.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(34, 41, 50));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("X  ");
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        pnl_chart.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        StatusConexao.setForeground(new java.awt.Color(255, 0, 51));
        StatusConexao.setText("Desconectado");
        pnl_chart.add(StatusConexao, java.awt.BorderLayout.LINE_START);

        panel_relatorio.setBackground(new java.awt.Color(255, 255, 255));
        panel_relatorio.setEnabled(false);
        panel_relatorio.setLayout(new javax.swing.BoxLayout(panel_relatorio, javax.swing.BoxLayout.LINE_AXIS));

        pnl_conexao.setBackground(new java.awt.Color(255, 255, 255));
        pnl_conexao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_conexao.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Deseja Se conectar ao Arduino ?");
        jLabel4.setPreferredSize(new java.awt.Dimension(180, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Clique no botao para se conectar:");

        jBLedOn.setBackground(new java.awt.Color(153, 255, 153));
        jBLedOn.setText("Conectar");
        jBLedOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLedOnActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Status:");

        Jbl_FeebackCon.setText("Não Conectado");

        JBLedOff.setText("Desconectar");
        JBLedOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLedOffActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Conexão com o Arduino");

        javax.swing.GroupLayout pnl_conexaoLayout = new javax.swing.GroupLayout(pnl_conexao);
        pnl_conexao.setLayout(pnl_conexaoLayout);
        pnl_conexaoLayout.setHorizontalGroup(
            pnl_conexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_conexaoLayout.createSequentialGroup()
                .addGroup(pnl_conexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_conexaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(0, 653, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(pnl_conexaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_conexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_conexaoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(76, 76, 76))
                    .addGroup(pnl_conexaoLayout.createSequentialGroup()
                        .addGroup(pnl_conexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(pnl_conexaoLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(27, 27, 27)
                                .addComponent(Jbl_FeebackCon)))
                        .addGap(0, 525, Short.MAX_VALUE))))
            .addGroup(pnl_conexaoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jBLedOn)
                .addGap(40, 40, 40)
                .addComponent(JBLedOff)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_conexaoLayout.setVerticalGroup(
            pnl_conexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_conexaoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(pnl_conexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Jbl_FeebackCon))
                .addGap(52, 52, 52)
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addGroup(pnl_conexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLedOn)
                    .addComponent(JBLedOff))
                .addGap(70, 70, 70)
                .addComponent(jButton2)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_conexao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(241, 241, 241)
                    .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 232, Short.MAX_VALUE)
                    .addComponent(panel_relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_chart, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_conexao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(174, Short.MAX_VALUE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 56, Short.MAX_VALUE)
                    .addComponent(panel_relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int xx;
    int xy;
    private void pnl_chartMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_chartMousePressed
        // TODO add your handling code here:
        System.out.print("clicaram no grafico");

    }//GEN-LAST:event_pnl_chartMousePressed

    private void pnl_chartMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_chartMouseDragged
        // TODO add your handling code here:


    }//GEN-LAST:event_pnl_chartMouseDragged

    private void btn_homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMousePressed
        setLblColor(btn_home);
        resetLblColor(btn_monitorar_consumo);
        resetLblColor(btn_resto);
        resetLblColor(btn_conectar);
        //mostra os paineis de novo
        pnl_chart.setVisible(true);
        pnl_conexao.setVisible(false);
    }//GEN-LAST:event_btn_homeMousePressed

    private void btn_monitorar_consumoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_monitorar_consumoMousePressed
        // TODO add your handling code here:
        setLblColor(btn_monitorar_consumo);
        resetLblColor(btn_home);
        resetLblColor(btn_resto);
        resetLblColor(btn_conectar);
    }//GEN-LAST:event_btn_monitorar_consumoMousePressed

    private void btn_conectarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_conectarMousePressed
        // TODO add your handling code here:
        setLblColor(btn_conectar);
        resetLblColor(btn_monitorar_consumo);
        resetLblColor(btn_resto);
        resetLblColor(btn_home);
    }//GEN-LAST:event_btn_conectarMousePressed

    private void btn_restoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoMousePressed
        // TODO add your handling code here:
        RenderChart();
        setLblColor(btn_resto);
        resetLblColor(btn_monitorar_consumo);
        resetLblColor(btn_home);
        resetLblColor(btn_conectar);

    }//GEN-LAST:event_btn_restoMousePressed

    private void pnl_sidebarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_sidebarMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnl_sidebarMousePressed

    private void pnl_sidebarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_sidebarMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnl_sidebarMouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel1MousePressed

    private void btn_monitorar_consumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_monitorar_consumoMouseClicked
        pnl_chart.setVisible(true);
        pnl_conexao.setVisible(false);
        home.setVisible(false);
        panel_relatorio.setVisible(true);

    }//GEN-LAST:event_btn_monitorar_consumoMouseClicked

    private void btn_conectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_conectarMouseClicked
        pnl_conexao.setVisible(true);
        pnl_chart.setVisible(false);

        jLabel1.setVisible(true);
        pnl_chart.setVisible(true);

    }//GEN-LAST:event_btn_conectarMouseClicked

    private void jBLedOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLedOnActionPerformed
        // conn.comunicacaoArduino(jBLedOn);
        Jbl_FeebackCon.setForeground(Color.green);
        StatusConexao.setForeground(Color.green);

        //arduino
        String status = StatusConexao.getText();
        if (status.equals("Desconectado")) {
            //arduino 
            Jbl_FeebackCon.setText("Conectado");
            StatusConexao.setText("Conectado");
            Arduino main = new Arduino();
            main.initialize();
            Thread t = new Thread() {
                public void run() {
                    //the following line will keep this app alive for 1000 seconds,
                    //waiting for events to occur and responding to them (printing incoming messages to console).
                    try {
                        Thread.sleep(1000000);
                    } catch (InterruptedException ie) {
                    }
                }
            };
            t.start();
            System.out.println("Started");
    }//GEN-LAST:event_jBLedOnActionPerformed
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_restoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restoMouseClicked

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        home.setVisible(true);
        pnl_sidebar.setVisible(true);
        pnl_chart.setVisible(true);
        panel_relatorio.setVisible(false);

    }//GEN-LAST:event_btn_homeMouseClicked

    private void JBLedOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLedOffActionPerformed
        // conn.comunicacaoArduino(JBLedOff);

        Jbl_FeebackCon.setForeground(Color.red);
        Jbl_FeebackCon.setText("Desconected");
        StatusConexao.setText("Desconected");
        StatusConexao.setForeground(Color.red);
    }//GEN-LAST:event_JBLedOffActionPerformed

    public void setLblColor(JLabel lbl) {
        lbl.setForeground(new Color(48, 201, 235));
    }

    public void resetLblColor(JLabel lbl) {
        lbl.setForeground(new Color(166, 166, 166));
    }

    //Let's add a chart to top Jpanel
    //We are going to use JfreeCharts
    //Source will be 
    //Ofcourse before doing anything else you need to download JfreeCharts Lib and import into your project
    public CategoryDataset createDataset() {
        final double[][] data = new double[][]{
            {1.0, 4.0, 3.0, 5.0, 5.0, 7.0, 7.0, 8.0},
            {5.0, 7.0, 6.0, 8.0, 4.0, 4.0, 2.0, 1.0},
            {4.0, 3.0, 2.0, 3.0, 6.0, 3.0, 4.0, 3.0}
        };

        final CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
                "LED", "HORA", data
        );
        return dataset;
    }

    private XYDataset createDataset2() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Object 1");
        XYSeries series2 = new XYSeries("Object 2");
        XYSeries series3 = new XYSeries("Object 3");
        
        //Aqui é onde vai os resultados que tem que trazer do banco de dados para alimentar o grafico
        
        series1.add(1.0, 2.0);
        series1.add(2.0, 3.0);
        series1.add(3.0, 2.5);
        series1.add(3.5, 2.8);
        series1.add(4.2, 6.0);

        series2.add(2.0, 12.0);
        series2.add(2.5, 2.4);
        series2.add(3.2, 1.2);
        series2.add(3.9, 2.8);
        series2.add(4.6, 3.0);

        series3.add(1.2, 4.0);
        series3.add(2.5, 4.4);
        series3.add(3.8, 4.2);
        series3.add(4.3, 3.8);
        series3.add(4.5, 4.0);

        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);

        return dataset;
    }

    void RenderChart() {
        CategoryDataset ds = createDataset();

        JFreeChart chart = ChartFactory.createStackedAreaChart("Total de Consumo de Energia", "TEMPO", "QNTIDADE DE ENERGIA GASTA", ds, PlotOrientation.HORIZONTAL, true, true, true);
        chart.setBackgroundPaint(new Color(54, 63, 73));
        chart.setBorderVisible(false);
        chart.setBorderPaint(new Color(54, 63, 73));
        chart.getCategoryPlot().setBackgroundPaint(new Color(54, 63, 73));
        chart.getCategoryPlot().setDomainGridlinePaint(new Color(54, 63, 73));
        chart.getCategoryPlot().setDomainGridlinesVisible(false);
        chart.getCategoryPlot().setOutlinePaint(new Color(54, 63, 73));

        ChartPanel cp = new ChartPanel(chart);
        cp.setBackground(new Color(54, 63, 73));

        panel_relatorio.add(cp, BorderLayout.AFTER_LAST_LINE);
        panel_relatorio.validate();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);

            }

        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBLedOff;
    private javax.swing.JLabel Jbl_FeebackCon;
    private javax.swing.JLabel StatusConexao;
    private javax.swing.JLabel btn_conectar;
    private javax.swing.JLabel btn_home;
    private javax.swing.JLabel btn_monitorar_consumo;
    private javax.swing.JLabel btn_resto;
    private javax.swing.JPanel home;
    private javax.swing.JButton jBLedOn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panel_relatorio;
    private javax.swing.JPanel pnl_chart;
    private javax.swing.JPanel pnl_conexao;
    private javax.swing.JPanel pnl_home;
    private javax.swing.JPanel pnl_sidebar;
    // End of variables declaration//GEN-END:variables
}