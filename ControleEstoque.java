/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Alisson
 */
public class ControleEstoque extends JFrame { 
    private static final long serialVersionUID = 1L;
	private JLabel labelCodigo, labelDescricao, labelCategoria, labelPrecoDeVenda, labelPrecoDeCusto, labelEstoqueAtual, labelUnidadeMedida, labelLimiteDeEstoque;
	private JButton btnSalvar, btnFechar, btnLimpar; 
	private JTextField tfCodigo, tfDescricao, tfCategoria, tfPrecoDeVenda, tfPrecoDeCusto, tfEstoqueAtual, tfUnidadeMedida, tfLimiteDeEstoque;
        
        public static void main(String args[]){
            //Intancia do objeto da classe JFrame.
            JFrame frame = new ControleEstoque();
            
            //Permite fechar a JFrame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            //Define JFrame visível
            frame.setVisible(true);
        }
    
    

    /**
     * Cronstrução da classe ControleEstoque
     */
    public ControleEstoque() {
        //Chamada dos métodos
       
        iniciaComponentes();
        defineEventos();
        
    }
    

    /**
     * Método iniciaComponentes, contém os atributos utilizados na JFrame
     */
    
    public void iniciaComponentes(){
        //Define título da JFrame.
        setTitle("Estoques");
        
        setBounds(10, 10, 700, 700);
        
        setBackground(new Color(240, 240, 240));
        
        
        
        labelCodigo = new JLabel("Código de barra  ");
        labelDescricao = new JLabel("Descrição  ");
        labelCategoria = new JLabel("Categoria  ");
        labelPrecoDeVenda = new JLabel("Preço de venda  ");
        labelPrecoDeCusto = new JLabel("Preço de custo  ");
        labelEstoqueAtual = new JLabel("Estoque atual  ");
        labelUnidadeMedida = new JLabel("Unidade medida  ");
        labelLimiteDeEstoque = new JLabel("Limite de estoque  ");
        
        btnSalvar = new JButton("Salvar");
        btnFechar = new JButton("X");
        btnLimpar = new JButton("Limpar");
        
        tfCodigo = new JTextField();
        tfDescricao = new JTextField();
        tfCategoria = new JTextField();
        tfPrecoDeVenda = new JTextField();
        tfPrecoDeCusto = new JTextField();
        tfEstoqueAtual = new JTextField();
        tfUnidadeMedida = new JTextField();
        tfLimiteDeEstoque = new JTextField();
        
        //Definição das coordenadas dos componentes JLabel,JButton e JTextField.
        setLayout(null);
        
        
        labelCodigo.setBounds(50, 40, 100, 20);
        labelDescricao.setBounds(50, 80, 100, 20);
        labelCategoria.setBounds(50, 120, 100, 20);
        labelPrecoDeVenda.setBounds(50, 160, 100, 20);
        labelPrecoDeCusto.setBounds(50, 200, 100, 20);
        labelEstoqueAtual.setBounds(50, 240, 100, 20);
        labelUnidadeMedida.setBounds(50, 280, 100, 20);
        labelLimiteDeEstoque.setBounds(50, 320, 120, 20);
        
        btnSalvar.setBounds(95, 420, 75, 20);
        btnFechar.setBounds(620, 5, 50, 20);
        btnLimpar.setBounds(235, 420, 75, 20);
        
        tfCodigo.setBounds(160, 40, 240, 20);
        tfDescricao.setBounds(160, 80, 240, 20);
        tfCategoria.setBounds(160, 120, 240, 20);
        tfPrecoDeVenda.setBounds(160, 160, 240, 20);
        tfPrecoDeCusto.setBounds(160, 200, 240, 20);
        tfEstoqueAtual.setBounds(160, 240, 240, 20);
        tfUnidadeMedida.setBounds(160, 280, 240, 20);
        tfLimiteDeEstoque.setBounds(160, 320, 240, 20);
    
        //Adiciona os componentes JLabel, JButton e JTextField a JFrame.   
        
        
        add(labelCodigo);
        add(labelDescricao);
        add(labelCategoria);
        add(labelPrecoDeVenda);
        add(labelPrecoDeCusto);
        add(labelEstoqueAtual);
        add(labelUnidadeMedida);
        add(labelLimiteDeEstoque);
        
        add(btnSalvar);
        add(btnFechar);
        add(btnLimpar);
        
        add(tfCodigo);
        add(tfDescricao);
        add(tfCategoria);
        add(tfPrecoDeVenda);
        add(tfPrecoDeCusto);
        add(tfEstoqueAtual);
        add(tfUnidadeMedida);
        add(tfLimiteDeEstoque);
        
    }
    
