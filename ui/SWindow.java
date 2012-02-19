package hostel.ui;

import hostel.db.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SWindow extends JFrame {

    public String query;
    JTabbedPane jtp;
    JPanel detail, hostel;
    String name, add, id, fa_name;
    Double phone;
    JTextField sname, padd, fname, ph;
    Color m;
    JButton submit, update;
    JLabel snamel, paddl, fnamel, phl, heading, msg;
    JButton h1, h2, h3, h4, h5, h6, m1, m2, m3, m4;
    JTable ht1, ht2, ht3, ht4, ht5, ht6;
    JScrollPane scrollPane;

    SWindow() {
        this.setSize(1000, 900);
        update = new JButton("Update address and phone");

        jtp = new JTabbedPane();
        detail = new JPanel();
        msg = new JLabel("WARNING:Multiple insertions with same id WILL NOT BE SUPPORTED,insipte of success msg");
        heading = new JLabel("Student Details");
        msg.setBounds(100, 100, 650, 30);
        detail.add(msg);
        sname = new JTextField("", 40);
        padd = new JTextField("", 100);
        JLabel stid = new JLabel("ID");
        final JTextField idinput = new JTextField("", 50);
        fname = new JTextField("", 50);
        ph = new JTextField("", 10);
        submit = new JButton("Submit");
        detail.setSize(800, 800);
        snamel = new JLabel("Name");
        paddl = new JLabel("Permanent Add");
        fnamel = new JLabel("Fathers Name");
        phl = new JLabel("Phone No");

        detail.setBackground(Color.BLACK);
        detail.setForeground(Color.GRAY);

        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.GRAY);

        update.setBackground(Color.BLACK);
        update.setForeground(Color.GRAY);

        sname.setBounds(450, 200, 80, 30);
        padd.setBounds(450, 300, 80, 30);
        stid.setBounds(250, 150, 80, 30);
        fname.setBounds(450, 250, 80, 30);
        idinput.setBounds(450, 150, 80, 30);
        ph.setBounds(450, 350, 80, 30);
        submit.setBounds(350, 450, 80, 30);
        update.setBounds(450, 450, 200, 30);
        snamel.setBounds(250, 200, 80, 30);
        paddl.setBounds(250, 300, 120, 30);
        fnamel.setBounds(250, 250, 80, 30);
        phl.setBounds(250, 350, 80, 30);
        submit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                name = sname.getText();
                fa_name = fname.getText();
                add = padd.getText();
                phone = Double.parseDouble(ph.getText());
                query = "insert into student values('" + idinput.getText() + "','" + name + "','" + fa_name + "'," + phone + ",'" + add + "')";
                dbconnect conn1 = new dbconnect(query);
                try {
                    conn1.insquery();
                    JOptionPane.showMessageDialog(SWindow.this, "Inserted", "Insert Sucessful",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(SWindow.this, "Insert failed", "Failed", JOptionPane.ERROR_MESSAGE);
                }

            }
        });


        update.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                name = sname.getText();
                fa_name = fname.getText();
                add = padd.getText();
                phone = Double.parseDouble(ph.getText());
                query = "update student set ph=" + phone + ", perm_add='" + add + "' where student_id='" + idinput.getText() + "';";
                System.out.println("Printing update query");
                System.out.println(query);

                dbconnect db2 = new dbconnect(query);
                try {
                    db2.insquery();
                } catch (Exception g) {
                    JOptionPane.showMessageDialog(SWindow.this, "Insert failed", "Failed", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        detail.setLayout(null);
        detail.add(sname);
        detail.add(update);
        detail.add(fname);
        detail.add(padd);
        detail.add(ph);
        detail.add(stid);
        detail.add(idinput);
        detail.add(snamel);
        detail.add(fnamel);
        detail.add(paddl);
        detail.add(phl);
        detail.add(submit);
        detail.add(heading);
        this.setTitle("Hostel Management System");
        jtp.add("Student Details", detail);
        jtp.setSize(800, 800);

        setVisible(true);
        add(jtp);


        hostel = new JPanel();
        hostel.setLayout(null);
        hostel.setSize(800, 800);
        hostel.setBackground(Color.BLACK);
        hostel.setForeground(Color.GRAY);

        h1 = new JButton("Block 1");
        h2 = new JButton("Block 2");
        h3 = new JButton("Block 3");
        h4 = new JButton("Block 4");
        h5 = new JButton("Block 5");
        h6 = new JButton("Block 6");

        h1.setBounds(50, 100, 90, 40);
        h2.setBounds(150, 100, 90, 40);
        h3.setBounds(250, 100, 90, 40);
        h4.setBounds(350, 100, 90, 40);
        h5.setBounds(450, 100, 90, 40);
        h6.setBounds(550, 100, 90, 40);

        hostel.add(h1);
        hostel.add(h2);
        hostel.add(h3);
        hostel.add(h4);
        hostel.add(h5);
        hostel.add(h6);

        final JPanel hostell = new JPanel();
        hostell.setLayout(null);
        hostell.setBounds(100, 200, 700, 500);

        hostel.add(hostell);
        hostell.setVisible(false);
        hostell.setBackground(Color.BLACK);
        hostell.setForeground(Color.GRAY);

        JLabel no = new JLabel("Hostel No.");
        final JLabel no1 = new JLabel();
        JLabel type = new JLabel("Type");
        final JLabel type1 = new JLabel();
        JLabel dt = new JLabel("Total Double Rooms");
        final JLabel dt1 = new JLabel();
        JLabel da = new JLabel("Available Double Rooms");
        final JLabel da1 = new JLabel();
        JLabel df = new JLabel("Double Room Fees");
        final JLabel df1 = new JLabel();
        JLabel st = new JLabel("Total Single Rooms");
        final JLabel st1 = new JLabel();
        JLabel sa = new JLabel("Available Single  Rooms");
        final JLabel sa1 = new JLabel();
        JLabel sf = new JLabel("Single Room Fess");
        final JLabel sf1 = new JLabel();

        no.setBounds(150, 100, 150, 30);
        hostell.add(no);
        no1.setBounds(450, 100, 450, 30);
        hostell.add(no1);
        type.setBounds(150, 150, 150, 30);
        hostell.add(type);
        type1.setBounds(450, 150, 450, 30);
        hostell.add(type1);
        dt.setBounds(150, 200, 150, 30);
        hostell.add(dt);
        dt1.setBounds(450, 200, 450, 30);
        hostell.add(dt1);
        da.setBounds(150, 250, 150, 30);
        hostell.add(da);
        da1.setBounds(450, 250, 450, 30);
        hostell.add(da1);
        df.setBounds(150, 300, 150, 30);
        hostell.add(df);
        df1.setBounds(450, 300, 450, 30);
        hostell.add(df1);
        st.setBounds(150, 350, 150, 30);
        hostell.add(st);
        st1.setBounds(450, 350, 450, 30);
        hostell.add(st1);
        sa.setBounds(150, 400, 150, 30);
        hostell.add(sa);
        sa1.setBounds(450, 400, 450, 30);
        hostell.add(sa1);
        sf.setBounds(150, 450, 150, 30);
        hostell.add(sf);
        sf1.setBounds(450, 450, 450, 30);
        hostell.add(sf1);

        h1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                hostell.setVisible(true);
                query = "select * from hostel where hostel_id=1;";
                dbconnect conn = new dbconnect(query);
                ResultSet rs = conn.exquery();
                try {
                    while (rs.next()) {
                        if (Integer.parseInt(rs.getString("hostel_id")) == 1) {
                            no1.setText("Block 1");
                            type1.setText(rs.getString("htype"));
                            dt1.setText(rs.getString("double_t"));
                            da1.setText(rs.getString("double_a"));
                            df1.setText(rs.getString("double_fees"));
                            st1.setText(rs.getString("single_t"));
                            sa1.setText(rs.getString("single_a"));
                            sf1.setText(rs.getString("single_fees"));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error in Resultset");
                }

            }
        });

        h2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                hostell.setVisible(true);
                query = "select * from hostel where hostel_id=2;";
                dbconnect conn = new dbconnect(query);
                ResultSet rs = conn.exquery();
                try {
                    while (rs.next()) {
                        if (Integer.parseInt(rs.getString("hostel_id")) == 2) {
                            no1.setText("Block 2");
                            type1.setText(rs.getString("htype"));
                            dt1.setText(rs.getString("double_t"));
                            da1.setText(rs.getString("double_a"));
                            df1.setText(rs.getString("double_fees"));
                            st1.setText(rs.getString("single_t"));
                            sa1.setText(rs.getString("single_a"));
                            sf1.setText(rs.getString("single_fees"));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("RS2");
                }

            }
        });


        h3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                hostell.setVisible(true);
                query = "select * from hostel where hostel_id=3;";
                dbconnect conn = new dbconnect(query);
                ResultSet rs = conn.exquery();
                try {
                    while (rs.next()) {
                        if (Integer.parseInt(rs.getString("hostel_id")) == 3) {
                            no1.setText("Block 3");
                            type1.setText(rs.getString("htype"));
                            dt1.setText(rs.getString("double_t"));
                            da1.setText(rs.getString("double_a"));
                            df1.setText(rs.getString("double_fees"));
                            st1.setText(rs.getString("single_t"));
                            sa1.setText(rs.getString("single_a"));
                            sf1.setText(rs.getString("single_fees"));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("RS3");
                }
            }
        });

        h4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                hostell.setVisible(true);
                query = "select * from hostel where hostel_id=4;";
                dbconnect conn = new dbconnect(query);
                ResultSet rs = conn.exquery();
                try {
                    while (rs.next()) {
                        if (Integer.parseInt(rs.getString("hostel_id")) == 4) {
                            no1.setText("Block 4");
                            type1.setText(rs.getString("htype"));
                            dt1.setText(rs.getString("double_t"));
                            da1.setText(rs.getString("double_a"));
                            df1.setText(rs.getString("double_fees"));
                            st1.setText(rs.getString("single_t"));
                            sa1.setText(rs.getString("single_a"));
                            sf1.setText(rs.getString("single_fees"));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("RS4");
                }
            }
        });


        h5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                hostell.setVisible(true);
                query = "select * from hostel where hostel_id=5;";
                dbconnect conn = new dbconnect(query);
                ResultSet rs = conn.exquery();
                try {
                    while (rs.next()) {
                        if (Integer.parseInt(rs.getString("hostel_id")) == 5) {
                            no1.setText("Block 5");
                            type1.setText(rs.getString("htype"));
                            dt1.setText(rs.getString("double_t"));
                            da1.setText(rs.getString("double_a"));
                            df1.setText(rs.getString("double_fees"));
                            st1.setText(rs.getString("single_t"));
                            sa1.setText(rs.getString("single_a"));
                            sf1.setText(rs.getString("single_fees"));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("RS5");
                }
            }
        });


        h6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                hostell.setVisible(true);
                query = "select * from hostel where hostel_id=6;";
                dbconnect conn = new dbconnect(query);
                ResultSet rs = conn.exquery();
                try {
                    while (rs.next()) {
                        if (Integer.parseInt(rs.getString("hostel_id")) == 6) {
                            no1.setText("Block 6");
                            type1.setText(rs.getString("htype"));
                            dt1.setText(rs.getString("double_t"));
                            da1.setText(rs.getString("double_a"));
                            df1.setText(rs.getString("double_fees"));
                            st1.setText(rs.getString("single_t"));
                            sa1.setText(rs.getString("single_a"));
                            sf1.setText(rs.getString("single_fees"));
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Error in RS2");

                }

            }
        });

        jtp.add("Hostel Details", hostel);
        JPanel mess = new JPanel();
        mess.setLayout(null);

        m1 = new JButton("Mess 1");
        m1.setBounds(50, 100, 90, 40);
        mess.add(m1);
        mess.add(m1);
        m2 = new JButton("Mess 2");
        m2.setBounds(150, 100, 90, 40);
        mess.add(m2);
        mess.add(m2);
        m3 = new JButton("Mess 3");
        m3.setBounds(250, 100, 90, 40);
        mess.add(m3);
        mess.add(m3);
        m4 = new JButton("Mess 4");
        m4.setBounds(350, 100, 90, 40);
        mess.add(m4);
        mess.add(m4);
        jtp.add("Mess Details", mess);
        mess.setBackground(Color.BLACK);
        final JPanel mes = new JPanel();
        mes.setLayout(null);
        mes.setVisible(false);
        mes.setBackground(Color.BLACK);
        mes.setForeground(Color.GRAY);
        mes.setBounds(100, 200, 700, 500);
        mess.add(mes);
        JLabel namee = new JLabel("Name");
        JLabel fees = new JLabel("Fees");
        final JLabel name1 = new JLabel();
        final JLabel fees1 = new JLabel();
        namee.setBounds(150, 100, 150, 30);
        mes.add(namee);
        name1.setBounds(450, 100, 450, 30);
        mes.add(name1);
        fees.setBounds(150, 150, 150, 30);
        mes.add(fees);
        fees1.setBounds(450, 150, 450, 30);
        mes.add(fees1);
        m1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent a) {
                mes.setVisible(true);
                query = "select * from mess where mname='Aditya';";
                dbconnect conn = new dbconnect(query);
                ResultSet rs = conn.exquery();
                try {
                    while (rs.next()) {
                        if (rs.getString("mname").equals("Aditya")) {
                            name1.setText(rs.getString("mname"));
                            fees1.setText(rs.getString("fees"));
                        }
                    }
                } catch (Exception f) {
                    System.out.println("MRS1");
                }
            }
        });




        m2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent a) {
                mes.setVisible(true);
                query = "select * from mess where mname='Ananya';";
                dbconnect conn = new dbconnect(query);
                ResultSet rs = conn.exquery();
                try {
                    while (rs.next()) {
                        if (rs.getString("mname").equals("Ananya")) {
                            name1.setText(rs.getString("mname"));
                            fees1.setText(rs.getString("fees"));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("RS2");
                }

            }
        });



        m3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent a) {
                mes.setVisible(true);
                query = "select * from mess where mname='Food Court';";
                dbconnect conn = new dbconnect(query);
                ResultSet rs = conn.exquery();
                try {
                    while (rs.next()) {
                        if (rs.getString("mname").equals("Food Court")) {
                            name1.setText(rs.getString("mname"));
                            fees1.setText(rs.getString("fees"));
                        }

                    }
                } catch (Exception f) {
                    System.out.println("MRS3");
                }

            }
        });





        m4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent a) {
                mes.setVisible(true);
                query = "select * from mess where mname='Asharaya';";
                dbconnect conn = new dbconnect(query);
                System.out.println("Into mess display");
                ResultSet rs = conn.exquery();
                try {
                    while (rs.next()) {
                        System.out.println("Into mess block");
                        if (rs.getString("mname").equals("Asharaya")) {
                            name1.setText(rs.getString("mname"));
                            fees1.setText(rs.getString("fees"));
                        }
                    }

                } catch (Exception e) {
                    System.out.println("RS2");
                }
            }
        });







        JPanel app = new JPanel();
        app.setBackground(Color.BLACK);
        app.setForeground(Color.GRAY);
        app.setLayout(null);
        jtp.add("Apply", app);
        final JComboBox hostelb = new JComboBox();
        final JComboBox hostelg = new JComboBox();
        /*hostelb.addItem("Block 4");
        hostelb.addItem("Block 6");
        hostelb.addItem("Block 5");
        hostelg.addItem("Block 1");
        hostelg.addItem("Block 2");
        hostelg.addItem("Block 3");*/
        final JLabel bl1 = new JLabel("Block 1");
        final JLabel bl2 = new JLabel("Block 2");
        final JLabel bl3 = new JLabel("Block 3");
        final JLabel bl4 = new JLabel("Block 4");
        final JLabel bl5 = new JLabel("Block 5");
        final JLabel bl6 = new JLabel("Block 6");
        hostelb.addItem(bl4.getText());
        hostelb.addItem(bl5.getText());
        hostelb.addItem(bl6.getText());
        hostelg.addItem(bl1.getText());
        hostelg.addItem(bl2.getText());

        hostelg.addItem(bl3.getText());

        hostelb.setBackground(Color.BLACK);
        hostelg.setBackground(Color.BLACK);
        final JRadioButton girl = new JRadioButton("Girl");
        final JRadioButton boy = new JRadioButton("Boy");
        final ButtonGroup bg = new ButtonGroup();
        bg.add(girl);
        bg.add(boy);
        girl.setBounds(100, 100, 80, 40);
        boy.setBounds(100, 150, 80, 40);
        boy.setBackground(Color.BLACK);
        girl.setBackground(Color.BLACK);

        app.add(girl);
        app.add(boy);
        JButton applyb = new JButton("Apply");
        JLabel ide = new JLabel("Student Id");
        ide.setBounds(100, 50, 80, 30);
        app.add(ide);
        applyb.setBounds(350, 550, 150, 30);
        final JTextField idin = new JTextField("", 10);
        idin.setBounds(300, 50, 80, 30);
        app.add(idin);
        app.add(applyb);
        hostelb.setBounds(350, 350, 100, 30);
        hostelb.setVisible(false);
        hostelg.setBounds(550, 350, 100, 30);
        hostelg.setVisible(false);
        app.add(hostelg);
        app.add(hostelb);
        final JRadioButton mes1 = new JRadioButton("Ananya");
        final JRadioButton mes2 = new JRadioButton("Asharaya");
        final JRadioButton mes3 = new JRadioButton("Food Court");
        final JRadioButton mes4 = new JRadioButton("Aditya");
        mes1.setBackground(Color.BLACK);
        mes2.setBackground(Color.BLACK);
        mes3.setBackground(Color.BLACK);
        mes4.setBackground(Color.BLACK);
        mes1.setForeground(Color.GRAY);
        mes2.setForeground(Color.GRAY);
        mes3.setForeground(Color.GRAY);
        mes4.setForeground(Color.GRAY);
        boy.setForeground(Color.GRAY);
        girl.setForeground(Color.GRAY);

        final ButtonGroup bg1 = new ButtonGroup();
        bg1.add(mes1);
        final JLabel hosteln = new JLabel("Hostel");
        hosteln.setBounds(250, 350, 50, 40);
        bg1.add(mes2);
        final JLabel messn = new JLabel("Mess");
        messn.setBounds(250, 450, 50, 40);
        bg1.add(mes3);
        app.add(mes1);
        app.add(mes2);
        app.add(mes3);
        app.add(mes4);
        bg1.add(mes4);
        app.add(hosteln);
        app.add(messn);
        mes1.setBounds(350, 450, 80, 40);
        mes2.setBounds(450, 450, 80, 40);
        mes3.setBounds(550, 450, 110, 40);
        mes4.setBounds(690, 450, 80, 40);

        girl.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                hostelb.setVisible(false);
                hostelg.setVisible(true);

            }
        });
        boy.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                hostelg.setVisible(false);
                hostelb.setVisible(true);
            }
        });
        System.out.println("Printing near apply query");

        applyb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                System.out.println("Into Apply block");

                String s1 = bg.getSelection().getActionCommand();
                int s2 ;
                String s3 = idin.getText();
                /*  JLabel bl1=new JLabel("Block 1");
                JLabel bl2=new JLabel("Block 2");
                JLabel bl3=new JLabel("Block 3");
                JLabel bl4=new JLabel("Block 4");
                JLabel bl5=new JLabel("Block 5");    JLabel bl6=new JLabel("Block 6");*/

                System.out.println("Printing after apply block");

                String s5 = (String) bg1.getSelection().getActionCommand();
                if ((s1.compareToIgnoreCase(girl.getActionCommand()))==0) {
                    System.out.println("Selecting into apply block");
                    s2 = hostelg.getSelectedIndex();

                    if (s2==1) {
                        query = "insert into apply values('" + s3 + "',1,'" + s5 + "');";
                        System.out.println("Printing apply query");
                        System.out.println(query);
                    }
                    if (s2 == 2) {
                        query = "insert into apply values('" + s3 + "',2,'" + s5 + "');";
                        System.out.println("Printing apply query");
                        System.out.println(query);

                    }
                    if (s2==3) {
                        query = "insert into apply values('" + s3 + "',3,'" + s5 + "');";
                        System.out.println(query);
                    }


                }

