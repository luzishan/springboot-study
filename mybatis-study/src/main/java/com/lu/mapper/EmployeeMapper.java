package com.lu.mapper;

import com.lu.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    public Employee getById(int id);

    public List<Employee> ifList(Employee employee);

    public List<Employee> whereList(Employee employee);

    public List<Employee> trimList(Employee employee);

    public List<Employee> chooseWhenOtherwise(Employee employee);

    public List<Employee> foreachList(List<Integer> ids);

    public List<Employee> bindList(@Param("str") String address);

    public int updateSql(Employee employee);

    public int deleteById(int id);

}