    //Definição dos eventos que serão executados por cada componentes
    public void defineEventos(){
        // Evento do Botão Limpar.
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Limpa todos os campos.
				tfCodigo.setText("");
				tfDescricao.setText("");
				tfCategoria.setText("");
                                tfPrecoDeVenda.setText("");
                                tfPrecoDeCusto.setText("");
                                tfEstoqueAtual.setText("");
                                tfUnidadeMedida.setText("");
                                tfLimiteDeEstoque.setText("");
			}
		});
        //Evento botão Salvar
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                //Verifica se os campos estão vazios e exibe caixa de dialogo.
                
                if (tfCodigo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"O Código não pode está vazio!");
                    tfCodigo.requestFocus();
                } else if (tfDescricao.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"A Descrição não pode está vazio!");
                    tfDescricao.requestFocus();    
                }else if (tfCategoria.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"A Categoria não pode está vazio!");
                    tfCategoria.requestFocus();   
                }else if (tfPrecoDeVenda.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"O Preço de venda não pode está vazio!");
                    tfPrecoDeVenda.requestFocus();
                }else if (tfPrecoDeCusto.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"O Preço de custo não pode está vazio!");
                    tfPrecoDeCusto.requestFocus();
                }else if (tfEstoqueAtual.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"O Estoque atual não pode está vazio!");
                    tfEstoqueAtual.requestFocus();
                }else if (tfUnidadeMedida.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"A Unidade medida não pode está vazio!");
                    tfUnidadeMedida.requestFocus();
                }else if (tfLimiteDeEstoque.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"O Limite de estoque não pode está vazio!");
                    tfLimiteDeEstoque.requestFocus();    
                
                    
                    
                    
                }else {                            //Tratamento de erros.
                      try {
                          FileWriter arq = new FileWriter("C:\\Nova pasta\\estoques.txt");
                          PrintWriter gravarArq = new PrintWriter(arq);
                          
                          
                          
                          
                          gravarArq.println(tfCodigo.getText());
                          gravarArq.println(tfDescricao.getText());
                          gravarArq.println(tfCategoria.getText());
                          gravarArq.println(tfPrecoDeVenda.getText());
                          gravarArq.println(tfPrecoDeCusto.getText());
                          gravarArq.println(tfEstoqueAtual.getText());
                          gravarArq.println(tfUnidadeMedida.getText());
                          gravarArq.println(tfLimiteDeEstoque.getText());
                          
                          
                          arq.close();
                          
                          
                               JOptionPane.showMessageDialog(null,"Arquivo Gravado com Sucesso!");
                       
                    } catch (IOException Erro) {
			       JOptionPane.showMessageDialog(null, "Erro ao Gravar no Arquivo" + Erro );
                             
                          
                                               
                    }
                    
                }
	    }   
                
        });
        
       
    }      
            
            
        
        
        
        
    
            
    

        
        
        
          
              
                
		
                
                
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        textField1 = new java.awt.TextField();
        label3 = new java.awt.Label();
        textField2 = new java.awt.TextField();
        label4 = new java.awt.Label();
        textField3 = new java.awt.TextField();
        label5 = new java.awt.Label();
        textField4 = new java.awt.TextField();
        label6 = new java.awt.Label();
        textField5 = new java.awt.TextField();
        label7 = new java.awt.Label();
        textField6 = new java.awt.TextField();
        label8 = new java.awt.Label();
        textField7 = new java.awt.TextField();
        label9 = new java.awt.Label();
        textField8 = new java.awt.TextField();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setText("Estoques");

        label2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label2.setText("Código de barra :");

        label3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label3.setText("Descrição :\n");

        label4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label4.setText("Categoria :");

        label5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label5.setText("Preço de venda :");

        label6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label6.setText("Preço de custo :");

        textField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField5ActionPerformed(evt);
            }
        });

        label7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label7.setText("Estoque atual :");

        label8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label8.setText("Unidade medida :");

        label9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        label9.setText("Limite de estoque :");

        button1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        button1.setLabel("Salvar");

        button2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        button2.setLabel("X");

        button3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        button3.setLabel("Limpar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField5ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.TextField textField1;
    private java.awt.TextField textField2;
    private java.awt.TextField textField3;
    private java.awt.TextField textField4;
    private java.awt.TextField textField5;
    private java.awt.TextField textField6;
    private java.awt.TextField textField7;
    private java.awt.TextField textField8;
    // End of variables declaration//GEN-END:variables
}
