package com.huang.controller

import com.huang.dao.DepartmentMapper
import com.huang.pojo.Department
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid
import javax.validation.constraints.Min

@Controller
@Validated
@RequestMapping("/department")
class DepartmentController(
    private val departmentMapper: DepartmentMapper,
) {

    /**
     * 部门列表
     *
     * @param model 视图模型
     */
    @RequestMapping("")
    fun list(model: Model): String {
        val departments = departmentMapper.selectList(null)
        model.addAttribute("departments", departments)
        return "dept/list"
    }

    /**
     * 删除部门
     *
     * @param id 要删除的部门ID
     */
    @RequestMapping("/delete/{id}")
    fun del(@PathVariable("id") id: Int): String {
        departmentMapper.deleteById(id)
        return "redirect:/department/"
    }

    /**
     * 添加部门页面
     */
    @GetMapping("/add")
    fun add(): String {
        return "dept/add"
    }

    /**
     * 添加部门接口
     *
     * @param department 部门实体
     */
    @PostMapping("/add")
    fun doAdd(@Valid department: Department): String {
        departmentMapper.insert(department)
        return "redirect:/department/"
    }

    /**
     * 更新部门页面
     *
     * @param model 视图模型
     * @param id    要更新的部门ID
     */
    @GetMapping("/update/{id}")
    fun update(
        model: Model,
        @Min(value = 1, message = "ID 必须大于等于 1！") @PathVariable("id") id: String
    ): String {
        val department = departmentMapper.selectById(id.toInt()) ?: return "redirect:/department/"
        model.addAttribute("dept", department)
        departmentMapper.updateById(department)
        return "dept/update"
    }

    /**
     * 更新部门接口
     *
     * @param department 部门实体
     */
    @PostMapping("/update/{id}")
    fun doUpdate(@Valid department: Department): String {
        println(department)
        departmentMapper.updateById(department)
        return "redirect:/department/"
    }
}