package javademo.DAO;

import Vo.Commend;
import Vo.User;
import javademo.DButil.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimpl implements UserDAO {
    @Override
    public boolean insert(Commend commend) {
        boolean flag = false;
        Connection con = DButil.getCon();
        String sql = "INSERT INTO commend(username,info,pid) VALUE(?,?,?)";
        PreparedStatement pst_insert = null;
        try {
            pst_insert = con.prepareStatement(sql);
            pst_insert.setString(1,commend.getUsername());
            pst_insert.setString(2,commend.getInfo());
            pst_insert.setInt(3,commend.getPid());
            pst_insert.execute();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
            pst_insert.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Commend> findchild(int pid) {
        Connection con = DButil.getCon();
        String str = "SELECT * FROM commend where pid = ?";
        PreparedStatement pre_find = null;
        ResultSet result = null;
        List<Commend> list = new ArrayList<Commend>();
        try {
            pre_find = con.prepareStatement(str);
            pre_find.setInt(1,pid);
            result = pre_find.executeQuery();
            while (result.next()){
                Commend commend = new Commend();
                commend.setInfo(result.getString("info"));
                commend.setPid(result.getInt("pid"));
                commend.setUsername(result.getString("username"));
                commend.setId(result.getInt("id"));
                list.add(commend);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pre_find.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean findLogin(User user) {
        boolean flag = false;
        Connection con = DButil.getCon();
        PreparedStatement pstm = null;
        String sql = "SELECT name FROM user WHERE userid=? AND password=?";
        try {
            pstm = con.prepareStatement(sql);
            pstm = con.prepareStatement(sql);
            pstm.setString(1,user.getUserid());
            pstm.setString(2,user.getPassword());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                user.setName(rs.getString(1));
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (pstm!=null){
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean signin(User user) {
        boolean flag = false;
        PreparedStatement pre_sign = null;
        String str = "INSERT INTO user(name,userid,password) VALUE(?,?,?)";
        Connection con = DButil.getCon();
        try {
            pre_sign = con.prepareStatement(str);
            pre_sign.setString(1,user.getName());
            pre_sign.setString(2,user.getUserid());
            pre_sign.setString(3,user.getPassword());
            pre_sign.execute();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pre_sign.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
