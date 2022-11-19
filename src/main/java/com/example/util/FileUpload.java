package com.example.util;

import com.example.bean.StudentVO;
import com.example.dao.StudentDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUpload {
    public StudentVO uploadPhoto(HttpServletRequest request){
        String filename = "";
        int sizeLimit = 15*1024*1024;

        String realPath = request.getServletContext().getRealPath("upload");

        File dir = new File(realPath);
        if(!dir.exists()) dir.mkdirs();

        StudentVO one = null;
        MultipartRequest multipartRequest = null;
        try{
            multipartRequest = new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
            filename = multipartRequest.getFilesystemName("photo");
            one = new StudentVO();
            String seq = multipartRequest.getParameter("seq");
            if(seq != null && !seq.equals("")) one.setSeq(Integer.parseInt(seq));
            one.setName(multipartRequest.getParameter("name"));
            one.setAge(Integer.parseInt(multipartRequest.getParameter("age")));
            one.setGender(multipartRequest.getParameter("gender"));
            one.setId(Integer.parseInt(multipartRequest.getParameter("id")));
            one.setEmail(multipartRequest.getParameter("email"));
            one.setRC(multipartRequest.getParameter("RC"));
            one.setPhone(multipartRequest.getParameter("phone"));



            if(seq != null && !seq.equals("")){
                StudentDAO dao = new StudentDAO();
                String oldfilename = dao.getPhotoFilename(Integer.parseInt(seq));
                if(filename != null && oldfilename != null) FileUpload.deleteFile(request, oldfilename);
                else if(filename == null && oldfilename != null) filename = oldfilename;
            }
            one.setPhoto(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return one;
    }
    public static void deleteFile(HttpServletRequest request, String filename){
        String filePath = request.getServletContext().getRealPath("upload");

        File f = new File(filePath + "/" + filename);
        if(f.exists()) f.delete();
    }
}

