package java12.API;


import java12.dto.request.SaveCompanyRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Company;
import java12.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyAPI {

    private final CompanyService companyService;

   @PostMapping("/save")
    public SimpleResponse saveCompany(@RequestBody SaveCompanyRequest saveCompanyRequest){
       return companyService.save(saveCompanyRequest);
   }
   @GetMapping("/{companyId}")
    public Company findById(@PathVariable Long companyId){
       return companyService.findById(companyId);
   }
   @DeleteMapping("/delete/{companyId}")
    public SimpleResponse delete(@PathVariable Long companyId){
        return   companyService.delete(companyId);
   }
   @PutMapping("/update/{companyId}")
   public SimpleResponse update(@PathVariable Long companyId,
                      @RequestBody Company company){
     return   companyService.update(companyId,company);
   }




}
