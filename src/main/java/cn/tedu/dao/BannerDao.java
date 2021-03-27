package cn.tedu.dao;

import cn.tedu.entity.Banner;
import cn.tedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BannerDao {
    public List<Banner> findall() {
        ArrayList list=new ArrayList();
        //获取链接
        try (Connection conn= DBUtils.getConn()){
            String sql="select id,url from banner";
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt(1);
                String url=rs.getString(2);
                list.add(new Banner(id,url));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void insert(Banner banner) {
        //获取链接
        try (Connection conn=DBUtils.getConn()){
            String sql="insert into banner values(null,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,banner.getUrl());
            ps.executeUpdate();
            System.out.println("轮播图添加成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
