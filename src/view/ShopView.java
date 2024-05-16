package view;

import java.awt.EventQueue;
import javax.swing.*;

import main.Shop;
import utils.Constants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

public class ShopView extends JFrame implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Shop shop;  
    private JButton btnCount, btnAddProduct, btnAddStock, btnDeleteProduct;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ShopView frame = new ShopView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ShopView() {
    	 
        addKeyListener(this);
        setFocusable(true);
        setVisible(true);
        
        shop = new Shop();
        shop.loadInventory();
        
        setTitle("MiTienda.com - Principal Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 590, 432);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(206, 242, 224));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Choose or select an option");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblNewLabel.setBounds(94, 36, 381, 50);
        contentPane.add(lblNewLabel);
        
        btnCount = new JButton("1. Count");
        btnCount.setBounds(169, 97, 210, 50);
        contentPane.add(btnCount);
        btnCount.addActionListener(this);
        
        btnAddProduct = new JButton("2. Add Product");
        btnAddProduct.setBounds(169, 158, 210, 50);
        contentPane.add(btnAddProduct);
        btnAddProduct.addActionListener(this);
        
        btnAddStock = new JButton("3. Add Stock");
        btnAddStock.setBounds(169, 219, 210, 50);
        contentPane.add(btnAddStock);
        btnAddStock.addActionListener(this);
        
        btnDeleteProduct = new JButton("4. Delete Product");
        btnDeleteProduct.setBackground(new Color(255, 132, 135));
        btnDeleteProduct.setBounds(169, 280, 210, 50);
        contentPane.add(btnDeleteProduct);
        btnDeleteProduct.addActionListener(this);
       
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (e.getSource() == btnCount) {
            this.openCashView();
        } else if (e.getSource() == btnAddProduct) {
            this.openProductView(Constants.OPTION_ADD_PRODUCT);
        } else if (e.getSource() == btnAddStock) {
        	this.openProductView(Constants.OPTION_ADD_STOCK);
        } else if (e.getSource() == btnDeleteProduct) {
        	this.openProductView(Constants.OPTION_REMOVE_PRODUCT);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    private void openCashView() {
        CashView cashView = new CashView(shop);
        cashView.setVisible(true);
    }

    private void openProductView(int option) {
        ProductView productView = new ProductView(shop, option);
        productView.setSize(400,400);
        productView.setVisible(true);
    }
}

