package com.huang.controller;

import com.huang.dao.DepartmentsMapper;
import com.huang.error.NotFoundException;
import com.huang.pojo.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
     */
    @GetMapping("/add")
    public String add() {
        return "dept/add";
    }

    /**
     * 添加部门接口
     *
     * @param departments 部门实体
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAdd(@Validated Departments departments) {
        departmentsMapper.insert(departments);
        return "redirect:/depts";
    }

    /**
     * 更新部门
     *
     * @param model 视图模型
     * @param ids   要更新的部门ID
     */
    @GetMapping("/dept/{ids}")
    public String update(Model model, @PathVariable("ids") int ids) {
        Departments departments = departmentsMapper.selectById(ids);
        if (departments == null) {
            throw new NotFoundException("数据不存在", 400);
        }
        model.addAttribute("dept", departments);
        return "dept/update";
    }

    /**
     * 返回部门管理
     *
     * @param departments 要更新的部门ID
     */
    @PostMapping("/updateDept")
    public String doUpdate(Departments departments) {
        departmentsMapper.updateById(departments);
        return "redirect:/depts";
    }


}