//                if (s1.equals(boy.getText())) {
//                    s2 = "" + hostelb.getSelectedItem();
//                }
                s2=0;
                System.out.println(bl4.getText());
                System.out.println(""+s2);

                if ((s1.compareToIgnoreCase(boy.getText())) == 0) {


                    s2 =  hostelb.getSelectedIndex();

                    if (s2== 1) {
                        query = "insert into apply values('" + s3 + "',4,'" + s5 + "');";
                        System.out.println("Printing apply query");
                        System.out.println(query);
                    }
                    if (s2==2) {
                        query = "insert into apply values('" + s3 + "',5,'" + s5 + "');";
                        System.out.println("Printing apply query");
                        System.out.println(query);
                    }
                    if (s2==3) {
                        query = "insert into apply values('" + s3 + "',6,'" + s5 + "');";
                        System.out.println(query);
                    }
                    dbconnect conn1 = new dbconnect(query);
                    try {
                        conn1.insquery();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(SWindow.this, "Insert failed", "Failed", JOptionPane.ERROR_MESSAGE);
                    }
                }
//System.out.printl"n(bl4.getText());
                System.out.println(s2);
                System.out.println(s1);
                System.out.println(s5);
                System.out.println(s3);
                System.out.println(query);
            }
        });

        JPanel delete1 = new JPanel();
        delete1.setLayout(null);
        final JLabel udelete = new JLabel("User id");
        udelete.setBounds(350, 150, 180, 30);
        delete1.add(udelete);
        final JLabel sdelete = new JLabel("Student id");
        sdelete.setBounds(350, 200, 180, 30);
        delete1.add(sdelete);
        final JLabel pdelete = new JLabel("Corresponding password");
        pdelete.setBounds(350, 250, 180, 30);
        delete1.add(pdelete);
        final JTextField uidelete = new JTextField("", 10);
        uidelete.setBounds(550, 200, 130, 30);
        delete1.add(uidelete);
        final JTextField sidelete = new JTextField("", 10);
        sidelete.setBounds(550, 150, 130, 30);
        delete1.add(sidelete);
        final JPasswordField pidelete = new JPasswordField("", 40);
        pidelete.setBounds(550, 250, 130, 30);
        delete1.add(pidelete);
        final JButton deleteb = new JButton("Delete information");
        deleteb.setBounds(400, 300, 200, 30);
        delete1.add(deleteb);
        final JLabel displayd = new JLabel("Deleted");
        displayd.setBounds(425, 400, 200, 50);
        delete1.add(displayd);
        displayd.setVisible(false);
        final JLabel displayd1 = new JLabel("Delete unsuccessful");
        displayd1.setBounds(425, 400, 250, 50);
        delete1.add(displayd1);
        displayd1.setVisible(false);

        delete1.setBackground(Color.BLACK);
        delete1.setForeground(Color.GRAY);


        deleteb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                String get = null;
                displayd.setVisible(false);
                int f = 2;
                displayd1.setVisible(false);
                String uuid = uidelete.getText();
                String ssid = sidelete.getText();
                String ppid = pidelete.getText();
                //String user_id=null,password=null;
                try {
                    String query = "select * from \"login\"";
                    dbconnect db3 = new dbconnect(query);
                    ResultSet res = db3.exquery();
                    //boolean t=res.next();

                    String usid = null, pas = null;
                    while (res.next())//res.next()
                    {
                        usid = res.getString("user_id");
                        pas = res.getString("password");
                        if (usid.compareTo(uidelete.getText()) == 0
                                && pas.compareTo(pidelete.getText()) == 0) {
                            f = 0;
                            get = res.getString("user_id");
                            break;
                        }

                    }
                } catch (SQLException s) {
                    JOptionPane.showMessageDialog(SWindow.this, "Failed to delete",
                            "Login Failed", JOptionPane.ERROR_MESSAGE);
                    f = 1;
                }
                if (f == 2) {
                    query = "delete from student where student.student_id='" + uidelete.getText() + "' and uname='" + sidelete.getText() + "';";
                    System.out.println("Printing delete query");
                    System.out.println(query);
                    dbconnect del = new dbconnect(query);
                    try {
                        del.insquery();
                        //f=0;
                    } catch (Exception d) {
                        System.out.println("Delete Exception");
                    }
                    JOptionPane.showMessageDialog(SWindow.this, "Deleted", "Delete Sucessful",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        jtp.add("Delete", delete1);






    }
}
