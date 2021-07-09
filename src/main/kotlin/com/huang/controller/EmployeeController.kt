package com.huang.controller

import com.huang.dao.DepartmentMapper
import com.huang.dao.EmployeeMapper
import com.huang.pojo.Employee
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@Controller
@RequestMapping("/emp")
class EmployeeController(
    var employeeMapper: EmployeeMapper,
    var departmentMapper: DepartmentMapper
) {
    /**
     * 遍历所有数据
     *
     * @param model 视图模型
     */
    @RequestMapping("/")
    fun list(model: Model): String {
        val employees = employeeMapper.selectList(null)
        val departments = departmentMapper.selectList(null)
        val departmentsMap = HashMap<Int, String>()
        for (department in departments) {
            if (department == null) continue
            departmentsMap[department.id!!] = department.departmentName
        }
        model.addAttribute("emps", employees)
        model.addAttribute("departmentsMap", departmentsMap)
        return "emp/list"

//        Model->Dao 模型/数据
//        View       视图层
//        Controller 控制器层
    }

    /**
     * 添加员工页面
     *
     * @param model 视图模式
     */
    @GetMapping("/add")
    fun add(model: Model): String {
        val departments = departmentMapper.selectList(null)
        model.addAttribute("Departments", departments)
        return "emp/add"
    }

    /**
     * 增加员工接口
     *
     * @param employee 员工实体
     */
    @PostMapping("/add")
    fun doAdd(employee: Employee): String {
        employeeMapper.insert(employee)
        return "redirect:/emp/"
    }

    /**
     * 更改员工页面
     *
     * @param model 视图模式
     * @param id    要修改的员工ID
     */
    @GetMapping("/{id}")
    fun update(model: Model, @PathVariable("id") id: Int): String {
        val employee = employeeMapper.selectById(id)
        model.addAttribute("emp", employee)
        val departments = departmentMapper.selectList(null)
        model.addAttribute("depts", departments)
        return "emp/update"
    }

    /**
     * 更改员工接口
     *
     * @param employee 员工实体
     */
    @PostMapping("/{id}")
    fun doUpdate(employee: Employee): String {
        employeeMapper.updateById(employee)
        return "redirect:/emp/"
    }

    /**
     * 删除员工
     *
     * @param id 要删除的员工ID
     */
    @GetMapping("/delete/{id}")
    fun del(@PathVariable("id") id: Int): String {
        val i = employeeMapper.deleteById(id)
        return "redirect:/emp/"
    }
}