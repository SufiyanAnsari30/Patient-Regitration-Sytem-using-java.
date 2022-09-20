package mp;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AJPMicro extends JFrame {
    JPanel pan;

    JTextField tf_Id, tf_Name, tf_Age, tf_Address, tf_Email, tf_Contact_number, tf_Blood_Group, tf_Doc_assigned;
    JLabel l_Id, l_Name, l_Age, l_Address, l_Email, l_Contact_number, l_Blood_Group, l_Doc_assigned, rec;

    JTextField tf_del_Id, tf_update_Id;
    JLabel l_del_Id, l_udapte_Id;

    JButton but_insert, but_delete, but_Update;

    public AJPMicro() {
    	setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 50, 900, 900);
        setLocation(100, 50);

        pan = new JPanel();
        setContentPane(pan);
        pan.setLayout(null);
        rec = new JLabel("PATIENT RECORD");
        rec.setFont(new Font("Serif", Font.PLAIN, 45));
        rec.setBounds(50, 25, 500, 100);

        l_Id = new JLabel("ID:");
        l_Id.setBounds(10, 100, 325, 50);

        l_Name = new JLabel("NAME:");
        l_Name.setBounds(10, 160, 325, 50);

        l_Age = new JLabel("AGE:");
        l_Age.setBounds(10, 220, 325, 50);

        l_Address = new JLabel("ADDRESS:");
        l_Address.setBounds(10, 280, 325, 50);

        l_Email = new JLabel("EMAIL:");
        l_Email.setBounds(10, 340, 325, 50);

        l_Contact_number = new JLabel("CONT No.:");
        l_Contact_number.setBounds(10, 400, 325, 50);

        l_Blood_Group = new JLabel("BLOOD GRP:");
        l_Blood_Group.setBounds(10, 460, 325, 50);

        l_Doc_assigned = new JLabel("DOCTOR ASSIGNED:");
        l_Doc_assigned.setBounds(10, 520, 325, 50);


        tf_Id = new JTextField();
        tf_Id.setBounds(150, 108, 300, 35);

        tf_Name = new JTextField();
        tf_Name.setBounds(150, 168, 300, 35);

        tf_Age = new JTextField();
        tf_Age.setBounds(150, 228, 300, 35);

        tf_Address = new JTextField();
        tf_Address.setBounds(150, 288, 300, 35);

        tf_Email = new JTextField();
        tf_Email.setBounds(150, 348, 300, 35);

        tf_Contact_number = new JTextField();
        tf_Contact_number.setBounds(150, 408, 300, 35);

        tf_Blood_Group = new JTextField();
        tf_Blood_Group.setBounds(150, 468, 300, 35);

        tf_Doc_assigned = new JTextField();
        tf_Doc_assigned.setBounds(150, 528, 300, 35);

        but_insert = new JButton("INSERT");
        but_insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = tf_Id.getText();
                String name = tf_Name.getText();
                String age = tf_Age.getText();
                String address = tf_Address.getText();
                String email = tf_Email.getText();
                String cont_no = tf_Contact_number.getText();
                String blood_grp = tf_Blood_Group.getText();
                String doc_assigned = tf_Doc_assigned.getText();
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AJPProject", "root", "root");

                    String query = "INSERT INTO projecttbl values('" + id + "','" + name + "','" + age + "','" +
                        address + "','" + email + "','" + cont_no + "','" + blood_grp + "','" + doc_assigned + "')";

                    Statement sta = connection.createStatement();
                    sta.executeUpdate(query);

                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                tf_Id.setText(null);
                tf_Name.setText(null);
                tf_Age.setText(null);
                tf_Address.setText(null);
                tf_Email.setText(null);
                tf_Contact_number.setText(null);
                tf_Blood_Group.setText(null);
                tf_Doc_assigned.setText(null);
            }
        });
        but_insert.setBounds(80, 600, 200, 35);

        // delete
        l_del_Id = new JLabel("ID:");
        l_del_Id.setBounds(500, 100, 325, 50);


        tf_del_Id = new JTextField();
        tf_del_Id.setBounds(550, 108, 300, 35);

        but_delete = new JButton("DELETE");


        but_delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = tf_del_Id.getText();
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AJPProject", "root", "root");

                    String query = "DELETE FROM projecttbl " +
                        "WHERE id =" + id;
                    Statement sta = connection.createStatement();
                    sta.executeUpdate(query);

                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                tf_del_Id.setText(null);
            }


        });

        but_delete.setBounds(560, 160, 200, 35);

        //Update 
        but_Update = new JButton("UPDATE");
        but_Update.setBounds(380, 600, 200, 35);

        but_Update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = tf_Id.getText();
                String name = tf_Name.getText();
                String age = tf_Age.getText();
                String address = tf_Address.getText();
                String email = tf_Email.getText();
                String cont_no = tf_Contact_number.getText();
                String blood_grp = tf_Blood_Group.getText();
                String doc_assigned = tf_Doc_assigned.getText();
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AJPProject", "root", "root");


                    String query = "Update projecttbl SET ";
                    if (name != null && !name.isEmpty()) {
                        query += "name='" + name + "',";
                    }
                    if (age != null && !age.isEmpty()) {
                        query += "age='" + age + "',";
                    }
                    if (address != null && !address.isEmpty()) {
                        query += "address='" + address + "',";
                    }
                    if (email != null && !email.isEmpty()) {
                        query += "email='" + email + "',";
                    }
                    if (cont_no != null && !cont_no.isEmpty()) {
                        query += "cont_no='" + cont_no + "',";
                    }
                    if (blood_grp != null && !blood_grp.isEmpty()) {
                        query += "blood_grp='" + blood_grp + "',";
                    }
                    if (doc_assigned != null && !doc_assigned.isEmpty()) {
                        query += "doc_assigned='" + doc_assigned+"'";
                    }

                    if (query.endsWith(",")) {
                        query = query.substring(0, query.length() - 1);
                    }

                    query += " where id=" + id;

                    Statement sta = connection.createStatement();
                    sta.executeUpdate(query);

                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                tf_Id.setText(null);
                tf_Name.setText(null);
                tf_Age.setText(null);
                tf_Address.setText(null);
                tf_Email.setText(null);
                tf_Contact_number.setText(null);
                tf_Blood_Group.setText(null);
                tf_Doc_assigned.setText(null);
            }
        });

        pan.add(rec);
        pan.add(tf_Id);
        pan.add(tf_Name);
        pan.add(tf_Age);
        pan.add(tf_Address);
        pan.add(tf_Email);
        pan.add(tf_Contact_number);
        pan.add(tf_Blood_Group);
        pan.add(tf_Doc_assigned);

        pan.add(l_Id);
        pan.add(l_Name);
        pan.add(l_Age);
        pan.add(l_Address);
        pan.add(l_Email);
        pan.add(l_Contact_number);
        pan.add(l_Blood_Group);
        pan.add(l_Doc_assigned);

        pan.add(l_del_Id);
        pan.add(tf_del_Id);
        pan.add(but_insert);
        pan.add(but_delete);
        pan.add(but_Update);

    }
    
}