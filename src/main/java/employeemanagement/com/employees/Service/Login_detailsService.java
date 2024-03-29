package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.Model.Login_details;

import java.util.List;

public interface Login_detailsService {
    Login_details save(Login_details theLogin_details);
    List<Login_details> findAll();

    Login_details findById(int id);
    Login_details update(int id,Login_details updateLogin_details);

  void deleteById(int id);


}
