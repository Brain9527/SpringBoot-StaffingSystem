package com.huang.controller;

import com.huang.dao.DepartmentsMapper;
import com.huang.pojo.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
     * @param ids   要更新的部门ID
     */
    @GetMapping("/dept/{ids}")
    public String update(Model model, @PathVariable("ids") int ids) {
        Departments departments = departmentsMapper.selectById(ids);
        model.addAttribute("dept", departments);
        HashMap<String, Object> map = new HashMap<>();
        String id;
        map.put("id", ids);
        List<Departments> departments1 = departmentsMapper.selectByMap(map);
        boolean empty = CollectionUtils.isEmpty(departments1);
//        System.out.println(empty);
        if (empty) {
            return "redirect:/depts";
        } else {
            departmentsMapper.updateById(departments);
            return "dept/update";
        }
    }
    @PostMapping("/updateDept")
    public String doUpdate(Departments departments) {
        departmentsMapper.updateById(departments);
        return "redirect:/depts";
    }

}
