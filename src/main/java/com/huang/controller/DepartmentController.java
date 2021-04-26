package com.huang.controller;

import com.huang.dao.DepartmentsMapper;
import com.huang.pojo.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentsMapper departmentsMapper;

    /**
     * 部门列表
     *
     * @param model 视图模型
     */
    @RequestMapping("/depts")
    public String list(Model model) {
        List<Departments> departments = departmentsMapper.selectList(null);
        model.addAttribute("departments", departments);
        return "dept/list";
    }

    /**
     * 删除部门
     *
     * @param id 要删除的部门ID
     */
    @RequestMapping("/deldept/{id}")
    public String del(@PathVariable("id") int id) {
        departmentsMapper.deleteById(id);
        return "redirect:/depts";
    }

    /**
     * 添加部门页面
     *
     * @param model 视图模型
     */
    @GetMapping("/add")
    public String add(Model model) {
        return "dept/add";
    }

    /**
     * 添加部门接口
     *
     * @param departments 部门实体
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAdd(Departments departments) {
        departmentsMapper.insert(departments);
        return "redirect:/depts";
    }

    /**
     * 更新部门
     *
     * @param model 视图模型
     * @param id 要更新的部门ID
     */
    @GetMapping("/dept/{id}")
    public String update(Model model, @PathVariable("id") int id) {
        Departments departments = departmentsMapper.selectById(id);
        model.addAttribute("dept", departments);
        departmentsMapper.updateById(departments);

        return "dept/update";
    }

    @PostMapping("/updateDept")
    public String doUpdate(Departments departments) {
        departmentsMapper.updateById(departments);
        return "redirect:/depts";
    }

}
