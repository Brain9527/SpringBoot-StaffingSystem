//package com.huang.controller;
//
//import com.huang.dao.DepartmentsMapper;
//import com.huang.dao.EmployeesMapper;
//import com.huang.pojo.departments;
//import com.huang.pojo.employees;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.Collection;
//
//@Controller
//public class EmployeeController {
//
//    @Autowired
//    EmployeesMapper employeeDao;
//    @Autowired
//    DepartmentsMapper departmentDao;
//
//
//    @RequestMapping("/emps")
//    public String list(Model model) {
//        Collection<employees> employees = employeeDao.getAll();
//        model.addAttribute("emps", employees);
//        return "emp/list";
//    }
//
//    @RequestMapping("/emp")
//    public String toAddpage(Model model) {
//        //查出所有部门信息
//        Collection<departments> department = departmentDao.getDepartment();
//        model.addAttribute("department", department);
//        return "emp/add";
//    }
//
//    @PostMapping("/emp")
//    public String addEmp(employees employee) {
//        //添加员工
//        System.out.println("save=>" + employee);
//        employeeDao.save(employee);//调用底层业务方法保存员工信息
//        return "redirect:/emps";
//    }
//
//    //去员工的修改页面
//    @GetMapping("/emp/{id}")
//    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
//        //查出原来的数据
//        employees employee = employeeDao.getEmployeeById(id);
//        model.addAttribute("emp", employee);
//        //查出所有部门信息
//        Collection<departments> department = departmentDao.getDepartment();
//        model.addAttribute("department", department);
//        return "emp/update";
//    }
//
//    @PostMapping("/updateEmp")
//    public String updateEmp(employees employee) {
//        employeeDao.save(employee);
//        return "redirect:/emps";
//    }
//
//    //删除员工
//    @GetMapping("/delemp/{id}")
//    public String deleteEmp(@PathVariable("id") int id) {
//        employeeDao.delete(id);
//        return "redirect:/emps";
//
//    }
//
//}
