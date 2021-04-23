package com.huang;

import com.huang.dao.DepartmentsMapper;
import com.huang.pojo.departments;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class SpringBootStaffingSystemApplicationTests {
    @Autowired
    private DepartmentsMapper departmentsMapper;


    @Test
    void contextLoads() {
        List<departments> departments = departmentsMapper.selectList(null);
        departments.forEach(System.out::println);

    }
    //增加数据
    @Test
    public void AddDepartments() {
        departments departments = new departments();
        departments.setId(106);
        departments.setDepartment_name("人才部");
        departmentsMapper.insert(departments);

    }

    //删除数据
    @Test
    public void DeleteDepartments() {
        int i = departmentsMapper.deleteById(109);
        System.out.println("删除成功");
    }

    //修改数据
    @Test
    public void UpdateDepartments() {
        departments departments = new departments();
        departments.setId(106);
        departments.setDepartment_name("人才部");
        departmentsMapper.updateById(departments);
    }
    //查询数据
    @Test
    public void SelectDepartments(){
        departments departments = departmentsMapper.selectById(101);
        System.out.println(departments);
    }

}
