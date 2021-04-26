package com.huang.controller;

import com.huang.dao.DepartmentMapper;
import com.huang.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Controller
@Validated
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 部门列表
     *
     * @param model 视图模型
     */
    @RequestMapping("")
    public String list(Model model) {
        List<Department> departments = departmentMapper.selectList(null);
        model.addAttribute("departments", departments);
        return "dept/list";
    }

    /**
     * 删除部门
     *
     * @param id 要删除的部门ID
     */
    @RequestMapping("/delete/{id}")
    public String del(@PathVariable("id") int id) {
        departmentMapper.deleteById(id);
        return "redirect:/department/";
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
     * @param department 部门实体
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAdd(Department department) {
        departmentMapper.insert(department);
        return "redirect:/department/";
    }

    /**
     * 更新部门页面
     *
     * @param model 视图模型
     * @param id    要更新的部门ID
     */
    @GetMapping("/update/{id}")
    public String update(Model model,
                         @Min(value = 1, message = "ID 必须大于等于 1！") @PathVariable("id") String id
    ) {
        Department department = departmentMapper.selectById(Integer.parseInt(id));
        if (department == null) {
            return "redirect:/department/";
        }

        model.addAttribute("dept", department);
        departmentMapper.updateById(department);

        return "dept/update";
    }

    /**
     * 更新部门接口
     *
     * @param department 部门实体
     */
    @PostMapping("/update/{id}")
    public String doUpdate(@Valid Department department) {
        departmentMapper.updateById(department);
        return "redirect:/department/";
    }

}
