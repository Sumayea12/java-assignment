package dev.service;


import dev.domain.TaxTable;
import dev.repository.TaxRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaxService {

    private TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    public void create(TaxTable tax) {
       /* tax.setFullname(user.getFullname().toUpperCase());*/
       tax.setTotal_income(tax.getTotal_income()*12);
        if (tax.getTotal_income()>0 && tax.getTotal_income()<=250000){
            tax.setTax_amount(0);
            taxRepository.create(tax);
        }
        else if (tax.getTotal_income()>250000 && tax.getTotal_income()<=550000){
            tax.setTax_amount((tax.getTotal_income() * 0.1)-22000);
            taxRepository.create(tax);
        }
        else if (tax.getTotal_income()>550000 && tax.getTotal_income()<=950000){
            tax.setTax_amount((tax.getTotal_income() * 0.15)-48000);
            taxRepository.create(tax);
        }

        else if (tax.getTotal_income()>950000 && tax.getTotal_income()<=1250000){
            tax.setTax_amount((tax.getTotal_income() * 0.2)-94000);
            taxRepository.create(tax);
        }
        else if (tax.getTotal_income()>1250000){
            tax.setTax_amount((tax.getTotal_income() * 0.25)-15500);
            taxRepository.create(tax);
        }

    }

    public List<TaxTable> getAll() {
        return taxRepository.getAll();
    }

    public TaxTable get(int id) {
        return taxRepository.get(id);
    }

    public void delete(int id) {
        taxRepository.delete(id);
    }

    public void edit (TaxTable tax) {
        taxRepository.edit(tax);
    }

}
