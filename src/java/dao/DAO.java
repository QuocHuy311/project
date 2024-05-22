/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.DBContext;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.logging.Level;
import model.Account;
import model.Category;
import model.Product;
import java.util.logging.Logger;
import model.Cart;
import model.CategoryDTO;
import model.Item;

/**
 *
 * @author quoch
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> listProduct = new ArrayList<>();
        String sql = "select * from Product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return listProduct;
    }

    public ArrayList<Product> getNewProduct() {
        ArrayList<Product> listProduct = new ArrayList<>();
        String sql = "select top 4 * \n"
                + "from Product\n"
                + "order by product_id desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return listProduct;
    }

    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> listCategory = new ArrayList<>();
        String sql = "select * \n"
                + "from Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listCategory.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return listCategory;
    }

    public ArrayList<Product> getListProductByCategoryId(int id) {
        ArrayList<Product> listProduct = new ArrayList<>();
        String sql = "select product.*\n"
                + "from Product join Category \n"
                + "on Product.category_id = Category.category_id \n"
                + "where Category.category_id = " + id + " ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return listProduct;
    }

    public String getCategoryByCateid(int id) {
        String text = null;
        String sql = "select [name]\n"
                + "from [dbo].[Category]\n"
                + "where [category_id] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                text = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return text;
    }

    public Product getProductById(int id) {
        Product p = null;
        String sql = "select *\n"
                + "from Product \n"
                + "where Product.product_id = " + id + "";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return p;
    }

    public ArrayList<Product> getListProductByName(String name) {
        ArrayList<Product> listProduct = new ArrayList<>();
        String sql = "select * \n"
                + "from Product \n"
                + "where [name] like '%" + name + "%'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return listProduct;
    }

    public Account getAccountByEmailAndPassword(String email, String password) {
        Account a = null;
        String sql = "select *\n"
                + "from [dbo].[Account]\n"
                + "where [email] = '" + email + "'and [password] = '" + password + "'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
        }
        return a;
    }

    public void getRegister(String email, String password, String name, String address, int phonenumber) {
        String sql = "insert into [dbo].[Account]([password], [email], [isSell], [isAdmin], [phone], [fullname], [address])\n"
                + "values(?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.setBoolean(3, false);
            ps.setBoolean(4, false);
            ps.setInt(5, phonenumber);
            ps.setString(6, name);
            ps.setString(7, address);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

//    public void getRegister1(int accid, String name, String address, String phonenumber) {
//        String sql = "insert into [dbo].[User]([account_id], [full_name], [address], [phone_number])\n"
//                + "values(?, ?, ?, ?)";
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1, accid);
//            ps.setString(2, name);
//            ps.setString(3, address);
//            ps.setString(4, phonenumber);
//            ps.executeQuery();
//        } catch (Exception e) {
//        }
//    }
    public boolean checkDuplicateAccount(String username) {
        Account a = null;
        String sql = "select * \n"
                + "from [dbo].[Account]\n"
                + "where Account.email = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));;
            }
        } catch (Exception e) {
        }
        if (a != null) {
            return true;
        } else {
            return false;
        }
    }

    public void addOrder(Account u, Cart c) {
        LocalDate curDate = java.time.LocalDate.now();
//        Date date = (Date) Date.from(curDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        try {
            String sql = "insert into [dbo].[Order]([total_price], [account_id], [order_date])\n"
                    + "              values(?, ?, ?)";

            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                ps.setDouble(1, c.getTotalMoney());
                ps.setInt(2, u.getId());
                ps.setString(3, curDate.toString());
                ps.executeUpdate();
                // lấy ra id của Order vừa add
                String sqll = "SELECT top 1 order_id\n"
                        + "FROM     [Order]\n"
                        + "order by order_id desc";
                PreparedStatement ps1 = conn.prepareStatement(sqll);
                ResultSet rs = ps1.executeQuery();
                if (rs.next()) {
                    int oid = rs.getInt(1);
                    for (Item i : c.getItems()) {
                        String sql2 = "insert into [dbo].[OrderDetail]\n"
                                + "values(?, ?, ?, ?)";
                        PreparedStatement ps2 = conn.prepareStatement(sql2);
                        ps2.setInt(1, oid);
                        ps2.setInt(2, i.getProduct().getId());
                        ps2.setInt(3, i.getQuantity());
                        ps2.setDouble(4, i.getPrice());
                        ps2.executeUpdate();
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addOrderSale(Account u, Cart c, String sale) {
        LocalDate curDate = java.time.LocalDate.now();
//        Date date = (Date) Date.from(curDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        try {
            String sql = "insert into [dbo].[Order]([total_price], [account_id], [order_date])\n"
                    + "              values(?, ?, ?)";

            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(sql);
                ps.setDouble(1, c.getTotalMoney() * 0.5);
                ps.setInt(2, u.getId());
                ps.setString(3, curDate.toString());
                ps.executeUpdate();
                // lấy ra id của Order vừa add
                String sqll = "SELECT top 1 order_id\n"
                        + "FROM     [Order]\n"
                        + "order by order_id desc";
                PreparedStatement ps1 = conn.prepareStatement(sqll);
                ResultSet rs = ps1.executeQuery();
                if (rs.next()) {
                    int oid = rs.getInt(1);
                    for (Item i : c.getItems()) {
                        String sql2 = "insert into [dbo].[OrderDetail]\n"
                                + "values(?, ?, ?, ?)";
                        PreparedStatement ps2 = conn.prepareStatement(sql2);
                        ps2.setInt(1, oid);
                        ps2.setInt(2, i.getProduct().getId());
                        ps2.setInt(3, i.getQuantity());
                        ps2.setDouble(4, i.getPrice());
                        ps2.executeUpdate();
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addProduct(String name, String image, int size, String description, double price, int cateid, int stock, int sellid) {
        String sql = "insert into [dbo].[Product]([name], [image], [size], [description], [price], [category_id], [stock], [sellID])\n"
                + "values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setInt(3, size);
            ps.setString(4, description);
            ps.setDouble(5, price);
            ps.setInt(6, cateid);
            ps.setInt(7, stock);
            ps.setInt(8, sellid);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM [dbo].[Product]\n"
                + "WHERE [product_id] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();
            String sql1 = "DELETE FROM	[dbo].[OrderDetail]\n"
                    + "WHERE [product_id] = ?";
            conn = new DBContext().getConnection();
            PreparedStatement ps1 = conn.prepareStatement(sql);
            ps1.setInt(1, id);
            ps1.executeQuery();
        } catch (Exception e) {
        }
    }

    public void updateProduct(int id, String name, String image, int size, String description, double price, int cateid, int stock) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "SET [name] = ? , [image] = ? , [size] = ? , [description] = ?, [price] = ?, [category_id] = ?, [stock] = ?\n"
                + "WHERE [product_id] = " + id;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setInt(3, size);
            ps.setString(4, description);
            ps.setDouble(5, price);
            ps.setInt(6, cateid);
            ps.setInt(7, stock);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public ArrayList<Product> getAllProductByAccountId(int sellid) {
        ArrayList<Product> listProduct = new ArrayList<>();
        String sql = "select * \n"
                + "from [dbo].[Product] \n"
                + "where [sellID] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sellid);
            rs = ps.executeQuery();
            while (rs.next()) {
                listProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getDouble(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return listProduct;
    }

    public ArrayList<Account> getListAccount() {
        ArrayList<Account> listAccount = new ArrayList<>();
        String sql = "select * \n"
                + "from [dbo].[Account]";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));

                listAccount.add(a);
            }
        } catch (Exception e) {
        }
        return listAccount;
    }

    public void deleteAccount(int id) {
        String sql = "DELETE FROM [dbo].[Account]\n"
                + "WHERE [account_id] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public Account getAccountById(int id) {
        Account a = null;
        String sql = "select *\n"
                + "from [dbo].[Account]\n"
                + "where [account_id] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        } catch (Exception e) {
        }
        return a;
    }

    public void updateAccount(int accountid, String email, String password, String name, String address, int phonenumber, boolean issell, boolean isadmin) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "SET [password] = ?, [email] = ?, [isSell] = ?, [isAdmin] = ?, [phone] = ?, [fullname] = ?, [address] = ?\n"
                + "WHERE [account_id] = " + accountid;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.setBoolean(3, issell);
            ps.setBoolean(4, isadmin);
            ps.setInt(5, phonenumber);
            ps.setString(6, name);
            ps.setString(7, address);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public double getTotalMoneyByMonth(int month) {
        double total = 0;
        try {
            String sql = "select sum([total_price]) as totalprice\n"
                    + "from [dbo].[Order]\n"
                    + "where MONTH([order_date]) = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, month);
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public ArrayList<CategoryDTO> getQuantityCategory() {
        ArrayList<CategoryDTO> listO = new ArrayList<>();
        try {
            String sql = "SELECT SUM(OrderDetail.quantity) as total_quantity, Category.name\n"
                    + "FROM     Category INNER JOIN\n"
                    + "                  Product ON Category.category_id = Product.category_id INNER JOIN\n"
                    + "                  OrderDetail ON Product.product_id = OrderDetail.product_id\n"
                    + "group by Category.name";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int quantity = rs.getInt(1);
                String name = rs.getString(2);

                listO.add(new CategoryDTO(quantity, name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listO;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
//        ArrayList<Product> listProduct = dao.getListProductByCategoryId(1);
//        for (Product c : listProduct) {
//            System.out.println(c);
//        }
//        System.out.println(dao.checkDuplicateAccount("admin@gmail.com"));
//        dao.getRegister("huy@gmail.com", "11111111");
//          dao.getRegister("qhuy@gmail.com", "12345678", "Nguyễn Quốc Huy", "Hà Nội", "0123456789");
//        System.out.println(dao.checkDuplicateAccount("admin@gmail.com"));
//        ArrayList<Account> listA = dao.getListAccount();
//        for (Account account : listA) {
//            System.out.println(account);
//        }
        System.out.println(dao.getQuantityCategory());
    }
}
