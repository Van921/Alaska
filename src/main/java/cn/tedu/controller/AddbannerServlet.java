package cn.tedu.controller;

import cn.tedu.dao.BannerDao;
import cn.tedu.entity.Banner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@MultipartConfig
@WebServlet(name = "AddbannerServlet",urlPatterns = "/addbanner")
public class AddbannerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Part part=request.getPart("file");
        String info=part.getHeader("content-disposition");
        String suffix=info.substring(info.lastIndexOf("."),info.length()-1);
        String fileName= UUID.randomUUID()+suffix;
        System.out.println("文件名="+fileName);
        //得到保存文件的images文件夹
        String path=request.getServletContext().getRealPath("images/");
        part.write(path+fileName);
        //保存轮播图信息到数据库
        Banner banner=new Banner(0,"images/"+fileName);
        BannerDao dao=new BannerDao();
        dao.insert(banner);
        response.sendRedirect("/showbanner");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
