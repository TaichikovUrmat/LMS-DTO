package java12.service.Impl;


import java12.dto.request.SaveCompanyRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Company;
import java12.entity.Course;
import java12.repository.CompanyRepository;
import java12.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyImpl  implements  CompanyService {
 private final CompanyRepository companyRepository;
    @Override
    public SimpleResponse save(SaveCompanyRequest saveCompanyRequest) {

        List<Course> course = new ArrayList<>();
        Company company = new Company();
        company.setName(saveCompanyRequest.getName());
        company.setAddress(saveCompanyRequest.getAddress());
        company.setCountry(saveCompanyRequest.getCountry());
        company.setPhoneNumber(saveCompanyRequest.getPhoneNumber());
        company.setCourse(course);
        companyRepository.save(company);
           return SimpleResponse.builder()
                   .httpStatus(HttpStatus.OK)
                   .message("sonun")
                   .build();
    }

    @Override
    public Company findById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow();
    }

    @Override
    public SimpleResponse delete(Long companyId) {
        companyRepository.deleteById(companyId);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("sonun")
                .build();
    }

    @Override
    public SimpleResponse update(Long companyId, Company newCompany) {
        Company company = companyRepository.findById(companyId).orElseThrow();
        company.setName(newCompany.getName());
        company.setAddress(newCompany.getAddress());
        company.setPhoneNumber(newCompany.getPhoneNumber());
        company.setCountry(newCompany.getCountry());
        companyRepository.save(company);
         return SimpleResponse
                 .builder()
                 .httpStatus(HttpStatus.OK)
                 .message("almashty !!")
                 .build();
    }
}
