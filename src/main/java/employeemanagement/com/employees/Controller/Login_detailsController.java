package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Login_details;
import employeemanagement.com.employees.Service.Login_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//added rest controller
//added cross origin
@RestController
@CrossOrigin
public class Login_detailsController {
    private Login_detailsService theLogin_detailsService;
    @Autowired

    public Login_detailsController(Login_detailsService theLogin_details) {
        this.theLogin_detailsService = theLogin_details;
    }
    @PostMapping("/addId")
    public Login_details addLogin_details(@RequestBody  Login_details theLogin_Details)
    {
        Login_details login=theLogin_detailsService.save(theLogin_Details);
        return login;
    }
    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody Login_details thelogin){
        String email = thelogin.getEmail();
        Login_details login = theLogin_detailsService.findByEmail(email);
        Map<String, Object> result = new HashMap<>();
        String msg = "";
        boolean authenticated = false;

        if(login != null){
            if(thelogin.getPassword().equals(login.getPassword())){
                authenticated = true;
                msg = "Login Successfull";
                }
            else{
                msg = "Wrong Password";
            }
        }
        else{
            msg="email Not found";
        }
        result.put("message",msg);
        result.put("success",authenticated);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @GetMapping("/getLogins")
    public List<Login_details> findAll()
    {
        return theLogin_detailsService.findAll();
    }
    @GetMapping("/Logins/{id}")
    public Login_details findById(@PathVariable int id)
    {
        Login_details login=theLogin_detailsService.findById(id);
        if(login==null)
        {
            throw new RuntimeException("id not found "+id);
        }
        return login;
    }
    @PutMapping("/Logins/{id}")
    public Login_details updateLogin(@PathVariable int id,@RequestBody Login_details theLoginDetails)
    {
        return theLogin_detailsService.update(id,theLoginDetails);
    }
    @DeleteMapping("/Logins/{id}")
    public  void deleteById(@PathVariable int id)
    {
        theLogin_detailsService.deleteById(id);
    }

//    @GetMapping("/getEmail")
//    public Login_details findByEmail(@RequestBody String email){
//        System.out.println(email);
//        return theLogin_detailsService.findByEmail(email);
//    }
}
