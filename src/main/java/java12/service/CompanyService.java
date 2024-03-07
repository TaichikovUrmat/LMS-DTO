package java12.service;

import java12.dto.request.SaveCompanyRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Company;

public interface CompanyService {
    SimpleResponse save(SaveCompanyRequest saveCompanyRequest);

    Company findById(Long companyId);

    SimpleResponse delete(Long companyId);

    SimpleResponse update(Long companyId,Company newCompany);

}
