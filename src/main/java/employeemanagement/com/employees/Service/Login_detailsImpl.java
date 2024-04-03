package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.DAO.Login_detailsRepository;
import employeemanagement.com.employees.Model.Login_details;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Login_detailsImpl implements Login_detailsService{
    private Login_detailsRepository theLogin_detailsRepository;
    @Autowired

    public Login_detailsImpl(Login_detailsRepository theLogin_detailsRepository) {
        this.theLogin_detailsRepository = theLogin_detailsRepository;
    }

    @Override
    @Transactional
    public Login_details save(Login_details theLogin_details) {
        return theLogin_detailsRepository.save(theLogin_details);
    }

    @Override
    public List<Login_details> findAll() {
        return theLogin_detailsRepository.findAll();
    }

    @Override
    public Login_details findById(int id) {
        Optional<Login_details> result=theLogin_detailsRepository.findById(id);
        Login_details theLogin=null;
        if(result.isPresent())
        {
            theLogin=result.get();
        }
        else
        {
            throw new RuntimeException("id not found " + id);
        }
        return theLogin;
    }

    @Override
    @Transactional
    public Login_details update(int id, Login_details updateLogin_details) {
        Login_details existingDetails=theLogin_detailsRepository.findById(id).orElse(null);
         if(existingDetails!=null)
         {
             existingDetails.setEmail(updateLogin_details.getEmail());
             existingDetails.setPassword(updateLogin_details.getPassword());
             return theLogin_detailsRepository.save(existingDetails);
         }
        return null;
    }

    @Override
    @Transactional
    public void  deleteById(int id) {
         theLogin_detailsRepository.deleteById(id);
    }

    @Override
    public Login_details findByEmail(String email) {
        return theLogin_detailsRepository.findByEmail(email);
    }

}
