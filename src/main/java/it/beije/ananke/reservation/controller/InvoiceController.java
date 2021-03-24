package it.beije.ananke.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.beije.ananke.reservation.model.Invoice;
import it.beije.ananke.reservation.service.InvoiceService;


@RestController()
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping("/{id}")
	public Invoice getInvoiceById(@PathVariable Integer id) {
		return invoiceService.getInvoiceById(id);
	}
	
	@GetMapping("/allInvoices")
	public List<Invoice> getAllInvoices(){
		return invoiceService.getAllInvoices();
	}
	
	@DeleteMapping("/delete/{id}")
	public void removeInvoice(@PathVariable Integer id) {
		invoiceService.removeInvoice(id);
	}
	
	@PostMapping("/add")
	public void insertInvoice(@RequestBody Invoice invoice) {
		invoiceService.insertInvoice(invoice);
	}
}
