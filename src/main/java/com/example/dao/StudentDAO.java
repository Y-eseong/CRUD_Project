package com.example.dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.bean.StudentVO;
import com.example.util.JDBCUtil;

public class StudentDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String STUDENT_INSERT = "insert into STUDENT (name, age, gender, id, email, RC, phone, photo) values (?,?,?,?,?,?,?,?)";
    private final String STUDENT_UPDATE = "update STUDENT set name=?, age=?, gender=?, id=?, email=?, RC=?, phone=?, photo=? where seq=?";
    private final String STUDENT_DELETE = "delete from STUDENT  where seq=?";
    private final String STUDENT_GET = "select * from STUDENT  where seq=?";
    private final String STUDENT_LIST = "select * from STUDENT order by seq desc";
    private final String M_SELECT = "select photo from STUDENT where seq=? ";

    public int insertSTUDENT(StudentVO vo) {
        System.out.println("===> JDBC로 insertSTUDENT() 기능 처리");
        conn = JDBCUtil.getConnection();
        try {
            stmt = conn.prepareStatement(STUDENT_INSERT);
            stmt.setString(1, vo.getName());
            stmt.setInt(2, vo.getAge());
            stmt.setString(3, vo.getGender());
            stmt.setInt(4, vo.getId());
            stmt.setString(5, vo.getEmail());
            stmt.setString(6, vo.getRC());
            stmt.setString(7, vo.getPhone());
            stmt.setString(8, vo.getPhoto());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 글 삭제
    public void deleteSTUDENT(StudentVO vo) {
        System.out.println("===> JDBC로 deleteSTUDENT() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(STUDENT_DELETE);
            stmt.setInt(1, vo.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int updateSTUDENT(StudentVO vo) {
        System.out.println("===> JDBC로 updateSTUDENT() 기능 처리");
        conn = JDBCUtil.getConnection();
        try {
            stmt = conn.prepareStatement(STUDENT_UPDATE);
            stmt.setString(1, vo.getName());
            stmt.setInt(2, vo.getAge());
            stmt.setString(3, vo.getGender());
            stmt.setInt(4, vo.getId());
            stmt.setString(5, vo.getEmail());
            stmt.setString(6, vo.getRC());
            stmt.setString(7, vo.getPhone());
            stmt.setString(8, vo.getPhoto());
            stmt.setInt(9, vo.getSeq());

            System.out.println(vo.getName() + "-" + vo.getAge() + "-" + vo.getGender() + "-" + vo.getId() + "-" + vo.getEmail() + "-" + vo.getRC() + "-" + vo.getPhone() + "-" + vo.getPhoto() + "-" + vo.getSeq());
            stmt.executeUpdate();
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //목록
    public StudentVO getSTUDENT(int seq) {
        StudentVO one = new StudentVO();
        System.out.println("===> JDBC로 getSTUDENT() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(STUDENT_GET);
            stmt.setInt(1, seq);
            rs = stmt.executeQuery();
            if(rs.next()) {
                one.setSeq(rs.getInt("seq"));
                one.setName(rs.getString("name"));
                one.setAge(rs.getInt("age"));
                one.setGender(rs.getString("gender"));
                one.setId(rs.getInt("id"));
                one.setEmail(rs.getString("email"));
                one.setRC(rs.getString("RC"));
                one.setPhone(rs.getString("phone"));
                one.setPhoto(rs.getString("photo"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return one;
    }

    public List<StudentVO> getSTUDENTList(){
        List<StudentVO> list = new ArrayList<StudentVO>();
        System.out.println("===> JDBC로 getSTUDENTList() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(STUDENT_LIST);
            rs = stmt.executeQuery();
            while(rs.next()) {
                StudentVO one = new StudentVO();
                one.setSeq(rs.getInt("seq"));
                one.setName(rs.getString("name"));
                one.setAge(rs.getInt("age"));
                one.setGender(rs.getString("gender"));
                one.setId(rs.getInt("id"));
                one.setEmail(rs.getString("email"));
                one.setRC(rs.getString("RC"));
                one.setPhone(rs.getString("phone"));
                one.setPhoto(rs.getString("photo"));
                list.add(one);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public String getPhotoFilename(int sid){
        String filename = null;
        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(M_SELECT);
            stmt.setInt(1, sid);
            rs = stmt.executeQuery();
            if(rs.next()){
                filename = rs.getString("photo");
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("===> JDBC로 getPhotoFilename() 기능 처리");
        return filename;
    }
}