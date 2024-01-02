package dev.rest;


import dev.domain.TaxTable;
import dev.service.TaxService;
import dev.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaxController {
    private TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }
    @PostMapping("/tax")
    public String createUser(@RequestBody TaxTable tax) {
        taxService.create(tax);
        return "Tax Added Successfully";
    }
    @PutMapping("/{t}")
    public String updateUser(@PathVariable("t") int t, @RequestBody TaxTable tax) {

        taxService.edit(tax);
        return "Update information";
    }
    @GetMapping("/tax")
    public List<TaxTable> getUsers() {
        return taxService.getAll();
    }

    @GetMapping("/tax/{id}")
    public TaxTable addUser(@PathVariable("id") int id) {
        return taxService.get(id);
    }

    @DeleteMapping("/tax/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        taxService.delete(id);
        return "Information deleted";
    }

}
